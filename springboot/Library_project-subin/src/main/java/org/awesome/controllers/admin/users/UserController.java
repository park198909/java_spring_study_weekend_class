package org.awesome.controllers.admin.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.awesome.commons.Pagination;
import org.awesome.controllers.admin.UserListForm;
import org.awesome.controllers.admin.UserSearch;
import org.awesome.controllers.admin.books.BookForm;
import org.awesome.entities.RentalBook;
import org.awesome.entities.User;
import org.awesome.models.user.UserEditService;
import org.awesome.models.user.UserListService;
import org.awesome.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminUserController")
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController {

    private final UserListService userListService;
    private final UserEditService userEditService;
    private final UserRepository userRepository;

    @GetMapping
    public String userList(UserSearch userSearch, Model model, HttpServletRequest request) {
        List<User> userList = userListService.getUserList(userSearch).toList();
        Page<User> page = userListService.getPage();

        String url = request.getContextPath() + "/admin/user";
        Pagination<User> pagination = new Pagination<>(page, url);
        model.addAttribute("userList", userList);
        model.addAttribute("pagination", pagination);

        return "admin/user/index";
    }

    // user 정보 수정
    @GetMapping("/edit/{userNo}")
    public String editUser(@PathVariable Long userNo, Model model) {
        User user = userRepository.findById(userNo).orElse(null);
        UserListForm userForm = null;
        if (user != null) {
            userForm = new ModelMapper().map(user, UserListForm.class);
            userForm.setUserType(user.getUserType().toString());
        }
        userForm.setMode("editing");

        model.addAttribute("userForm", userForm);
        return "admin/user/index";
    }

    @PostMapping("/edit")
    public String editUserPs(@Valid UserListForm userForm, Errors errors) {
        if (errors.hasErrors()) {
            String mode = userForm.getMode();
            if (mode.equals("update")) {
                return "admin/book/update";
            } else {
                return "admin/book/register";
            }
        }
        userEditService.edit(userForm);
        userForm.setMode(null);
        return "redirect:/admin/user";
    }


    // user 삭제
    @GetMapping("/delete/{userNo}")
    public String deleteUser(@PathVariable Long userNo){
        User user = userRepository.findById(userNo).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }

        userRepository.flush();

        return "redirect:/admin/user";
    }


}
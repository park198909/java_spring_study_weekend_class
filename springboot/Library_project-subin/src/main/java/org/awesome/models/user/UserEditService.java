package org.awesome.models.user;

import lombok.RequiredArgsConstructor;
import org.awesome.constants.RentalType;
import org.awesome.constants.UserType;
import org.awesome.controllers.admin.UserListForm;
import org.awesome.controllers.admin.books.BookForm;
import org.awesome.entities.RentalBook;
import org.awesome.entities.User;
import org.awesome.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEditService {

    private final UserRepository userRepository;
    public void edit(UserListForm userForm) {

        Long userNo = userForm.getUserNo();
        User user = userRepository.findById(userNo).orElseGet(User::new);
        user.setUserNm(userForm.getUserNm());
        user.setUserId(userForm.getUserId());
        user.setUserType(UserType.valueOf(userForm.getUserType()));

        userRepository.saveAndFlush(user);
    }

}

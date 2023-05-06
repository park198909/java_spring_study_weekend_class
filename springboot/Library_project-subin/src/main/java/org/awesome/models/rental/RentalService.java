package org.awesome.models.rental;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.awesome.entities.RentalBook;
import org.awesome.entities.User;
import org.awesome.repositories.RentalBookRepository;
import org.awesome.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalBookRepository bookRepository;
    private final UserRepository userRepository;

    public RentalService rental(HttpServletRequest request, RentForm rentForm) {
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");
        User user = userRepository.findByUserId(userId);

        String bookId = request.getParameter("bookId");
        RentalBook book = bookRepository.findById(bookId).orElse(null);

        if(user != null && book != null) {



        }





        return null;
    }
}

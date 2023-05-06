package org.awesome.controllers.user.books;

import lombok.RequiredArgsConstructor;
import org.awesome.entities.RentalBook;
import org.awesome.models.rental.RentalService;
import org.awesome.repositories.RentalBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final RentalBookRepository bookRepository;
    private final RentalService rentalService;

    @GetMapping("/books/{bookId}")
    public String index(@PathVariable String bookId, Model model) {
        RentalBook book = bookRepository.findById(bookId).orElse(null);
        model.addAttribute("book", book);

        return "front/books/detail";
    }

    @PostMapping("/books/rental")
    public String rental() {

        return null;
    }
}

package org.factoriaf5.libritos.controllers;

import org.factoriaf5.libritos.models.Book;
import org.factoriaf5.libritos.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    String listBooks(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("title", "Book list");
        model.addAttribute("books", books);
        return "books/all";
    }
}
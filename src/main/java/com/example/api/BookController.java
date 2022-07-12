package com.example.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/books",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
class BookController {

    @GetMapping
    List<Book> getAllBooks() {
        return List.of(
                new Book("Harry Potter", "J.K. Rowling", 1997, 223),
                new Book("Cień wiatru", "Carlos Ruiz Zafon", 2001, 565),
                new Book("Latarnik", "Henryk Sienkiewicz", 1881, 24)
        );
    }

    @GetMapping("/1")
    Book getSingleBook() {
        return new Book("Harry Potter", "J.K. Rowling", 1997, 223);
    }
}

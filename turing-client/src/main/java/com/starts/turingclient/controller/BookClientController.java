package com.starts.turingclient.controller;

import com.starts.turingclient.service.BookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookClientController {

    @Autowired
    BookClientService bookClientService;

    @GetMapping("/book")
    public String listBooks(String bookName) {



        return bookClientService.getBooksFromService(bookName);
    }
}

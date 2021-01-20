package com.starts.turingclient.service;

import com.starts.turingclient.feignservice.BookFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookClientService  {

    @Autowired
    private BookFeignService bookFeignService;


    public String getBooksFromService(String bookName) {
        String result = bookFeignService.getBooksFromService(bookName);
        return result;
    }


}


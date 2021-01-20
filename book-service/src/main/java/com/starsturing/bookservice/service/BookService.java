package com.starsturing.bookservice.service;


import com.alibaba.fastjson.JSONArray;
import com.starsturing.common.domain.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    JSONArray saveBooks(String savePath, String name, MultipartFile[] books);

    List<Book> getBookList(String bookName);


}

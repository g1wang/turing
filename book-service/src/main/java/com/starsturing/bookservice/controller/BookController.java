package com.starsturing.bookservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.starsturing.bookservice.constants.ResponseCode;
import com.starsturing.bookservice.service.BookService;
import com.starsturing.common.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
class BookController {


    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    /**
     * 保存文件
     *
     * @param category
     * @param books
     * @return
     */
    @PostMapping(value = "/book")
    public String saveBooks(String category, MultipartFile[] books) {
        //TO-DO config
        String savePath = "D:/ss";
        JSONObject resultJson = new JSONObject();
        JSONArray failResult = null;
        failResult = bookService.saveBooks(savePath, category, books);
        if (failResult.isEmpty()) {
            resultJson.put("status", ResponseCode.SUCCESS_CODE);
        } else {
            resultJson.put("status", ResponseCode.FAIL_CODE);
            resultJson.put("files", failResult);
        }
        return resultJson.toJSONString();
    }

    @GetMapping(value = "/book")
    public String getBookList(String bookName) {
        JSONObject resultJson = new JSONObject();
        List<Book> bookList = bookService.getBookList(bookName);
        if (bookList == null || bookList.isEmpty()) {
            resultJson.put("list", "");
        } else {
            resultJson.put("list", bookList);
        }
        return resultJson.toJSONString();
    }

}

package com.starsturing.bookservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.starsturing.bookservice.mapper.BookMapper;
import com.starsturing.bookservice.service.BookService;
import com.starsturing.common.domain.Book;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    /**
     * @param savePath
     * @param category
     * @param files
     * @return 返回失败文件名
     */
    @Transactional
    @Override
    public JSONArray saveBooks(String savePath, String category, MultipartFile[] files) {
        JSONArray resultJson = new JSONArray();
        String categoryPath = savePath + File.separator + category;
        File categoryDir = new File(savePath + File.separator + category);
        List<Book> bookList = new ArrayList<>();
        if (!categoryDir.exists()) {
            categoryDir.mkdirs();
        }
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            String filePath = categoryPath + File.separator + filename;
            try {
                file.transferTo(new File(filePath));
                Book book = new Book();
                book.setBookName(filename);
                book.setCategory(category);
                book.setPath(StringUtils.replace(filePath, "\\", "/"));
                bookList.add(book);
            } catch (IOException e) {
                logger.warn("文件[" + filename + "]保存失败:", e.fillInStackTrace());
                resultJson.add(filename);
            }
        }
        bookMapper.intsertAll(bookList);
        return resultJson;
    }

    @Override
    public List<Book> getBookList(String bookName) {
        List<Book> list = bookMapper.selectBooks(bookName);

        return list;
    }
}

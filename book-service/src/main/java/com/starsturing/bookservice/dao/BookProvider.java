package com.starsturing.bookservice.dao;

import com.starsturing.common.domain.Book;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * 批操作
 */
public class BookProvider {

    /**
     * 批量插入
     * @param map
     * @return
     */
    public String insertAllBooks(Map<String,List<Book>> map) {
        List<Book> bookList = map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into book ");
        sb.append("(book_name,category,path) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].bookName},#'{'list[{0}].category},#'{'list[{0}].path})");
        for (int i = 0; i < bookList.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < bookList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }



}

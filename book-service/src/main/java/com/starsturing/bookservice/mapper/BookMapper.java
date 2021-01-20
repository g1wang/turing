package com.starsturing.bookservice.mapper;


import com.starsturing.bookservice.dao.BookProvider;
import com.starsturing.common.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper {

    @Insert("insert into book(book_name,category,path) value (#{bookName},#{category},#{path})")
    int insert(@Param("bookName") String bookName, @Param("category") String category, @Param("path") String path);

    @Insert("insert into book(book_name,category,path) value (#{bookName},#{category},#{path})")
    int insertUser(Book book);


    @InsertProvider(type = BookProvider.class, method = "insertAllBooks")
    int intsertAll(@Param("list") List<Book> list);

    @Select("select book_name,category,path from book where book_name like concat('%',#{bookName},'%')")
    @Results({
            @Result(column = "book_name",property = "bookName"),
    })
    List<Book> selectBooks(@Param("bookName") String bookName);


}

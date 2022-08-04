package com.test.service.impl;

import com.test.entity.Book;
import com.test.mapper.BookMapper;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


   @Autowired
   private BookMapper bookMapper;


    @Override
    public Book getBookById(int uid) {
        return bookMapper.getBookById(uid);
    }
}

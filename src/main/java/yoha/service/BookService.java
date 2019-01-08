package yoha.service;

import yoha.entity.Book;

import java.util.List;

/**
 * 定义业务层相关的CRUD方法
 */
public interface BookService {
    Book findById(Long id);

    List<Book> findAll(int offset, int limit);

    Integer addBook(Book book);

    Integer updateBook(Book book);

    Integer deleteBookById(Long id);
}

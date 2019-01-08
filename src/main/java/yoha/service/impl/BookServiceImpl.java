package yoha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yoha.dao.BookDao;
import yoha.entity.Book;
import yoha.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll(int offset, int limit) {
        return bookDao.findAll(offset, limit);
    }

    @Override
    public Integer addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Integer updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Integer deleteBookById(Long id) {
        return bookDao.deleteBookById(id);
    }
}

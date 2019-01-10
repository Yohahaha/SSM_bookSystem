package yoha.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yoha.entity.Book;
import yoha.service.BookService;

import java.util.List;

public class BookServiceTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void TestAdd() {
        Book book = new Book();
        book.setName("stranger");
        book.setNumber(2);
        book.setDetail("new book");
        bookService.addBook(book);
    }

    @Test
    public void TestDelete() {
        bookService.deleteBookById(6L);
    }

    @Test
    public void TestFindAll() {
        List<Book> bookList = bookService.findAll(0, 5);
        bookList.forEach(System.out::println);
    }

    @Test
    public void TestUpdate() {
        Book book = bookService.findById(1L);
        book.setDetail("we have some changes");
        bookService.updateBook(book);
    }
}

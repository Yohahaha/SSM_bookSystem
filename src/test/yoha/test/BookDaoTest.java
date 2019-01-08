package yoha.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yoha.dao.BookDao;
import yoha.entity.Book;

import java.util.List;

public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void TestAdd() {
        Book book = new Book();
        book.setName("live");
        book.setNumber(2);
        book.setDetail("this is a book");
        for (int i = 0; i < 30; i++) {
            book.setName("live" + i);
            book.setNumber(1 + i);
            book.setDetail("this is a book" + i);
            bookDao.addBook(book);
        }
    }

    @Test
    public void TestFindById() {
        Long id = 2L;
        Book book = bookDao.findById(id);
        System.out.println(book);
    }

    @Test
    public void TestUpdate() {
        Long id = 2L;
        Book book = bookDao.findById(id);
        book.setDetail("something new");
        book.setNumber(2);
        book.setName("a new book");
        bookDao.updateBook(book);
    }

    @Test
    public void TestFindAll() {
        List<Book> bookList = bookDao.findAll(0, 10);
        bookList.forEach(System.out::println);
    }

    @Test
    public void TestDelete() {
        Long id = 4L;
        Integer num = bookDao.deleteBookById(id);
        System.out.println(num);
    }
}

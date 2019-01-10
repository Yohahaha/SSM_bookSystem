package yoha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yoha.entity.Book;
import yoha.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBook(Model model) {
        List<Book> list = bookService.findAll(0, 10);
        model.addAttribute("bookList", list);
        return "list";
    }

    @RequestMapping("/detail/{bookid}")
    public String bookDetail(@PathVariable String bookid, Model model) {
        Book book = bookService.findById(Long.valueOf(bookid));
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping("/delete/{bookid}")
    public String deleteBook(@PathVariable String bookid) {
        bookService.deleteBookById(Long.valueOf(bookid));
        return "list";
    }

    @RequestMapping("/addPage")
    public String toAddPage() {
        return "add";
    }

    /**
     * 存在编码问题问题，传来的参数有问题
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "list";
    }
}

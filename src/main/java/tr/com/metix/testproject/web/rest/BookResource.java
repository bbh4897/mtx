package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.BookService;
import tr.com.metix.testproject.service.dto.BookDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookResource {

    private static final String ENTITY_NAME = "book";
    private final BookService bookService;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBook()
    {
        return bookService.findAll();
    }


}

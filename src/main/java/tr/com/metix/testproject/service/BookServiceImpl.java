package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.repository.BookRepository;
import tr.com.metix.testproject.service.dto.BookDTO;
import tr.com.metix.testproject.service.mapper.BookMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream()
            .map(bookMapper::bookToBookDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}

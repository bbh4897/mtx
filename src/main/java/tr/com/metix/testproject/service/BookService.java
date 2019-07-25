package tr.com.metix.testproject.service;

import tr.com.metix.testproject.service.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findAll();


}

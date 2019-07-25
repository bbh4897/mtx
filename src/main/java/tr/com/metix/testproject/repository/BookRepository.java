package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.metix.testproject.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByBookNameContains(String name);

    //List<Book> findByBookNameIsContainingOrAuthorAuthor_nameIsContaining(String bookName, String authorName);




}

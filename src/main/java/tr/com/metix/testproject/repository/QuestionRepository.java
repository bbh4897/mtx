package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Question;

public interface QuestionRepository  extends JpaRepository<Question,Long> {


}

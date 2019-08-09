package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.GeneralCategory;
import tr.com.metix.testproject.domain.Restaurant;

public interface GeneralCategoryRepository extends JpaRepository<GeneralCategory,Long> {
}

package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Book;
import tr.com.metix.testproject.service.dto.BookDTO;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "category", target = "categoryDTO")
    @Mapping(source = "languages", target = "languageDTO")
    BookDTO bookToBookDTO(Book book);

    @Mapping(source = "publisherId", target = "publisher.id")
    @Mapping(source = "authorId", target = "author.id")
    @Mapping(source = "categoryDTO", target = "category")
    @Mapping(source = "languageDTO", target = "languages")
    Book bookDTOToBook(BookDTO bookDTO);

}

package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Author;
import tr.com.metix.testproject.domain.Book;
import tr.com.metix.testproject.service.dto.AuthorDTO;
import tr.com.metix.testproject.service.dto.BookDTO;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "country.id", target = "countryId")
    AuthorDTO authorToAuthorDTO(Author author);

    @Mapping(source = "countryId", target = "country.id")
    Author authorDTOToAuthor(AuthorDTO authorDTO);
}

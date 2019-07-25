package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Book;
import tr.com.metix.testproject.domain.Language;
import tr.com.metix.testproject.service.dto.LanguageDTO;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);


    LanguageDTO languageToLanguageDTO(Language language);
    Language languageDTOToLanguage(LanguageDTO languageDTO);

}

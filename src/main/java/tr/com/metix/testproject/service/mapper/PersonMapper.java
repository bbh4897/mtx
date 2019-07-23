package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.service.dto.PersonDTO;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO personToPersonDTO(Person person);
    Person personDTOToPerson(PersonDTO personDTO);


}

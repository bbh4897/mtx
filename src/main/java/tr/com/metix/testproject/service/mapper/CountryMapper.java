package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Country;
import tr.com.metix.testproject.service.dto.CountryDTO;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);


    CountryDTO countryToCountryDTO(Country country);
    Country countryDTOToCountry(CountryDTO countryDTO);
}

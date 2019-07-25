package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Publisher;
import tr.com.metix.testproject.service.dto.PublisherDTO;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);


    @Mapping(source = "country", target = "countryDTO")
    PublisherDTO publisherToPublisherDTO(Publisher publisher);

    @Mapping(source = "countryDTO", target = "country")
    Publisher publisherDTOToPublisher(PublisherDTO publisherDTO);

}

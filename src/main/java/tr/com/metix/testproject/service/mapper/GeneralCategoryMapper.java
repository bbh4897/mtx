package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.GeneralCategory;
import tr.com.metix.testproject.service.dto.GeneralCategoryDTO;

@Mapper(componentModel = "spring")
public interface GeneralCategoryMapper {
    GeneralCategoryMapper INSTANCE = Mappers.getMapper(GeneralCategoryMapper.class);

    GeneralCategoryDTO toDTO(GeneralCategory generalCategory);
    GeneralCategory toEntity(GeneralCategoryDTO generalCategoryDTO);
}

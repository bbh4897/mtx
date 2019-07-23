package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.service.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);


}

package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.service.ProductRentService;
import tr.com.metix.testproject.service.dto.RentProductDTO;

@Mapper(componentModel = "spring", uses = { PersonMapper.class, ProductMapper.class})
public interface RentProductMapper {

    RentProductMapper INSTANCE = Mappers.getMapper(RentProductMapper.class);

//    RentProductDTO rentproductToRentproductDTO(ProductRent productRent);
//    ProductRent productrentDTOToProductrent(RentProductDTO rentProductDTO);
//


    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "product.id", target = "productId")
    RentProductDTO rentproductToRentproductDTO(ProductRent productRent);


    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "productId", target = "product.id")
    ProductRent productrentDTOToProductrent(RentProductDTO rentProductDTO);





}

package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.service.dto.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "owner.id", target = "ownerId")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(source = "ownerId", target = "owner.id")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}

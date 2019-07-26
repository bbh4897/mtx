package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.service.dto.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO INSTANCE = Mappers.getMapper(CustomerDTO.class);

    @Mapping(source = "users.id", target = "usersId")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(source = "usersId", target = "users.id")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}

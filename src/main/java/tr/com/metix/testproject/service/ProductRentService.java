package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.service.dto.RentProductDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRentService {

    List<RentProductDTO> findAll(); // Tüm kiralanmıs urunlerı getırme

//    Optional<ProductRent> findOne(Long id);  // Tek bir kiralanmış ürün getırme

    // Teslim tarihi gecikmiş ürünler ()
    List<RentProductDTO> findAllByEndDateLessThan(Date date);
    // Şuan kirada olan tüm ürünler
    List<RentProductDTO> findAllByDeliveryDateIsNull();


    RentProductDTO save(RentProductDTO productRentDto);

    Optional<RentProductDTO> findById(Long id);
}

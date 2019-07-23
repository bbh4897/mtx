package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.repository.ProductRentRepository;
import tr.com.metix.testproject.service.dto.RentProductDTO;
import tr.com.metix.testproject.service.mapper.RentProductMapper;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductRentServiceImpl implements ProductRentService {

    private final ProductRentRepository productRentRepository;
    private final RentProductMapper rentProductMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ProductRentServiceImpl(ProductRentRepository productRentRepository, RentProductMapper rentProductMapper) {
        this.productRentRepository = productRentRepository;
        this.rentProductMapper = rentProductMapper;
    }

    // Kiralanmıs tum urunlerı listeleme
    @Override
    @Transactional(readOnly = true)
    public List<RentProductDTO> findAll()
    {
        return productRentRepository.findAll().stream()
            .map(rentProductMapper::rentproductToRentproductDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RentProductDTO> findById(Long id)
    {
        return productRentRepository.findById(id).map(rentProductMapper::rentproductToRentproductDTO);
    }


    // Teslim tarihi gecikmiş ürünler ()
    @Override
    @Transactional(readOnly = true)
    public List<RentProductDTO> findAllByEndDateLessThan(Date date) {
        return productRentRepository.findAllByEndDateLessThan(date).stream()
            .map(rentProductMapper::rentproductToRentproductDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    // Şuan kirada olan tüm ürünler
    @Override
    @Transactional(readOnly = true)
    public List<RentProductDTO> findAllByDeliveryDateIsNull() {
        return productRentRepository.findAllByDeliveryDateIsNull().stream()
            .map(rentProductMapper::rentproductToRentproductDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public RentProductDTO save(RentProductDTO rentProductDTO)
    {
        ProductRent productRent = rentProductMapper.productrentDTOToProductrent(rentProductDTO);
        productRent = productRentRepository.save(productRent);
        return rentProductMapper.rentproductToRentproductDTO(productRent);
    }



}

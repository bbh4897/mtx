package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.repository.ProductRentRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductRentServiceImpl implements ProductRentService {
    private final ProductRentRepository productRentRepository;

    public ProductRentServiceImpl(ProductRentRepository productRentRepository) {
        this.productRentRepository = productRentRepository;
    }

    // Kiralanmıs tum urunlerı listeleme
    @Override
    public List<ProductRent> findAll() {
        return productRentRepository.findAll();
    }

    // Teslim tarihi gecikmiş ürünler ()
    @Override
    public List<ProductRent> findAllByEndDateLessThan(Date date) {
        return productRentRepository.findAllByEndDateLessThan(date);
    }

    // Şuan kirada olan tüm ürünler
    @Override
    public List<ProductRent> findAllByDeliveryDateIsNull() {
        return productRentRepository.findAllByDeliveryDateIsNull();
    }

    @Override
    public void save(ProductRent productRent) {
        productRentRepository.save(productRent);
    }

    @Override
    public Optional<ProductRent> findById(Long id) {
        return productRentRepository.findById(id);
    }


}

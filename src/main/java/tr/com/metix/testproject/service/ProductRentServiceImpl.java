package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.repository.ProductRentRepository;

import java.util.List;

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
}

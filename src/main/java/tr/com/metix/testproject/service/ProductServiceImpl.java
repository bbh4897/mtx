package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.repository.ProductRepository;
import tr.com.metix.testproject.service.dto.ProductDTO;
import tr.com.metix.testproject.service.mapper.ProductMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper)
    {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Tüm ürünleri listeleme
    @Override
    public List<ProductDTO> findAll()

    {
        return productRepository.findAll().stream()
            .map(productMapper::productToProductDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public Optional<ProductDTO> findById(Long id)
    {
        return productRepository.findById(id).map(productMapper::productToProductDTO);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {

        Product product = productMapper.productDTOToProduct(productDTO);
        product = productRepository.save(product);
        return productMapper.productToProductDTO(product);


    }



}

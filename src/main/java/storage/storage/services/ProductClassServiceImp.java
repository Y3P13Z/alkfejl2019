package storage.storage.services;

import org.springframework.stereotype.Service;
import storage.storage.models.Product;
import storage.storage.models.ProductClass;
import storage.storage.repositories.ProductClassRepository;
import storage.storage.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductClassServiceImp implements ProductClassService {

    private final ProductClassRepository productClassRepository;

    private final ProductRepository productRepository;

    public ProductClassServiceImp(ProductClassRepository productClassRepository, ProductRepository productRepository) {
        this.productClassRepository = productClassRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductClass makeClass(String name) {
        ProductClass productClass = new ProductClass(name);
        productClassRepository.save(productClass);
        return productClass;
    }

    @Override
    public ProductClass addProductToClass(long productClassId, long productId) {
        ProductClass productClass = productClassRepository.findById(productClassId).get();
        Product product = productRepository.findById(productId).get();
        productClass.getProducts().add(product);
        product.setProductClass(productClass);
        productRepository.save(product);
        productClassRepository.save(productClass);
        return productClass;
    }

    @Override
    public ProductClass deleteProductToClass(long productClassId, long productId) {
        ProductClass productClass = productClassRepository.findById(productClassId).get();
        Product product = productRepository.findById(productId).get();
        productClass.getProducts().remove(product);
        product.setProductClass(null);
        productRepository.save(product);
        productClassRepository.save(productClass);
        return productClass;
    }

    @Override
    public List<ProductClass> findAll() {
        Iterable<ProductClass> products =  productClassRepository.findAll();
        List<ProductClass> productClassList = new ArrayList<>();
        products.forEach(productClass -> productClassList.add(productClass));
        return productClassList;
    }

    @Override
    public List<Product> findAllProducts(long productClassId) {
        ProductClass productClass = productClassRepository.findById(productClassId).get();
        return productClass.getProducts();
    }
}

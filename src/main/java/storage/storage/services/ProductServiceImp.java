package storage.storage.services;

import org.springframework.stereotype.Service;
import storage.storage.inputModels.Product.ProductInputModel;
import storage.storage.inputModels.Product.ProductStatusInputModel;
import storage.storage.models.Product;
import storage.storage.models.ProductStatus;
import storage.storage.repositories.ProductRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductInputModel productInputModel) {
        Product product = new Product();
        product.setName(productInputModel.getName());
        product.setPrice(productInputModel.getPrice());
        product.setProductClass(null);
        product.setQuantity(productInputModel.getQuantity());
        product.setStatus(ProductStatus.ON_HOLD);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterable<Product> products =  productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(product -> productList.add(product));
        return productList;
    }

    @Override
    public Product changeProductStatus(ProductStatusInputModel productStatusInputModel) {
        Optional<Product> oProduct = productRepository.findById(productStatusInputModel.getProductId());
        if(oProduct.isPresent()){
            Product product = oProduct.get();
            product.setStatus(ProductStatus.valueOf(productStatusInputModel.getStatus()));
            productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        Optional<Product> producttoDeleteOpt = productRepository.findById(id);
        if(producttoDeleteOpt.isPresent()){
            Product productToDelete = producttoDeleteOpt.get();
            productRepository.delete(productToDelete);
            return productToDelete;
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Optional<Product> productToBeUpdatedOpt = productRepository.findById(id);
        if(productToBeUpdatedOpt.isPresent()) {
            Product productToBeUpdated = productToBeUpdatedOpt.get();
            productToBeUpdated.setName(product.getName());
            productToBeUpdated.setPrice(product.getPrice());
            productToBeUpdated.setQuantity(product.getQuantity());
            productRepository.save(productToBeUpdated);
            return product;
        }
        return null;
    }

    @Override
    public Product getProduct(long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()){
            Product product = productOpt.get();
            return product;
        }
        return null;
    }
}

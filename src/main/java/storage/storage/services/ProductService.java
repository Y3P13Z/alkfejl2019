package storage.storage.services;

import storage.storage.inputModels.Product.ProductInputModel;
import storage.storage.inputModels.Product.ProductStatusInputModel;
import storage.storage.models.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductInputModel productInputModel);
    List<Product> findAll();
    Product changeProductStatus(ProductStatusInputModel productStatusInputModel);
    Product deleteProduct(long id);
    Product updateProduct(Product product, long id);
    Product getProduct(long id);
}

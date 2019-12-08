package storage.storage.services;

import storage.storage.models.Product;
import storage.storage.models.ProductClass;

import java.util.List;

public interface ProductClassService {

    ProductClass makeClass(String name);
    ProductClass addProductToClass(long productClassId, long productId);
    ProductClass deleteProductToClass(long productClassId, long productId);
    List<ProductClass> findAll();
    List<Product> findAllProducts(long productClassId);
}

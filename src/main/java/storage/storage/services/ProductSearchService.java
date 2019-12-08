package storage.storage.services;

import storage.storage.models.Product;
import storage.storage.utils.SearchParams;

import java.util.List;

public interface ProductSearchService {

    List<Product> findProductsByClass(String productClassName);
    List<Product> findProductsByPrice(double productPrice);
    List<Product> findProductsByStatus(String productStatus);
    List<Product> checkSearchParams(SearchParams searchParams);
}

package storage.storage.services;

import org.springframework.stereotype.Service;
import storage.storage.models.Product;
import storage.storage.repositories.ProductClassRepository;
import storage.storage.repositories.ProductRepository;
import storage.storage.utils.SearchParams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductSearchServiceImp implements ProductSearchService {

    private final ProductRepository productRepository;
    private final ProductClassRepository productClassRepository;

    public ProductSearchServiceImp(ProductRepository productRepository, ProductClassRepository productClassRepository) {
        this.productRepository = productRepository;
        this.productClassRepository = productClassRepository;
    }

    @Override
    public List<Product> findProductsByClass(String productClassName) {
        List<Product> allProducts = findAllToList();
        return allProducts.stream()
                .filter(product -> product.getProductClass().getName().toLowerCase().contains(productClassName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByPrice(double productPrice) {
        List<Product> allProducts = findAllToList();
        return allProducts.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByStatus(String productStatus) {
        List<Product> allProducts = findAllToList();
        return allProducts.stream().
                filter(product -> String.valueOf(product.getStatus()).equals(productStatus))
                .collect(Collectors.toList());

    }

    public List<Product> findProductsByName(String productName) {
        List<Product> allProducts = findAllToList();
        return allProducts.stream()
                .filter(product -> product.getName().toLowerCase().contains(productName.toLowerCase()))
                .collect(Collectors.toList());

    }

    private List<Product> findAllToList() {
        Iterable<Product> products =  productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(product -> productList.add(product));
        return productList;
    }

    public List<Product> checkSearchParams(SearchParams searchParams) {
        if(searchParams.getProductName() != null ){
            return findProductsByName(searchParams.getProductName());
        }
        if(searchParams.getProductClassName() != null ){
            return findProductsByClass(searchParams.getProductClassName());
        }
        if(searchParams.getProductStatus() != null ){
            return findProductsByStatus(searchParams.getProductStatus());
        }

        return new ArrayList<>();
    }
}

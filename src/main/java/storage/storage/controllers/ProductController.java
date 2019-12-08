package storage.storage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storage.storage.inputModels.Product.ProductInputModel;
import storage.storage.inputModels.Product.ProductStatusInputModel;
import storage.storage.models.Product;
import storage.storage.services.ProductSearchService;
import storage.storage.services.ProductService;
import storage.storage.utils.SearchParams;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;
    private final ProductSearchService productSearchService;

    public ProductController(ProductService productService, ProductSearchService productSearchService) {
        this.productService = productService;
        this.productSearchService = productSearchService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = productService.getProduct(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("product/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductInputModel productInputModel) {
        Product product =  productService.addProduct(productInputModel);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id){
        Product product = productService.deleteProduct(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping("product/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product, id);
        if(updatedProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("product/getAll")
    public ResponseEntity<List<Product>> getProducts (){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("product/changeStatus")
    public ResponseEntity<Product> changeStatus(@RequestBody ProductStatusInputModel productStatusInputModel) {
        Product product = productService.changeProductStatus(productStatusInputModel);
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("product/search")
    public ResponseEntity<List<Product>> search(@RequestBody SearchParams searchParams) {
        List<Product> products = productSearchService.checkSearchParams(searchParams);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

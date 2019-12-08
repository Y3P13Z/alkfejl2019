package storage.storage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import storage.storage.inputModels.ProductClass.ClassProductInputModel;
import storage.storage.inputModels.ProductClass.ProductClassInputModel;
import storage.storage.models.Product;
import storage.storage.models.ProductClass;
import storage.storage.services.ProductClassService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Secured({"ROLE_ADMIN"})
public class ProductClassController {

    private final ProductClassService productClassService;

    public ProductClassController(ProductClassService productClassService) {
        this.productClassService = productClassService;
    }

    @PostMapping("/productClass/add")
    public ResponseEntity<ProductClass> add (@RequestBody ProductClassInputModel productClassInputModel) {
        ProductClass productClass = productClassService.makeClass(productClassInputModel.getName());
        return new ResponseEntity<>(productClass, HttpStatus.OK);
    }

    @PostMapping("/productClass/product/add")
    public ResponseEntity<ProductClass> addProduct (@RequestBody ClassProductInputModel classProductInputModel) {
        ProductClass productClass = productClassService.addProductToClass(classProductInputModel.getProductClassId(), classProductInputModel.getProductId());
        return new ResponseEntity<>(productClass, HttpStatus.OK);
    }

    @GetMapping("/productClass/getAll")
    public ResponseEntity<List<ProductClass>> getAll(){
        return new ResponseEntity<>(productClassService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/productClass/products/{id}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable long id){
        return new ResponseEntity<>(productClassService.findAllProducts(id), HttpStatus.OK);
    }
}

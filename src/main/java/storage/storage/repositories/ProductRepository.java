package storage.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import storage.storage.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}

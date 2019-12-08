package storage.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import storage.storage.models.ProductClass;

public interface ProductClassRepository extends CrudRepository<ProductClass, Long> {
}

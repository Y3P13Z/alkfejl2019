package storage.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import storage.storage.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

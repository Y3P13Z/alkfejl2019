package storage.storage.services;

import storage.storage.inputModels.Order.OrderInputModel;
import storage.storage.inputModels.Order.OrderStatusInputModel;
import storage.storage.models.Order;

import java.util.List;

public interface OrderService {

    Order makeOrder(OrderInputModel orderInputModel);
    Order changeOrderStatus(OrderStatusInputModel orderStatusInputModel);
    List<Order> getOrdersOfEvaluator(long id);
}

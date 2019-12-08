package storage.storage.services;

import org.springframework.stereotype.Service;
import storage.storage.inputModels.Order.OrderInputModel;
import storage.storage.inputModels.Order.OrderStatusInputModel;
import storage.storage.models.Order;
import storage.storage.models.OrderStatus;
import storage.storage.models.Product;
import storage.storage.models.User;
import storage.storage.repositories.OrderRepository;
import storage.storage.repositories.ProductRepository;
import storage.storage.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderServiceImp(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order makeOrder(OrderInputModel orderInputModel) {

        Optional<User> oEvaluator = userRepository.findById(orderInputModel.getEvaluatorId());
        Optional<Product> oProduct = productRepository.findById(orderInputModel.getProductId());
        if(oEvaluator.isPresent() && oProduct.isPresent()) {
            User evaluator = oEvaluator.get();
            Product product = oProduct.get();
            Order order = new Order();
            order.setPetitionerId(orderInputModel.getPetitionerId());
            order.setStatus(OrderStatus.NOT_EVAULATED);
            order.setProduct(product);
            order.setQuantity(orderInputModel.getQuantity());
            order.setEvaluator(evaluator);
            order.setTotalPrice(calculateTotalPrice(orderInputModel.getQuantity(), product.getPrice()));
            orderRepository.save(order);
            return order;
        }

        return null;
    }

    @Override
    public Order changeOrderStatus(OrderStatusInputModel orderStatusInputModel) {
        Optional<Order> oOrder = orderRepository.findById(orderStatusInputModel.getOrderId());
        if(oOrder.isPresent()) {

            Order order = oOrder.get();
            if(order.getStatus().name().equals("ACCEPTED")){
                return null;
            }
            order.setStatus(OrderStatus.valueOf(orderStatusInputModel.getStatus()));
            orderRepository.save(order);
            if(orderStatusInputModel.getStatus().equals("ACCEPTED")) {
                updateProductQuantity(order.getProduct().getId(), order.getQuantity());
            }
            return order;
        }
        return null;
    }

    @Override
    public List<Order> getOrdersOfEvaluator(long id) {
        Iterable<Order> orders = orderRepository.findAll();
        List<Order> orderList = new ArrayList<>();
        for (Order o : orders) {
            if (o.getEvaluator().getId() == id) {
                orderList.add(o);
            }
        }
        return orderList;
    }

    private double calculateTotalPrice(int quantity, double price){
        return price * quantity;
    }

    private boolean updateProductQuantity(long productId, int orderquantity) {
        Optional<Product> oProduct = productRepository.findById(productId);
        if(oProduct.isPresent()) {
            Product product = oProduct.get();
            product.setQuantity(product.getQuantity() + orderquantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}

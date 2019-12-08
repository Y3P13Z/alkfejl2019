package storage.storage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import storage.storage.inputModels.Order.OrderInputModel;
import storage.storage.inputModels.Order.OrderStatusInputModel;
import storage.storage.models.Order;
import storage.storage.services.OrderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Secured({ "ROLE_STOREMAN" })
    @PostMapping("order/add")
    public ResponseEntity<Order> add(@RequestBody OrderInputModel orderInputModel) {
        Order order = orderService.makeOrder(orderInputModel);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @Secured({ "ROLE_STOREKEEPER" , "ROLE_ADMIN" })
    @PostMapping("/order/changeStatus")
    public ResponseEntity<Order> changeStatus(@RequestBody OrderStatusInputModel orderStatusInputModel){
        Order order = orderService.changeOrderStatus(orderStatusInputModel);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<Order>> getOrdersOfEvaluator(@PathVariable long id){
        List<Order> orders = orderService.getOrdersOfEvaluator(id);
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

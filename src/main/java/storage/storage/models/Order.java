package storage.storage.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    private long petitionerId;

    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    @ManyToOne(fetch = FetchType.EAGER)
    private User evaluator;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_id"))
    Product product;

    private double totalPrice;

    private int quantity;

    private OrderStatus status;

    public Order(long petitionerId, User evaluator, double totalPrice, OrderStatus status, Product product, int quantity) {
        this.petitionerId = petitionerId;
        this.evaluator = evaluator;
        this.totalPrice = totalPrice;
        this.status = status;
        this.product = product;
        this.quantity = quantity;
    }

    public Order() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPetitionerId() {
        return petitionerId;
    }

    public void setPetitionerId(long petitionerId) {
        this.petitionerId = petitionerId;
    }

    public User getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(User evaluator) {
        this.evaluator = evaluator;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

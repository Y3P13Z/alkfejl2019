package storage.storage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String name;

    private double price;

    private ProductStatus status;

    private int quantity;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "product")
    private Order order;


    @JoinColumn(name = "product_class_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductClass productClass;

    public Product(String name, double price, int quantity, ProductClass productClass) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productClass = productClass;
        status = ProductStatus.ON_HOLD;
    }

    public Product() {
        status = ProductStatus.ON_HOLD;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductClass getProductClass() {
        return productClass;
    }

    public void setProductClass(ProductClass productClass) {
        this.productClass = productClass;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

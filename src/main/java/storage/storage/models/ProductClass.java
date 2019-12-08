package storage.storage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_class_id")
    private long id;


    @JsonIgnore
    @OneToMany(mappedBy = "productClass" , fetch = FetchType.EAGER)
    private List<Product> products;

    private String name;

    public ProductClass(String name) {
        this.name = name;
    }

    public ProductClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package storage.storage.inputModels.Order;

import storage.storage.models.Product;

public class OrderInputModel {

    private String name;
    private long petitionerId;
    private long evaluatorId;
    private int quantity;
    private long productId;

    public OrderInputModel(String name, long petitionerId, long evaluatorId, int quantity, long productId) {
        this.name = name;
        this.petitionerId = petitionerId;
        this.evaluatorId = evaluatorId;
        this.quantity = quantity;
        this.productId = productId;
    }

    public OrderInputModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPetitionerId() {
        return petitionerId;
    }

    public void setPetitionerId(long petitionerId) {
        this.petitionerId = petitionerId;
    }

    public long getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(long evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}

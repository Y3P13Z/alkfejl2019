package storage.storage.inputModels.Order;

public class OrderStatusInputModel {

    private String status;
    private long orderId;

    public OrderStatusInputModel(String status, long orderId) {
        this.status = status;
        this.orderId = orderId;
    }

    public OrderStatusInputModel() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}

package storage.storage.inputModels.Product;

public class ProductStatusInputModel {

    private long productId;

    private String status;

    public ProductStatusInputModel(long productId, String status) {
        this.productId = productId;
        this.status = status;
    }

    public ProductStatusInputModel() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

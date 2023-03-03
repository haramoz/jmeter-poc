package dr.sattlers.bar.jmeterpoc.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_item")
public class OrderItem {
    private String product;
    private int quantity;

    public OrderItem(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

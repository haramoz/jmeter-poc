package dr.sattlers.bar.jmeterpoc.models;

import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private List<OrderItem> items;
    private Double total;

    // Constructor
    public Order(Long id, String customerName, List<OrderItem> items, Double total) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
        this.total = total;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

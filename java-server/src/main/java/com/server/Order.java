package com.server;

public class Order {
    String id;
    String partnerId;

    String description;

    public Order(String id, String partnerId, String description) {
        this.id = id;
        this.partnerId = partnerId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}

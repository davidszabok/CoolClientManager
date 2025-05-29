package hu.coolclientmanager.model;

import java.math.BigDecimal;

public class Product {
    private String articleNumber;
    private String name;
    private BigDecimal netPrice;
    private String serialNumber; // opcionális

    public Product(String articleNumber, String name, BigDecimal netPrice, String serialNumber) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.netPrice = netPrice;
        this.serialNumber = serialNumber;
    }

    // Getterek és setterek
    public String getArticleNumber() {
        return articleNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
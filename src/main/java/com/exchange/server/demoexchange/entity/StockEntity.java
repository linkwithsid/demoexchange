package com.exchange.server.demoexchange.entity;

import javax.persistence.*;

@Entity
@Table(name="stock_information")
public class StockEntity {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * stockId
     */
    @Column(name="stock_id")
    private String stockId;

    /**
     * companyName
     */
    @Column(name="stock_name")
    private String companyName;

    /**
     * price
     */
    @Column(name="stock_price")
    private String price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}

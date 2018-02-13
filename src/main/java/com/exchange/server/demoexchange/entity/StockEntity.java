package com.exchange.server.demoexchange.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="stock_information")
@Data
public class StockEntity {


    @Id
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

}

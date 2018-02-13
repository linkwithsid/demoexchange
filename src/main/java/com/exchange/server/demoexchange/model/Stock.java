package com.exchange.server.demoexchange.model;

import lombok.Data;

@Data
public class Stock {

    /**
     * stockId
     */
    private String stockId;

    /**
     * price
     */
    private String price;

    /**
     * companyName
     */
    private String companyName;


}

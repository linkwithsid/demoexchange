package com.exchange.server.demoexchange.controller;

import com.exchange.server.demoexchange.model.Stock;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface ExchangeController {


    @RequestMapping( value = "/stock/{id}" , method = RequestMethod.GET)
    Stock getStock(String stockId);

    @RequestMapping (value = "/stock" , method = RequestMethod.POST)
    String createStock(@RequestBody Stock stock);


    @RequestMapping (value = "/stock" , method = RequestMethod.PUT)
    Stock updateStock(@RequestBody Stock stock);
}

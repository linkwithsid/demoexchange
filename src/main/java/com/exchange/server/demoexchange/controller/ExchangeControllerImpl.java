package com.exchange.server.demoexchange.controller;

import com.exchange.server.demoexchange.Service.ExchangeService;
import com.exchange.server.demoexchange.model.Stock;
import com.exchange.server.demoexchange.model.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExchangeControllerImpl implements ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    public static final Logger logger = LoggerFactory.getLogger(ExchangeControllerImpl.class);

    @Override
    public Stock getStock(@PathVariable("id") String stockId) {
        logger.info("Inside ExchangeControllerImpl getStock method, stockId = " + stockId);
        Stock stock = exchangeService.getStock(stockId);
        logger.info("Exiting ExchangeControllerImpl getStock method, stockId = " + stockId + ", company name = " + stock.getCompanyName());
        return stock;
    }

    @Override
    public StockResponse createStock(@RequestBody Stock stock) {
        logger.info("Inside ExchangeControllerImpl createStock method");
        StockResponse stockResponse = new StockResponse();
        if (null != stock && !StringUtils.isEmpty(stock.getStockId())
                && !StringUtils.isEmpty(stock.getCompanyName())
                && !StringUtils.isEmpty(stock.getPrice())) {

            String companyName = exchangeService.createStock(stock);
            logger.info("Exiting ExchangeControllerImpl createStock method");
            stockResponse.setStatusMessage(companyName + " added in DB");
            return stockResponse;
        } else
            logger.info("Exiting ExchangeControllerImpl createStock method, information not valid");
        stockResponse.setStatusMessage("Give Valid Info");
        return stockResponse;
    }


    @Override
    public Stock updateStock(@RequestBody Stock stock) {
        logger.info("Inside ExchangeControllerImpl updateStock method");

        if (null != stock && !StringUtils.isEmpty(stock.getStockId())
                && !StringUtils.isEmpty(stock.getCompanyName())
                && !StringUtils.isEmpty(stock.getPrice())) {
            stock = exchangeService.updateStock(stock);
        }
        logger.info("Exiting ExchangeControllerImpl updateStock method");
        return stock;

    }

}

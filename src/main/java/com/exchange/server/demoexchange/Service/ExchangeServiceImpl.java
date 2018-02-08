package com.exchange.server.demoexchange.Service;

import com.exchange.server.demoexchange.dao.ExchangeDao;
import com.exchange.server.demoexchange.entity.StockEntity;
import com.exchange.server.demoexchange.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeServiceImpl implements ExchangeService{

    @Autowired
    private ExchangeDao stockDao;

    public static final Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    @Override
    public String createStock(Stock stock) {

        logger.info("Inside ExchangeServiceImpl createStock method");

        StockEntity stockEntity = mapData(stock); //map data to entity object

        stockDao.insertStock(stockEntity);
        logger.info("Exiting ExchangeServiceImpl createStock method");
        return stockEntity.getCompanyName();
    }

    private StockEntity mapData(Stock stock) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStockId(stock.getStockId());
        stockEntity.setCompanyName(stock.getCompanyName());
        stockEntity.setPrice(stock.getPrice());
        return stockEntity;
    }
}

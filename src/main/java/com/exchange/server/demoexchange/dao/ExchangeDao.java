package com.exchange.server.demoexchange.dao;

import com.exchange.server.demoexchange.entity.StockEntity;


public interface ExchangeDao {

    /**
     *
     * @param stockId
     * @return
     */
    StockEntity getStockById(String stockId);
    StockEntity insertStock(StockEntity stockEntity);
    StockEntity updateStock(StockEntity stockEntity);
}

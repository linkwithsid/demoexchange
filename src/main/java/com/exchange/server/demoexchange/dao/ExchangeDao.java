package com.exchange.server.demoexchange.dao;

import com.exchange.server.demoexchange.entity.StockEntity;


public interface ExchangeDao {
    /**
     *
     * @param stockEntity
     * @return
     */
    StockEntity insertStock(StockEntity stockEntity);
}

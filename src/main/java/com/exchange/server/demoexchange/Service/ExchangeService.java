package com.exchange.server.demoexchange.Service;

import com.exchange.server.demoexchange.model.Stock;

public interface ExchangeService {

    /**
     *
     * @param stockId
     * @return
     */
    Stock getStock(String stockId);
    String createStock(Stock stock);
    Stock updateStock(Stock stock);
}

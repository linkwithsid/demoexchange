package com.exchange.server.demoexchange.Service;

import com.exchange.server.demoexchange.model.Stock;

public interface ExchangeService {

    /**
     *
     * @param stock
     * @return
     */
    public String createStock(Stock stock);
}

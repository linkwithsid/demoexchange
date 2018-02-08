package com.exchange.server.demoexchange.controller;
import com.exchange.server.demoexchange.dao.ExchangeDaoImpl;
import com.exchange.server.demoexchange.entity.StockEntity;
import com.exchange.server.demoexchange.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExchangeControllerImpl implements ExchangeController {

    @Autowired
    private ExchangeDaoImpl stockDao;

    @Override
    public Stock getStock(@PathVariable("id") String stockId) {
        Stock stock = new Stock();
        stock.setStockId(stockId);
        stock.setCompanyName("Xebia");
        stock.setPrice("452.89");
        return stock;
    }

    @Override
    public String createStock(@RequestBody Stock stock) {
        if(null!=stock && !StringUtils.isEmpty(stock.getStockId())
                && !StringUtils.isEmpty(stock.getCompanyName())
                && !StringUtils.isEmpty(stock.getPrice())) {

            StockEntity stockEntity = mapdata(stock);

            stockDao.insertStock(stockEntity);

            return stock.getCompanyName() + " added in DB";
        }
        else return "Give Valid Info";
    }

    private StockEntity mapdata(Stock stock) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStockId(stock.getStockId());
        stockEntity.setCompanyName(stock.getCompanyName());
        stockEntity.setPrice(stock.getPrice());
        return stockEntity;
    }

    @Override
    public Stock updateStock(@RequestBody Stock stock) {
        return null;
    }
}

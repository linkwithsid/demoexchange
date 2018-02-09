package com.exchange.server.demoexchange.dao;

import com.exchange.server.demoexchange.entity.StockEntity;
import com.exchange.server.demoexchange.model.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {

    public static final Logger logger = LoggerFactory.getLogger(ExchangeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public StockEntity getStockById(String stockId) {
        logger.info("Inside ExchangeDaoImpl getStockById method");
        Session session = null;
        StockEntity stockEntity = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            stockEntity = session.get(StockEntity.class, stockId);
            logger.info("Exiting ExchangeDaoImpl getStockById method, stock found id = " + stockEntity.getStockId());
        } catch (Exception e) {
            logger.error("Exiting ExchangeDaoImpl getStockById method, data not found , id = " + stockId + e);
        }
        return stockEntity;
    }

    @Override
    public StockEntity insertStock(StockEntity stockEntity) {
        logger.info("Inside ExchangeDaoImpl insertStock");
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(stockEntity);
            session.getTransaction().commit();
            logger.info("Save success, Exiting ExchangeDaoImpl insertStock");
            return stockEntity;
        } catch (Exception e) {
            logger.error("Save failed, Exiting ExchangeDaoImpl insertStock" + e);
        }
        logger.info("");
        return null;
    }

    @Override
    public StockEntity updateStock(StockEntity stockEntity) {
        logger.info("Inside ExchangeDaoImpl updateStock method");
        Session session = null;
        StockEntity updatedStockEntity = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(stockEntity);
            updatedStockEntity = (StockEntity) session.get(StockEntity.class, stockEntity.getStockId());
            session.getTransaction().commit();
            logger.info("Exiting ExchangeDaoImpl updateStock method, data updated, id = " + stockEntity.getStockId());
        } catch (Exception e) {
            logger.error("Exiting ExchangeDaoImpl updateStock method, data update failed, id = " + stockEntity.getStockId() + e);
        }
        return updatedStockEntity;
    }
}

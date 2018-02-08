package com.exchange.server.demoexchange.dao;

import com.exchange.server.demoexchange.entity.StockEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {

    public static final Logger logger = LoggerFactory.getLogger(ExchangeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public StockEntity insertStock(StockEntity stockEntity){
        logger.info("Inside ExchangeDaoImpl insertStock");
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(stockEntity);
            session.getTransaction().commit();
            logger.info("Save success, Exiting ExchangeDaoImpl insertStock");
            return stockEntity;
        } catch (Exception e){
            logger.error("Save failed, Exiting ExchangeDaoImpl insertStock" + e );
        }
        logger.info("");
        return null;
    }
}

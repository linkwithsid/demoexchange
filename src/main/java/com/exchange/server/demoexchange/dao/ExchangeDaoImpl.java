package com.exchange.server.demoexchange.dao;

import com.exchange.server.demoexchange.entity.StockEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public StockEntity insertStock (StockEntity stockEntity){
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(stockEntity);
            session.getTransaction().commit();
            return stockEntity;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

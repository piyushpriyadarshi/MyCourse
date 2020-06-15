package com.piyush.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Piyush Priyadarshi.
 * User: @Piyush
 * Date: 15-06-2020
 * Time: 18:55
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory!=null){
            return sessionFactory;
        }
        sessionFactory=new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
    public static void closeSessionFactory(){
        sessionFactory.close();
    }
    public static Session getSession(){
        if(sessionFactory!=null){
            return sessionFactory.openSession();
        }
        getSessionFactory();
        return sessionFactory.openSession();
    }
    public static void closeSession(Session session){
        session.close();
    }
}

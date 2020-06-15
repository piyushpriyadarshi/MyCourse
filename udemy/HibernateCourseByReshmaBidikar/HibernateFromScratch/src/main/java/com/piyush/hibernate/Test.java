package com.piyush.hibernate;

import com.piyush.hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by Piyush Priyadarshi.
 * User: @Piyush
 * Date: 14-06-2020
 * Time: 21:44
 */
public class Test {
    public static void main(String[] args) {
        Book book=new Book();
        book.setBookAuthor("Piyush priyadarshi");
        book.setBookName("My Journey2");


        Session session=HibernateUtil.getSession();

        Transaction tx=session.beginTransaction();
        session.save(book);


        tx.commit();

        HibernateUtil.closeSession(session);

        HibernateUtil.closeSessionFactory();
    }

}

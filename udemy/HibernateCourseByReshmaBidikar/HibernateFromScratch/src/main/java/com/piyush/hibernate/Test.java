package com.piyush.hibernate;

import com.piyush.hibernate.entity.Book;
import com.piyush.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Piyush Priyadarshi.
 * User: @Piyush
 * Date: 14-06-2020
 * Time: 21:44
 */
public class Test {
    public static void main(String[] args) {
    //Load vs Get

        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();

//        Person person=(Person) session.load(Person.class,10);
//        System.out.println(person.getName());

        Person person1=(Person) session.get(Person.class,10);
        System.out.println(person1.getName());

        tx.commit();
        HibernateUtil.closeSession(session);
        HibernateUtil.closeSessionFactory();



    }

}

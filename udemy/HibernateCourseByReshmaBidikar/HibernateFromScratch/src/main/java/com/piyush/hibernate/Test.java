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
//        Book book=new Book();
//        book.setBookAuthor("Piyush priyadarshi");
//        book.setBookName("My Journey2");
//
//
//        Session session=HibernateUtil.getSession();
//
//        Transaction tx=session.beginTransaction();
//        session.save(book);
//
//
//        tx.commit();
//
//        HibernateUtil.closeSession(session);
//
//        HibernateUtil.closeSessionFactory();

        /*


        1) 'Mickey Mouse', 35, Male
        2)  'Donald Duck', 30, Male
        3) Daisy Duck 32, Female,
        4) Peppa Pig 15, Female,
        5) Suzie Sheep, 18, Female
         */

        List<Person> personList=new ArrayList<Person>();
        personList.add(new Person("Mickey Mouse",35,"Male"));
        personList.add(new Person("Donald Duck",30,"Male"));
        personList.add(new Person("Daisy Duck",32,"Female"));
        personList.add(new Person("Peppa Pig",15,"Female"));
        personList.add(new Person("Suzie Sheep",18,"Female"));

        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        for (Person person:personList) {
            session.persist(person);
        }
        tx.commit();
        HibernateUtil.closeSession(session);
        HibernateUtil.closeSessionFactory();


    }

}

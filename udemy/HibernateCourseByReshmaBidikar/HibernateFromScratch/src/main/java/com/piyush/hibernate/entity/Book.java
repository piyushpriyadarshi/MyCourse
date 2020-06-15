package com.piyush.hibernate.entity;


import javax.persistence.*;

/**
 * Created by Piyush Priyadarshi.
 * User: @Piyush
 * Date: 15-06-2020
 * Time: 13:43
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private  String bookAuthor;

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public Book setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Book setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        return this;
    }

    public Book(int id, String bookName, String bookAuthor) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public Book(){

    }
}

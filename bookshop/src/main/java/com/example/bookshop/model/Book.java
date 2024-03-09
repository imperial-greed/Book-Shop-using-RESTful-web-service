/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookshop.model;

/**
 *
 * @author Cardo Dalisay
 */
public class Book {
    private Long id;
    private String title;
    private double price;
    
    //Constructors
    public Book(Long id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    
    //Getter and setter methods
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
     public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Book() {
    	
    }
}

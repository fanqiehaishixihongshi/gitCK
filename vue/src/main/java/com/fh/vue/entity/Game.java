package com.fh.vue.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Game {
    private int id;
    private String name;
    private int price;
    private String account;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date showTime;

    public Game() {
    }

    public Game(int id, String name, int price, String account, Date showTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.account = account;
        this.showTime = showTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }
}

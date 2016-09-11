package model;

import java.util.*;

public class Order {

    private int id;
    private Member member;
    private Date date;
    private String shippingAddress;

    Order(int id, Member member, Date date, String shippingAddress) {
        this.id = id;
        this.member = member;
        this.date = date;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}

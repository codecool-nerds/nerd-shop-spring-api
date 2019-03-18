package com.codecool.nerdshop.users;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;

@Entity(name = "UserData")
@Table(name = "user_data")
public class UserData {
    @Id
    private Long id;
    @Column(name = "pic_url")
    private String picUrl;
    private Long balance;
    private Long exp;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonGetter("user")
    public Long getUserId(){
        return user.getId();
    }
}

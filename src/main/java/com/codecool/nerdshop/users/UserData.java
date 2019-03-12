package com.codecool.nerdshop.users;

import javax.persistence.*;

@Entity(name = "UserData")
@Table(name = "user_data")
public class UserData {
    @Id
    private Long id;
    private String pic_url;
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

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
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
}

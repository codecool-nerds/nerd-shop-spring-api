package com.codecool.nerdshop.users;

import com.codecool.nerdshop.users.addresses.Address;
import com.codecool.nerdshop.users.userData.UserData;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "hashed_password")
    private String hashedPassword;
    private String hash;
    @Column(name = "session_id")
    private String sessionId;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserData userData;

    public User() {
    }

    public User(String email, String hashedPassword, AccessLevel accessLevel) {
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.accessLevel = accessLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

//    @JsonGetter("address")
//    public Long getAddressId() {
//        return address.getId();
//    }
//
//    @JsonGetter("userData")
//    public Long getUserDataId() {
//        return userData.getId();
//    }
}

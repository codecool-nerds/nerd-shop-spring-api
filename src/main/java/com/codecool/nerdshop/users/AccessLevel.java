package com.codecool.nerdshop.users;



public enum AccessLevel {
    ADMIN,
    USER;

    @Override
    public String toString() {
        return this.name();
    }
}

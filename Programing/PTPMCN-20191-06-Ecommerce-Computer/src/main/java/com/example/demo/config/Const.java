package com.example.demo.config;

/**
 * @author Hung Hoang
 * @version 1.0 Dec 15, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name Const.java
 * @description TODO
 */
public class Const {
    // ROLES
    public static final String ROLE_MEMBER = "ROLE_MEMBER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final String ROLE_STOCKER = "ROLE_STOCKER";
    public static final String ROLE_SHIPPER = "ROLE_SHIPPER";
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    
    // ORDER STATUS
    public static final int NEW = 0;
    public static final int CONFIRMED = 1;
    public static final int DESTROYED = 2;
    public static final int ASSIGNED = 3;
    public static final int DELIVERING = 4;
    public static final int COMPLETED = 5;

    // NUMBER DAY OF DELAY CONVENTION
    public static final int DELAY = 3;
    
    // USER STATUS
    public static final int ACTIVE = 1;
    public static final int BLOCKED = 2;
}

package com.revature;

import com.revature.daos.UserDAO;
import com.revature.pojos.User;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting...");
        Connection connection = ConnectionManager.getConnection();
        User Dayna = new User("djones", "djones@email.com", "Okinawa21!");
        UserDAO userDao = new UserDAO(connection);

        userDao.create(Dayna);




        System.out.println("Done!");

    }
}

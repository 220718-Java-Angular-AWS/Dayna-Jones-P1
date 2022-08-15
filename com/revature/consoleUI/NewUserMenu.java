package com.revature.consoleUI;

import com.revature.daos.UserDAO;
import com.revature.pojos.User;
import com.revature.services.ConsoleService;
import com.revature.services.UserService;

import java.util.Scanner;

public class NewUserMenu extends View{
    private UserService service;
    public NewUserMenu() {
        viewName = "NewUser";
        consoleService = ConsoleService.getConsoleService();
        service = new UserService();
    }
    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("====== New User ======");
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(username, email, password);
        service.save(newUser);


        consoleService.navigate("MainMenu");





    }
}

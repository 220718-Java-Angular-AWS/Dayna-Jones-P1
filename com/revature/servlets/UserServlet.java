package com.revature.servlets;
import com.revature.pojos.User;
import com.revature.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserService service;
    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("User servlet initializing...");
        this.service = new UserService();
        this.mapper = new ObjectMapper();
        System.out.println("User servlet initialized!");
    }
    @Override
    public void destroy() {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if (param == null) {
            //Returning all if no input for userId detected (unsafe)
            List<User> userList = service.getAllUsers();
            String json = mapper.writeValueAsString(userList);
            resp.getWriter().println(json);
        } else {
            //specified userId input detected (favored)
            Integer userId = Integer.parseInt(req.getParameter("user-id"));
            User user = service.getUser(userId);
            String json = mapper.writeValueAsString(user);
            resp.getWriter().println(json);
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();
        User newUsers = mapper.readValue(json, Users.class);
        service.saveUser(newUser);
        System.out.println("New user created");
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        User newUser = mapper.readValue(json, User.class);
        service.updateUser(newUser);
        System.out.println("Current user has been updated");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if (param == null) {
            resp.getWriter().println("User id not found");
        } else {
            Integer userId = Integer.parseInt(req.getParameter("user_Id"));
            service.deleteUser(userId);
            resp.getWriter().println("User has been Deleted");
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
}
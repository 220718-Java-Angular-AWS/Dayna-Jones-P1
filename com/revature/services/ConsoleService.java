package com.revature.services;

import com.revature.consoleUI.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private static ConsoleService viewManager;
    private boolean running;

    List<View> ViewList;
    Scanner scanner;
    View nextView;

    private ConsoleService() {
        running = true;
        scanner = new Scanner(System.in);
        ViewList = new LinkedList<>();
    }

    public static ConsoleService getConsoleService() {
        if(viewManager == null) {
            viewManager = new ConsoleService();
        }
        return viewManager;
    }

    public void navigate(String destination) {
        for(View view : ViewList) {
            if(view.getViewName().equals(destination)) {
                nextView = view;
            }
        }
    }

    public void registerView(View view) {
        ViewList.add(view);
    }

    public void render() {
        nextView.renderView();
    }

    public Scanner getScanner(){
        return scanner;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}


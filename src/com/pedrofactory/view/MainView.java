package com.pedrofactory.view;

import com.pedrofactory.controller.MainController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private MainController mainController;

    public void start() throws Exception {
        printMainMenu();
    }

    public void printMainMenu() throws Exception {
        System.out.println("--->Application Main menu<---" +
                "\n- Press button, please -" +
                "\n1 - Developer action" +
                "\n2 - Skill action" +
                "\n3 - Account action" +
                "\n4 - Exit");
        String command = reader.readLine();
        mainController.route(command);
    }
}

package com.pedrofactory.controller;

import com.pedrofactory.view.MainView;

public class MainController {
    DeveloperController developerController;
    AccountController accountController;
    SkillController skillController;
    MainView mainView;

    public void route(String command) throws Exception {
        switch (command) {
            case "0" -> mainView.printMainMenu();
            case "1" -> developerController.route("0");
            case "2" -> skillController.route("0");
            case "3" -> accountController.route("0");
            case "4" -> {
                System.out.println("See you next time, good luck!");
                System.exit(0);
            }
        }
    }

    public void setDeveloperController(DeveloperController developerController) {
        this.developerController = developerController;
    }

    public void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }

    public void setSkillController(SkillController skillController) {
        this.skillController = skillController;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
}

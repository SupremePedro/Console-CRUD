package com.pedrofactory.controller;

import com.pedrofactory.enums.AccountStatus;
import com.pedrofactory.model.Account;
import com.pedrofactory.repository.AccountRepository;
import com.pedrofactory.view.AccountView;

public class AccountController {
    MainController mainController;
    AccountView accountView;
    AccountRepository accountRepository;

    public void route(String command, Object... parameters) throws Exception {
        switch (command) {
            case "main" -> mainController.route("0");
            case "0" -> accountView.printMainMenu();
            case "1" -> accountView.actionCreateAccount();
            case "create" -> {
                Account newAccount = new Account();
                newAccount.setAccountStatus((AccountStatus) parameters[0]);
                accountView.printCreateAccount(accountRepository.create(newAccount));
            }
            case "2" -> accountView.actionReadAccountById();
            case "read" -> accountView.printReadAccount(accountRepository.read((long) parameters[0]));
            case "3" -> accountView.actionUpdateAccountById();
            case "update" -> {
                Account updateAccount = new Account();
                updateAccount.setAccountStatus((AccountStatus) parameters[1]);
                accountView.printUpdateAccount(accountRepository.update((long) parameters[0], updateAccount));
            }
            case "4" -> accountView.actionDeleteAccountById();
            case "delete" -> {
                accountRepository.delete((long) parameters[0]);
                accountView.printDeleteAccount();
            }
            case "exit" -> {
                System.out.println("See you next time, good luck!");
                System.exit(0);
            }
        }
    }

    public void setAccountView(AccountView accountView) {
        this.accountView = accountView;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

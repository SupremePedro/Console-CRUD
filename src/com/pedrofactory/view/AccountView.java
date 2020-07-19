package com.pedrofactory.view;

import com.pedrofactory.controller.AccountController;
import com.pedrofactory.enums.AccountStatus;
import com.pedrofactory.model.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AccountView {
    private AccountController accountController;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }

    public void printMainMenu() throws Exception {
        System.out.println("\n--->Account Main menu<---" +
                "\n- Press button, please -" +
                "\n0 - Go to main menu" +
                "\n1 - Create account" +
                "\n2 - Read account " +
                "\n3 - Update account" +
                "\n4 - Delete account" +
                "\n5 - Exit");
        String command = reader.readLine();
        accountController.route(command);
    }

    public void actionCreateAccount() throws Exception {
        System.out.println("\n--->Create Account<---");
        System.out.println("Chose new status: \n" +
                "1 - ACTIVE\n" +
                "2 - BANNED\n" +
                "3 - DELETED\n");
        int statusId = Integer.parseInt(reader.readLine());
        accountController.route("create", AccountStatus.values()[statusId - 1]);

    }

    public void printCreateAccount(Long id) throws Exception {
        System.out.println("\n--->Create Account menu<---");
        System.out.println(String.format("Account created with id %s", id));
        afterAction();
    }

    public void actionReadAccountById() throws Exception {
        System.out.println("\n--->Read Account<---");
        System.out.println("Please input account id ...");
        String command = reader.readLine();
        long accountId = Long.parseLong(command);
        accountController.route("read", accountId);

    }

    public void printReadAccount(Account account) throws Exception {
        System.out.println("\n--->Result of read account by id<---");
        System.out.println(account);
        afterAction();
    }

    public void actionUpdateAccountById() throws Exception {
        System.out.println("\n--->Update Account<---");
        System.out.println("Input account id for update");
        long accountId = Long.parseLong(reader.readLine());
        System.out.println("Chose new status: \n" +
                "1 - ACTIVE\n" +
                "2 - BANNED\n" +
                "3 - DELETED\n");
        int statusId = Integer.parseInt(reader.readLine());
        accountController.route("update", accountId, AccountStatus.values()[statusId - 1]);

    }

    public void printUpdateAccount(Account account) throws Exception {
        System.out.println("\n--->Updated Account<---");
        System.out.println("Account updated");
        System.out.println(account);
        afterAction();
    }

    public void actionDeleteAccountById() throws Exception {
        System.out.println("\n--->Delete Account<---");
        System.out.println("Input account id for delete...");
        String command = reader.readLine();
        long accountId = Long.parseLong(command);
        accountController.route("delete", accountId);

    }

    public void printDeleteAccount() throws Exception {
        System.out.println("\n--->Deleted Account<---");
        System.out.println("Account deleted.");
        afterAction();
    }

    public void afterAction() throws Exception {
        System.out.println("\n- Input next command, please -" +
                "\n0 - Go to account main menu" +
                "\nexit - Close application");
        String command = reader.readLine();
        accountController.route(command);
    }


}

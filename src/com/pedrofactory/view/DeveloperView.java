package com.pedrofactory.view;

import com.pedrofactory.controller.DeveloperController;
import com.pedrofactory.model.Developer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeveloperView {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void setDeveloperController(DeveloperController developerController) {
        this.developerController = developerController;
    }

    private DeveloperController developerController;

    public void printMainMenu() throws Exception {
        System.out.println("\n--->Developer main menu<---" +
                "\n- Press button, please -" +
                "\n0 - Go to main menu" +
                "\n1 - Create developer" +
                "\n2 - Read developer by id" +
                "\n4 - Update developer by id " +
                "\n5 - Update developer by id " +
                "\n6 - Exit");
        String command = reader.readLine();
        developerController.route(command.replace("0", "main"));
    }

    public void actionCreateDeveloper() throws Exception {
        System.out.println("\n--->Create Developer<---");
        System.out.println("Please input developer skill ids, for example '1 2 3' ");
        String ids = reader.readLine();
        System.out.println("Please input developer account id, for example '1' ");
        Long accountId = Long.parseLong(reader.readLine());
        developerController.route("create", ids, accountId);

    }

    public void printCreateDeveloper(Long id) throws Exception {
        System.out.println("\n--->Create Developer menu<---");
        System.out.println(String.format("Developer created with id %s", id));
        afterAction();
    }

    public void actionReadDeveloperById() throws Exception {
        System.out.println("\n--->Read Developer<---");
        System.out.println("Please input developer id ...");
        String command = reader.readLine();
        long developerId = Long.parseLong(command);
        developerController.route("read", developerId);

    }

    public void printReadDeveloper(Developer developer) throws Exception {
        System.out.println("\n--->Result of read developer by id<---");
        System.out.println(developer);
        afterAction();
    }

    public void actionUpdateDeveloperById() throws Exception {
        System.out.println("\n--->Update Developer<---");
        String command = reader.readLine();
        long developerId = Long.parseLong(command);
        developerController.route("update", developerId);

    }

    public void printUpdateDeveloper(Developer developer) throws Exception {
        System.out.println("\n--->Updated Developer<---");
        System.out.println("Developer updated");
        System.out.println(developer);
        afterAction();
    }

    public void actionDeleteDeveloperById() throws Exception {
        System.out.println("\n--->Delete Developer<---");
        String command = reader.readLine();
        long developerId = Long.parseLong(command);
        developerController.route("delete", developerId);

    }

    public void printDeleteDeveloper() throws Exception {
        System.out.println("\n--->Delete Developer<---");
        System.out.println("Developer deleted.");
        afterAction();
    }

    public void afterAction() throws Exception {
        System.out.println("\n- Input next command, please -" +
                "\n0 - Go to developer main menu" +
                "\nexit - Close application");
        String command = reader.readLine();
        developerController.route(command);
    }
}

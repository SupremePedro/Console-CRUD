package com.pedrofactory.controller;

import com.pedrofactory.model.Developer;
import com.pedrofactory.model.Skill;
import com.pedrofactory.repository.AccountRepository;
import com.pedrofactory.repository.DeveloperRepository;
import com.pedrofactory.repository.SkillRepository;
import com.pedrofactory.view.DeveloperView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeveloperController {
    private MainController mainController;
    private DeveloperRepository developerRepository;
    private SkillRepository skillRepository;
    private AccountRepository accountRepository;
    private DeveloperView view;

    public void route(String command, Object... parameters) throws Exception {
        switch (command) {
            case "main":
                mainController.route("0");
            case "0":
                view.printMainMenu();
                break;
            case "1":
                view.actionCreateDeveloper();
                break;
            case "create":
                Developer newDeveloper = new Developer();
                String ids= (String) parameters[0];
                Set<Skill> skills = new HashSet<>();
                Arrays.stream(ids.split(" ")).forEach(idStr->{
                    long id = Long.parseLong(idStr);
                    skills.add(skillRepository.read(id));
                });
                newDeveloper.setSkills(skills);
                newDeveloper.setAccount(accountRepository.read((long)parameters[1]));
                view.printCreateDeveloper(developerRepository.create(newDeveloper));
                break;
            case "2":
                view.actionReadDeveloperById();
                break;
            case "read":
                view.printReadDeveloper(developerRepository.read((long) parameters[0]));
                break;
            case "3":
                view.actionUpdateDeveloperById();
                break;
            case "update":
                view.printUpdateDeveloper(developerRepository.update((Long) parameters[0], (Developer) parameters[1]));
                break;
            case "4":
                view.actionDeleteDeveloperById();
                break;
            case "delete":
                developerRepository.delete((Long) parameters[0]);
                view.printDeleteDeveloper();
                break;
            case "exit":
                System.out.println("See you next time, good luck!");
                System.exit(0);
        }
    }

    public void setDeveloperRepository(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public void setView(DeveloperView view) {
        this.view = view;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}

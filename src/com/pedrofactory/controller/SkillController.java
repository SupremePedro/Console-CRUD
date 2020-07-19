package com.pedrofactory.controller;

import com.pedrofactory.model.Skill;
import com.pedrofactory.repository.SkillRepository;
import com.pedrofactory.view.SkillView;

public class SkillController {
    MainController mainController;
    SkillView skillView;
    SkillRepository skillRepository;

    public void route(String command, Object... parameters) throws Exception {
        switch (command) {
            case "0":
                skillView.printMainMenu();
                break;
            case "1":
                skillView.actionCreateSkill();
                break;
            case "create":
                Skill newSkill = new Skill();
                newSkill.setName((String) parameters[0]);
                skillView.printCreateSkill(skillRepository.create(newSkill));
            case "2":
                skillView.actionReadSkillById();
                break;
            case "read":
                skillView.printReadSkill(skillRepository.read((long) parameters[0]));
                break;
            case "3":
                skillView.actionUpdateSkillById();
            case "update":
                Skill updateSkill = new Skill();
                updateSkill.setName((String) parameters[1]);
                skillView.printUpdateSkill(skillRepository.update((long) parameters[0], updateSkill));
            case "4":
                skillView.actionDeleteSkillById();
            case "main":
                mainController.route("0");
                break;
            case "exit":
                System.out.println("See you next time, good luck!");
                System.exit(0);

        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSkillView(SkillView skillView) {
        this.skillView = skillView;
    }

    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
}

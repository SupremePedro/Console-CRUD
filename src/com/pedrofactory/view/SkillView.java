package com.pedrofactory.view;

import com.pedrofactory.controller.SkillController;
import com.pedrofactory.model.Developer;
import com.pedrofactory.model.Skill;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkillView {
    private SkillController skillController;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void printMainMenu() throws Exception {
        System.out.println("--->Skill Main menu<---" +
                "\n- Press button, please -" +
                "\n0 - Go to main menu" +
                "\n1 - Create skill" +
                "\n2 - Read skill by id" +
                "\n3 - Update skill by id" +
                "\n4 - Delete skill by id" +
                "\n5 - Exit");
        String command = reader.readLine();
        skillController.route(command.replace("0","main"));
    }

    public void actionCreateSkill() throws Exception {
        System.out.println("\n--->Create Skill<---");
        System.out.println("Please input skill name");
        String skillName = reader.readLine();
        skillController.route("create", skillName);
    }
    public void printCreateSkill(Long id) throws Exception {
        System.out.println("\n--->Created Skill<---");
        System.out.println(String.format("Skill created with id %s", id));
        afterAction();
    }

    public void actionReadSkillById() throws Exception {
        System.out.println("\n--->Read Skill<---");
        System.out.println("Please input skill id ...");
        String command = reader.readLine();
        long skillId = Long.parseLong(command);
        skillController.route("read", skillId);

    }

    public void printReadSkill (Skill skill) throws Exception {
        System.out.println("\n--->Result of read skill by id<---");
        System.out.println(skill);
        afterAction();
    }

    public void actionUpdateSkillById() throws Exception {
        System.out.println("\n--->Update Skill<---");
        System.out.println("Please input skill id for update");
        String command = reader.readLine();
        long skillId = Long.parseLong(command);
        System.out.println("Please input new skill name");
        String newSkillName = reader.readLine();
        skillController.route("update", skillId,newSkillName);

    }

    public void printUpdateSkill(Skill skill) throws Exception {
        System.out.println("\n--->Updated Skill<---");
        System.out.println("Skill updated");
        System.out.println(skill);
        afterAction();
    }

    public void actionDeleteSkillById() throws Exception {
        System.out.println("\n--->Delete Skill<---");
        System.out.println("Please input skill id for deletion");
        String command = reader.readLine();
        long skillId = Long.parseLong(command);
        skillController.route("delete", skillId);

    }

    public void printDeleteSkill() throws Exception {
        System.out.println("\n--->Delete Skill<---");
        System.out.println("Skill deleted.");
        afterAction();
    }
    public void afterAction() throws Exception {
        System.out.println("\n- Input next command, please -"+
                "\n0 - Go to skill main menu"+
                "\nexit - Close application");
        String command = reader.readLine();
        skillController.route(command);
    }

    public void setSkillController(SkillController skillController) {
        this.skillController = skillController;
    }
}

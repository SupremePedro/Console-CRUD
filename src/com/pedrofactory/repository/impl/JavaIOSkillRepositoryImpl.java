package com.pedrofactory.repository.impl;

import com.pedrofactory.model.Skill;
import com.pedrofactory.repository.SkillRepository;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private final static String REPOSITORY_FILE_PATH = "skills.txt";

    @Override
    public Long create(Skill skill) {
        long lastId=0;
        List<Skill> skillList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))) {
            while (true){
                Skill lastSkill = (Skill)in.readObject();
                skillList.add(lastSkill);
                lastId = lastSkill.getId();

            }
        }catch (EOFException e){

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        skill.setId(lastId+1);
        skillList.add(skill);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
            for (Skill skill1 : skillList) {
                out.writeObject(skill1);
                System.out.println("Write to file -> "+skill1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skill.getId();
    }

    @Override
    public Skill read(Long id) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))) {
            Skill currentSkill = null;
            while (true) {
                currentSkill = (Skill) in.readObject();
                if (currentSkill.getId().equals(id)) {
                    return currentSkill;
                }
            }
        } catch (EOFException exc) {
            System.out.println(String.format("Object with id %s not found..", id));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Skill update(Long id, Skill skill) {
        Skill updatedSkill = null;
        List<Skill> skillList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
        ){
            Skill currentSkill = null;
            while (true){
                currentSkill = (Skill) in.readObject();
                if(currentSkill.getId().equals(id)){
                    currentSkill.setName(skill.getName());
                    updatedSkill = currentSkill;
                }
                skillList.add(currentSkill);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(updatedSkill)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Skill skill1 : skillList) {
                        out.writeObject(skill1);
                        System.out.println("Write to file -> "+skill1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return updatedSkill;
    }

    @Override
    public void delete(Long id) {
        List<Skill> skillList = new LinkedList<>();
        Skill deletedSkill = null;
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
        ){
            Skill currentSkill = null;
            while (true){
                currentSkill = (Skill) in.readObject();
                if(currentSkill.getId().equals(id)){
                    deletedSkill = currentSkill;
                    continue;
                }
                skillList.add(currentSkill);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(deletedSkill)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Skill skill1 : skillList) {
                        out.writeObject(skill1);
                        System.out.println("Write to file -> "+skill1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

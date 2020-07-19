package com.pedrofactory.repository.impl;

import com.pedrofactory.model.Developer;
import com.pedrofactory.repository.DeveloperRepository;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    private final static String REPOSITORY_FILE_PATH = "developers.txt";
    @Override
    public Long create(Developer developer) {
        long lastId=0;
        List<Developer> developerList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))) {
            while (true){
                Developer lastDeveloper = (Developer)in.readObject();
                developerList.add(lastDeveloper);
                lastId = lastDeveloper.getId();

            }
        }catch (EOFException e){

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        developer.setId(lastId+1);
        developerList.add(developer);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
            for (Developer developer1 : developerList) {
                out.writeObject(developer1);
                System.out.println("Write to file -> "+developer1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer.getId();
    }

    @Override
    public Developer read(Long id) {
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))){
            Developer currentDeveloper = null;
            while (true){
                currentDeveloper = (Developer) in.readObject();
                if(currentDeveloper.getId().equals(id)){
                    return currentDeveloper;
                }
            }
        }catch (EOFException exc)
        {
            System.out.println(String.format("Object with id %s not found..",id));
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Developer update(Long id, Developer developer) {
        Developer updatedDeveloper = null;
        List<Developer> developerList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
        ){
            Developer currentDeveloper = null;
            while (true){
                currentDeveloper = (Developer) in.readObject();
                if(currentDeveloper.getId().equals(id)){
                    currentDeveloper.setAccount(developer.getAccount());
                    currentDeveloper.setSkills(developer.getSkills());
                    updatedDeveloper = currentDeveloper;
                }
                developerList.add(currentDeveloper);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(updatedDeveloper)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Developer developer1 : developerList) {
                        out.writeObject(developer1);
                        System.out.println("Write to file -> "+developer1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return updatedDeveloper;
    }

    @Override
    public void delete(Long id) {
        List<Developer> developerList = new LinkedList<>();
        Developer deletedDeveloper = null;
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
        ){
            Developer currentDeveloper = null;
            while (true){
                currentDeveloper = (Developer) in.readObject();
                if(currentDeveloper.getId().equals(id)){
                    deletedDeveloper = currentDeveloper;
                    continue;
                }
                developerList.add(currentDeveloper);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(deletedDeveloper)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Developer developer1 : developerList) {
                        out.writeObject(developer1);
                        System.out.println("Write to file -> "+developer1);
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

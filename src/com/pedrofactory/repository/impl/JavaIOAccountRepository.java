package com.pedrofactory.repository.impl;

import com.pedrofactory.model.Account;
import com.pedrofactory.repository.AccountRepository;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class JavaIOAccountRepository implements AccountRepository {
    private final static String REPOSITORY_FILE_PATH = "accounts.txt";
    @Override
    public Long create(Account account) {
        long lastId=0;
        List<Account> accountList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))) {
            while (true){
                Account lastAccount = (Account)in.readObject();
                accountList.add(lastAccount);
                lastId = lastAccount.getId();

            }
        }catch (EOFException e){

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        account.setId(lastId+1);
        accountList.add(account);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
            for (Account account1 : accountList) {
                out.writeObject(account1);
                System.out.println("Write to file -> "+account1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account.getId();
    }

    @Override
    public Account read(Long id) {

        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))){
            Account currentAccount = null;
            while (true){
                currentAccount = (Account) in.readObject();
                if(currentAccount.getId().equals(id)){
                    return currentAccount;
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
    public Account update(Long id, Account account) {
        Account updatedAccount = null;
        List<Account> accountList = new LinkedList<>();
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
            ){
            Account currentAccount = null;
            while (true){
                currentAccount = (Account) in.readObject();
                if(currentAccount.getId().equals(id)){
                    currentAccount.setAccountStatus(account.getAccountStatus());
                    updatedAccount = currentAccount;
                }
                accountList.add(currentAccount);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(updatedAccount)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Account account1 : accountList) {
                        out.writeObject(account1);
                        System.out.println("Write to file -> "+account1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return updatedAccount;
    }

    @Override
    public void delete(Long id) {
        List<Account> accountList = new LinkedList<>();
        Account deletedAccount = null;
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE_PATH))
        ){
            Account currentAccount = null;
            while (true){
                currentAccount = (Account) in.readObject();
                if(currentAccount.getId().equals(id)){
                    deletedAccount = currentAccount;
                    continue;
                }
                accountList.add(currentAccount);
            }

        }catch (EOFException exc)
        {
            if(Objects.isNull(deletedAccount)){
                System.out.println(String.format("Object with id %s not found..",id));
            }else{
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE_PATH))){
                    for (Account account1 : accountList) {
                        out.writeObject(account1);
                        System.out.println("Write to file -> "+account1);
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

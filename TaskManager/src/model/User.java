/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author USER
 */
//  проверочка
public class User {
    private String id;
    private final String login;
    private final String password;
    private TaskLog taskLog;
    
    public User(String i, String l, String p, LinkedList<Record> rec){
        id = i;
        login = l;
        password = p;
        taskLog = new TaskLog(rec);
    }
    
    public String getId(){
        return id;
    }
    
    public void setId (String i){
        id=i;
    }

    public String getLogin(){
        return login;
    }
    
    public String getPassword(){
        return password;
    }
    
    public TaskLog getTaskLog(){
        return taskLog;
    }

}

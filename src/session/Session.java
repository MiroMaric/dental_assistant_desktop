/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.User;

/**
 *
 * @author MikoPC
 */
public class Session {
    
    private static Session instance;
    private User user;
    
    private Session(){
        
    }
    
    public static Session getInstance(){
        if(instance==null){
            instance = new Session();
        }
        return instance;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
}

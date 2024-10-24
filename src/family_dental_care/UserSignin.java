/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package family_dental_care;

import java.sql.ResultSet;

/**
 *
 * @author thoma
 */
public abstract class UserSignin {
    private String username; 
    private String password;
    
    public abstract ResultSet signin(String username, String password);
    
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }       
}
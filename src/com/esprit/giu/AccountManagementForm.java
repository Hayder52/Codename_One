/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.giu;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Entities.personnes;
import java.util.Random;

/**
 *
 * @author Fakhri Argoubi
 */
public class AccountManagementForm {
    Form myProfileForm;
    Container lastNameBox ;
    Container firstNameBox;
    Container adressBox ;
    Container profileBox ;
    Container loginBox ;
    Container emailBox ;
    
    Label lastNameLb ;
    Label sqlLastNameLb ;
   
    
    Label firstNameLb ;
    Label sqlFirstNameLb ;
    
    Label adressLb ;
    Label sqlAdressLb ;
    
    Label profieLb ;
    Label sqlProfileLb ;
    
    Label loginLb ;
    Label sqlLoginLb ;
    
    Label emailLb ;
    Label sqlEmailLb ;
    Button changePwd;
    public AccountManagementForm(personnes p) {
    myProfileForm= new Form("My account",BoxLayout.y());
    lastNameBox = new Container(BoxLayout.x());
    firstNameBox = new Container(BoxLayout.x());
    adressBox = new Container(BoxLayout.x());
    profileBox = new Container(BoxLayout.x());
    loginBox = new Container(BoxLayout.x());
    emailBox = new Container(BoxLayout.x());
    
    lastNameLb = new Label("Last Name");
    sqlLastNameLb = new Label(p.getNom());
    lastNameBox.add(lastNameLb);
    lastNameBox.add(sqlLastNameLb);
    
    firstNameLb = new Label("First Name");
    sqlFirstNameLb = new Label(p.getPrenom());
    firstNameBox.add(firstNameLb);
    firstNameBox.add(sqlFirstNameLb);
    
    adressLb = new Label("Adress");
    sqlAdressLb = new Label(p.getAdress());
    adressBox.add(adressLb);
    adressBox.add(sqlAdressLb);
    
    profieLb = new Label("Profile");
    sqlProfileLb = new Label(p.getProfile());
    profileBox.add(profieLb);
    profileBox.add(sqlProfileLb);
    
    loginLb = new Label("Login");
    sqlLoginLb = new Label(p.getLogin());
    loginBox.add(loginLb);
    loginBox.add(sqlLoginLb);
            
    emailLb = new Label("Email");
    sqlEmailLb = new Label(p.getEmail());
    emailBox.add(emailLb);
    emailBox.add(sqlEmailLb);
    
    changePwd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String numbers = "0123456789"; 
        String values = Capital_chars +numbers ; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] password = new char[5]; 
  
        for (int i = 0; i < 5; i++) 
        { 
            password[i] = values.charAt(rndm_method.nextInt(values.length()));
        } 
        Message m = new Message(password.toString());
        
        Display.getInstance().sendMessage(new String[] {"hamzaargoubi@hotmail.com"}, "Subject of message", m);
        
        }
    });
    
    
    myProfileForm.add(firstNameBox);
    myProfileForm.add(lastNameBox);
    myProfileForm.add(adressBox);
    myProfileForm.add(profileBox);
    myProfileForm.add(loginBox);
    myProfileForm.add(emailBox);
    myProfileForm.add(changePwd);
    
    
    myProfileForm.getToolbar().addCommandToLeftSideMenu("back", null, e->{
        
    });
    
    
    
    
    }
    
    
    
    
    
    public Form getForm(){
        return myProfileForm;
    } 
    
}

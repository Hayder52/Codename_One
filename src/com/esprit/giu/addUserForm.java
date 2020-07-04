/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.giu;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Entities.personnes;
import com.esprit.Service.ServicePersonnes;

/**
 *
 * @author Fakhri Argoubi
 */
public class addUserForm {
    Form addUserF ;
    TextField lastNameTf; 
    TextField firstNameTf; 
    TextField adressTf; 
    TextField profileTf; 
    TextField loginTf; 
    TextField emailTf; 
    TextField pwdTf;
    Button addBtn;
    personnes p;
    public addUserForm() {
        addUserF= new Form("Add a User",BoxLayout.y());
        lastNameTf=new TextField("","Last name");
        firstNameTf=new TextField("","First name");
        adressTf=new TextField("","adress");
        profileTf=new TextField("","profile");
        loginTf=new TextField("","login");
        emailTf=new TextField("","email");
        pwdTf=new TextField("","password");
        addBtn = new Button("add user");
        addUserF.add(lastNameTf); 
        addUserF.add(firstNameTf); 
        addUserF.add(adressTf); 
        addUserF.add(profileTf); 
        addUserF.add(loginTf); 
        addUserF.add(emailTf); 
        addUserF.add(pwdTf); 
        addUserF.add(addBtn); 
        addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
             p = new personnes(0, lastNameTf.getText(), firstNameTf.getText(),adressTf.getText()
                    , profileTf.getText(),null, loginTf.getText(), pwdTf.getText(),emailTf.getText());
            ServicePersonnes sp = new ServicePersonnes();
            sp.ajoutPersonne(p);
           
        
        });
        addUserF.getToolbar().addCommandToLeftBar("back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminManagementForm amf = new AdminManagementForm();
                amf.getForm().show();
            }
        });
        
    }
    
    public Form getForm(){
        return addUserF;
    }
}

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
import com.esprit.Entities.personnes;
import com.esprit.Service.ServicePersonnes;

/**
 *
 * @author Fakhri Argoubi
 */
public class editUserInterface {
    Form f ;
    TextField firstNameTf;
    TextField lastNameTf;
    TextField adressTf;
    TextField profileTf;
    TextField loginTf;
    TextField emailTf;
    TextField pwdTf;
    Button save;
    
    public editUserInterface(personnes p){
      f = new Form();
      firstNameTf=new TextField(p.getPrenom());
      lastNameTf=new TextField(p.getNom());
      adressTf = new TextField(p.getAdress());
      profileTf = new TextField(p.getProfile());
      loginTf = new TextField(p.getLogin());
      emailTf = new TextField(p.getEmail());
      pwdTf = new TextField(p.getPwd());
      save = new Button ("save");
      save.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              ServicePersonnes sp = new ServicePersonnes();
              sp.updatePersonne(p);
          }
      });
      f.add(firstNameTf);
      f.add(lastNameTf);
      f.add(adressTf);
      f.add(profileTf);
      f.add(loginTf);
      f.add(emailTf);
      f.add(pwdTf);
      f.add(save);
      
      f.getToolbar().addCommandToLeftBar("back", null, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              AdminManagementForm amf = new AdminManagementForm();
              amf.getForm().showBack();
          }
      });
    }
    public Form getForm (){
       return f; 
    }
}

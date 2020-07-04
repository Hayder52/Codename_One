/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.giu;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Entities.personnes;
import com.esprit.Service.ServicePersonnes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fakhri Argoubi
 */
public class AdminManagementForm {
    Form adminManagementForm ;
    Container addC ;
    Button addBtn;
    public AdminManagementForm() {
        adminManagementForm= new Form("Managinng Accounts",BoxLayout.y());
        List<personnes> listOfUsers = new ArrayList();
        ServicePersonnes sp = new ServicePersonnes();
        listOfUsers = sp.getList2();
        addC = new Container(new BorderLayout());
        addBtn = new Button("add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addUserForm auf = new addUserForm();
                auf.getForm().show();
            }
        });
        addC.add(BorderLayout.EAST,addBtn);
        for (personnes p : listOfUsers){
            Container c = new Container(new BorderLayout());
            Container cLabel = new Container(BoxLayout.x());
            Container cButton = new Container(BoxLayout.x());
            Label lastNameLb = new Label(p.getNom());
            Label firstNameLb = new Label(p.getPrenom());
            cLabel.add(lastNameLb);
            cLabel.add(firstNameLb);
            
            Button editBtn = new Button("edit");
            editBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    editUserInterface eui = new editUserInterface(p);
                    eui.getForm().show();
                    
                }
            });
            Button deleteBtn = new Button("delete");
            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ServicePersonnes sp = new ServicePersonnes();
                    sp.deletePersonne(p.getId_user());
                }
            });
            cButton.add(editBtn);
            cButton.add(deleteBtn);
            c.add(BorderLayout.WEST,cLabel);
            c.add(BorderLayout.EAST,cButton);
            
            adminManagementForm.add(c);
            
            
        }
        adminManagementForm.add(addC);
    }
    
    
    public Form getForm(){
        return adminManagementForm;
    }
    
    
    
}

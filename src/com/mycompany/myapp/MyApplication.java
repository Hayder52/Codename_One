package com.mycompany.myapp;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.messaging.Message;
import com.esprit.Entities.personnes;
import com.esprit.Service.ServicePersonnes;
import com.esprit.giu.AccountManagementForm;
import com.esprit.giu.AdminManagementForm;
import com.esprit.giu.addUserForm;
import java.util.ArrayList;
import java.util.List;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
       addUserForm addForm = new addUserForm();
        addForm.getForm().show();
        //AdminManagementForm amf = new AdminManagementForm();
        //amf.getForm().show();
        /*List <personnes> list = new ArrayList<>();
        ServicePersonnes sp = new ServicePersonnes();
        personnes p = new personnes();
        p=sp.getPersonne(1);
        AccountManagementForm amf = new AccountManagementForm(p);*/
       /* List <personnes> list = new ArrayList<>();
        ServicePersonnes sp = new ServicePersonnes();
        personnes p = new personnes();
        p=sp.getPersonne(1);
        list=sp.getList2();
        System.out.println(list);*/
        //sp.deletePersonne(114);
        //System.out.println("person deleted");
        
        /*Message m = new Message("hello");
        
        Display.getInstance().sendMessage(new String[] {"hamzaargoubi@hotmail.com"}, "Subject of message", m);*/
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}

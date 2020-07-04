/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.Entities.personnes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fakhri Argoubi
 */
public class ServicePersonnes {
    public void ajoutPersonne(personnes p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/personnesApp/addPersonne.php?" +"nom="+ p.getNom() +
                "&prenom=" + p.getPrenom()+ "&adress=" + p.getAdress()
                + "&profile=" + p.getProfile()+ "&login=" + p.getLogin()+ "&pwd=" + p.getPwd()+"&email="+p.getEmail();   // création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(false);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public ArrayList<personnes> parseListTaskJson(String json) {

        ArrayList<personnes> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                personnes p = new personnes();

               
                p.setNom(obj.get("nom").toString());
                p.setPrenom(obj.get("prenom").toString());
                p.setAdress(obj.get("adress").toString());
                p.setProfile(obj.get("profil").toString());
                p.setLogin(obj.get("login").toString());
                p.setPwd(obj.get("pwd").toString());
                p.setEmail(obj.get("email").toString());
                 int id = Integer.parseInt((String)obj.get("id_user").toString());
                System.out.println(id);
                p.setId_user((int) id);
                System.out.println(p);
                
                listTasks.add(p);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<personnes> listPersonnes = new ArrayList<>();
    
    public ArrayList<personnes> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/personnesApp/getPersonnes.php");  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePersonnes ser = new ServicePersonnes();
                listPersonnes = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPersonnes;
    }
    
    public personnes getPersonne(int id_user){
       personnes p = new personnes();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/personnesApp/get1Personne.php?"+"id_user="+id_user);  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                List<personnes> list = new ArrayList<>();
                ServicePersonnes ser = new ServicePersonnes();
                 list= ser.parseListTaskJson(new String(con.getResponseData()));
                 for(final personnes person :list){
                     p.setId_user(person.getId_user());
                     p.setNom(person.getNom());
                     p.setPrenom(person.getPrenom());
                     p.setAdress(person.getAdress());
                     p.setProfile(person.getProfile());
                     p.setLogin(person.getLogin());
                     p.setPwd(person.getPwd());
                     p.setEmail(person.getEmail());
                     
                 }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return p;
    }
    
    public void updatePersonne(personnes p){
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/personnesApp/updatePersonne.php?" +"id_user="+ p.getId_user()+"&nom="+ p.getNom() +
                "&prenom=" + p.getPrenom()+ "&adress=" + p.getAdress()
                + "&profile=" + p.getProfile()+ "&login=" + p.getLogin()+ "&pwd=" + p.getPwd()+"&email="+p.getEmail();;   // création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(false);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    
    
    public void deletePersonne(int id_user) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/personnesApp/deletePersonne.php?" +"id_user="+ id_user;   // création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(false);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}

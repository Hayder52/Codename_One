/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

/**
 *
 * @author Fakhri Argoubi
 */
public class personnes {
     private int id_user;
    private String nom;
    private String prenom;
    private String adress;
    private String profile;
    private String photo;
    private String login;
    private String pwd;
    private String email;
    
    public personnes() {
    }

    public personnes(int id_user, String nom, String prenom, String adress, String profile, String photo, String login, String pwd, String email) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.profile = profile;
        this.photo = photo;
        this.login = login;
        this.pwd = pwd;
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    

    @Override
    public String toString() {
        return "Personne{" + "id=" + id_user + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}

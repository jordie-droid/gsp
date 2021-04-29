/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Jordie
 */
public class Client {
    
    int numero;
    String noms;
    String adresse;
    String telephone;
    
    public Client (int numero, String noms, String adresse, String telephone){
        this.numero = numero;
        this.noms = noms;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setNoms(String noms){
        this.noms = noms;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getNoms(){
        return noms;
    }
    
    public String getAdresse(){
        return adresse;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
}

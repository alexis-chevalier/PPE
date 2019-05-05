/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import entites.RapportVisite;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class ListeRapportVisite {
     public ArrayList<RapportVisite> listeRapportVisite = new ArrayList();
    
    boolean insererRapport(RapportVisite rapport) {
        if (rapport == null){
            return false;
        }
        else{
            this.listeRapportVisite.add(rapport);
            return true;
        }
    }
    
    public RapportVisite lireRapport(int num) {
        for (RapportVisite listeRapport : this.listeRapportVisite) {
            if (listeRapport.numeroRapportVisite == num) {
                return listeRapport;
            }
        }
        return null;
    }
    
    
        
    void afficher(){
        for (RapportVisite listeRapport : this.listeRapportVisite){
            System.out.println(""+listeRapport.toString());
        }
    }
    
    ArrayList<RapportVisite> LireRapports(){
        return this.listeRapportVisite;
    } 

    boolean supprimerRapport(int num){
        boolean res = false;
        for (int i = 0; i < listeRapportVisite.size(); i++) {
            if (listeRapportVisite.get(i).numeroRapportVisite == num){
                listeRapportVisite.remove(i);
                res = true;
            }
        }
        return res;
    }
    
    boolean MettreAJourRapport(RapportVisite rapport){
        boolean res = false;
        for (int i = 0; i < listeRapportVisite.size(); i++) {
            if (listeRapportVisite.get(i).numeroRapportVisite == rapport.getNumero()){
                listeRapportVisite.remove(i);
                listeRapportVisite.add(i, rapport);
                res = true;
            }
        }
        return res;
    }
}

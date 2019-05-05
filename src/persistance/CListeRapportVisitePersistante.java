/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Praticien;
import entites.RapportVisite;
import entites.Visiteur;
import java.util.ArrayList;
import table.CTableRapportVisite;

/**
 *
 * @author Alexis
 */
public class CListeRapportVisitePersistante extends ListeRapportVisite {
    
    public CTableRapportVisite tableRapportVisite;

    public void setTableRapport(CTableRapportVisite tableRapportVisite) {
        this.tableRapportVisite = tableRapportVisite;
    }
    
    public boolean InsererRapport(RapportVisite rapport){        
        if (super.insererRapport(rapport) == false){
            return false;
        }
        tableRapportVisite.inserer(rapport);
        this.listeRapportVisite.clear();
        this.chargerTable();
        return true;
    }
    
    boolean SupprimerRapport(int num){
        if (super.supprimerRapport(num) == false){
            return false;
        }
        this.tableRapportVisite.supprimer(num);
        return true;
    }
    
    boolean MettreaJourRapport(RapportVisite rapport){
        if (super.MettreAJourRapport(rapport) == false){
            return false;
        }
        this.tableRapportVisite.modifier(rapport);
        return true;
    }
    
    public void chargerTable(){
        this.listeRapportVisite = this.tableRapportVisite.lireRapportVisites();
    }
    
    //Recupere la liste des rapports de visite
    public ArrayList<RapportVisite> getListeRapportsVisite(){
        CListeRapportVisitePersistante listeRapportVisitePersistance = new CListeRapportVisitePersistante();
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableRapportVisite tabRapport = new CTableRapportVisite();
        tabRapport.setBdd(bdd);
        
        listeRapportVisitePersistance.setTableRapport(tabRapport);
        listeRapportVisitePersistance.chargerTable();
        
        return listeRapportVisitePersistance.listeRapportVisite;
    }
    
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableRapportVisite tableRapportVisite = new CTableRapportVisite();
        tableRapportVisite.setBdd(bdd);
        
        CListeRapportVisitePersistante listeRapport = new CListeRapportVisitePersistante();
        listeRapport.setTableRapport(tableRapportVisite);
        listeRapport.chargerTable();
        
        Visiteur visiteur = new Visiteur("1");
        Praticien praticien = new Praticien(1);
        RapportVisite rapport = new RapportVisite(5,"1970-01-01","test","test",visiteur,praticien);
        listeRapport.InsererRapport(rapport);
    }
    
    
}

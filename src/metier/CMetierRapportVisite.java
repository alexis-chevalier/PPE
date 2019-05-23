/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Praticien;
import entites.RapportVisite;
import entites.Visiteur;
import java.sql.SQLException;
import java.util.ArrayList;
import table.CTablePraticien;
import table.CTableRapportVisite;
import table.CTableVisiteur;

/**
 *
 * @author Alexis
 */
public class CMetierRapportVisite {

    /**
     * Recupère la liste des rapports de visite
     *
     * @return la liste des rapports de visites
     */
    public ArrayList<RapportVisite> RecupererListeRapportVisite() {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableRapportVisite tableRapportVisite = new CTableRapportVisite();
        tableRapportVisite.setBdd(bdd);
        ArrayList<RapportVisite> liste = tableRapportVisite.lireRapportVisites();
        return liste;
    }

    /**
     * Recupere le nom et le prenom du visiteur grâce à son matricule
     *
     * @param matricule Chaîne de caractères
     * @return Retourne une chaine de caractères sous la forme "nom prenom"
     */
    public String RecupererNomPrenomVisiteur(String matricule) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableVisiteur tabVisiteur = new CTableVisiteur();
        tabVisiteur.setBdd(bdd);
        Visiteur visiteur = tabVisiteur.lireVisiteur(matricule);
        String nomPrenom = visiteur.getNomVisiteur() + " " + visiteur.getPrenomVisiteur();
        return nomPrenom;
    }

    /**
     * Recupere le nom du pratcien grâce à son numéro
     *
     * @param numero entier
     * @return Le nom du praticien en chaine de caractere
     */
    public String RecupererNomPraticien(int numero) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTablePraticien tabPraticien = new CTablePraticien();
        tabPraticien.setBdd(bdd);
        Praticien praticien = tabPraticien.lireUnPraticien(numero);
        String nom = praticien.getNomPraticien();
        return nom;
    }

    /**
     * Supprimer un rapport de visite grâce à son index dans le tableau
     *
     * @param index
     */
    public void SupprimerRapportVisite(int index) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableRapportVisite tabRapport = new CTableRapportVisite();
        tabRapport.setBdd(bdd);
        tabRapport.supprimer(index);
    }

    /**
     * Récupere le dernier id des rapports de visite. Utiliser pour
     * JFrame_Ajouter.
     *
     * @return le dernier id utiliser
     * @throws SQLException
     */
    public int RecupererDernierIdRapportVisite() throws SQLException {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableRapportVisite tabRapport = new CTableRapportVisite();
        tabRapport.setBdd(bdd);
        return tabRapport.getDernierId();
    }

    /**
     * Met tout les visiteurs dans un tableau de chaine de caractère. Utiliser
     * pour la comboBox.
     *
     * @return tout les visiteurs sous la forme d'un tableau de String.
     */
    public String[] RecupererTabVisiteur() {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableVisiteur tabVisiteur = new CTableVisiteur();
        return tabVisiteur.RecupererTabVisiteur(bdd);
    }

    public static void main(String[] args) {
        CMetierRapportVisite metier = new CMetierRapportVisite();
        //System.out.println(metier.RecupererNomPrenomVisiteur("3"));
        System.out.println(metier.RecupererTabVisiteur());
    }
}

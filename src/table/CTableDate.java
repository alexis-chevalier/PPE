/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.DatePPE;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableDate {

    protected CBDD bdd;

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    /**
     * Permet de créer la table si elle n'existe pas
     *
     * @return
     */
    public int creerTable() {
        String requete = "CREATE TABLE IF NOT EXISTS `date` (\n"
                + "  `JJMMAA` date NOT NULL,\n"
                + "  PRIMARY KEY (`JJMMAA`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
        int res = -1;
        if (bdd.connecter() == true) {
            bdd.executerRequeteUpdate(requete);
            res = 1;
            bdd.deconnecter();
        } else {
            System.out.println("Connexion à la base impossible");
        }
        return res;
    }

    /**
     * Permet de supprimer la table
     * @return 
     */    
    public int supprimerTable(){
        String req1 = "SET foreign_key_checks = 0;";
        String requete = "DROP TABLE IF EXISTS `date`;";
        String req2 = "SET foreign_key_checks = 1;";
        int res = -1;
        if (bdd.connecter() == true) {
            bdd.executerRequeteUpdate(req1);
            bdd.executerRequeteUpdate(requete);
            bdd.executerRequeteUpdate(req2);
            res = 1;
            bdd.deconnecter();
        } else {
            System.out.println("Connexion à la base impossible");
        }
        return res;
    }
    
     /**
     * Permet d'insérer un secteur dans la BDD
     *
     * @param date
     * @return
     */
    public int inserer(DatePPE date) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `date` (`JJMMAA`) VALUES ('"
                   + date.getJJMMAA()+"')";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /**
     * Permet de supprimer un secteur dans la BDD grâce à son id
     *
     * @param date
     * @return
     */
    public int supprimer(DatePPE date) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `date` WHERE `JJMMAA` = '" + date.getJJMMAA()+"'" ;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public DatePPE convertir_RS_Date(ResultSet rs) {
        try {
            String date = rs.getString("JJMMAA");
            return new DatePPE(date);
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Permet de lire toute la table `JJMMAA`
     * @return 
     */
    public ArrayList<DatePPE> lireDates() {
        if (bdd.connecter() == true) {
            ArrayList<DatePPE> listeDate = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from date");
            try {
                while (rs.next()) {
                    DatePPE date = convertir_RS_Date(rs);
                    listeDate.add(date);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeDate;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }    
    
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableDate table = new CTableDate();
        GregorianCalendar gc = new GregorianCalendar();
        Date date = new Date(gc.getTimeInMillis());
        //DatePPE dateppe = new DatePPE(date);
        
        table.setBdd(bdd);
        //table.inserer(dateppe);
        ArrayList<DatePPE> listeDate = table.lireDates();
        for (DatePPE dateppe : listeDate) {
            System.out.println(dateppe.toString());
        }
        //table.creerTable();
    }
    
}

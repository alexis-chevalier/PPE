/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.DatePPE;
import entites.Region;
import entites.Travailler;
import entites.Visiteur;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableTravailler {

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
        String requete = "CREATE TABLE IF NOT EXISTS `travailler` (\n"
                + "  `REG_CODE` tinyint(4) NOT NULL,\n"
                + "  `JJMMAA` date NOT NULL,\n"
                + "  `VIS_MATRICULE` varchar(4) COLLATE utf8_unicode_ci NOT NULL,\n"
                + "  `TRA_ROLE` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  PRIMARY KEY (`REG_CODE`,`JJMMAA`,`VIS_MATRICULE`),\n"
                + "  KEY `FK_TRAVAILLER_JJMMAA` (`JJMMAA`),\n"
                + "  KEY `FK_TRAVAILLER_VIS_MATRICULE` (`VIS_MATRICULE`)\n"
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
     *
     * @return
     */
    public int supprimerTable() {
        String req1 = "SET foreign_key_checks = 0;";
        String requete = "DROP TABLE IF EXISTS `travailler`;";
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
     * Permet d'insérer dans la BDD
     *
     * @param travail
     * @return
     */
    public int inserer(Travailler travail) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `travailler` (`REG_CODE`, `JJMMAA`, `VIS_MATRICULE`, `TRA_ROLE`) "
                    + "VALUES ('"+travail.getRegion().getId()+"',"
                    + " '"+travail.getDateppe().getJJMMAA()+"',"
                    + " '"+travail.getVisiteur().getMatricule()+"',"
                    + " '"+travail.getRole()+"')";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /**
     * Permet de supprimer dans la BDD grâce à son id
     *
     * @param travail
     * @return
     */
    public int supprimer(Travailler travail) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `travailler` WHERE `REG_CODE` = '" + travail.getRegion().getId()+"' AND `JJMMAA` = '"+travail.getDateppe().getJJMMAA()+"' AND `VIS_MATRICULE` = '"+travail.getVisiteur().getMatricule()+"';" ;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public Travailler convertir_RS_Travailler(ResultSet rs) {
        CTableTravailler travail = new CTableTravailler();
        try {
            int region = rs.getInt("REG_CODE");
            String date = travail.SQLDateversDate(rs.getDate("JJMMAA"));
            String matricule = rs.getString("VIS_MATRICULE");
            String role = rs.getString("TRA_ROLE");
            return new Travailler(new Region(region), new DatePPE(date), new Visiteur(matricule), role);
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Permet de lire toute la table `travailler`
     * @return une lite de Travailler
     */
    public ArrayList<Travailler> lireTravaillers() {
        if (bdd.connecter() == true) {
            ArrayList<Travailler> listeTravail = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from travailler");
            try {
                while (rs.next()) {
                    Travailler travail = convertir_RS_Travailler(rs);
                    listeTravail.add(travail);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeTravail;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }  
    
    /**
     * Permet de lire un travail dans la BDD grâce à l'id de la région, la date et le matricule du visiteur.
     * @param travailler
     * @return 
     */
    public Travailler lireTravail(Travailler travailler) {
        Travailler travail = null;
        if (bdd.connecter() == true) {
            ResultSet rs = bdd.executerRequeteQuery("select * from travailler  WHERE `REG_CODE` = " + travailler.getRegion().getId()+ " AND `JJMMAA` = '"+travailler.getDateppe().getJJMMAA()+"' AND `VIS_MATRICULE` = '"+travailler.getVisiteur().getMatricule()+"'");
            try {
                if (rs.next()) {
                    travail = convertir_RS_Travailler(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return travail;
    }
    
    /**
     * Permet de transformer une date SQL (AAAA-MM-JJ) en une date normale (JJ/MM/AAAA).
     * @param dateSQL
     * @return Une date en chaine de caractères.
     */
    public String SQLDateversDate(Date dateSQL) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String Date = formatter.format(dateSQL);
        
        return Date;
    }

    public static void main(String[] args) {
        CTableTravailler table = new CTableTravailler();
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        Region region = new Region(1);
        GregorianCalendar gc = new GregorianCalendar();
        Date date = new Date(gc.getTimeInMillis());
        DatePPE dateppe = new DatePPE(date.toString());
        Visiteur visiteur = new Visiteur("1");
        //Travailler travail = new Travailler(region, dateppe, visiteur,"c est juste un test");
        
        table.setBdd(bdd);
        //table.inserer(travail);
        ArrayList<Travailler> listeTravailler = table.lireTravaillers();
        for (Travailler travail : listeTravailler) {
            System.out.println(travail);
        }
        //System.out.println(table.lireTravail(travail));
    }
    
    
}

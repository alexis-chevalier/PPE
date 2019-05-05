/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Secteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableSecteur {

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
        String requete = "CREATE TABLE IF NOT EXISTS `secteur` (\n"
                + "  `SEC_CODE` tinyint(4) NOT NULL,\n"
                + "  `SEC_LIBELLE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  PRIMARY KEY (`SEC_CODE`)\n"
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
        String requete = "DROP TABLE IF EXISTS `secteur`;";
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
     * @param secteur
     * @return
     */
    public int inserer(Secteur secteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `secteur` (`SEC_CODE`, `SEC_LIBELLE`) VALUES ('"
                    + secteur.getCode()+"', '"
                    + secteur.getLibelle()+"')";
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
     * @param code
     * @return
     */
    public int supprimer(int code) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `secteur` WHERE `SEC_CODE` = '" + code + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /**
     * Permet de modifier un secteur dans la BDD
     *
     * @param secteur
     * @return
     */
    public int modifier(Secteur secteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `secteur` SET `SEC_LIBELLE` = '"+
                    secteur.getLibelle()+"' WHERE `secteur`.`SEC_CODE` = "+secteur.getCode();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public Secteur convertir_RS_Secteur(ResultSet rs) {
        try {
            int code = rs.getInt("SEC_CODE");
            String libelle = rs.getString("SEC_LIBELLE");
            return new Secteur(code, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Secteur> lireSecteurs() {
        if (bdd.connecter() == true) {
            ArrayList<Secteur> listeDepartement = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from secteur");
            try {
                while (rs.next()) {
                    Secteur secteur = convertir_RS_Secteur(rs);
                    listeDepartement.add(secteur);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeDepartement;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Secteur lireSecteur(int code) {
        Secteur rapport = null;
        if (bdd.connecter() == true) {
            ResultSet rs = bdd.executerRequeteQuery("select * from secteur  WHERE SEC_CODE = " + code);
            try {
                if (rs.next()) {
                    rapport = convertir_RS_Secteur(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return rapport;
    }
    
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableSecteur table = new CTableSecteur();
        //Secteur secteur = new Secteur(2,"abcd");
        
        table.setBdd(bdd);
        //table.inserer(secteur);
        ArrayList<Secteur> listeSecteur = table.lireSecteurs();
        /*for (Secteur secteur : listeSecteur) {
            System.out.println(secteur.toString());
        }*/
        System.out.println(table.lireSecteur(2));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Departement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableDepartement {

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
        String requete = "CREATE TABLE IF NOT EXISTS `departement` (\n"
                + "  `DEP_CODE` float NOT NULL,\n"
                + "  `DEP_CHEFVENTE` tinyint(1) DEFAULT NULL,\n"
                + "  `DEP_NOM` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  PRIMARY KEY (`DEP_CODE`)\n"
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
        String requete = "DROP TABLE IF EXISTS `departement`;";
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
     * Permet d'insérer un departement dans la BDD
     *
     * @param departement
     * @return
     */
    public int inserer(Departement departement) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `departement` (`DEP_CODE`, `DEP_CHEFVENTE`, `DEP_NOM`) VALUES ('"
                    + departement.getCode() + "', '"
                    + departement.getChefVente() + "', '"
                    + departement.getNom() + "')";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de supprimer un departement dans la BDD grâce à son numéro
     *
     * @param numero
     * @return
     */
    public int supprimer(int numero) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `departement` WHERE `DEP_CODE` = '" + numero + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de modifier un departement dans la BDD
     *
     * @param departement
     * @return
     */
    public int modifier(Departement departement) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `departement` SET `DEP_CHEFVENTE` = '"
                    + departement.getChefVente() + "', `DEP_NOM` = '"
                    + departement.getNom() + "' WHERE CONCAT(`departement`.`DEP_CODE`) = '"
                    + departement.getCode() + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public Departement convertir_RS_Departement(ResultSet rs) {
        try {
            int code = rs.getInt("DEP_CODE");
            int chefvente = rs.getInt("DEP_CHEFVENTE");
            String nom = rs.getString("DEP_NOM");
            return new Departement(code, nom, chefvente);
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Departement> lireDepartements() {
        if (bdd.connecter() == true) {
            ArrayList<Departement> listeDepartement = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from departement");
            try {
                while (rs.next()) {
                    Departement departement = convertir_RS_Departement(rs);
                    listeDepartement.add(departement);
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

    public Departement lireDepartement(int code) {
        Departement rapport = null;
        if (bdd.connecter() == true) {
            ResultSet rs = bdd.executerRequeteQuery("select * from departement  WHERE DEP_CODE = " + code);
            try {
                if (rs.next()) {
                    rapport = convertir_RS_Departement(rs);
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
        CTableDepartement table = new CTableDepartement();
        //Departement departement = new Departement(2,"test2",0);

        table.setBdd(bdd);
        //table.modifier(departement);

        /*ArrayList<Departement> listeDepartement = table.lireDepartements();
        for (Departement departement : listeDepartement) {
            System.out.println(departement.toString());
        }*/
        System.out.println(table.lireDepartement(2));
    }
}

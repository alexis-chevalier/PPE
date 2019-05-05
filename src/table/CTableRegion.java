/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Region;
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
public class CTableRegion {

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
        String requete = "CREATE TABLE IF NOT EXISTS `region` (\n"
                + "  `REG_CODE` tinyint(4) NOT NULL,\n"
                + "  `REG_NOM` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `SEC_CODE` tinyint(4) NOT NULL,\n"
                + "  PRIMARY KEY (`REG_CODE`),\n"
                + "  KEY `FK_REGION_SEC_CODE` (`SEC_CODE`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
        String req2 = "ALTER TABLE `region`\n"
                + "  ADD CONSTRAINT `FK_REGION_SEC_CODE` FOREIGN KEY (`SEC_CODE`) REFERENCES `secteur` (`SEC_CODE`);";
        int res = -1;
        if (bdd.connecter() == true) {
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
     * Permet de supprimer la table
     *
     * @return
     */
    public int supprimerTable() {
        String req1 = "SET foreign_key_checks = 0;";
        String requete = "DROP TABLE IF EXISTS `region`;";
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
     * Permet d'insérer une région dans la BDD
     *
     * @param region
     * @return
     */
    public int inserer(Region region) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `region` (`REG_CODE`, `REG_NOM`, `SEC_CODE`) VALUES ('"
                    + region.getId() + "', '"
                    + region.getNom() + "', '"
                    + region.getSecteur().getCode() + "')";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de supprimer une région dans la BDD grâce à son id
     *
     * @param id
     * @return
     */
    public int supprimer(int id) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `region` WHERE `REG_CODE` = '" + id + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de modifier une région dans la BDD
     *
     * @param region
     * @return
     */
    public int modifier(Region region) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `region` SET `REG_NOM` = '"
                    + region.getNom() + "', `SEC_CODE` = '"
                    + region.getSecteur().getCode() + "' WHERE `region`.`REG_CODE` = "
                    + region.getId();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public Region convertir_RS_Region(ResultSet rs) {
        try {
            int codeReg = rs.getInt("REG_CODE");
            String nom = rs.getString("REG_NOM");
            int codeSecteur = rs.getInt("SEC_CODE");
            return new Region(codeReg, nom,new Secteur(codeSecteur));
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Permet de lire toutes les régions de la table
     * @return 
     */
    public ArrayList<Region> lireRegions() {
        if (bdd.connecter() == true) {
            ArrayList<Region> listeRegion = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from region");
            try {
                while (rs.next()) {
                    Region region = convertir_RS_Region(rs);
                    listeRegion.add(region);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeRegion;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Permet de lire une région depuis la BDD grâce à son code.
     * @param code
     * @return 
     */
    public Region lireRegion(int code) {
        Region rapport = null;
        if (bdd.connecter() == true) {
            ResultSet rs = bdd.executerRequeteQuery("select * from region  WHERE REG_CODE = " + code);
            try {
                if (rs.next()) {
                    rapport = convertir_RS_Region(rs);
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
        CTableRegion table = new CTableRegion();
        Secteur secteur = new Secteur(2, "");
        Region region = new Region(1, "test3", secteur);

        table.setBdd(bdd);
        table.modifier(region);
        //table.inserer(region);
        ArrayList<Region> listeRegion = table.lireRegions();
        /*for (Region region : listeRegion) {
            System.out.println(region.toString());
        }*/
        //System.out.println(table.lireRegion(1));
    }

}

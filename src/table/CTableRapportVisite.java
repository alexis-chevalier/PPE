/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entites.RapportVisite;
import entites.Visiteur;
import entites.Praticien;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableRapportVisite {

    protected CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    /**
     * Permet de créer la table si elle n'existe pas
     *
     * @return
     */
    public int creerTable() {
        String requete = "CREATE TABLE IF NOT EXISTS `rapport_visite` (\n"
                + "  `RAP_NUM` smallint(6) NOT NULL,\n"
                + "  `RAP_DATE` date DEFAULT NULL,\n"
                + "  `RAP_BILAN` text COLLATE utf8_unicode_ci,\n"
                + "  `RAP_MOTIF` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_MATRICULE` varchar(4) COLLATE utf8_unicode_ci NOT NULL,\n"
                + "  `PRA_NUM` smallint(3) NOT NULL,\n"
                + "  PRIMARY KEY (`RAP_NUM`),\n"
                + "  KEY `FK_RAPPORT_VISITE_VIS_MATRICULE` (`VIS_MATRICULE`),\n"
                + "  KEY `FK_RAPPORT_VISITE_PRA_NUM` (`PRA_NUM`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
        String requete2 = "ALTER TABLE `rapport_visite`\n"
                + "  ADD CONSTRAINT `FK_RAPPORT_VISITE_PRA_NUM` FOREIGN KEY (`PRA_NUM`) REFERENCES `praticien` (`PRA_NUM`),\n"
                + "  ADD CONSTRAINT `FK_RAPPORT_VISITE_VIS_MATRICULE` FOREIGN KEY (`VIS_MATRICULE`) REFERENCES `visiteur` (`VIS_MATRICULE`);";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(requete);
            bdd.executerRequeteUpdate(requete2);
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
        String requete = "DROP TABLE IF EXISTS `rapport_visite`;";
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
     * Permet d'insérer un rapport dans la BDD
     *
     * @param rapport
     * @return
     */
    public int inserer(RapportVisite rapport) {
        CTableRapportVisite table = new CTableRapportVisite();
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        table.setBdd(bdd);
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `rapport_visite` (`RAP_NUM`, `RAP_DATE`, `RAP_BILAN`, `RAP_MOTIF`, `VIS_MATRICULE`, `PRA_NUM`)"
                    + " VALUES ('" + rapport.getNumero() + "',"
                    + " '" + rapport.getDate() + "', "
                    + " '" + rapport.getBilan() + "', "
                    + " '" + rapport.getMotif() + "', "
                    + " '" + rapport.getVisiteur().getMatricule() + "', "
                    + " " + rapport.getPraticien().getNumPraticien() + ")";
            System.out.println(req);
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de supprimer un rapport dans la BDD grâce à son numéro
     *
     * @param numero
     * @return
     */
    public int supprimer(int numero) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `rapport_visite` WHERE `RAP_NUM` = '" + numero + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de modifier un rapport dans la BDD
     *
     * @param rapport
     * @return
     */
    public int modifier(RapportVisite rapport) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `rapport_visite` "
                    + "SET `RAP_DATE` = '" + rapport.getDate() + "', `RAP_BILAN` = '" + rapport.getBilan()
                    + "', `RAP_BILAN` = '" + rapport.getBilan()
                    + "', `RAP_MOTIF` = '" + rapport.getMotif() + "' WHERE `rapport_visite`.`RAP_NUM` ='"
                    + rapport.getNumero() + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public RapportVisite convertir_RS_RapportVisite(ResultSet rs) {
        CTableRapportVisite table = new CTableRapportVisite();
        try {
            int num = rs.getInt("RAP_NUM");
            String date = table.SQLDateversDate(rs.getDate("RAP_DATE"));
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            String matricule = rs.getString("VIS_MATRICULE");
            int numPra = rs.getInt("PRA_NUM");
            return new RapportVisite(num, date, bilan, motif, new Visiteur(matricule), new Praticien(numPra));
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<RapportVisite> lireRapportVisites() {
        if (bdd.connecter() == true) {
            ArrayList<RapportVisite> listeRapportVisite = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from rapport_visite");
            try {
                while (rs.next()) {
                    RapportVisite rapport = convertir_RS_RapportVisite(rs);
                    listeRapportVisite.add(rapport);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeRapportVisite;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public RapportVisite lireRapportVisite(int id) {
        RapportVisite rapport = null;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select * from rapport_visite  WHERE RAP_NUM = " + id);
            try {
                if (rs.next()) {
                    rapport = convertir_RS_RapportVisite(rs);
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

    public String SQLDateversDate(Date dateSQL) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String Date = formatter.format(dateSQL);

        return Date;
    }

    public Date StringVersSQLDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date langDate = null;
        try {
            langDate = sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(langDate.getTime());
        return sqlDate;
    }

    public int getDernierId() throws SQLException {
        int index = 0;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select max(RAP_NUM) from rapport_visite");
            if (rs.next()) {
                index = rs.getInt("max(RAP_NUM)");
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return index;
    }
    
    
    
    public static void main(String[] args) throws SQLException {
        GregorianCalendar gc = new GregorianCalendar();
        Date SQLDate = new Date(gc.getTimeInMillis());
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        Visiteur visiteur = new Visiteur("1");
        Praticien praticien = new Praticien(1);
        //RapportVisite rapport = new RapportVisite(1, SQLDate, "bilan", "motif", visiteur,praticien);
        RapportVisite rapport2 = new RapportVisite(2, SQLDate, "bilan", "motif", visiteur, praticien);
        CTableRapportVisite table = new CTableRapportVisite();

        table.setBdd(bdd);
        //table.modifier(rapport2);
        //table.inserer(rapport2);
        /*ArrayList<RapportVisite> listeRapportVisites = table.lireRapportVisites();
        for (RapportVisite rapportVisite : listeRapportVisites) {
            System.out.println(rapportVisite);
        }*/
        //System.out.println(table.lireRapportVisite(2));
        //System.out.println(SQLDate);
        //System.out.println(table.SQLDateversDate(SQLDate));
        System.out.println(table.getDernierId());
    }

}

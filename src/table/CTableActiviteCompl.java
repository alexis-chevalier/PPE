/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Utilitaires.CUtilitaire_dateSQL_PPE;
import entites.ActiviteCompl;
import liste.ListeActiviteCompl;
import entites.Specialite;
import entites.Praticien;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clément
 */
public class CTableActiviteCompl {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableActiviteCompl() {
    }

    public CTableActiviteCompl(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table activite_compl dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTableActiviteCompl() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`activite_compl` ( `AC_NUM_ACTIVITE_COMPL` SMALLINT(6) UNSIGNED NOT NULL AUTO_INCREMENT , `AC_DATE_ACTIVITE_COMPL` DATE NULL , `AC_LIEU_ACTIVITE_COMPL` VARCHAR(50) NULL , `AC_THEME_ACTIVITE_COMPL` VARCHAR(50) NULL, PRIMARY KEY (`AC_NUM_ACTIVITE_COMPL`)) ENGINE = InnoDB;";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Méthode de suppression de la table activite_compl. Attention cette
     * méthode supprimeras entièrement la table activite_compl et toutes les
     * informations qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerActiviteCompl() {
        String req = "DROP TABLE IF EXISTS `activite_compl`;";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Méthode qui permet d'inserer un enregistrement TypePraticien dans la BDD
     *
     * @param ActiviteCompl insererActiviteCompl prend en paramètre un objet
     * ActiviteCompl préalablement créé. Elle insère une Activite complémentaire
     * dans la BDD
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererActiviteCompl(ActiviteCompl nouveau) {
        String req = "INSERT INTO `activite_compl`(`AC_NUM_ACTIVITE_COMPL`, `AC_DATE_ACTIVITE_COMPL`, `AC_LIEU_ACTIVITE_COMPL`, `AC_THEME_ACTIVITE_COMPL`) "
                + "VALUES ('"
                + nouveau.getNumActiviteCompl() + "', '"
                + nouveau.getToSQLDateActiviteCompl() + "', '"
                + nouveau.getLieuActiviteCompl() + "', '"
                + nouveau.getThemeActiviteCompl() + "');";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Méthode qui permet de modifier un enregistrement ActiviteCompl dans la
     * BDD.
     *
     * @param TypePraticien modifierTypePraticien prend en paramètre un objet
     * ActiviteCompl préalablement crée. Elle modifie cet élement au sein de la
     * BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierPraticien(ActiviteCompl numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `activite_compl` SET "
                + "`AC_NUM_ACTIVITE_COMPL`="
                + numero.getNumActiviteCompl() + "', '"
                + "`AC_DATE_ACTIVITE_COMPL`="
                + numero.getDateActiviteCompl() + "', '"
                + "`AC_LIEU_ACTIVITE_COMPL`="
                + numero.getLieuActiviteCompl() + "', '"
                + "`AC_THEME_ACTIVITE_COMPL`="
                + numero.getThemeActiviteCompl() + "', '"
                + "WHERE ppe.activite_compl = "
                + numero.getNumActiviteCompl() + "');";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Convertit les informations de la lecture de BDD
     *
     * @param rs Méthode qui permet de convertir les informations d'activité
     * complémentaire lors de la lecture de la BDD.
     * @return
     */
    ActiviteCompl convertirActiviteCompl(ResultSet rs) {
        try {
            int num = rs.getInt("AC_NUM_ACTIVITE_COMPL");
            Date date = rs.getDate("AC_DATE_ACTIVITE_COMPL");
            String lieu = rs.getString("AC_LIEU_ACTIVITE_COMPL");
            String theme = rs.getString("AC_THEME_ACTIVITE_COMPL");
            GregorianCalendar dateConvert = new GregorianCalendar();
            dateConvert.setTime(date);
            return new ActiviteCompl(num, dateConvert, lieu, theme);
        } catch (SQLException ex) {
            Logger.getLogger(Praticien.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Object query() {
        if (bdd.connecter() == true) {
            Object objet = new Object();
            ResultSet rs = bdd.executerRequeteQuery("");
            try {
                while (rs.next()) {
                    //lecture et creation objet par objet de l'entite correspondante
                    //ajout eventuel a une liste
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return objet;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture de toute la table activite_compl. Cette méthode doit
     * être utilisé conjointement avec afficherActivite_compl() de la classe
     * ListeActivite_compl.
     *
     * @return
     */
    public ListeActiviteCompl lireActiviteCompl() {
        if (bdd.connecter() == true) {
            ArrayList<ActiviteCompl> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`activite_compl`;");
            try {
                while (rs.next()) {
                    ActiviteCompl activiteComplementaire = convertirActiviteCompl(rs);
                    liste.add(activiteComplementaire);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeActiviteCompl listeActiviteCompl = new ListeActiviteCompl();
            listeActiviteCompl.setListeActiviteCompl(liste);
            return listeActiviteCompl;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture d'un élément ActiviteCompl.
     *
     * @param int Cette méthode prend en paramètre un objet ActiviteCompl, elle
     * permet de lire les informations d'un objet ActiviteCompl dans la BDD.
     * @return
     */
    public ActiviteCompl lireUneActiviteCompl(int num) {
        if (bdd.connecter() == true) {
            ActiviteCompl activiteComplementaire = new ActiviteCompl();
            activiteComplementaire.setNumActiviteCompl(num);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`activite_compl` where `AC_NUM_ACTIVITE_COMPL`=" + num + ";");
            try {
                while (rs.next()) {
                    activiteComplementaire = convertirActiviteCompl(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return activiteComplementaire;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de suppresion d'un élément ActiviteCompl dans la BDD.
     *
     * @param ActiviteCompl Cette méthode prend en paramètre un objet
     * ActiviteCompl. Elle supprime le ActiviteCompl correspondant dans la base
     * de donnée
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerUneActiviteCompl(ActiviteCompl numero) {
        String req = "DELETE FROM `ppe`.`activite_compl` WHERE `AC_NUM_ACTIVITE_COMPL`=" + numero.getNumActiviteCompl() + ";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res supprimer une activité supplémentaire = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public static void main(String[] args) {
        CTableActiviteCompl table = new CTableActiviteCompl();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableActiviteCompl();

        ActiviteCompl test = new ActiviteCompl();

        GregorianCalendar GCdate = new GregorianCalendar();
        Date SQLDate = new Date(GCdate.getTimeInMillis());
        /*
        test.setDateActiviteCompl(SQLDate);
        test.setLieuActiviteCompl("Clinique Saint Laurent");
        test.setThemeActiviteCompl("Epigenetique");

        table.insererActiviteCompl(test);
         */
        //table.supprimerPraticien();

        //test.setNumActiviteCompl(3);
        //table.supprimerUneActiviteCompl(test);
        //table.lireActiviteCompl().afficherActiviteCompl();
        // nouvelle methode d'affichage activite unique
        // table.lireUneActiviteCompl(2).affichageUniqueActiviteCompl(test);
        table.lireActiviteCompl().afficherActiviteCompl();
        // table.lireUneActiviteCompl(2).affichageUniqueActiviteCompl(test);
        /* ancienne méthode de lecture
        System.out.println(table.lireUneActiviteCompl(2));
        table.supprimerUneActiviteCompl(test);
         */
 /*
        GC test;
        test.setTime();
        Date SQLDate = new Date("aaaa-mm-jj");
        
        
        sout(SQLDate); --> imprimera "aaaa-mm-jj";
        
         */

    }

}

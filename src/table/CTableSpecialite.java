/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import liste.ListeSpecialite;
import entites.Specialite;

/**
 *
 * @author Clément
 */
public class CTableSpecialite {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableSpecialite() {
    }

    public CTableSpecialite(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table specialite dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTableSpecialite() {
        String req = "CREATE TABLE IF NOT EXISTS `specialite` ( `SPE_CODE_SPECIALITE` SMALLINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `SPE_LIBELLE_SPECIALITE` VARCHAR(50) NULL , PRIMARY KEY (`SPE_CODE_SPECIALITE`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table specialite. Attention cette méthode
     * supprimeras entièrement la table specialite et toutes les informations
     * qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerSpecialite() {
        String req = "DROP TABLE IF EXISTS `specialite`;";
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
     * Méthode qui permet d'inserer un enregistrement de type Specialite dans la
     * BDD
     *
     * @param Specialite La méthode insererSpecialite prend en paramètre
     * un objet Specialite préalablement créé. Elle insère cet objet dans la BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererSpecialite(Specialite nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `specialite`(`SPE_CODE_SPECIALITE`, `SPE_LIBELLE_SPECIALITE`) "
                + "VALUES ('"
                + nouveau.getCodeSpecialite() + "', '"
                + nouveau.getLibelleSpecialite() + "');";
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
     * Méthode qui permet de modifier un enregistrement Specialite dans la
     * BDD.
     *
     * @param Specialite modifierSpecialite prend en paramètre un objet
     * Specialite préalablement crée. Elle modifie cet élément au sein de la
     * BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierSpecialite(Specialite numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());

        String req = "UPDATE `specialite` SET "
                + "`SPE_LIBELLE_SPECIALITE`='"
                + numero.getLibelleSpecialite() + "', "
                + "WHERE `SPE_CODE_SPECIALITE`="
                + numero.getCodeSpecialite() + ";";
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
     * @param rs Méthode qui permet de convertir les informations de la table
     * type_praticien lors de la lecture.
     * @return
     */
    Specialite ConvertirSpecialite(ResultSet rs) {
        try {
            int code = rs.getInt("SPE_CODE_SPECIALITE");
            String libelle = rs.getString("SPE_LIBELLE_SPECIALITE");
            /*
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String idAdresse = rs.getString("idAdresse");
            String mail = rs.getString("mail");
            String telephone = rs.getString("telephone");
            String dateNaissance = rs.getString("dateNaissance");
             */
            //GregorianCalendar dateNaissanceGC = CUtilitaire_dateSQL_PPE.convertSQLDatetoGregCal(dateNaissance);

            return new Specialite(code, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(Specialite.class.getName()).log(Level.SEVERE, null, ex);
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
     * Méthode de lecture de toute la table specialite. Cette méthode doit
     * être utilisé conjointement avec afficherSpecialite() de la classe
     * ListeSpecialite.
     *
     * @return
     */
    public ListeSpecialite lireSpecialite() {
        if (bdd.connecter() == true) {
            ArrayList<Specialite> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `specialite`;");
            try {
                while (rs.next()) {
                    Specialite specialite = ConvertirSpecialite(rs);
                    liste.add(specialite);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeSpecialite possederSpecialite = new ListeSpecialite();
            possederSpecialite.setListePossederSpecialite(liste);
            return possederSpecialite;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture d'un objet Specialite.
     *
     * @param int Cette méthode prend en paramètre un objet TypePraticien, elle
     * permet de lire les informations d'un objet TypePraticien dans la BDD.
     * @return
     */
    public Specialite lireUniqueSpecialite(int num) {
        if (bdd.connecter() == true) {
            Specialite possederSpecialite = new Specialite();
            possederSpecialite.setCodeSpecialite(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `specialite` where `SPE_CODE_SPECIALITE`=" + num + ";");
            try {
                while (rs.next()) {
                    possederSpecialite = ConvertirSpecialite(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return possederSpecialite;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Methode de suppression d'un praticien. Permet de supprimer un praticien
     * en rentrant en paramètre son code (un entier).
     *
     * @param
     * @return affiche "1" si effectué, affiche "-1" si il y a une erreur de
     * détectée.
     */
    public int supprimerSpecialite(int code) {
        String req = "DELETE FROM `specialite` WHERE `SPE_CODE_SPECIALITE`=" + code + ";";
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

    /*
    avant :
        public int supprimerPraticien(Specialite code) {
        String req = "DELETE FROM `ppe`.`specialite` WHERE `SPE_CODE_SPECIALITE`=" + code.getCodeSpecialite() + ";";
     */
    public static void main(String[] args) {
        CTableSpecialite table = new CTableSpecialite();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        //table.creerTableSpecialite();
        //table.supprimerPossederSpecialite();

        Specialite specialite = new Specialite();
        /*      
        specialite.setDiplomePosseder("podologue du sport");
        specialite.setLibelleSpecialite("podologue");
        specialite.setCoefprescription(0.8F);
        table.insererPossederSpecialite(specialite);
         */
        //table.supprimerPraticien();
        // table.supprimerPraticien(code)
        //specialite.setCodeSpecialite(1);
        //specialite.setDiplomePosseder("pedicure");
        //specialite.setLibelleSpecialite("Soin du pied");
        //specialite.setCoefprescription(0.3F);

        //table.modifierSpecialite(specialite);
        //table.lireSpecialite().afficherPossederSpecialite();
        table.lireUniqueSpecialite(1).afficherUniqueSpecialite(specialite);
    }
}

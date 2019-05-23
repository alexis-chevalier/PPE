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
import liste.ListeRealiser;
import entites.Realiser;

/**
 *
 * @author admin
 */
public class CTableRealiser {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableRealiser() {
    }

    public CTableRealiser(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table realiser dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , elle retourne "-1" s'il y a une erreur.
     */
    public int creerTableRealiser() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`realiser` ( `VIS_MATRICULE_VISITEUR` SMALLINT(3) UNSIGNED NOT NULL, `AC_NUM_ACTIVITE_COMPL` TINYINT(3) NOT NULL, PRIMARY KEY (`VIS_MATRICULE_VISITEUR`, `AC_NUM_ACTIVITE_COMPL`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table realiser.
     *
     * Attention cette méthode supprimeras entièrement la table realiser et
     * toutes les informations qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerTableRealiser() {
        String req = "DROP TABLE IF EXISTS `realiser`;";
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
     * Méthode qui permet d'inserer un enregistrement Realiser dans la BDD
     *
     * @param Realiser nouveauRealiser prend en paramètre un objet Réaliser
     * préalablement crée.
     * @return , retourne "-1" s'il y a une erreur.
     */
    public int insererRealiser(Realiser nouveauRealiser) {
        String req = "INSERT INTO `realiser`(`VIS_MATRICULE_VISITEUR`, `AC_NUM_ACTIVITE_COMPL`) "
                + "VALUES ('"
                + nouveauRealiser.getVisMatriculeVisteur() + "', '"
                + nouveauRealiser.getNumActiviteCompl() + "');";
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
     * Methode qui permet de modifier un enregistrement Realiser dans la BDD.
     *
     * @param Realiser modifierRealiser prend en paramètre un objet Realiser
     * préalablement crée
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierRealiser(Realiser identifiant) {
        String req = "UPDATE `ppe`.`realiser` SET "
                + "`VIS_MATRICULE_VISITEUR`="
                + identifiant.getVisMatriculeVisteur() + ", "
                + "`AC_NUM_ACTIVITE_COMPL`="
                + identifiant.getNumActiviteCompl() + ";";
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
     * Réaliser lors de la lecture.
     * @return
     */
    Realiser convertirRealiser(ResultSet rs) {
        try {
            int matriculeVisiteur = rs.getInt("VIS_MATRICULE_VISITEUR");
            int numActivite = rs.getInt("AC_NUM_ACTIVITE_COMPL");
            return new Realiser(matriculeVisiteur, numActivite);
        } catch (SQLException ex) {
            Logger.getLogger(Realiser.class.getName()).log(Level.SEVERE, null, ex);
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
     * Méthode de lecture de toute la table Realiser. Cette méthode doit être
     * utilisé conjointement avec afficherRealiser() de la classe ListeRealiser
     *
     * @return
     */
    public ListeRealiser lireRealiser() {
        if (bdd.connecter() == true) {
            ArrayList<Realiser> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`realiser`;");
            try {
                while (rs.next()) {
                    Realiser realiser = convertirRealiser(rs);
                    liste.add(realiser);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeRealiser listeRealiser = new ListeRealiser();
            listeRealiser.setListeRealiser(liste);
            return listeRealiser;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    //avant Praticien "SELECT * FROM `ppe`.`praticien` where `PRA_NUM_PRATICIEN`=" + num + ";"
    /**
     * Méthode de lecture d'un élément réaliser.
     *
     * @param Realiser Cette méthode prend en paramètre un objet Realiser, elle
     * permet de lire les informations d'un objet Realiser dans la BDD.
     * @return
     */
    public ListeRealiser lireUnRealiser(Realiser realisation) {
        if (bdd.connecter() == true) {
            ArrayList<Realiser> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`realiser` where `VIS_MATRICULE_VISITEUR`=" + realisation.getVisMatriculeVisteur() + " AND `AC_NUM_ACTIVITE_COMPL`=" + realisation.getNumActiviteCompl() + ";");
            try {
                while (rs.next()) {
                    Realiser realiser = convertirRealiser(rs);
                    liste.add(realiser);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeRealiser listeRealiser = new ListeRealiser();
            listeRealiser.setListeRealiser(liste);
            return listeRealiser;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de suppresion d'un élément Realiser dans la BDD.
     *
     * @param Realiser Cette méthode prend en paramètre un objet Realiser. Elle
     * supprime le Realiser correspondant dans la base de donnée.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerRealiser(Realiser realisation) {
        String req = "DELETE FROM `ppe`.`realiser` where `VIS_MATRICULE_VISITEUR`=" + realisation.getVisMatriculeVisteur() + " AND `AC_NUM_ACTIVITE_COMPL`=" + realisation.getNumActiviteCompl() + ";";
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

    public static void main(String[] args) {

        CTableRealiser tableRealiser = new CTableRealiser();

        tableRealiser.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));

        Realiser test = new Realiser();
        test.setNumActiviteCompl(56);
        test.setVisMatriculeVisteur(45);
        /*
        tableRealiser.creerTableRealiser();
        tableRealiser.insererRealiser(test);
         */
        tableRealiser.lireRealiser().afficherRealiser();
        //tableRealiser.lireUnRealiser(test).afficherRealiser();

        //tableRealiser.modifierRealiser(test);
        //tableRealiser.supprimerRealiser(test);
        //tableRealiser.supprimerTableRealiser();
    }
}

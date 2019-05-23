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
import liste.ListePosseder;
import entites.Posseder;

/**
 *
 * @author admin
 */
public class CTablePosseder {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTablePosseder() {
    }

    public CTablePosseder(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table posseder dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTablePosseder() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`posseder` ( `PRA_NUM_PRATICIEN` SMALLINT(6) UNSIGNED NOT NULL, `SPE_CODE_SPECIALITE` SMALLINT(6) NOT NULL , `POS_DIPLOME_POSSEDER` VARCHAR(255), `POS_COEFPRESCRIPTION_POSSEDER`FLOAT, PRIMARY KEY (`PRA_NUM_PRATICIEN`, `SPE_CODE_SPECIALITE`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table posseder. Attention cette méthode
     * supprimeras entièrement la table posseder et toutes les informations
     * qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerTablePosseder() {
        String req = "DROP TABLE IF EXISTS `posseder`;";
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
     * Méthode qui permet d'inserer un enregistrement Posseder dans la BDD
     *
     * @param Posseder La méthode insererPosseder prend en paramètre un objet
     * Posseder préalablement créé. Elle insère un objet Posseder dans la BDD
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererPosseder(Posseder nouveauPosseder) {

        String req = "INSERT INTO `posseder`(`PRA_NUM_PRATICIEN`, `SPE_CODE_SPECIALITE`, `POS_DIPLOME_POSSEDER`, `POS_COEFPRESCRIPTION_POSSEDER`) "
                + "VALUES ('"
                + nouveauPosseder.getNumPraticien() + "', '"
                + nouveauPosseder.getCodeSpecialite() + "', '"
                + nouveauPosseder.getDiplomePosseder() + "', '"
                + nouveauPosseder.getCoefprescription() + "');";
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
     * Méthode qui permet de modifier un enregistrement Posseder dans la BDD.
     *
     * @param Posseder modifierPosseder prend en paramètre un objet Posseder
     * préalablement crée. Elle modifie cet élément au sein de la BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierPosseder(Posseder modifPosseder) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `ppe`.`posseder` SET "
                + "`PRA_NUM_PRATICIEN`="
                + modifPosseder.getNumPraticien() + ", "
                + "`SPE_CODE_SPECIALITE`='"
                + modifPosseder.getCodeSpecialite() + "', "
                + "`POS_DIPLOME_POSSEDER`='"
                + modifPosseder.getDiplomePosseder() + "', "
                + "`POS_COEFPRESCRIPTION_POSSEDER`="
                + modifPosseder.getCoefprescription() + " "
                + "WHERE `PRA_NUM_PRATICIEN` = "
                + modifPosseder.getNumPraticien() + " "
                + "AND  `SPE_CODE_SPECIALITE` = "
                + modifPosseder.getCodeSpecialite() + ";";
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
    Posseder convertirPosseder(ResultSet rs) {
        try {
            int numPrat = rs.getInt("PRA_NUM_PRATICIEN");
            int codeSpe = rs.getInt("SPE_CODE_SPECIALITE");
            String nomdiplome = rs.getString("POS_DIPLOME_POSSEDER");
            Float coefPrescription = rs.getFloat("POS_COEFPRESCRIPTION_POSSEDER"); // Si bug de convertir posseder <-- c'est ici ! getFloat !
            return new Posseder(numPrat, codeSpe, nomdiplome, coefPrescription);
        } catch (SQLException ex) {
            Logger.getLogger(Posseder.class.getName()).log(Level.SEVERE, null, ex);
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
     * Méthode de lecture de toute la table posseder. Cette méthode doit être
     * utilisé conjointement avec afficherTypePosseder() de la classe
     * ListePosseder.
     *
     * @return
     */
    public ListePosseder lirePosseder() {
        if (bdd.connecter() == true) {
            ArrayList<Posseder> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`posseder`;");
            try {
                while (rs.next()) {
                    Posseder posseder = convertirPosseder(rs);
                    liste.add(posseder);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePosseder listePosseder = new ListePosseder();
            listePosseder.setListePosseder(liste);
            return listePosseder;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture d'un élément Posseder.
     *
     * @param int Cette méthode prend en paramètre un objet Posseder, elle
     * permet de lire les informations d'un objet Posseder dans la BDD.
     * @return
     */
    public ListePosseder lireUnPosseder(int praNum, int speCode) {
        if (bdd.connecter() == true) {
            ArrayList<Posseder> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`posseder` where `PRA_NUM_PRATICIEN`=" + praNum + " AND `SPE_CODE_SPECIALITE`=" + speCode + ";");
            try {
                while (rs.next()) {
                    Posseder posseder = convertirPosseder(rs);
                    liste.add(posseder);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePosseder listePosseder = new ListePosseder();
            listePosseder.setListePosseder(liste);
            return listePosseder;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de suppresion d'un élément Posseder dans la BDD.
     *
     * @param TypePraticien Cette méthode prend en paramètre un objet
     * Posseder. Elle supprime l'enregistrement Posseder correspondant dans la base
     * de donnée
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerUnPosseder(Posseder posseder) {
        String req = "DELETE FROM `ppe`.`posseder` WHERE PRA_NUM_PRATICIEN=" + posseder.getNumPraticien() + " AND `SPE_CODE_SPECIALITE`=" + posseder.getCodeSpecialite() + ";";
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
        CTablePosseder tablePosseder = new CTablePosseder();
        tablePosseder.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        //tablePosseder.creerTablePosseder()
        //tablePosseder.supprimerTablePosseder();

        Posseder nouvellePossession = new Posseder();

        nouvellePossession.setNumPraticien(1);
        nouvellePossession.setCodeSpecialite(2);
        nouvellePossession.setDiplomePosseder("dentiste");
        nouvellePossession.setCoefprescription(0.8F);
        //tablePosseder.insererPosseder(nouvellePossession);
        //tablePosseder.modifierPosseder(nouvellePossession);
        tablePosseder.modifierPosseder(nouvellePossession);
        tablePosseder.lirePosseder().afficherPosseder();
    }
}

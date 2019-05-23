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
import liste.ListeInviter;
import entites.Inviter;

/**
 *
 * @author admin
 */
public class CTableInviter {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableInviter() {
    }

    public CTableInviter(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table INVITER dans la BDD. Si la table n'existe
     * pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTableInviter() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`INVITER` ( `AC_NUM_ACTVITE_COMPL` TINYINT(3) UNSIGNED NOT NULL, `PRA_NUM_PRATICIEN` TINYINT(3) NOT NULL, `SPECIALISTEON` VARCHAR(20) NULL, PRIMARY KEY (`AC_NUM_ACTVITE_COMPL`, `PRA_NUM_PRATICIEN`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table INVITER. Attention cette méthode
     * supprimeras entièrement la table INVITER et toutes les informations
     * qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerTableInviter() {
        String req = "DROP TABLE IF EXISTS `INVITER` ;";
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
     * Méthode qui permet d'inserer un enregistrement Inviter dans la BDD
     *
     * @param Inviter La méthode insererInviter prend en paramètre
     * un objet Réaliser préalablement créé. Elle insère un Inviter 
     * dans la BDD
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererInviter(Inviter nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `INVITER` (`AC_NUM_ACTVITE_COMPL`, `PRA_NUM_PRATICIEN`, `SPECIALISTEON`) "
                + "VALUES ('"
                + nouveau.getNumActiviteCompl() + "', '"
                + nouveau.getNumPraticien() + "', '"
                + nouveau.getSpecialisteon() + "');";
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
     * Méthode qui permet de modifier un enregistrement Inviter dans la
     * BDD.
     *
     * @param Inviter modifierInviter prend en paramètre un objet
     * Inviter préalablement crée. Elle modifie cet élément au sein de la
     * BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierInviter(Inviter numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `ppe`.`INVITER` SET "
                + "`AC_NUM_ACTVITE_COMPL`="
                + numero.getNumActiviteCompl() + ", "
                + "`PRA_NUM_PRATICIEN`="
                + numero.getNumPraticien() + ", "
                + "`SPECIALISTEON`='"
                + numero.getSpecialisteon() + "' "
                + "WHERE `AC_NUM_ACTVITE_COMPL`="
                + numero.getNumActiviteCompl() + " "
                + "AND `PRA_NUM_PRATICIEN`="
                + numero.getNumPraticien() + ";";
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
     * INVITER lors de la lecture.
     * @return
     */
    Inviter convertirInviter(ResultSet rs) {
        try {
            int numAct = rs.getInt("AC_NUM_ACTVITE_COMPL");
            int numPrat = rs.getInt("PRA_NUM_PRATICIEN");
            String specialiston = rs.getString("SPECIALISTEON");
            return new Inviter(numAct, numPrat, specialiston);
        } catch (SQLException ex) {
            Logger.getLogger(Inviter.class.getName()).log(Level.SEVERE, null, ex);
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
     * Méthode de lecture de toute la table INVITER. Cette méthode doit
     * être utilisé conjointement avec afficherInviter() de la classe
     * ListeInviter.
     *
     * @return
     */
    public ListeInviter lireInviter() {
        if (bdd.connecter() == true) {
            ArrayList<Inviter> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`INVITER`;");
            try {
                while (rs.next()) {
                    Inviter inviter = convertirInviter(rs);
                    liste.add(inviter);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeInviter listeInviter = new ListeInviter();
            listeInviter.setListeInviter(liste);
            return listeInviter;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    /**
     * Méthode de lecture d'un élément Inviter.
     *
     * @param int Cette méthode prend en paramètre un objet Inviter, elle
     * permet de lire les informations d'un objet Inviter dans la BDD.
     * @return
     */
    public Inviter lireUnInviter(Inviter invitation) {
        if (bdd.connecter() == true) {
            Inviter inviter = new Inviter();
            inviter.setNumActiviteCompl(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`INVITER` WHERE `AC_NUM_ACTVITE_COMPL`=" + invitation.getNumActiviteCompl() + " AND `PRA_NUM_PRATICIEN`=" + invitation.getNumPraticien() + ";");
            try {
                while (rs.next()) {
                    inviter = convertirInviter(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return inviter;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    /**
     * Méthode de suppresion d'un élément Inviter dans la BDD.
     *
     * @param Inviter Cette méthode prend en paramètre un objet
     * Inviter. Elle supprime le Inviter correspondant dans la base
     * de donnée
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerUnInviter(Inviter invitation) {
        String req = "DELETE FROM INVITER WHERE `AC_NUM_ACTVITE_COMPL`=" + invitation.getNumActiviteCompl() + " AND `PRA_NUM_PRATICIEN`=" + invitation.getNumPraticien() + ";";
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
        CTableInviter table = new CTableInviter();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));

        table.creerTableInviter();
        Inviter test = new Inviter();
        test.setNumActiviteCompl(1);
        test.setNumPraticien(2);
        test.setSpecialisteon("absent");
        //table.insererInviter(test);

        //table.supprimerTableInviter();
        //table.modifierInviter(test);
        //table.lireInviter().afficherInviter();
        //table.lireUnInviter(test.getNumActiviteCompl(), test.getNumPraticien()).affichageUniqueInviter(test);
        //table.supprimerUnInviter(test.getNumActiviteCompl(), test.getNumPraticien());
        table.supprimerUnInviter(test);
    }
}

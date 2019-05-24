/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Utilitaires.CUtilitaire_dateSQL_PPE;
import entites.ActiviteCompl;
import liste.ListePraticien;
import entites.Specialite;
import entites.Praticien;
import entites.TypePraticien;
import bdd.CBDD;
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
public class CTablePraticien {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTablePraticien() {
    }

    public CTablePraticien(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table praticien dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTablePraticien() {
        String req = "CREATE TABLE IF NOT EXISTS `praticien` ( `PRA_NUM_PRATICIEN` SMALLINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `PRA_CODE_PRATICIEN` TINYINT(3) NULL , `PRA_NOM_PRATICIEN` VARCHAR(25) NULL , `PRA_ADRESSE_PRATICIEN` VARCHAR(50) NULL , `PRA_CP_PRATICIEN` VARCHAR(5) NULL, `PRA_VILLE_PRATICIEN` VARCHAR(45) NULL, `PRA_COEFNOTORIETE_PRATICIEN` FLOAT NULL , `TYP_CODE_TYPE_PRATICIEN` TINYINT(3) NULL, `SPE_CODE_SPECIALITE` SMALLINT(3), PRIMARY KEY (`PRA_NUM_PRATICIEN`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table praticien. Attention cette méthode
     * supprimeras entièrement la table praticien et toutes les informations
     * qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerTablePraticien() {
        String req = "DROP TABLE IF EXISTS `praticien`;";
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
     * Méthode qui permet d'inserer un enregistrement Praticien dans la BDD
     *
     * @param Praticien La méthode insererPraticien prend en paramètre un objet
     * Praticien préalablement créé. Elle insère un type de praticien dans la
     * BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererPraticien(Praticien nouveauPraticien) {

        String req = "INSERT INTO `praticien`(`PRA_NUM_PRATICIEN`, `PRA_CODE_PRATICIEN`, `PRA_NOM_PRATICIEN`, `PRA_ADRESSE_PRATICIEN`, `PRA_CP_PRATICIEN`, `PRA_VILLE_PRATICIEN`, `PRA_COEFNOTORIETE_PRATICIEN`, `TYP_CODE_TYPE_PRATICIEN`, `SPE_CODE_SPECIALITE`) "
                + "VALUES ('"
                + nouveauPraticien.getNumPraticien() + "', '"
                + nouveauPraticien.getCodePraticien() + "', '"
                + nouveauPraticien.getNomPraticien() + "', '"
                + nouveauPraticien.getAdresse() + "', '"
                + nouveauPraticien.getCpPraticien() + "', '"
                + nouveauPraticien.getVillePraticien() + "', '"
                + nouveauPraticien.getCoefNotorietePraticien() + "', '"
                + nouveauPraticien.getCodeTypePraticien() + "', '"
                + nouveauPraticien.getCodeSpecialite() + "');";
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
     * Méthode qui permet de modifier un enregistrement Praticien dans la BDD.
     *
     * @param Praticien modifierPraticien prend en paramètre un objet Praticien
     * préalablement crée. Elle modifie cet élément au sein de la BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierPraticien(Praticien numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `praticien` SET "
                + "`PRA_CODE_PRATICIEN`="
                + numero.getCodePraticien() + ", "
                + "`PRA_NOM_PRATICIEN`='"
                + numero.getNomPraticien() + "', "
                + "`PRA_ADRESSE_PRATICIEN`='"
                + numero.getAdresse() + "', "
                + "`PRA_CP_PRATICIEN`='"
                + numero.getCpPraticien() + "', "
                + "`PRA_VILLE_PRATICIEN`='"
                + numero.getVillePraticien() + "', "
                + "`PRA_COEFNOTORIETE_PRATICIEN`="
                + numero.getCoefNotorietePraticien() + ", "
                + "`TYP_CODE_TYPE_PRATICIEN`= "/*
                + numero.getCodeTypeDuPraticien() */ + " "
                + "WHERE `PRA_NUM_PRATICIEN` = "
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
     * @param rs Méthode qui permet de convertir les informations de praticiens
     * lors de la lecture.
     * @return
     */
    Praticien convertirPraticien(ResultSet rs) {
        try {
            int num = rs.getInt("PRA_NUM_PRATICIEN");
            int code = rs.getInt("PRA_CODE_PRATICIEN");
            String nom = rs.getString("PRA_NOM_PRATICIEN");
            String adresse = rs.getString("PRA_ADRESSE_PRATICIEN");
            String cp = rs.getString("PRA_CP_PRATICIEN");
            String ville = rs.getString("PRA_VILLE_PRATICIEN");
            Float coef = rs.getFloat("PRA_COEFNOTORIETE_PRATICIEN");
            int codeTypePraticien = rs.getInt("TYP_CODE_TYPE_PRATICIEN");
            int codeSpePrat = rs.getInt("SPE_CODE_SPECIALITE");

            return new Praticien(num, code, nom, adresse, cp, ville, coef, codeTypePraticien, codeSpePrat /*new TypePraticien(codeTypePraticien)*/);
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
     * Méthode de lecture de toute la table praticien. Cette méthode doit être
     * utilisé conjointement avec afficherPraticien() de la classe
     * ListePraticien.
     *
     * @return
     */
    public ListePraticien lirePraticien() {
        if (bdd.connecter() == true) {
            ArrayList<Praticien> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `praticien`;");
            try {
                while (rs.next()) {
                    Praticien praticien = convertirPraticien(rs);
                    liste.add(praticien);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePraticien listePraticien = new ListePraticien();
            listePraticien.setListePraticien(liste);
            return listePraticien;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture d'un élément Praticien.
     *
     * @param Praticien Cette méthode prend en paramètre un objet Praticien, elle
     * permet de lire les informations d'un objet Praticien dans la BDD.
     * @return
     */
    public ListePraticien lireUnPraticien(Praticien praticienALire) {
        if (bdd.connecter() == true) {
            ArrayList<Praticien> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `praticien` where `PRA_NUM_PRATICIEN`=" + praticienALire.getNumPraticien() + ";");
            try {
                while (rs.next()) {
                    Praticien praticien = convertirPraticien(rs);
                    liste.add(praticien);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePraticien listePraticien = new ListePraticien();
            listePraticien.setListePraticien(liste);
            return listePraticien;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    
    /**
     * Méthode de lecture d'un élément Praticien.
     *
     * @param int Cette méthode prend en paramètre un numero, elle
     * permet de lire les informations Praticien dans la BDD.
     * @return Praticien
     */
    public Praticien lireUnPraticien(int numero) {
        Praticien praticien = null;
        if (bdd.connecter() == true) {
            ArrayList<Praticien> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `praticien` where `PRA_NUM_PRATICIEN`=" + numero + ";");
            try {
                while (rs.next()) {
                    praticien = convertirPraticien(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return praticien;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    

    /**
     * Méthode de suppresion d'un élément Praticien dans la BDD.
     *
     * @param Praticien Cette méthode prend en paramètre un objet Praticien.
     * Elle supprime le Praticien correspondant dans la base de donnée.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerPraticien(Praticien praticienASupprimer) {
        String req = "DELETE FROM `ppe`.`praticien` WHERE PRA_NUM_PRATICIEN=" + praticienASupprimer.getNumPraticien() + ";";
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
    Avant :
        public int supprimerPraticien(Praticien numero) {
            String req = "DELETE FROM praticien WHERE id=" + numero.getNumPraticien() + ";";
     */
    public static void main(String[] args) {
        CTablePraticien tablePraticien = new CTablePraticien();

        tablePraticien.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));

        // tablePraticien.creerTablePraticien();
        /*
        Praticien test = new Praticien();
        test.setCodePraticien(2);
        test.setNomPraticien("Artic");
        test.setAdresse("5 impasse du pied");
        test.setCpPraticien("35000");
        test.setVillePraticien("Rennes");
        test.setCoefNotorietePraticien(0.9F);
        table.insererPraticien(test);
         */
        //tablePraticien.supprimerTablePraticien();
        //table.supprimerPraticien(test);
        //table.supprimerPraticien(3);
        Praticien test = new Praticien();
        test.setNumPraticien(3);
        test.setCodePraticien(3);
        test.setNomPraticien("Jean");
        test.setAdresse("43 rue Robespierre");
        test.setCpPraticien("29000");
        test.setVillePraticien("Brest");
        test.setCoefNotorietePraticien(0.1F);
        test.setCodeTypePraticien(1);
        test.setCodeSpecialite(1);
        tablePraticien.insererPraticien(test);

        tablePraticien.lirePraticien().afficherPraticien();
        /*test.setTypeDuPraticien(type);*/
        //tablePraticien.supprimerTablePraticien();
        //tablePraticien.lireUnPraticien(1).afficherPraticien();
        //tablePraticien.lirePraticien().afficherPraticien();

    }

}

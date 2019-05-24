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
import liste.ListeTypePraticien;

import entites.TypePraticien;

/**
 *
 * @author admin
 */
public class CTableTypePraticien {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableTypePraticien() {
    }

    public CTableTypePraticien(CBDD bdd) {
        this.setBdd(bdd);
    }

    /**
     * Méthode de création de la table type_praticien dans la BDD. Si la table
     * n'existe pas elle sera créée.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int creerTableTypePraticien() {
        String req = "CREATE TABLE IF NOT EXISTS `type_praticien` ( `TYP_CODE_TYPE_PRATICIEN` TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `TYP_LIBELLE_TYPE_PRATICIEN` VARCHAR(20) NULL, `TYP_LIEU_TYPE_PRATICIEN` VARCHAR(20) NULL, PRIMARY KEY (`TYP_CODE_TYPE_PRATICIEN`)) ENGINE = InnoDB;";
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
     * Méthode de suppression de la table type_praticien. Attention cette
     * méthode supprimeras entièrement la table type_praticien et toutes les
     * informations qu'elle contient.
     *
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerTypePraticien() {
        String req = "DROP TABLE IF EXISTS `type_praticien` ;";
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
     * @param TypePraticien La méthode insererTypePraticien prend en paramètre
     * un objet TypePraticien préalablement créé. Elle insère un type de
     * praticien dans la BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int insererTypePraticien(TypePraticien nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `type_praticien`(`TYP_LIBELLE_TYPE_PRATICIEN`, `TYP_LIEU_TYPE_PRATICIEN`) "
                + "VALUES ('"
                + nouveau.getLibelleTypePraticien() + "', '"
                + nouveau.getLieuTypePraticien() + "');";
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
     * Méthode qui permet de modifier un enregistrement TypePraticien dans la
     * BDD.
     *
     * @param TypePraticien modifierTypePraticien prend en paramètre un objet
     * TypePraticien préalablement crée. Elle modifie cet élément au sein de la
     * BDD.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int modifierTypePraticien(TypePraticien numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `type_praticien` SET "
                + "`TYP_LIBELLE_TYPE_PRATICIEN`='"
                + numero.getLibelleTypePraticien() + "', "
                + "`TYP_LIEU_TYPE_PRATICIEN`='"
                + numero.getLieuTypePraticien() + "' "
                + "WHERE `TYP_CODE_TYPE_PRATICIEN`="
                + numero.getCodeTypePraticien() + ";";
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
    TypePraticien convertirTypePraticien(ResultSet rs) {
        try {
            int code = rs.getInt("TYP_CODE_TYPE_PRATICIEN");
            String libelle = rs.getString("TYP_LIBELLE_TYPE_PRATICIEN");
            String typeLieu = rs.getString("TYP_LIEU_TYPE_PRATICIEN");
            return new TypePraticien(code, libelle, typeLieu);
        } catch (SQLException ex) {
            Logger.getLogger(TypePraticien.class.getName()).log(Level.SEVERE, null, ex);
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
     * Méthode de lecture de toute la table type_praticien. Cette méthode doit
     * être utilisé conjointement avec afficherTypePraticien() de la classe
     * ListePraticien.
     *
     * @return
     */
    public ListeTypePraticien lireTypePraticien() {
        if (bdd.connecter() == true) {
            ArrayList<TypePraticien> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `type_praticien`;");
            try {
                while (rs.next()) {
                    TypePraticien typePraticien = convertirTypePraticien(rs);
                    liste.add(typePraticien);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeTypePraticien listeTypePraticien = new ListeTypePraticien();
            listeTypePraticien.setListeTypePraticien(liste);
            return listeTypePraticien;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de lecture d'un élément TypePraticien.
     *
     * @param int Cette méthode prend en paramètre un objet TypePraticien, elle
     * permet de lire les informations d'un objet TypePraticien dans la BDD.
     * @return
     */
    public TypePraticien lireUnTypePraticien(int code) {
        if (bdd.connecter() == true) {
            TypePraticien typePraticien = new TypePraticien();
            typePraticien.setCodeTypePraticien(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `type_praticien` where `TYP_CODE_TYPE_PRATICIEN`=" + code + ";");
            try {
                while (rs.next()) {
                    typePraticien = convertirTypePraticien(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return typePraticien;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode de suppresion d'un élément TypePraticien dans la BDD.
     *
     * @param TypePraticien Cette méthode prend en paramètre un objet
     * TypePraticien. Elle supprime le TypePraticien correspondant dans la base
     * de donnée.
     * @return int , retourne "-1" s'il y a une erreur.
     */
    public int supprimerUnTypePraticien(TypePraticien code) {
        String req = "DELETE FROM type_praticien `WHERE TYP_CODE_TYPE_PRATICIEN`=" + code.getCodeTypePraticien() + ";";
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
        CTableTypePraticien table = new CTableTypePraticien();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableTypePraticien();
        // table
        /*
        TypePraticien NouveauTypePraticien = new TypePraticien();
        NouveauTypePraticien.setLibelleTypePraticien("chirurgien");
        NouveauTypePraticien.setLieuTypePraticien("Cabinet privé");
        table.insererTypePraticien(NouveauTypePraticien);

        test.setCodePraticien(1);
        test.setNomPraticien("Heart");
        test.setAdresse("1 rue du coeur");
        test.setCpPraticien("35400");
        test.setVillePraticien("Saint-Malo");
        test.setCoefNotorietePraticien(0.5F);
        table.insererPraticien(test);
         */ //table.supprimerPraticien();
        TypePraticien NouveauTypePraticien = new TypePraticien();
        /*
        NouveauTypePraticien.setCodeTypePraticien(4);
        NouveauTypePraticien.setLibelleTypePraticien("infirmier");
        NouveauTypePraticien.setLieuTypePraticien("a domicile - liberal");
        table.modifierTypePraticien(NouveauTypePraticien);

        table.insererTypePraticien(NouveauTypePraticien);
         */

        //table.lireUnTypePraticien(1).affichageUniquePraticien(NouveauTypePraticien);
        //table.creerTableTypePraticien();
        table.lireTypePraticien().afficherTypePraticien();
        table.lireTypePraticien().afficherTypePraticien();
        // table.lireUnTypePraticien(3).affichageUniqueTypePraticien(NouveauTypePraticien);
    }
}

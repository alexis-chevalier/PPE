/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeComposant;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Composant;



/**
 *
 * @author admin
 */
public class CTableComposant {
    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableComposant() {
    }

    public CTableComposant(CBDD bdd) {
        this.setBdd(bdd);
    }
    /**
     * Permet de creer la requete de creation de table, de l'envoyer à phpmyadmin et de la creer avec les attribus spécifier dans cette requete.
     * @return 
     */
    public int creerTableComposant() {
        String req = "CREATE TABLE IF NOT EXISTS `COMPOSANT` ( `CMP_CODE` TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `CMP_LIBELLE` VARCHAR(20) NULL, PRIMARY KEY (`CMP_CODE`)) ENGINE = InnoDB;";
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
     * Cette méthode permet de supprimer la totalité de la table composant.
     * @return 
     */
    public int supprimerTableComposant() {
        String req = "DROP TABLE IF EXISTS `COMPOSANT`;";
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
     * Cette méthode permet d'insere
     * @param nouveau
     * @return 
     */
    public int insererTableComposant(Composant nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `COMPOSANT`(`CMP_LIBELLE`) "
                + "VALUES ('"
                //+ nouveau.getCmpCode() + "', '"
                + nouveau.getCmpLibelle()+ "');";
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
     * 
     * @param numero
     * @return 
     */
    public int modifierTableComposant(Composant numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `COMPOSANT` SET "
                //+ "`CMP_CODE`="
                //+ numero.getCmpCode()+ ", "
                + "`CMP_LIBELLE`='"
                + numero.getCmpLibelle()+ "' "
                + "WHERE `CMP_CODE` = "
                + numero.getCmpCode() + ";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            //System.out.println(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
/**
 * 
 * @param rs
 * @return 
 */
    Composant convertirComposant(ResultSet rs) {
        try {
            int code = rs.getInt("CMP_CODE");
            String libelle = rs.getString("CMP_LIBELLE");
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

            return new Composant(code, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(Composant.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * 
     * @return 
     */
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
     * permet de lire tous les enregistrements de la table composant de les afficher a l'aide de listecomposant qui recupere les valeurs des enregistrements
     * @return 
     */
    public ListeComposant lireTableComposant() {
         System.out.println("------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Composant> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `COMPOSANT`;");
            try {
                while (rs.next()) {
                    Composant composant = convertirComposant(rs);
                    liste.add(composant);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeComposant listeComposant = new ListeComposant();
            listeComposant.setListeComposant(liste);
            return listeComposant;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    /**
     * Permet de lire un enregistrement précis, celui etant défnit par son code
     * @param code
     * @return 
     */
    public Composant lireTableComposant(int code) {
         if (bdd.connecter() == true) {
            Composant composant = new Composant();
            composant.setCmpCode(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `COMPOSANT` where `CMP_CODE`=" + code + ";");
            try {
                while (rs.next()) {
                    composant = convertirComposant(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return composant;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    /**
     * Permet de supprimer un enregistrement, l'enregistrement à supprimer est défnit par son code
     * @param code
     * @return 
     */
    public int supprimerTableComposant(Composant code) {
        String req = "DELETE FROM `COMPOSANT` WHERE `CMP_CODE`=" + code.getCmpCode()+ ";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            //System.out.println(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public static void main(String[] args) {
        CTableComposant table = new CTableComposant();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableComposant();
        
        Composant test = new Composant();
        test.setCmpCode(3);
        test.setCmpLibelle("helicoptere");
        
        //table.insererTableComposant(test);

        //table.modifierTableComposant(test);
        
        //System.out.println(table.lireTableComposant(2));
        
        //table.supprimerTableComposant();
        //table.supprimerTableComposant(test);
        

        //table.supprimerPraticien();
        table.lireTableComposant().afficherListeComposant();

    } 
    
}

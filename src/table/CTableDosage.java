/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeDosage;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Dosage;

/**
 *
 * @author Jeremy
 */
public class CTableDosage {
  
   protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
}
public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableDosage() {
    }

    public CTableDosage(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTableDosage() {
        String req = "CREATE TABLE IF NOT EXISTS `DOSAGE` ( DOS_CODE smallint(6) primary key, DOS_QUANTITE TINYINT(4) NULL, DOS_UNITE tinyint(4) NULL) ENGINE = InnoDB;";
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

    public int supprimerDosage() {
        String req = "DROP TABLE IF EXISTS `DOSAGE`;";
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

    public int insererDosage(Dosage nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `DOSAGE`(`DOS_CODE`, `DOS_QUANTITE`, `DOS_UNITE`) "
                + "VALUES ('"
                + nouveau.getDosCodeDosage() + "', '"
                + nouveau.getDosQuantiteDosage() + "', '"
                + nouveau.getDosUniteDosage() + "');";
        //+ personne.getId()+"', '"
        // + personne.getNom() + "', '"
        //+ personne.getPrenom() + "', '"
        //+ personne.getIdAdresse() + "', '"
        //+ personne.getMail() + "', '"
        //+ personne.getTelephone() + "', '"
        //+ dateNaiss + "');";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            System.out.println("Le résultat à bien été inséré !");
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int modifierDosage(Dosage numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `DOSAGE` SET "
                + "`DOS_CODE`="
                + numero.getDosCodeDosage() + ", "
                + "`DOS_QUANTITE`="
                + numero.getDosQuantiteDosage() + ", "
                + "`DOS_UNITE`="
                + numero.getDosUniteDosage() + " "
                + "WHERE `DOS_CODE`= "
                + numero.getDosCodeDosage() + ";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            System.out.println(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    Dosage convertirDosage(ResultSet rs) {
        try {
            int dosCode = rs.getInt("DOS_CODE");
            int dosQuantite = rs.getInt("DOS_QUANTITE");
            int dosUnite = rs.getInt("DOS_UNITE");
            
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

            return new Dosage(dosCode, dosQuantite, dosUnite);
        } catch (SQLException ex) {
            Logger.getLogger(Dosage.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListeDosage lireDosage() { 
        System.out.println("-------------------------------------------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Dosage> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `DOSAGE`;");
            try {
                while (rs.next()) {
                    Dosage dosage = convertirDosage(rs);
                   
                    liste.add(dosage);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeDosage listeDosage = new ListeDosage();
            listeDosage.setListeDosage(liste);
            return listeDosage;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Dosage lireUnDosage(int dosCode) {
        if (bdd.connecter() == true) {
            Dosage dosage = new Dosage();
            dosage.setDosCodeDosage(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `DOSAGE` where `DOS_CODE`=" + dosCode + ";");
            try {
                while (rs.next()) {
                    dosage = convertirDosage(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return dosage;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int supprimerDosage(Dosage dosCode) {
        String req = "DELETE FROM DOSAGE WHERE `DOS_CODE` =" + dosCode.getDosCodeDosage() + ";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            System.out.println(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public static void main(String[] args) {
        CTableDosage table = new CTableDosage();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableDosage();

        Dosage test = new Dosage();
        test.setDosCodeDosage(1);
        test.setDosQuantiteDosage(7);
        test.setDosUniteDosage(5);
        
        //table.modifierDosage(test);//modification dosage par les valeur de l'objet test en gardant le code qui fait reference au dosage a modifier
        //table.lireDosage();
        table.insererDosage(test);
        //System.out.println(table.lireUnDosage(1));//pour convertir un dosage une objet
        //System.out.println(table.lireUnDosage(1));//lire un dosage via son code
        //table.supprimerDosage();
        
        table.lireDosage().afficherDosage();
        
        //table.supprimerDosage();//Supprimer la table dosage
        //table.supprimerDosage(test);//supprimer le dosage correspondant au code dosage de l'objet test

    }
}

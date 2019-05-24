/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeFormuler;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Formuler;

/**
 *
 * @author Jeremy
 */
public class CTableFormuler {
  protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableFormuler() {
    }

    public CTableFormuler(CBDD bdd) {
        this.setBdd(bdd);
    }
    /**
     * Permet de creer la requete de creation de table, de l'envoyer à phpmyadmin et de la creer avec les attribus spécifier dans cette requete.
     * @return 
     */
    public int creerTableFormuler() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe2`.`FORMULER` ( `PRE_CODE` TINYINT(4) UNSIGNED NOT NULL, `MED_DEPOTLEGAL` INT(11) NOT NULL, PRIMARY KEY (`PRE_CODE`, `MED_DEPOTLEGAL`)) ENGINE = InnoDB;";
        String req2 = "ALTER TABLE FORMULER\\n\"\n" +
"                + \"  ADD CONSTRAINT FK_FORMULER_TIN_CODE FOREIGN KEY (TIN_CODE) REFERENCES TYPE_INDIVIDU (TIN_CODE),\\n\"\n" +
"                 + \"  ADD CONSTRAINT FK_FORMULER_DOS_CODE FOREIGN KEY (DOS_CODE) REFERENCES dosage (DOS_CODE),\\n\"\n" +
"                + \"  ADD CONSTRAINT FK_FORMULER_MED_DEPOTLEGAL FOREIGN KEY (MED_DEPOTLEGAL) REFERENCES medicament (MED_DEPOTLEGAL);\";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            bdd.executerRequeteUpdate(req2);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    /**
     * Cette méthode permet de supprimer la totalité de la table Formuler.
     * @return 
     */
    public int supprimerTableFormuler() {
        String req = "DROP TABLE IF EXISTS `FORMULER`;";
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
    public int insererTableFormuler(Formuler nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `FORMULER`(`MED_DEPOTLEGAL`) "
                + "VALUES ('"
                //+ nouveau.getPreCode() + "', '"
                + nouveau.getMedDepotLegal()+ "');";
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
    public int modifierTableFormuler(Formuler numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `FORMULER` SET "
                //+ "`CMP_CODE`="
                //+ numero.getCmpCode()+ ", "
                + "`MED_DEPOTLEGAL`='"
                + numero.getMedDepotLegal()+ "' "
                + "WHERE `PRE_CODE` = "
                + numero.getPreCode() + ";";
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
    Formuler convertirFormuler(ResultSet rs) {
        try {
            int code = rs.getInt("DOS_CODE");
            int depotLegal = rs.getInt("MED_DEPOTLEGAL");
           
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

            return new Formuler(code, depotLegal);
        } catch (SQLException ex) {
            Logger.getLogger(Formuler.class.getName()).log(Level.SEVERE, null, ex);
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
     * permet de lire tous les enregistrements de la table Formuler de les afficher a l'aide de listeFormuler qui recupere les valeurs des enregistrements
     * @return 
     */
    public ListeFormuler lireTableFormuler() {
         System.out.println("------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Formuler> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`FORMULER`;");
            try {
                while (rs.next()) {
                    Formuler formuler = convertirFormuler(rs);
                    liste.add(formuler);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeFormuler listeFormuler = new ListeFormuler();
            listeFormuler.setListeFormuler(liste);
            return listeFormuler;
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
    public Formuler lireTableFormuler(int code) {
         if (bdd.connecter() == true) {
            Formuler formuler = new Formuler();
            formuler.setPreCode(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`Formuler` where `PRE_CODE`=" + code + ";");
            try {
                while (rs.next()) {
                    formuler = convertirFormuler(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return formuler;
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
    public int supprimerTableFormuler(Formuler code) {
        String req = "DELETE FROM `FORMULER` WHERE `CMP_CODE`=" + code.getPreCode()+ ";";
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
        CTableFormuler table = new CTableFormuler();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableFormuler();
        
        Formuler test = new Formuler();
        test.setPreCode(1);
        test.setMedDepotLegal(3);
        
        
        //table.insererTableFormuler(test);

        //table.modifierTableFormuler(test);
        
        //System.out.println(table.lireTableFormuler(2));
        
        //table.supprimerTableFormuler();
        //table.supprimerTableFormuler(test);
        

        //table.supprimerPraticien();
        //table.lireTableFormuler().afficherListeFormuler();

    } 
    
}

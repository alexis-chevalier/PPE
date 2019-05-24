/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListePrescrire;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Prescrire;

/**
 *
 * @author Jeremy
 */
public class CTablePrescrire {
    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTablePrescrire() {
    }

    public CTablePrescrire(CBDD bdd) {
        this.setBdd(bdd);
    }
    /**
     * Permet de creer la requete de creation de table, de l'envoyer à phpmyadmin et de la creer avec les attribus spécifier dans cette requete.
     * @return 
     */
    public int creerTablePrescrire() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe2`.`PRESCRIRE` ( `TIN_CODE` TINYINT(4) UNSIGNED NOT NULL, `DOS_CODE` TINYINT(4) NOT NULL, `MED_DEPOTLEGAL` INT(11) NOT NULL, `PRE_POSOLOGIE` TINYINT(4) NULL, PRIMARY KEY (`TIN_CODE`, `DOS_CODE`, `MED_DEPOTLEGAL`)) ENGINE = InnoDB;";
        String req2 = "ALTER TABLE PRESCRIRE\\n\"\n" +
"                + \"  ADD CONSTRAINT FK_PRESCRIRE_TIN_CODE FOREIGN KEY (TIN_CODE) REFERENCES TYPE_INDIVIDU (TIN_CODE),\\n\"\n" +
"                 + \"  ADD CONSTRAINT FK_PRESCRIRE_DOS_CODE FOREIGN KEY (DOS_CODE) REFERENCES dosage (DOS_CODE),\\n\"\n" +
"                + \"  ADD CONSTRAINT FK_PRESCRIRE_MED_DEPOTLEGAL FOREIGN KEY (MED_DEPOTLEGAL) REFERENCES medicament (MED_DEPOTLEGAL);\";";
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
     * Cette méthode permet de supprimer la totalité de la table Prescrire.
     * @return 
     */
    public int supprimerTablePrescrire() {
        String req = "DROP TABLE IF EXISTS `PRESCRIRE`;";
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
    public int insererTablePrescrire(Prescrire nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `PRESCRIRE`(`PRE_POSOLOGIE`) "
                + "VALUES ('"
                //+ nouveau.getCmpCode() + "', '"
                + nouveau.getPrePosologie()+ "');";
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
    public int modifierTablePrescrire(Prescrire numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `PRESCRIRE` SET "
                //+ "`CMP_CODE`="
                //+ numero.getCmpCode()+ ", "
                + "`PRE_POSOLOGIE`='"
                + numero.getPrePosologie()+ "' "
                + "WHERE `DOS_CODE` = "
                + numero.getDosCode() + ";";
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
    Prescrire convertirPrescrire(ResultSet rs) {
        try {
            int ccode = rs.getInt("TIN_CODE");
            int code = rs.getInt("DOS_CODE");
            int depotLegal = rs.getInt("MED_DEPOTLEGAL");
            int posologie = rs.getInt("PRE_POSOLOGIE");
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

            return new Prescrire(ccode, code, depotLegal, posologie);
        } catch (SQLException ex) {
            Logger.getLogger(Prescrire.class.getName()).log(Level.SEVERE, null, ex);
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
     * permet de lire tous les enregistrements de la table Prescrire de les afficher a l'aide de listePrescrire qui recupere les valeurs des enregistrements
     * @return 
     */
    public ListePrescrire lireTablePrescrire() {
         System.out.println("------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Prescrire> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`PRESCRIRE`;");
            try {
                while (rs.next()) {
                    Prescrire prescrire = convertirPrescrire(rs);
                    liste.add(prescrire);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePrescrire listePrescrire = new ListePrescrire();
            listePrescrire.setListePrescrire(liste);
            return listePrescrire;
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
    public Prescrire lireTablePrescrire(int code) {
         if (bdd.connecter() == true) {
            Prescrire prescrire = new Prescrire();
            prescrire.setTinCode(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`PRESCRIRE` where `CMP_CODE`=" + code + ";");
            try {
                while (rs.next()) {
                    prescrire = convertirPrescrire(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return prescrire;
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
    public int supprimerTablePrescrire(Prescrire code) {
        String req = "DELETE FROM `PRESCRIRE` WHERE `CMP_CODE`=" + code.getTinCode()+ ";";
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
        CTablePrescrire table = new CTablePrescrire();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTablePrescrire();
        
        Prescrire test = new Prescrire();
        test.setTinCode(1);
        test.setDosCode(3);
        test.setMedDepotLegal(3);
        test.setPrePosologie(0);
        
        //table.insererTablePrescrire(test);

        //table.modifierTablePrescrire(test);
        
        //System.out.println(table.lireTablePrescrire(2));
        
        //table.supprimerTablePrescrire();
        //table.supprimerTablePrescrire(test);
        

        //table.supprimerPraticien();
        //table.lireTablePrescrire().afficherListePrescrire();

    } 
    
}

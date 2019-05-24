/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeConstituer;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Constituer;

/**
 *
 * @author Jeremy
 */
public class CTableConstituer {
 protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableConstituer() {
    }

    public CTableConstituer(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTableConstituer() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe2`.`CONSTITUER` ( `MED_DEPOTLEGAL` INT(11) NOT NULL, `CMP_CODE` INT(11) NOT NULL AUTO_INCREMENT, `CST_UNITE` INT(11) NOT NULL, `CST_QTE` FLOAT(11) NOT NULL, PRIMARY KEY (`MED_DEPOTLEGAL`, `CMP_CODE`)) ENGINE = InnoDB;";
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

    public int supprimerConstituer() {
        String req = "DROP TABLE IF EXISTS `CONSTITUER` ;";
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

    public int insererConstituer(Constituer nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `CONSTITUER`(`MED_DEPOTLEGAL`, `CST_UNITE`, `CST_QTE`) "
                + "VALUES ('"
                + nouveau.getMedDepotLegal() + "', '"
                + nouveau.getCstUnite() + "', '"
                + nouveau.getCstQte() + "');";
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

    public int modifierConstituer(Constituer numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `CONSTITUER` SET "
                //+ "`FAM_CODE`="
                //+ numero.getFamCode() + ", "
                + "`MED_DEPOTLEGAL`='"
                + numero.getMedDepotLegal()+ "' "
                + "`CST_UNITE`='"
                + numero.getCstUnite()+ "' "
                + "`CST_QTE`='"
                + numero.getCstQte()+ "' "
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

    Constituer convertirConstituer(ResultSet rs) {
        try {
            int medDepotLegal = rs.getInt("MED_DEPOTLEGAL");
            int cmpCode = rs.getInt("CMP-CODE");
            String cstCode = rs.getString("CST-CODE");
            Float cstQte = rs.getFloat("CST_QTE");
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

            return new Constituer(medDepotLegal, cmpCode, cstCode, cstQte);
        } catch (SQLException ex) {
            Logger.getLogger(Constituer.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListeConstituer lireConstituer() {
        System.out.println("--------------------------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Constituer> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`CONSTITUER`;");
            try {
                while (rs.next()) {
                    Constituer constituer = convertirConstituer(rs);
                    liste.add(constituer);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeConstituer listeConstituer = new ListeConstituer();
            listeConstituer.setListeConstituer(liste);
            return listeConstituer;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Constituer lireUneConstituer(int code) {
        if (bdd.connecter() == true) {
            Constituer constituer = new Constituer();
            constituer.setMedDepotLegal(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`CONSTITUER` where `MED_DEPOTLEGAL`=" + code + ";");
            try {
                while (rs.next()) {
                    constituer = convertirConstituer(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return constituer;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    /**
     * titre
     * descritpion
     * 
     * @param code
     * @return 
     */

    public int supprimerConstituer(Constituer code) {
        String req = "DELETE FROM CONSTITUER WHERE `MED_DEPOTLEGAL`=" + code.getMedDepotLegal() + ";";
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
        CTableConstituer table = new CTableConstituer();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableConstituer();

        Constituer test = new Constituer();
        //test.setFamCode(2); //pas besoin car le code est en auto-increment 
        test.setMedDepotLegal(51);
        
        //table.insererConstituer(test); //inserer des infos(celles de l'objet test) dans la bdd 
        
        //table.modifierConstituer(test);
        //System.out.println(table.lireUneConstituer(1));

        //table.supprimerConstituer();
        
        //table.supprimerConstituer(test);
        //table.supprimerConstituer();
        
        table.lireConstituer().afficherListeConstituer();

    }
}

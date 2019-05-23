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
import liste.ListeComposant;
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

    public int creerTableComposant() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`COMPOSANT` ( `CMP_CODE` TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `CMP_LIBELLE` VARCHAR(20) NULL, PRIMARY KEY (`CMP_CODE`)) ENGINE = InnoDB;";
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

    public int modifierTableComposant(Composant numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `COMPOSANT` SET "
                + "`CMP_LIBELLE`="
                + numero.getCmpLibelle()+ "');";
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

    public ListeComposant lireTableComposant() {
        if (bdd.connecter() == true) {
            ArrayList<Composant> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`COMPOSANT`;");
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

    public Composant lireTableComposant(int code) {
        if (bdd.connecter() == true) {
            Composant composant = new Composant();
            composant.setCmpCode(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`COMPOSANT` where `FAM_CODE`=" + code + ";");
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

    public int supprimerTableComposant(Composant code) {
        String req = "DELETE FROM `COMPOSANT` `WHERE FAM_CODE`=" + code.getCmpCode()+ ";";
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
        CTableComposant table = new CTableComposant();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        //table.creerTableComposant();
        
        Composant test = new Composant();
        test.setCmpLibelle("Acide Salicyclique");
        test.setCmpCode(1);
        table.insererTableComposant(test);
/*
        Praticien test = new Praticien();
        test.setCodePraticien(1);
        test.setNomPraticien("Heart");
        test.setAdresse("1 rue du coeur");
        test.setCpPraticien("35400");
        test.setVillePraticien("Saint-Malo");
        test.setCoefNotorietePraticien(0.5F);
        table.insererPraticien(test);
*/
        //table.supprimerPraticien();
        //table.lirePraticien().afficherPraticien();

    } 
    
}

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
import liste.ListeFamille;
import entites.Famille;

/**
 *
 * @author admin
 */
public class CTableFamille {
        protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableFamille() {
    }

    public CTableFamille(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTableFamille() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe`.`FAMILLE` ( `FAM_CODE` TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT , `FAM_LIBELLE` VARCHAR(20) NULL, PRIMARY KEY (`FAM_CODE`)) ENGINE = InnoDB;";
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

    public int supprimerFamille() {
        String req = "DROP TABLE IF EXISTS `FAMILLE` ;";
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

    public int insererFamille(Famille nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `FAMILLE`(`FAM_LIBELLE`) "
                + "VALUES ('"
                + nouveau.getFamLibelle() + "');";
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

    public int modifierFamille(Famille numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `FAMILLE` SET "
                + "`FAM_LIBELLE`="
                + numero.getFamLibelle()+ "');";
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

    Famille convertirFamille(ResultSet rs) {
        try {
            int code = rs.getInt("TYP_CODE");
            String libelle = rs.getString("FAM_LIBELLE");
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

            return new Famille(code, libelle);
        } catch (SQLException ex) {
            Logger.getLogger(Famille.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListeFamille lireFamille() {
        if (bdd.connecter() == true) {
            ArrayList<Famille> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`FAMILLE`;");
            try {
                while (rs.next()) {
                    Famille famille = convertirFamille(rs);
                    liste.add(famille);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeFamille listeFamille = new ListeFamille();
            listeFamille.setLListeFamille(liste);
            return listeFamille;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Famille lireUneFamille(int code) {
        if (bdd.connecter() == true) {
            Famille famille = new Famille();
            famille.setFamCode(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe`.`FAMILLE` where `FAM_CODE`=" + code + ";");
            try {
                while (rs.next()) {
                    famille = convertirFamille(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return famille;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int supprimerFamille(Famille code) {
        String req = "DELETE FROM FAMILLE `WHERE FAM_CODE`=" + code.getFamCode() + ";";
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
        CTableFamille table = new CTableFamille();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableFamille();
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

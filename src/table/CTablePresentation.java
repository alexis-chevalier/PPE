/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListePresentation;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Presentation;

/**
 *
 * @author Jeremy
 */
public class CTablePresentation {
    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
}
public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTablePresentation() {
    }

    public CTablePresentation(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTablePresentation() {
        String req = "CREATE TABLE IF NOT EXISTS `ppe2`.`presentation` ( PRE_CODE int(11) primary key, PRE_LIBELLE varchar(30) NULL) ENGINE = InnoDB;";
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

    public int supprimerPresentation() {
        String req = "DROP TABLE IF EXISTS `presentation`;";
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

    public int insererPresentation(Presentation nouveau) {
        
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `presentation`(`PRE_CODE`, `PRE_LIBELLE`) "
                + "VALUES ('"
                + nouveau.getPreCodePresentation() + "', '"
                + nouveau.getPreLibellePresentation() + "');";
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
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int modifierPresentation(Presentation numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `Presentation` SET "
                + "`PRE_CODE`="
                + numero.getPreCodePresentation() + ", "
                + "`PRE_LIBELLE`='"
                + numero.getPreLibellePresentation() + "' "
                + "WHERE `PRE_CODE` = "
                + numero.getPreCodePresentation() + ";";
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

    Presentation convertirPresentation(ResultSet rs) {
        try {
            int preCode = rs.getInt("PRE_CODE");
            String preLibelle = rs.getString("PRE_LIBELLE");
            
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

            return new Presentation(preCode, preLibelle);
        } catch (SQLException ex) {
            Logger.getLogger(Presentation.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListePresentation lirePresentation() {
        System.out.println("--------------------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Presentation> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`presentation`;");
            try {
                while (rs.next()) {
                    Presentation presentation = convertirPresentation(rs);
                    liste.add(presentation);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListePresentation listePresentation = new ListePresentation();
            listePresentation.setListePresentation(liste);
            return listePresentation;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Presentation lireUnePresentation(int preCode) {
        if (bdd.connecter() == true) {
            Presentation presentation = new Presentation();
            presentation.setPreCodePresentation(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `ppe2`.`presentation` where `PRE_CODE`=" + preCode + ";");
            try {
                while (rs.next()) {
                    presentation = convertirPresentation(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return presentation;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int supprimerPresentation(Presentation preCode) {
        String req = "DELETE FROM presentation WHERE `PRE_CODE`=" + preCode.getPreCodePresentation() + ";";
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
        CTablePresentation table = new CTablePresentation();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTablePresentation();

        Presentation test = new Presentation();
        test.setPreCodePresentation(3);
        test.setPreLibellePresentation("Pop");
        
        //table.insererPresentation(test);

        //table.supprimerPresentation();
        
        
        //table.modifierPresentation(test);//modifier les données prelibelle de l'objet test en utilisant comme referecence le precode.

        //System.out.println(table.lireUnePresentation(1));
        
        //table.supprimerPresentation(test);
        //table.supprimerPresentation();
        
        table.lirePresentation().afficherPresentation();
    }
}
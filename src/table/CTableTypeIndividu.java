/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeTypeIndividu;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.TypeIndividu;


/**
 *
 * @author Jeremy
 */
public class CTableTypeIndividu {
    
   protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
}
public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableTypeIndividu() {
    }

    public CTableTypeIndividu(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTableTypeIndividu() {
        String req = "CREATE TABLE IF NOT EXISTS `TYPE_INDIVIDU` ( TIN_CODE int(11) primary key, TIN_LIBELLE varchar(30) NULL) ENGINE = InnoDB;";
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

    public int supprimerTypeIndividu() {
        String req = "DROP TABLE IF EXISTS `TYPE_INDIVIDU`;";
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

    public int insererTypeIndividu(TypeIndividu nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `TYPE_INDIVIDU`(`TIN_CODE`, `TIN_LIBELLE`) "
                + "VALUES ('"
                + nouveau.getTinCodeTypeIndividu() + "', '"
                + nouveau.getTinLibelleTypeIndividu() + "');";
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

    public int modifierTypeIndividu(TypeIndividu numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `TYPE_INDIVIDU` SET "
                + "`TIN_CODE`= "
                + numero.getTinCodeTypeIndividu() + ", "
                + "`TIN_LIBELLE`= '"
                + numero.getTinLibelleTypeIndividu() + "' "
                + "WHERE `TIN_CODE`= "
                + numero.getTinCodeTypeIndividu() + ";";
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

    TypeIndividu convertirTypeIndividu(ResultSet rs) {
        try {
            int tinCode = rs.getInt("TIN_CODE");
            String tinLibelle = rs.getString("TIN_LIBELLE");
            
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

            return new TypeIndividu(tinCode, tinLibelle);
        } catch (SQLException ex) {
            Logger.getLogger(TypeIndividu.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListeTypeIndividu lireTypeIndividu() {
        System.out.println("-------------------------------------------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<TypeIndividu> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `TYPE_INDIVIDU`;");
            try {
                while (rs.next()) {
                    TypeIndividu typeIndividu = convertirTypeIndividu(rs);
                    liste.add(typeIndividu);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeTypeIndividu listeTypeIndividu = new ListeTypeIndividu();
            listeTypeIndividu.setListeTypeIndividu(liste);
            return listeTypeIndividu;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public TypeIndividu lireUnTypeIndividu(int tinCode) {
        if (bdd.connecter() == true) {
            TypeIndividu typeIndividu = new TypeIndividu();
            typeIndividu.setTinCodeTypeIndividu(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `TYPE_INDIVIDU` where `TIN_CODE`=" + tinCode + ";");
            try {
                while (rs.next()) {
                    typeIndividu = convertirTypeIndividu(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return typeIndividu;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int supprimerTypeIndividu(TypeIndividu tinCode) {
        String req = "DELETE FROM TYPE_INDIVIDU WHERE `TIN_CODE`=" + tinCode.getTinCodeTypeIndividu() + ";";
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
        CTableTypeIndividu table = new CTableTypeIndividu();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableTypeIndividu();

        TypeIndividu test = new TypeIndividu();
        test.setTinCodeTypeIndividu(2);
        test.setTinLibelleTypeIndividu("Break");
        
        table.insererTypeIndividu(test);
        //table.modifierTypeIndividu(test); //modifier un individu via les parametre de lobjet test
        //table.lireTypeIndividu();

        //table.supprimerTypeIndividu();
        table.lireTypeIndividu().afficherTypeIndividu();//afficher toute la table typeindividu
        
        //System.out.println(table.lireUnTypeIndividu(1)); //affiche un objet sous forme de chaine de caractere affichant toutes les données de lindiv 1

        //table.supprimerTypeIndividu();//supprimer la table type_individu dans son intégralité
        //table.supprimerTypeIndividu(test);// supprime l'individu pour lequel son code correspond a celui de l'objet test
    }
}
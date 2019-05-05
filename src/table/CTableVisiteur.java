/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Departement;
import entites.Secteur;
import entites.Visiteur;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class CTableVisiteur {

    protected CBDD bdd;

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    /**
     * Permet de créer la table si elle n'existe pas
     *
     * @return
     */
    public int creerTable() {
        String requete = "CREATE TABLE IF NOT EXISTS `visiteur` (\n"
                + "  `VIS_MATRICULE` varchar(4) COLLATE utf8_unicode_ci NOT NULL,\n"
                + "  `VIS_NOM` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_PRENOM` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_ADRESSE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_CP` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_VILLE` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,\n"
                + "  `VIS_DATEEMBAUCHE` date DEFAULT NULL,\n"
                + "  `SEC_CODE` tinyint(4) NOT NULL,\n"
                + "  `DEP_CODE` float NOT NULL,\n"
                + "  PRIMARY KEY (`VIS_MATRICULE`),\n"
                + "  KEY `FK_VISITEUR_SEC_CODE` (`SEC_CODE`),\n"
                + "  KEY `FK_VISITEUR_DEP_CODE` (`DEP_CODE`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
        String requete2 = "ALTER TABLE `visiteur`\n"
                + "  ADD CONSTRAINT `FK_VISITEUR_DEP_CODE` FOREIGN KEY (`DEP_CODE`) REFERENCES `departement` (`DEP_CODE`),\n"
                + "  ADD CONSTRAINT `FK_VISITEUR_SEC_CODE` FOREIGN KEY (`SEC_CODE`) REFERENCES `secteur` (`SEC_CODE`);";
        int res = -1;
        if (bdd.connecter() == true) {
            bdd.executerRequeteUpdate(requete);
            bdd.executerRequeteUpdate(requete2);
            res = 1;
            bdd.deconnecter();
        } else {
            System.out.println("Connexion à la base impossible");
        }
        return res;
    }

    /**
     * Permet de supprimer la table
     * @return 
     */    
    public int supprimerTable(){
        String req1 = "SET foreign_key_checks = 0;";
        String requete = "DROP TABLE IF EXISTS `visiteur`;";
        String req2 = "SET foreign_key_checks = 1;";
        int res = -1;
        if (bdd.connecter() == true) {
            bdd.executerRequeteUpdate(req1);
            bdd.executerRequeteUpdate(requete);
            bdd.executerRequeteUpdate(req2);
            res = 1;
            bdd.deconnecter();
        } else {
            System.out.println("Connexion à la base impossible");
        }
        return res;
    }
    
    
    /**
     * Permet d'insérer un visiteur dans la BDD
     *
     * @param visiteur
     * @return
     */
    public int inserer(Visiteur visiteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `visiteur` (`VIS_MATRICULE`, `VIS_NOM`, `VIS_PRENOM`, `VIS_ADRESSE`, `VIS_CP`, `VIS_VILLE`, `VIS_DATEEMBAUCHE`, `SEC_CODE`, `DEP_CODE`) "
                    + "VALUES ('"+visiteur.getMatricule() + "', '"
                    + visiteur.getNomVisiteur()+"', '"
                    + visiteur.getPrenomVisiteur()+"', '"
                    + visiteur.getAdresse()+"', '"
                    + visiteur.getCp()+"', '"
                    + visiteur.getVille()+"', '"
                    + visiteur.getDateEmbauche()+"', '"
                    + visiteur.getSecteurVisiteur().getCode()+"', '"
                    + visiteur.getDepartementVisiteur().getCode()+"')";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Permet de supprimer un visiteur dans la BDD grâce à son numéro
     *
     * @param matricule
     * @return
     */
    public int supprimer(String matricule) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `visiteur` WHERE `VIS_MATRICULE` = '" + matricule + "'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /**
     * Permet de modifier un visiteur dans la BDD
     *
     * @param visiteur
     * @return
     */
    public int modifier(Visiteur visiteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `visiteur` SET `VIS_MATRICULE` = '"+visiteur.getMatricule()+
                    "', `VIS_NOM` = '"+visiteur.getNomVisiteur()+
                    "', `VIS_PRENOM` = '"+visiteur.getPrenomVisiteur()+
                    "', `VIS_ADRESSE` = '"+visiteur.getAdresse()+
                    "', `VIS_CP` = '"+visiteur.getCp()+
                    "', `VIS_VILLE` = '"+visiteur.getVille()+
                    "', `VIS_DATEEMBAUCHE` = '"+visiteur.getDateEmbauche()+
                    "', `SEC_CODE` = '"+visiteur.getSecteurVisiteur().getCode()+
                    "', `DEP_CODE` = '"+visiteur.getDepartementVisiteur().getCode()+
                    "' WHERE `visiteur`.`VIS_MATRICULE` = '"+visiteur.getMatricule()+"'";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public Visiteur convertir_RS_Visiteur(ResultSet rs) {
        try {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            int secteurCode = rs.getInt("SEC_CODE");
            int departementCode = rs.getInt("DEP_CODE");
            return new Visiteur(matricule,nom,prenom,adresse,cp,ville,dateEmbauche,new Secteur(secteurCode), new Departement(departementCode));
        } catch (SQLException ex) {
            Logger.getLogger(CTableRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    
    public ArrayList<Visiteur> lireVisiteurs() {
        if (bdd.connecter() == true) {
            ArrayList<Visiteur> listeVisiteur = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from visiteur");
            try {
                while (rs.next()) {
                    Visiteur visiteur = convertir_RS_Visiteur(rs);
                    listeVisiteur.add(visiteur);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeVisiteur;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    
    public Visiteur lireVisiteur(String matricule) {
        Visiteur rapport = null;
        if (bdd.connecter() == true) {
            ResultSet rs = bdd.executerRequeteQuery("select * from visiteur  WHERE VIS_MATRICULE = " + matricule);
            try {
                if (rs.next()) {
                    rapport = convertir_RS_Visiteur(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return rapport;
    }
    
    /**
     * Met tout les visiteurs dans un tableau de chaine de caractère. Utiliser
     * pour la comboBox.
     *
     * @return tout les visiteurs sous la forme d'un tableau de String.
     */
    public String[] RecupererTabVisiteur(CBDD bdd) {
        List<String> tabVisiteurList = new ArrayList<String>();
        //CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableVisiteur table = new CTableVisiteur();
        table.setBdd(bdd);
        ArrayList<Visiteur> listeVisiteur = table.lireVisiteurs();
        for (Visiteur visiteur : listeVisiteur) {
            tabVisiteurList.add(visiteur.getMatricule() + " - " + visiteur.getNomVisiteur() + " " + visiteur.getPrenomVisiteur());
        }
        String[] tabVisiteur = new String[tabVisiteurList.size()];
        tabVisiteurList.toArray(tabVisiteur);
        return tabVisiteur;
    }
    
    
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        Date SQLDate = new Date(gc.getTimeInMillis());
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        Secteur secteur = new Secteur(2,"");
        Departement departement = new Departement(2,"test",1);
        Visiteur visiteur = new Visiteur("3","testNom2","testPrenom2","adresse2","22001","ville2",SQLDate,secteur,departement);
        CTableVisiteur table = new CTableVisiteur();
        
        table.setBdd(bdd);
        table.supprimer("2");
        ArrayList<Visiteur> listeVisiteur = table.lireVisiteurs();
        /*for (Visiteur visiteur : listeVisiteur) {
            System.out.println(visiteur.toString());
        }*/
        //System.out.println(table.lireVisiteur("1"));
    }
    
}

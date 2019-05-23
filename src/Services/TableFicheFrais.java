package Services;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.FicheFrais;
import entites.Frais;
import entites.Visiteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class TableFicheFrais {
///*Un attribut bdd permet de se connecter à la base*/
//    CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));

    protected CBDD bdd;
    
    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    /**
     * Crée la table si elle n'existe pas déjà. La base doit exister avant.
     *
     * @return 1 si ok et -1 si fail
     */
    public int creerTable() {
        String req = "CREATE TABLE IF NOT EXISTS FICHE_FRAIS (FF_MOIS TINYINT(2) NOT NULL,"
                + "FF_NBHorsClassif TINYINT(3), "
                + "FF_MontantHorsClassif FLOAT, "
                + "VIS_MATRICULE VARCHAR(4) NOT NULL, "
                + "PRIMARY KEY (VIS_MATRICULE, FF_MOIS) )"
                + " ENGINE = InnoDB;";
        String req2 = "ALTER TABLE FICHE_FRAIS ADD CONSTRAINT FK_FICHE_FRAIS_VIS_MATRICULE FOREIGN KEY (VIS_MATRICULE) REFERENCES VISITEUR (VIS_MATRICULE);";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            res = bdd.executerRequeteUpdate(req2);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Crée la table si elle n'existe pas déjà. La base doit exister avant.
     *
     * @return 1 si ok et -1 si fail
     */
    public int supprimerTable() {
        String req0 = "SET foreign_key_checks = 0;";
        String req1 = "DROP IF EXISTS FICHE_FRAIS";
        String req2 = "SET foreign_key_checks = 1;";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req0);
            res = bdd.executerRequeteUpdate(req1);
            System.out.println("Res = " + res);
            res = bdd.executerRequeteUpdate(req2);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Crée un nouvel enregistrement dans la table, attention pas de doublon de
     * matricule possible.
     *
     * @param ficheFrais
     * @param frais
     * @return 1 si ok et -1 si fail
     */
    public int insererFicheFrais(FicheFrais ficheFrais, Frais frais) {
        String req = "INSERT INTO fiche_frais(FF_MOIS, FF_NBHorsClassif, FF_MontantHorsClassif,VIS_MATRICULE) VALUE('"
                + ficheFrais.getMois() + "','"
                + ficheFrais.getNbHorsClassif() + "','"
                + ficheFrais.getMontantHorsClassif() + "','"
                + ficheFrais.getVisiteur().getMatricule()
                + "');";
        
//      Seconde requête permettant, parallèlement, l'insertion des données de la liste de frais dans ma tabme 'inclure'
        /*String req2 = "INSERT INTO inclure(VIS_MATRICULE, FF_MOIS, TF_CODE, INC_QTE, INC_MONTANT) VALUE('"
                + frais.getVisiteur().getMatricule()
                + ", " 
                + frais.getFicheFrais().getMois()
                + ", "
                + frais.getTypeFrais().getCodeFrais()
                + ", "
                + frais.getQuantite()
                + ", "
                + frais.getMontant()
                + ";";*/
        
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
     * Supprime l'enregistrement dont le matricule est celui de l'objet en
     * paramètre.
     *
     * @param ficheFrais
     * @return 1 si ok et -1 si fail
     */
    public int supprimerFicheFrais(FicheFrais ficheFrais) {
        String req = "DELETE FROM fiche_frais WHERE FF_MOIS = " + ficheFrais.getMois() + " AND VIS_MATRICULE = '" + ficheFrais.getVisiteur().getMatricule() + "';";
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
     * Remplace nom et prénom de l'enregistrement par ceux de l'objet en
     * paramètre, au matricule correspondant.
     *
     * @param ficheFrais
     * @return 1 si ok et -1 si fail
     */
    public int modifierFicheFrais(FicheFrais ficheFrais) {
        String req = "UPDATE fiche_frais SET "
                + " FF_NBHorsClassif = "
                + ficheFrais.getNbHorsClassif()
                + ", FF_MontantHorsClassif = "
                + ficheFrais.getMontantHorsClassif()
                + " WHERE FF_MOIS = "
                + ficheFrais.getMois()
                + " AND VIS_MATRICULE = '"
                + ficheFrais.getVisiteur().getMatricule()
                + "';";

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

    public FicheFrais convertir_RS_FicheFrais(ResultSet rs) {
        try {
            int mois = rs.getInt("FF_MOIS");
            int nbHorsClassif = rs.getInt("FF_NBHorsClassif");
            float montantHorsClassif = rs.getFloat("FF_MontantHorsClassif");
            String matricule = rs.getString("VIS_MATRICULE");
            
            TableFrais tableFrais = new TableFrais();
            
            ArrayList<Frais> tab = tableFrais.lireFrais(matricule, mois);
            
            return new FicheFrais(mois, nbHorsClassif, montantHorsClassif, new Visiteur(matricule), tab);
            
        } catch (SQLException ex) {
            Logger.getLogger(TableFicheFrais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<FicheFrais> lireAllFicheFrais() {

        if (bdd.connecter() == true) {
            ArrayList<FicheFrais> listeFicheFrais = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM fiche_frais;");
            try {
                while (rs.next()) {
                    FicheFrais test = convertir_RS_FicheFrais(rs);
                    listeFicheFrais.add(test);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeFicheFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    
    public ArrayList<FicheFrais> lireFicheFrais(String matricule, int mois) {
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ArrayList<FicheFrais> listeFicheFrais = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT*FROM inclure WHERE `FF_MOIS` = '" 
                    + mois
                    + "' AND `VIS_MATRICULE` = '" 
                    + matricule
                    + "' ;");
            try {
                while (rs.next()) {
                    FicheFrais test2 = convertir_RS_FicheFrais(rs);
                    listeFicheFrais.add(test2);
                    if(listeFicheFrais.isEmpty()){
                        System.out.println("Not found");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeFicheFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
    
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        TableFicheFrais table = new TableFicheFrais();
        TableFrais tableFrais = new TableFrais();
        TableTypeFrais tableTypeFrais = new TableTypeFrais();
        table.setBdd(bdd);
        
//        ArrayList<Frais> tab = tableFrais.lireFrais("A001", 1);
//        Visiteur visiteur1 = new Visiteur("A001");
//        TypeFrais type1 = new TypeFrais(1, "Libellé type frais n°1", 42);
//        FicheFrais fiche1 = new FicheFrais(1, 10, 0, visiteur1, tab);
//        FicheFrais fiche2 = new FicheFrais(1, 15, 0, visiteur1, tab);
//        Frais frais1 = new Frais(visiteur1, fiche1, type1, 42, 42);
        
//        table.creerTable();
//        table.insererFicheFrais(fiche1, frais1);
//        table.supprimerFicheFrais(fiche1);
//        table.supprimerTable();
//        table.modifierFicheFrais(fiche2);
//        ArrayList<FicheFrais> listeFicheFrais = table.lireAllFicheFrais();
//            for (FicheFrais ficheFrais : listeFicheFrais) {
//                System.out.println(ficheFrais.toString());
//        }
//        ArrayList<FicheFrais> listeFicheFrais = table.lireFicheFrais("A001", 1);
//            for (FicheFrais ficheFrais : listeFicheFrais) {
//                System.out.println(ficheFrais.toString());
//        }
    }
}

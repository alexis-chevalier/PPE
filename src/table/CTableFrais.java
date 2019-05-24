package table;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.Frais;
import entites.FicheFrais;
import entites.TypeFrais;
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
public class CTableFrais {
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
        String req = "CREATE TABLE IF NOT EXISTS inclure ("
                + "VIS_MATRICULE VARCHAR(4) NOT NULL"
                + "FF_MOIS TINYINT(2) NOT NULL, "
                + "TF_CODE TINYINT(4) NOT NULL, "
                + "INC_QTE TINYINT(4), "
                + "INC_MONTANT FLOAT, "
                + "PRIMARY KEY (VIS_MATRICULE, FF_MOIS,  TF_CODE) )"
                + " ENGINE = InnoDB;";
        String req2 = "ALTER TABLE inclure ADD CONSTRAINT FK_INCLURE_VIS_MATRIUCLE FOREIGN KEY (VIS_MATRICULE) REFERENCES visiteur (VIS_MATRICULE);"
                + "ALTER TABLE inclure ADD CONSTRAINT FK_INCLURE_FF_MOIS FOREIGN KEY (FF_MOIS) REFERENCES fiche_frais (FF_MOIS);"
                + "ALTER TABLE inclure ADD CONSTRAINT FK_INCLURE_TF_CODE FOREIGN KEY (TF_CODE) REFERENCES type_frais (TF_CODE);";
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
        String req1 = "DROP IF EXISTS inclure";
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
     * @param frais
     * @return 1 si ok et -1 si fail
     */
    public int insererFrais(Frais frais) {
        String req = "INSERT INTO inclure(VIS_MATRICULE, FF_MOIS, TF_CODE, INC_QTE, INC_MONTANT) VALUE('"
                + frais.getVisiteur().getMatricule() + "','"
                + frais.getFicheFrais().getMois() + "','"
                + frais.getTypeFrais().getCodeFrais() + "','"
                + frais.getQuantite() + "','"
                + frais.getMontant()
                + "');";
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
     * @param frais
     * @return 1 si ok et -1 si fail
     */
    public int supprimerFrais(Frais frais) {
        String req = "DELETE FROM inclure WHERE VIS_MATRICULE = "
                + frais.getVisiteur().getMatricule()
                + " FF_MOIS = " 
                + frais.getFicheFrais().getMois() 
                + " AND TF_CODE = '" 
                + frais.getTypeFrais().getCodeFrais() 
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

    /**
     * Remplace nom et prénom de l'enregistrement par ceux de l'objet en
     * paramètre, au matricule correspondant.
     *
     * @param frais
     * @return 1 si ok et -1 si fail
     */
    public int modifierFrais(Frais frais) {
        String req = "UPDATE inclure SET " 
                + " INC_QTE =" 
                + frais.getQuantite() 
                + ", INC_MONTANT =" 
                + frais.getMontant()
                + " WHERE VIS_MATRICULE = "
                + frais.getVisiteur().getMatricule()
                + " FF_MOIS = " 
                + frais.getFicheFrais().getMois() 
                + " AND TF_CODE ='" 
                + frais.getTypeFrais().getCodeFrais() 
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

    public Frais convertir_RS_Frais(ResultSet rs) {
        try {
            String matricule = rs.getString("VIS_MATRICULE");
            int mois = rs.getInt("FF_MOIS");
            int code = rs.getInt("TF_CODE");
            int quantite = rs.getInt("INC_QTE");
            Float montant = rs.getFloat("INC_MONTANT");
            return new Frais(new Visiteur(matricule), new FicheFrais(mois), new TypeFrais(code), quantite, montant);
        } catch (SQLException ex) {
            Logger.getLogger(CTableFrais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Frais> lireAllFrais() {
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ArrayList<Frais> listeAllFrais = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM inclure;");
            try {
                while (rs.next()) {
                    Frais test = convertir_RS_Frais(rs);
                    listeAllFrais.add(test);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeAllFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public ArrayList<Frais> lireFrais(String matricule, int mois) {
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ArrayList<Frais> listeFrais = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM inclure WHERE `FF_MOIS` = '" 
                    + mois
                    + "' AND `VIS_MATRICULE` = '" 
                    + matricule
                    + "' ;");
            try {
                while (rs.next()) {
                    Frais test2 = convertir_RS_Frais(rs);
                    listeFrais.add(test2);
                    if(listeFrais.isEmpty()){
                        System.out.println("Not found");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public static void main(String[] args) {

        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableFrais table = new CTableFrais();
        table.setBdd(bdd);

        Visiteur visiteur1 = new Visiteur("f001");
        FicheFrais fiche1 = new FicheFrais(1);
        TypeFrais type1 = new TypeFrais(2);

        Frais frais1 = new Frais(visiteur1, fiche1, type1, 100, (float) 42.63);
        Frais frais2 = new Frais(visiteur1, fiche1, type1, 50, (float) 42.00);

//        table.creerTable();
//        table.insererFrais(frais1);
//        table.supprimerFrais(frais1); 
//        table.supprimerTable();
//        table.modifierFrais(frais2);
//        ArrayList<Frais> listeAllFrais = table.lireAllFrais();
//            for (Frais frais : listeAllFrais) {
//                System.out.println(frais);
//        }
//        ArrayList<Frais> listeFrais = table.lireFrais("A001", 2);
//        listeFrais.forEach((frais) -> {
//            System.out.println(frais);
//        });
    }
}

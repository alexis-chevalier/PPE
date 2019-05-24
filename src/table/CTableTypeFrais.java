package table;

import bdd.CBDD;
import bdd.CParametresStockageBDD;
import entites.TypeFrais;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTableTypeFrais {
///*Un attribut bdd permet de se connecter à la base*/
//    CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
    
    protected CBDD bdd;

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }
    
/**
 * Crée la table si elle n'existe pas déjà. La base doit exister avant.
 * @return 1 si ok et -1 si fail
 */
    public int creerTable() {
        String req = "CREATE TABLE TYPE_FRAIS (TF_CODE TINYINT NOT NULL,"
                + " TF_LIBELLE VARCHAR(30),"
                + " TF_FORFAIT FLOAT,"
                + "PRIMARY KEY (TF_CODE) )"
                + " ENGINE = InnoDB;";
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
 * Crée la table si elle n'existe pas déjà. La base doit exister avant.
 * @return 1 si ok et -1 si fail
 */
    public int supprimerTable() {
        String req1 = "DROP IF EXISTS type_frais;";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req1);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
/**
 * Crée un nouvel enregistrement dans la table, attention pas de doublon de matricule possible.
 * @param typeFrais
 * @return 1 si ok et -1 si fail
 */
    public int insererTypeFrais(TypeFrais typeFrais){
        String req = "INSERT INTO type_frais(TF_CODE, TF_LIBELLE, TF_FORFAIT) VALUE("
                + typeFrais.getCodeFrais() + ",'"
                + typeFrais.getLibelleFrais() + "',"
                + typeFrais.getForfait()
                + ");";
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
 * Supprime l'enregistrement dont le matricule est celui de l'objet en paramètre.
     * @param typeFrais
 * @return 1 si ok et -1 si fail
 */
    public int supprimerTypeFrais(TypeFrais typeFrais) {
        String req = "DELETE FROM fiche_frais WHERE TF_CODE = " 
                + typeFrais.getCodeFrais() 
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
 * Remplace nom et prénom de l'enregistrement par ceux de l'objet en paramètre, au matricule correspondant.
     * @param typeFrais
 * @return 1 si ok et -1 si fail
 */
    public int modifierTypeFrais(TypeFrais typeFrais) {
        String req = "UPDATE type_frais SET " 
                + " TF_LIBELLE = '" 
                + typeFrais.getLibelleFrais()
                + "', TF_FORFAIT=" 
                + typeFrais.getForfait()
                + " WHERE TF_CODE =" 
                + typeFrais.getCodeFrais() 
                + "';";
        /*Pour éviter les problèmes de syntaxes mySQL il faut repérer les
                apostrophes éventuels et les doubler (l'apostrophe est un caractère
                d'échappement en mySQL)*/
//                + "nom = '"+ CBDD.pretraiterChaineSQL(client.getNom()) + "', "
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
    
    public TypeFrais convertir_RS_TypeFrais(ResultSet rs) {
        try {
            int code = rs.getInt("TF_CODE");
            String libelle = rs.getString("TF_LIBELLE");
            int forfait = rs.getInt("TF_FORFAIT");
            return new TypeFrais(code, libelle, forfait);
        } catch (SQLException ex) {
            Logger.getLogger(CTableTypeFrais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public ArrayList<TypeFrais> lireAllTypeFrais() {
    
        if (bdd.connecter() == true) {
            ArrayList<TypeFrais> listeTypeFrais = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM type_frais;");
            try {
                while (rs.next()) {
                    TypeFrais test = convertir_RS_TypeFrais(rs);
                    listeTypeFrais.add(test);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeTypeFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
     
     public ArrayList<TypeFrais> lireTypeFrais(int code) {
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ArrayList<TypeFrais> listeTypeFrais= new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM inclure WHERE `TF_CODE` = '" 
                    + code
                    + "' ;");
            try {
                while (rs.next()) {
                    TypeFrais test2 = convertir_RS_TypeFrais(rs);
                    listeTypeFrais.add(test2);
                    if(listeTypeFrais.isEmpty()){
                        System.out.println("Not found");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeTypeFrais;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }
     
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableTypeFrais table = new CTableTypeFrais();
        table.setBdd(bdd);
        
        TypeFrais type1 = new TypeFrais(0, "Type de Frais 1", (float) 52.36);
        TypeFrais type2 = new TypeFrais(1, "Type de Frais 2", 42);
        
//        table.creerTable();
//        table.insererTypeFrais(type2);
//        table.supprimerTypeFrais(type1);
//        table.supprimerTable();
//        table.modifierTypeFrais(type1);
//        ArrayList<TypeFrais> listeAllTypeFrais = table.lireAllTypeFrais();
//            for (TypeFrais typeFrais : listeAllTypeFrais) {
//                System.out.println(typeFrais);
//        }
//        ArrayList<TypeFrais> listeTypeFrais = table.lireTypeFrais(1);
//            for (TypeFrais typeFrais : listeTypeFrais) {
//                System.out.println(typeFrais);
//        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import Liste.ListeMedicament;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Medicament;

/**
 *
 * @author Jeremy
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CTableMedicament {

    protected CBDD bdd;

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

    public CTableMedicament() {
    }

    public CTableMedicament(CBDD bdd) {
        this.setBdd(bdd);
    }

    public int creerTableMedicament() {
        String req = "CREATE TABLE IF NOT EXISTS `medicament` ( MED_DEPOTLEGAL int(11) primary key, MED_NOMCOMMERCIAL varchar(30) NULL, MED_COMPOSITION varchar(30) NULL, MED_EFFETS varchar(30) NULL, MED_CONTREINDIC varchar(30) NULL, MED_PRIXECHANTILLON float NULL) ENGINE = InnoDB;";
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

    public int supprimerMedicament() {
        String req = "DROP TABLE IF EXISTS `medicament`;";
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

    public int insererMedicament(Medicament nouveau) {
        //Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "INSERT INTO `medicament`(`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `MED_COMPOSITION`, `MED_EFFETS`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`) "
                + "VALUES ('"
                + nouveau.getDepotLegalMedicament() + "', '"
                + nouveau.getNomCommercialMedicament() + "', '"
                + nouveau.getCompositionMedicament() + "', '"
                + nouveau.getEffetsMedicament() + "', '"
                + nouveau.getContreIndicMedicament() + "', '"
                + nouveau.getPrixEchantillonMedicament() + "');";
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

    public int modifierMedicament(Medicament numero) {
        // Date dateNaiss = new Date(personne.getDateNaissance().getTimeInMillis());
        String req = "UPDATE `medicament` SET "
                + "`MED_DEPOTLEGAL`="
                + numero.getDepotLegalMedicament() + ", "
                + "`MED_NOMCOMMERCIAL`='"
                + numero.getNomCommercialMedicament() + "', "
                + "`MED_COMPOSITION`='"
                + numero.getCompositionMedicament() + "', "
                + "`MED_EFFETS`='"
                + numero.getEffetsMedicament() + "', "
                + "`MED_CONTREINDIC`='"
                + numero.getContreIndicMedicament() + "', "
                + "`MED_PRIXECHANTILLON`="
                + numero.getPrixEchantillonMedicament() + " "
                + "WHERE `MED_DEPOTLEGAL` = "
                + numero.getDepotLegalMedicament() + ";";
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

    Medicament convertirMedicament(ResultSet rs) {
        try {
            int depotLegal = rs.getInt("MED_DEPOTLEGAL");
            String nomCommercial = rs.getString("MED_NOMCOMMERCIAL");
            String composition = rs.getString("MED_COMPOSITION");
            String effets = rs.getString("MED_EFFETS");
            String contreIndic = rs.getString("MED_CONTREINDIC");
            Float prixEchantillon = rs.getFloat("MED_PRIXECHANTILLON");
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

            return new Medicament(depotLegal, nomCommercial, composition, effets, contreIndic, prixEchantillon);
        } catch (SQLException ex) {
            Logger.getLogger(Medicament.class.getName()).log(Level.SEVERE, null, ex);
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

    public ListeMedicament lireMedicament() {
        System.out.println("------------------------------------------------");
        if (bdd.connecter() == true) {
            ArrayList<Medicament> liste = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `medicament`;");
            try {
                while (rs.next()) {
                    Medicament medicament = convertirMedicament(rs);
                    liste.add(medicament);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            ListeMedicament listeMedicament = new ListeMedicament();
            listeMedicament.setListeMedicament(liste);
            return listeMedicament;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public Medicament lireUnMedicament(int depotLegal) {
        if (bdd.connecter() == true) {
            Medicament medicament = new Medicament();
            medicament.setDepotLegalMedicament(-1);
            ResultSet rs = bdd.executerRequeteQuery("SELECT * FROM `medicament` where `MED_DEPOTLEGAL`=" + depotLegal + ";");
            try {
                while (rs.next()) {
                    medicament = convertirMedicament(rs);
                }
            } catch (SQLException ex) {
            }
            bdd.deconnecter();
            return medicament;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int supprimerMedicament(Medicament depotLegal) {
        String req = "DELETE FROM medicament WHERE `MED_DEPOTLEGAL`=" + depotLegal.getDepotLegalMedicament() + ";";
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
        CTableMedicament table = new CTableMedicament();

        table.setBdd(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        table.creerTableMedicament();

        Medicament test = new Medicament();
        test.setDepotLegalMedicament(1);
        test.setNomCommercialMedicament("Heart");
        test.setCompositionMedicament("giraffe porc morue limace");
        test.setEffetsMedicament("aphrodisiaque");
        test.setContreIndicMedicament("dhiarrée aigu");
        test.setPrixEchantillonMedicament(50.5f);
        
        //table.modifierMedicament(test);//modification medicament par les valeur de l'objet test en gardant le code qui fait reference au medicament a modifier
        
        table.insererMedicament(test); //insertion des donnees de l'object test correspondant au information d'un medicament

        //table.supprimerMedicament();
        table.lireMedicament().afficherMedicament();//lecture de ce qui est stocker dans les objet et affichage de la liste medicament
        
        //System.out.println(table.lireUnMedicament(1));//lecture de la chaine de caractere contenant les information du medicament ayant le numero 1 pour depotlegal
        
        //table.supprimerMedicament(test);//supprime le medicament ou le depot legal de celui ci correspond au depot legal de l'objet test
        //table.supprimerMedicament();//supression de la totalite de la table medicament 
    }

}

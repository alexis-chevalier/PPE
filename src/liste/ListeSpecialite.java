/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import java.util.ArrayList;
import entites.Specialite;

/**
 *
 * @author Clément
 */
public class ListeSpecialite {
    
    public ArrayList<Specialite> listePossederSpecialite = new ArrayList();

    public ArrayList<Specialite> getListePossederSpecialite() {
        return listePossederSpecialite;
    }

    public void setListePossederSpecialite(ArrayList<Specialite> listePossederSpecialite) {
        this.listePossederSpecialite = listePossederSpecialite;
    }
    
    public int insererPossederSpecialite(Specialite numero) {
        if (numero != null) {
            this.listePossederSpecialite.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerPossederSpecialite(Specialite numero) {
        if (numero != null) {
            this.listePossederSpecialite.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherPossederSpecialite() {
        for (int i = 0; i < this.listePossederSpecialite.size(); i++) {
            System.out.println("Le code de la spécialité est : ");
            System.out.println(this.getListePossederSpecialite().get(i).codeSpecialite);
            System.out.println("Le libelle de son poste est : ");
            System.out.println(this.getListePossederSpecialite().get(i).libelleSpecialite);
            
        }
    }

    public int modifierPossederSpecialite(Specialite numero) {
        if(numero != null){
            for (int i = 0; i < this.getListePossederSpecialite().size(); i++) {
                this.getListePossederSpecialite().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
    
    
}

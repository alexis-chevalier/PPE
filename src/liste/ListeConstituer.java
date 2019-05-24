/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Constituer;

/**
 *
 * @author Jeremy
 */
public class ListeConstituer {
    
    public ArrayList<Constituer> listeConstituer = new ArrayList();

    public ArrayList<Constituer> getListeConstituer() {
        return listeConstituer;
    }

    public void setListeConstituer(ArrayList<Constituer> listeConstituer) {
        this.listeConstituer = listeConstituer;
    }
    
    public int insererListeConstituer(Constituer numero) {
        if (numero != null) {
            this.listeConstituer.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeConstituer(Constituer numero) {
        if (numero != null) {
            this.listeConstituer.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeConstituer() {
        for (int i = 0; i < this.listeConstituer.size(); i++) {
            System.out.println(" Le code associé a la constitution est :" + this.getListeConstituer().get(i).medDepotLegal);
            System.out.println(" Le libelle associé au contitution est :" + this.getListeConstituer().get(i).cmpCode);
            System.out.println("  :" + this.getListeConstituer().get(i).cstUnite);
            System.out.println(" :" + this.getListeConstituer().get(i).cstQte);
            System.out.println("---------------------------------");
            
        }
    }

    public int modifierListeConstituer(Constituer numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeConstituer().size(); i++) {
                this.getListeConstituer().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
    
    
}

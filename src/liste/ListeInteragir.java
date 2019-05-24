/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Interagir;

/**
 *
 * @author Jeremy
 */
public class ListeInteragir {
    public ArrayList<Interagir> listeInteragir = new ArrayList();

    public ArrayList<Interagir> getListeInteragir() {
        return listeInteragir;
    }

    public void setListeInteragir(ArrayList<Interagir> listeInteragir) {
        this.listeInteragir = listeInteragir;
    }
    
    public int insererListeInteragir(Interagir numero) {
        if (numero != null) {
            this.listeInteragir.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeInteragir(Interagir numero) {
        if (numero != null) {
            this.listeInteragir.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeInteragir() {
        for (int i = 0; i < this.listeInteragir.size(); i++) {
            System.out.println(" Le code associé a la constitution est :" + this.getListeInteragir().get(i).medDepotLegal);
            System.out.println(" Le libelle associé au contitution est :" + this.getListeInteragir().get(i).medDepotLegalInteragir);
            System.out.println("---------------------------------");
            
        }
    }

    public int modifierListeInteragir(Interagir numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeInteragir().size(); i++) {
                this.getListeInteragir().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
    
    
}

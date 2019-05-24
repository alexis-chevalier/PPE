/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Offrir;

/**
 *
 * @author Jeremy
 */
public class ListeOffrir {
    
    public ArrayList<Offrir> listeOffrir = new ArrayList();

    public ArrayList<Offrir> getListeOffrir() {
        return listeOffrir;
    }

    public void setListeOffrir(ArrayList<Offrir> listeOffrir) {
        this.listeOffrir = listeOffrir;
    }
    
    public int insererListeOffrir(Offrir numero) {
        if (numero != null) {
            this.listeOffrir.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeOffrir(Offrir numero) {
        if (numero != null) {
            this.listeOffrir.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeOffrir() {
        for (int i = 0; i < this.listeOffrir.size(); i++) {
            System.out.println(" Le code associé a la  est :" + this.getListeOffrir().get(i).rapNum);
            System.out.println(" Le libelle associé au  est :" + this.getListeOffrir().get(i).medDepotLegal);
            System.out.println("  :" + this.getListeOffrir().get(i).offQte);
            System.out.println("---------------------------------");
            
        }
    }

    public int modifierListeOffrir(Offrir numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeOffrir().size(); i++) {
                this.getListeOffrir().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
    
    
}

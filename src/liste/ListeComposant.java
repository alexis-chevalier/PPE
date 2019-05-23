/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import java.util.ArrayList;
import entites.Composant;

/**
 *
 * @author admin
 */
public class ListeComposant {
    public ArrayList<Composant> listeComposant = new ArrayList();

    public ArrayList<Composant> getListeComposant() {
        return listeComposant;
    }

    public void setListeComposant(ArrayList<Composant> listeComposant) {
        this.listeComposant = listeComposant;
    }
    
    public int insererListeComposant(Composant numero) {
        if (numero != null) {
            this.listeComposant.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeComposant(Composant numero) {
        if (numero != null) {
            this.listeComposant.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeComposant() {
        for (int i = 0; i < this.listeComposant.size(); i++) {
            System.out.println(this.getListeComposant().get(i).cmpLibelle);
            
        }
    }

    public int modifierListeComposant(Composant numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeComposant().size(); i++) {
                this.getListeComposant().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
}

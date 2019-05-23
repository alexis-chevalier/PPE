/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import java.util.ArrayList;
import entites.Inviter;
import entites.Realiser;

/**
 *
 * @author admin
 */
public class ListeRealiser {

    public ArrayList<Realiser> listeRealiser = new ArrayList();

    public ArrayList<Realiser> getListeRealiser() {
        return listeRealiser;
    }

    public void setListeRealiser(ArrayList<Realiser> listeRealiser) {
        this.listeRealiser = listeRealiser;
    }

    public int insererRealiser(Realiser numero) {
        if (numero != null) {
            this.listeRealiser.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerRealiser(Realiser numero) {
        if (numero != null) {
            this.listeRealiser.remove(numero);
            return 1;
        }
        return -1;
    }
    /**
     * Méthode qui vas parcourir la listeRealiser issue de la base de données.
     */
    public void afficherRealiser(){
        for (int i = 0; i < this.listeRealiser.size(); i++) {
            ListeRealiser affichageListeRealiserIndexI = new ListeRealiser();
            this.getListeRealiser().get(i).affichageUniqueRealiser();
        }
    }
    public int modifierRealiser(Realiser numero){
        if (numero != null) {
            for (int i = 0; i < this.getListeRealiser().size(); i++) {
                this.getListeRealiser().set(i, numero);
            }
            return 1;
        }
        return 0;
        
    }

}

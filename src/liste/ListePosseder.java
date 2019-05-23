/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import entites.Posseder;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ListePosseder {

    public ArrayList<Posseder> listePosseder = new ArrayList();

    public ArrayList<Posseder> getListePosseder() {
        return listePosseder;
    }

    public void setListePosseder(ArrayList<Posseder> listePosseder) {
        this.listePosseder = listePosseder;
    }

    public int insererPosseder(Posseder numero) {
        if (numero != null) {
            this.listePosseder.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerPraticien(Posseder numero) {
        if (numero != null) {
            this.listePosseder.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherPosseder() {
        for (int i = 0; i < this.listePosseder.size(); i++) {
            ListePraticien affichageListePraticienAIndexI = new ListePraticien();
            this.getListePosseder().get(i).affichageUniquePosseder();
        }
    }

    public int modifierPosseder(Posseder numero) {
        if (numero != null) {
            for (int i = 0; i < this.getListePosseder().size(); i++) {
                this.getListePosseder().set(i, numero);
                
            }
            return 1;
        }
        return -1;
    }
}

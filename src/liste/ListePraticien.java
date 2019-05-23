/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import entites.Praticien;
import java.util.ArrayList;

/**
 *
 * @author Clément
 */
public class ListePraticien {

    public ArrayList<Praticien> listePraticien = new ArrayList();

    public ArrayList<Praticien> getListePraticien() {
        return listePraticien;
    }

    public void setListePraticien(ArrayList<Praticien> listePraticien) {
        this.listePraticien = listePraticien;
    }

    public int insererPraticien(Praticien numero) {
        if (numero != null) {
            this.listePraticien.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerPraticien(Praticien numero) {
        if (numero != null) {
            this.listePraticien.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherPraticien() {
        for (int i = 0; i < this.listePraticien.size(); i++) {
            ListePraticien AffichageListePraticienAIndexI = new ListePraticien();
            this.getListePraticien().get(i).affichageUniquePraticien();
        }
    }

    public int modifierPraticien(Praticien numero) {
        if(numero != null){
            for (int i = 0; i < this.getListePraticien().size(); i++) {
                this.getListePraticien().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

}

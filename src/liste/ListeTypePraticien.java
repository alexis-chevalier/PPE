/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import java.util.ArrayList;
import entites.TypePraticien;

/**
 *
 * @author admin
 */
public class ListeTypePraticien {
    public ArrayList<TypePraticien> listeTypePraticien = new ArrayList();

    public ArrayList<TypePraticien> getListeTypePraticien() {
        return listeTypePraticien;
    }

    public void setListeTypePraticien(ArrayList<TypePraticien> listeTypePraticien) {
        this.listeTypePraticien = listeTypePraticien;
    }

    public int insererTypePraticien(TypePraticien numero) {
        if (numero != null) {
            this.listeTypePraticien.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerTypePraticien(TypePraticien numero) {
        if (numero != null) {
            this.listeTypePraticien.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherTypePraticien() {
        for (int i = 0; i < this.listeTypePraticien.size(); i++) {
            TypePraticien AffichePraticienAIndexI = new TypePraticien();
            this.getListeTypePraticien().get(i).affichageUniqueTypePraticien();
        }
    }


    public int modifierTypePraticien(TypePraticien numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeTypePraticien().size(); i++) {
                this.getListeTypePraticien().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
}

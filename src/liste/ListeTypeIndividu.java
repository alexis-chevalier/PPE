/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.TypeIndividu;

/**
 *
 * @author Jeremy
 */
public class ListeTypeIndividu {
    
     public ArrayList<TypeIndividu> listeTypeIndividu = new ArrayList();

    public ArrayList<TypeIndividu> getListeTypeIndividu() {
        return listeTypeIndividu;
    }

    public void setListeTypeIndividu(ArrayList<TypeIndividu> listeTypeIndividu) {
        this.listeTypeIndividu = listeTypeIndividu;
    }

    public int insererTypeIndividu(TypeIndividu numero) {
        if (numero != null) {
            this.listeTypeIndividu.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerTypeIndividu(TypeIndividu numero) {
        if (numero != null) {
            this.listeTypeIndividu.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherTypeIndividu() {
        for (int i = 0; i < this.listeTypeIndividu.size(); i++) {
            System.out.println("Le code associé à l'individu est :" + this.getListeTypeIndividu().get(i).tinCodeTypeIndividu);
            System.out.println("Le libelle de l'individu est : " + this.getListeTypeIndividu().get(i).tinLibelleTypeIndividu);
            System.out.println("-------------------------------------------------------------------------------------");
            
        }
    }

    public int modifierTypeIndividu(TypeIndividu numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeTypeIndividu().size(); i++) {
                this.getListeTypeIndividu().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

}


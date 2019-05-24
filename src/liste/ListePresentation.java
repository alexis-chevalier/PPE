/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Presentation;

/**
 *
 * @author Jeremy
 */
public class ListePresentation {

    public ArrayList<Presentation> listePresentation = new ArrayList();

    public ArrayList<Presentation> getListePresentation() {
        return listePresentation;
    }

    public void setListePresentation(ArrayList<Presentation> listePresentation) {
        this.listePresentation = listePresentation;
    }

    public int insererPresentation(Presentation numero) {
        if (numero != null) {
            this.listePresentation.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerPresentation(Presentation numero) {
        if (numero != null) {
            this.listePresentation.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherPresentation() {
        for (int i = 0; i < this.listePresentation.size(); i++) {
            System.out.println("Le code de présentation est :" + this.getListePresentation().get(i).preCodePresentation);
            System.out.println("Le Libelle présentation est :" + this.getListePresentation().get(i).preLibellePresentation);
            System.out.println("--------------------------------------------------------------");
            
        }
    }

    public int modifierPresentaion(Presentation numero) {
        if(numero != null){
            for (int i = 0; i < this.getListePresentation().size(); i++) {
                this.getListePresentation().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Prescrire;

/**
 *
 * @author Jeremy
 */
public class ListePrescrire {
    public ArrayList<Prescrire> listePrescrire = new ArrayList();

    public ArrayList<Prescrire> getListePrescrire() {
        return listePrescrire;
    }

    public void setListePrescrire(ArrayList<Prescrire> listePrescrire) {
        this.listePrescrire = listePrescrire;
    }
    
    public int insererListePrescrire(Prescrire numero) {
        if (numero != null) {
            this.listePrescrire.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListePrescrire(Prescrire numero) {
        if (numero != null) {
            this.listePrescrire.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListePrescrire() {
        for (int i = 0; i < this.listePrescrire.size(); i++) {
            System.out.println(" Le code associé a la prescription est :" + this.getListePrescrire().get(i).tinCode);
            System.out.println(" Le libelle associé au prescrit est :" + this.getListePrescrire().get(i).dosCode);
            System.out.println("  :" + this.getListePrescrire().get(i).medDepotLegal);
            System.out.println(" :" + this.getListePrescrire().get(i).prePosologie);
            System.out.println("---------------------------------");
            
        }
    }

    public int modifierListePrescrire(Prescrire numero) {
        if(numero != null){
            for (int i = 0; i < this.getListePrescrire().size(); i++) {
                this.getListePrescrire().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
    
}

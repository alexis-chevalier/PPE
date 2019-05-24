/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Formuler;

/**
 *
 * @author Jeremy
 */
public class ListeFormuler {
    public ArrayList<Formuler> listeFormuler = new ArrayList();

    public ArrayList<Formuler> getListeFormuler() {
        return listeFormuler;
    }

    public void setListeFormuler(ArrayList<Formuler> listeFormuler) {
        this.listeFormuler = listeFormuler;
    }
    
    public int insererListeFormuler(Formuler numero) {
        if (numero != null) {
            this.listeFormuler.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeFormuler(Formuler numero) {
        if (numero != null) {
            this.listeFormuler.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeFormuler() {
        for (int i = 0; i < this.listeFormuler.size(); i++) {
            System.out.println(" Le code associé a la  est :" + this.getListeFormuler().get(i).preCode);
            System.out.println(" Le libelle associé au  est :" + this.getListeFormuler().get(i).medDepotLegal);
            
            System.out.println("---------------------------------");
            
        }
    }

    public int modifierListeFormuler(Formuler numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeFormuler().size(); i++) {
                this.getListeFormuler().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
}

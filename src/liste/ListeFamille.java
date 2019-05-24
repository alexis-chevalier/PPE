/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Famille;
/**
 *
 * @author admin
 */
public class ListeFamille {
    public ArrayList<Famille> listeFamille = new ArrayList();

    public ArrayList<Famille> getListeFamille() {
        return listeFamille;
    }

    public void setLListeFamille(ArrayList<Famille> listeFamille) {
        this.listeFamille = listeFamille;
    }

    public int insererListeFamille(Famille numero) {
        if (numero != null) {
            this.listeFamille.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerListeFamille(Famille numero) {
        if (numero != null) {
            this.listeFamille.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherListeFamille() {
        for (int i = 0; i < this.listeFamille.size(); i++) {
            System.out.println(" Le code associé à la famille est :" + this.getListeFamille().get(i).famCode);
            System.out.println(" Le libelle lié à la famille est :" + this.getListeFamille().get(i).famLibelle);
            System.out.println("--------------------------------------------");
            
        }
    }

    public int modifierListeFamille(Famille numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeFamille().size(); i++) {
                this.getListeFamille().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
}

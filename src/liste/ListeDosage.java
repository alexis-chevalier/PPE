/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import java.util.ArrayList;
import entites.Dosage;

/**
 *
 * @author Jeremy
 */
public class ListeDosage {
    
     public ArrayList<Dosage> listeDosage = new ArrayList();

    public ArrayList<Dosage> getListeDosage() {
        return listeDosage;
    }

    public void setListeDosage(ArrayList<Dosage> listeDosage) {
        this.listeDosage = listeDosage;
    }

    public int insererDosage(Dosage numero) {
        if (numero != null) {
            this.listeDosage.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerDosage(Dosage numero) {
        if (numero != null) {
            this.listeDosage.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherDosage() {
        for (int i = 0; i < this.listeDosage.size(); i++) {
            System.out.println("Le numero de code du dosage : " + this.getListeDosage().get(i).dosCodeDosage);
            System.out.println("La quantite du dosage ayant le code : " + this.getListeDosage().get(i).dosCodeDosage + " ,est : " + this.getListeDosage().get(i).dosQuantiteDosage);
            System.out.println("Le numero d'unite du Dosage est : " + this.getListeDosage().get(i).dosUniteDosage);
            System.out.println("----------------------------------------------------------------------------------------");
            
        }
    }

    public int modifierDosage(Dosage numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeDosage().size(); i++) {
                this.getListeDosage().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

}


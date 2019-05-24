/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

import entites.Medicament;
import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class ListeMedicament {

    public ArrayList<Medicament> listeMedicament = new ArrayList();

    public ArrayList<Medicament> getListeMedicament() {
        return listeMedicament;
    }

    public void setListeMedicament(ArrayList<Medicament> listeMedicament) {
        this.listeMedicament = listeMedicament;
    }

    public int insererMedicament(Medicament numero) {
        if (numero != null) {
            this.listeMedicament.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerMedicament(Medicament numero) {
        if (numero != null) {
            this.listeMedicament.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherMedicament() {
        for (int i = 0; i < this.listeMedicament.size(); i++) {
            System.out.println("Le numero du depot legal de medicament est : " + this.getListeMedicament().get(i).depotLegalMedicament);
            System.out.println("Le nom commercial du medicament est : " + this.getListeMedicament().get(i).nomCommercialMedicament);
            System.out.println("La composition du medicament est : " + this.getListeMedicament().get(i).compositionMedicament);
            System.out.println("Les effets du medicaments sont : " + this.getListeMedicament().get(i).effetsMedicament);
            System.out.println("La contre-indication du medicament est : " + this.getListeMedicament().get(i).contreIndicMedicament);
            System.out.println("Le prix de l'echantillon du medicament est : " + this.getListeMedicament().get(i).prixEchantillonMedicament);
            System.out.println("-------------------------------------------------------------------");
            
        }
    }

    public int modifierMedicament(Medicament numero) {
        if(numero != null){
            for (int i = 0; i < this.getListeMedicament().size(); i++) {
                this.getListeMedicament().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

}


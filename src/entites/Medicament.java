/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

/**
 *
 * @author admin
 */
public class Medicament {

    public int depotLegalMedicament;
    public String nomCommercialMedicament;
    public String compositionMedicament;
    public String effetsMedicament;
    public String contreIndicMedicament;
    public Float prixEchantillonMedicament;
    
     public Medicament() {
    }
     
    public Medicament(int depotLegal, String nomCommercial, String composition, String effets, String contreIndic, float prixEchantillon) {
        this.setDepotLegalMedicament(depotLegal);
        this.setNomCommercialMedicament(nomCommercial);
        this.setCompositionMedicament(composition);
        this.setEffetsMedicament(effets);
        this.setContreIndicMedicament(contreIndic);
        this.setPrixEchantillonMedicament(prixEchantillon);
        
    }

    public int getDepotLegalMedicament() {
        return depotLegalMedicament;
    }

    public void setDepotLegalMedicament(int depotLegalMedicament) {
        this.depotLegalMedicament = depotLegalMedicament;
    }

    public String getNomCommercialMedicament() {
        return nomCommercialMedicament;
    }

    public void setNomCommercialMedicament(String nomCommercialMedicament) {
        this.nomCommercialMedicament = nomCommercialMedicament;
    }

    public String getCompositionMedicament() {
        return compositionMedicament;
    }

    public void setCompositionMedicament(String compositionMedicament) {
        this.compositionMedicament = compositionMedicament;
    }

    public String getEffetsMedicament() {
        return effetsMedicament;
    }

    public void setEffetsMedicament(String effetsMedicament) {
        this.effetsMedicament = effetsMedicament;
    }

    public String getContreIndicMedicament() {
        return contreIndicMedicament;
    }

    public void setContreIndicMedicament(String contreIndicMedicament) {
        this.contreIndicMedicament = contreIndicMedicament;
    }

    public Float getPrixEchantillonMedicament() {
        return prixEchantillonMedicament;
    }

    public void setPrixEchantillonMedicament(Float prixEchantillonMedicament) {
        this.prixEchantillonMedicament = prixEchantillonMedicament;
    }
    @Override
    public String toString() {
        return "" + this.depotLegalMedicament + " " + this.nomCommercialMedicament + " " + this.compositionMedicament + " " + this.effetsMedicament + " " + this.contreIndicMedicament + " " + this.prixEchantillonMedicament;
    }

   

}

    
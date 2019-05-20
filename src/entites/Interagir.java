/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Jeremy
 */
public class Interagir {
    
    public int medDepotLegalInteragir;
    public int medDepotLegal;

    

   

   
    public Interagir() {
    }

    public Interagir(int depotLegal, int depotLegalInteragir) {
        this.setMedDepotLegal(depotLegal);
        this.setMedDepotLegalInteragir(depotLegalInteragir); 
       
    }
    
   

    public int getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(int medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }
     public int getMedDepotLegalInteragir() {
        return medDepotLegalInteragir;
    }

    public void setMedDepotLegalInteragir(int medDepotLegalInteragir) {
        this.medDepotLegalInteragir = medDepotLegalInteragir;
    }
    

    
    @Override
    public String toString() {
        return "" + this.medDepotLegal + " " + this.medDepotLegalInteragir ;
    }
}

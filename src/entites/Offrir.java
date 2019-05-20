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
public class Offrir {
    public int rapNum;
    public int medDepotLegal;
    public int offQte;

    

   

   
    public Offrir() {
    }

    public Offrir(int num, int depotLegal, int qte) {
        this.setRapNum(num);
        this.setMedDepotLegal(depotLegal); 
        this.setOffQte(qte);
    }
     
    public int getRapNum() {
        return rapNum;
    }

    public void setRapNum(int rapNum) {
        this.rapNum = rapNum;
    }

    public int getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(int medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }

    public int getOffQte() {
        return offQte;
    }

    public void setOffQte(int offQte) {
        this.offQte = offQte;
    }

    
    @Override
    public String toString() {
        return "" + this.rapNum + " " + this.medDepotLegal + " " + this.offQte ;
    }
    
    
}

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
public class Prescrire {
    public int tinCode;
    public int dosCode;
    public int medDepotLegal;
    public int prePosologie;

   

   
    public Prescrire() {
    }

    public Prescrire(int ccode, int code, int depotLegal, int posologie) {
        this.setTinCode(ccode);
        this.setDosCode(code);
        this.setMedDepotLegal(depotLegal); 
        this.setPrePosologie(posologie);
    }
     public int getTinCode() {
        return tinCode;
    }

    public void setTinCode(int tinCode) {
        this.tinCode = tinCode;
    }

    public int getDosCode() {
        return dosCode;
    }

    public void setDosCode(int dosCode) {
        this.dosCode = dosCode;
    }

    public int getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(int medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }

    public int getPrePosologie() {
        return prePosologie;
    }

    public void setPrePosologie(int prePosologie) {
        this.prePosologie = prePosologie;
    }
    

    
    @Override
    public String toString() {
        return "" + this.tinCode + " " + this.dosCode + " " + this.medDepotLegal + " " + this.prePosologie ;
    }
    
}

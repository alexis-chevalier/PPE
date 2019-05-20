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
public class Formuler {
    public int preCode;
    public int medDepotLegal;

    

   

   
    public Formuler() {
    }

    public Formuler(int code, int depotLegal) {
        this.setPreCode(code);
        this.setMedDepotLegal(depotLegal); 
       
    }
    
    public int getPreCode() {
        return preCode;
    }

    public void setPreCode(int preCode) {
        this.preCode = preCode;
    }

    public int getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(int medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }
    
    

    
    @Override
    public String toString() {
        return "" + this.preCode + " " + this.medDepotLegal ;
    }
    
}

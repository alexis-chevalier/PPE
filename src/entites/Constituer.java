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
public class Constituer {
    public int medDepotLegal;
    public int cmpCode;
    public String cstUnite;
    public float cstQte;

   
    public Constituer() {
    }

    public Constituer(int depotLegal, int code, String unite, float qte) {
        this.setMedDepotLegal(depotLegal);
        this.setCmpCode(code);
        this.setCstUnite(unite); 
        this.setCstQte(qte);
    }
    public int getMedDepotLegal() {
        return medDepotLegal;
    }

    public void setMedDepotLegal(int medDepotLegal) {
        this.medDepotLegal = medDepotLegal;
    }

    public int getCmpCode() {
        return cmpCode;
    }

    public void setCmpCode(int cmpCode) {
        this.cmpCode = cmpCode;
    }

    public String getCstUnite() {
        return cstUnite;
    }

    public void setCstUnite(String cstUnite) {
        this.cstUnite = cstUnite;
    }

    public float getCstQte() {
        return cstQte;
    }

    public void setCstQte(float cstQte) {
        this.cstQte = cstQte;
    }

    
    @Override
    public String toString() {
        return "" + this.medDepotLegal + " " + this.cmpCode + " " + this.cstUnite + " " + this.cstQte ;
    }
    
}

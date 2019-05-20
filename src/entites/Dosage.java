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
public class Dosage {
    
    public int dosCodeDosage;
    public int dosQuantiteDosage;
    public int dosUniteDosage;
    
     public Dosage() {
    }
     
    public Dosage(int dosCode, int dosQuantite, int dosUnite) {
        this.setDosCodeDosage(dosCode);
        this.setDosQuantiteDosage(dosQuantite);
        this.setDosUniteDosage(dosUnite);
        
    }

    public int getDosCodeDosage() {
        return dosCodeDosage;
    }

    public void setDosCodeDosage(int dosCodeDosage) {
        this.dosCodeDosage = dosCodeDosage;
    }

    public int getDosQuantiteDosage() {
        return dosQuantiteDosage;
    }

    public void setDosQuantiteDosage(int dosQuantiteDosage) {
        this.dosQuantiteDosage = dosQuantiteDosage;
    }

    public int getDosUniteDosage() {
        return dosUniteDosage;
    }

    public void setDosUniteDosage(int dosUniteDosage) {
        this.dosUniteDosage = dosUniteDosage;
    }
    @Override
    public String toString() {
        return "" + this.dosCodeDosage + " " + this.dosQuantiteDosage + " " + this.dosUniteDosage;
    }
   
    
}

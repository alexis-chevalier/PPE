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
public class Famille {
    
    public int famCode;
    public String famLibelle;
    
    public Famille(){
}
    public Famille(int code, String libelle){
        this.setFamCode(code);
        this.setFamLibelle(libelle);
    }

    public int getFamCode() {
        return famCode;
    }

    public void setFamCode(int famCode) {
        this.famCode = famCode;
    }

    public String getFamLibelle() {
        return famLibelle;
    }

    public void setFamLibelle(String famLibelle) {
        this.famLibelle = famLibelle;
    }
    @Override
    public String toString() {
        return "" + this.famCode + " " + this.famLibelle ;
    }
}

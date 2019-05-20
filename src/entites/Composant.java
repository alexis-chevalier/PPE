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
public class Composant {

    public int cmpCode;
    public String cmpLibelle;

    public Composant() {
    }

    public Composant(int code, String libelle) {
        this.setCmpCode(code);
        this.setCmpLibelle(libelle);
    }

    public int getCmpCode() {
        return cmpCode;
    }

    public void setCmpCode(int cmpCode) {
        this.cmpCode = cmpCode;
    }

    public String getCmpLibelle() {
        return cmpLibelle;
    }

    public void setCmpLibelle(String cmpLibelle) {
        this.cmpLibelle = cmpLibelle;
    }
    @Override
    public String toString() {
        return "" + this.cmpCode + " " + this.cmpLibelle ;
    }
}

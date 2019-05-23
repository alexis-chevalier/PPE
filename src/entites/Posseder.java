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
public class Posseder {
    public int numPraticien;
    public int codeSpecialite;
    public String diplomePosseder;
    public Float coefprescription;

    public Posseder(){
    }
    
    public Posseder(int num, int code, String diplome, Float coef){
        this.setNumPraticien(num);
        this.setCodeSpecialite(code);
        this.setDiplomePosseder(diplome);
        this.setCoefprescription(coef);
    }
    
    public int getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(int numPraticien) {
        this.numPraticien = numPraticien;
    }

    public int getCodeSpecialite() {
        return codeSpecialite;
    }

    public void setCodeSpecialite(int codeSpecialite) {
        this.codeSpecialite = codeSpecialite;
    }

    public String getDiplomePosseder() {
        return diplomePosseder;
    }

    public void setDiplomePosseder(String diplomePosseder) {
        this.diplomePosseder = diplomePosseder;
    }

    public Float getCoefprescription() {
        return coefprescription;
    }

    public void setCoefprescription(Float coefprescription) {
        this.coefprescription = coefprescription;
    }
    
    public void affichageUniquePosseder(){
        System.out.println("-------------------------------------");
        System.out.println("Praticien N°");
        System.out.println(this.numPraticien);
        System.out.println("Code de la spécialité :");
        System.out.println(this.codeSpecialite);
        System.out.println("L'intitulé du diplome est :");
        System.out.println(this.diplomePosseder);
        System.out.println("Son coefficient de prescription est :");
        System.out.println(this.coefprescription);
        System.out.println("-------------------------------------");
    }
}

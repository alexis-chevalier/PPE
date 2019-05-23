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
public class TypePraticien {

    public int codeTypePraticien;
    public String libelleTypePraticien;
    public String lieuTypePraticien;

    public TypePraticien() {
    }
    public TypePraticien(int code){
        this.setCodeTypePraticien(code);
    }
    

    public TypePraticien(int code, String libelle, String lieu) {
        this.setCodeTypePraticien(code);
        this.setLibelleTypePraticien(libelle);
        this.setLieuTypePraticien(lieu);
    }

    public int getCodeTypePraticien() {
        return codeTypePraticien;
    }

    public void setCodeTypePraticien(int codeTypePraticien) {
        this.codeTypePraticien = codeTypePraticien;
    }

    public String getLibelleTypePraticien() {
        return libelleTypePraticien;
    }

    public void setLibelleTypePraticien(String libelleTypePraticien) {
        this.libelleTypePraticien = libelleTypePraticien;
    }

    public String getLieuTypePraticien() {
        return lieuTypePraticien;
    }

    public void setLieuTypePraticien(String lieuTypePraticien) {
        this.lieuTypePraticien = lieuTypePraticien;
    }

    public void affichageUniquePraticien() {
    }

    public void affichageUniqueTypePraticien() {
        System.out.println("-----------------------------------");
        System.out.println("Ce praticien est un :");
        System.out.println(this.getLibelleTypePraticien());
        System.out.println("Il travaille dans ce type de lieu :");
        System.out.println(this.getLieuTypePraticien());
        System.out.println("Son code de praticien est :");
        System.out.println(this.getCodeTypePraticien());
        System.out.println("-----------------------------------");
    }
    /*
    @Override
    public String toString() {
        return "" + this.libelleTypePraticien + " " + this.themeActiviteCompl + " ";
    }
     */
}

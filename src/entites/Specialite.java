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
public class Specialite {

    public int codeSpecialite;
    public String libelleSpecialite;
    
    public Specialite(){
    }

    public Specialite(int code, String libelle){
        this.setCodeSpecialite(code);
        this.setLibelleSpecialite(libelle);
    }
    public int getCodeSpecialite() {
        return codeSpecialite;
    }

    public void setCodeSpecialite(int codeSpecialite) {
        this.codeSpecialite = codeSpecialite;
    }

    public String getLibelleSpecialite() {
        return libelleSpecialite;
    }

    public void setLibelleSpecialite(String libelleSpecialite) {
        this.libelleSpecialite = libelleSpecialite;
    }
    /**
     * 
     * @param specialite 
     */
    public void afficherUniqueSpecialite(Specialite specialite){
        System.out.println("la spécialité est :");
        System.out.println(this.getLibelleSpecialite());
    }
}

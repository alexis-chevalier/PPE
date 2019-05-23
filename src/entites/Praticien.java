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
public class Praticien {

    public int numPraticien;
    public int codePraticien;
    public String nomPraticien;
    public String adresse;
    public String cpPraticien;
    public String villePraticien;
    public Float coefNotorietePraticien;
    public int codeTypePraticien;
    public int codeSpecialite;
 
    /*
    public TypePraticien typeDuPraticien;
    public PossederSpecialite specialitePossederParPraticien;
     */



    public Praticien() {
    }

    public Praticien(int numPraticien) {
        this.numPraticien = numPraticien;
    }

    public Praticien(int num, int code, String nom, String adresse, String cp, String ville, float coef, int codeTypePraticien, int codeSpe /*TypePraticien objetTypePraticien*/) {
        this.setNumPraticien(num);
        this.setCodePraticien(code);
        this.setNomPraticien(nom);
        this.setAdresse(adresse);
        this.setCpPraticien(cp);
        this.setVillePraticien(ville);
        this.setCoefNotorietePraticien(coef);
        this.setCodeTypePraticien(codeTypePraticien);
        this.setCodeSpecialite(codeSpe);
        //this.setCodeSpecialite(codeSpe);
                //this.setTypeDuPraticien(objetTypePraticien);
                //this.setSpecialitePossederParPraticien(specialite);
    }
        public int getCodeSpecialite() {
        return codeSpecialite;
    }

    public void setCodeSpecialite(int codeSpecialite) {
        this.codeSpecialite = codeSpecialite;
    }
    public int getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(int numPraticien) {
        this.numPraticien = numPraticien;
    }

    public int getCodePraticien() {
        return codePraticien;
    }

    public void setCodePraticien(int codePraticien) {
        this.codePraticien = codePraticien;
    }

    public String getNomPraticien() {
        return nomPraticien;
    }

    public void setNomPraticien(String nomPraticien) {
        this.nomPraticien = nomPraticien;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCpPraticien() {
        return cpPraticien;
    }

    public void setCpPraticien(String cpPraticien) {
        this.cpPraticien = cpPraticien;
    }

    public String getVillePraticien() {
        return villePraticien;
    }

    public void setVillePraticien(String villePraticien) {
        this.villePraticien = villePraticien;
    }

    public Float getCoefNotorietePraticien() {
        return coefNotorietePraticien;
    }

    public void setCoefNotorietePraticien(Float coefNotorietePraticien) {
        this.coefNotorietePraticien = coefNotorietePraticien;
    }

    /*
    public TypePraticien getTypeDuPraticien() {
        return typeDuPraticien;
    }

    public void setTypeDuPraticien(TypePraticien typeDuPraticien) {
        this.typeDuPraticien = typeDuPraticien;
    }

    public PossederSpecialite getSpecialitePossederParPraticien() {
        return specialitePossederParPraticien;
    }

    public void setSpecialitePossederParPraticien(PossederSpecialite specialitePossederParPraticien) {
        this.specialitePossederParPraticien = specialitePossederParPraticien;
    }*/

    public int getCodeTypePraticien() {
        return codeTypePraticien;
    }

    public void setCodeTypePraticien(int codeTypePraticien) {
        this.codeTypePraticien = codeTypePraticien;
    }

    public void affichageUniquePraticien() {
        /*System.out.println("Ce type de praticien est :");
        System.out.println(this.getNomPraticien());*/
        System.out.println("-------------------------------------");
        System.out.println("Praticien N°");
        System.out.println(this.numPraticien);
        System.out.println("Code du praticien : ");
        System.out.println(this.codePraticien);
        System.out.println("Nom du praticien : ");
        System.out.println(this.nomPraticien);
        System.out.println("Qui a pour adresse :");
        System.out.println(this.adresse);
        System.out.println("Son code postal est :");
        System.out.println(this.cpPraticien);
        System.out.println("Son coefficient de notoriété est de :");
        System.out.println(this.coefNotorietePraticien);
        System.out.println("Son code de type est :");
        System.out.println(this.codeTypePraticien);
        System.out.println("Son code de spécialité est :");
        System.out.println(this.codeSpecialite);
        System.out.println("-------------------------------------");
    }
    /*
    
    
     */
}

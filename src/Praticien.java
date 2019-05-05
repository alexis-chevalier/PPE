/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    private PossederSpecialite possederSpecialite;
    private TypePraticien typePraticien;
    
    
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
    
}

package entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.GregorianCalendar;

/**
 *
 * @author admin
 */
public class ActiviteCompl {

    public int numActiviteCompl;
    
    public GregorianCalendar dateActiviteCompl;
    
    public String lieuActiviteCompl;
    
    public String themeActiviteCompl;
    
    private Visiteur visiteur;
    private Praticien praticien;
    
    public int getNumActiviteCompl() {
        return numActiviteCompl;
    }

    public void setNumActiviteCompl(int numActiviteCompl) {
        this.numActiviteCompl = numActiviteCompl;
    }

    public GregorianCalendar getDateActiviteCompl() {
        return dateActiviteCompl;
    }

    public void setDateActiviteCompl(GregorianCalendar dateActiviteCompl) {
        this.dateActiviteCompl = dateActiviteCompl;
    }

    public String getLieuActiviteCompl() {
        return lieuActiviteCompl;
    }

    public void setLieuActiviteCompl(String lieuActiviteCompl) {
        this.lieuActiviteCompl = lieuActiviteCompl;
    }

    public String getThemeActiviteCompl() {
        return themeActiviteCompl;
    }

    public void setThemeActiviteCompl(String themeActiviteCompl) {
        this.themeActiviteCompl = themeActiviteCompl;
    }
}

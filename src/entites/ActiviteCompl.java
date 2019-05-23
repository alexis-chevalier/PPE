/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import java.util.Calendar;
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

    public ActiviteCompl() {

    }

    public ActiviteCompl(int num, GregorianCalendar date, String lieu, String theme) {
        this.setNumActiviteCompl(num);
        this.setDateActiviteCompl(date);
        this.setLieuActiviteCompl(lieu);
        this.setThemeActiviteCompl(theme);
    }

    public int getNumActiviteCompl() {
        return numActiviteCompl;
    }

    public void setNumActiviteCompl(int numActiviteCompl) {
        this.numActiviteCompl = numActiviteCompl;
    }

    public GregorianCalendar getDateActiviteCompl() {
        return dateActiviteCompl;
    }

    public Date getToSQLDateActiviteCompl() {
        Date SQLdate = new Date(this.dateActiviteCompl.getTimeInMillis());
        return SQLdate;
    }

    public void setDateActiviteCompl(GregorianCalendar dateActiviteCompl) {
        this.dateActiviteCompl = dateActiviteCompl;
    }

    public void setDateActiviteCompl(java.sql.Date SQLdateActiviteCompl) {
        GregorianCalendar dateActiviteCompl = new GregorianCalendar();
        dateActiviteCompl.setTime(SQLdateActiviteCompl);
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

    public void affichageUniqueActiviteCompl(ActiviteCompl activiteCompl) {
        System.out.println("-------------------------------------------");
        System.out.println("Le thème de l'activité est :");
        System.out.println(this.getThemeActiviteCompl());
        String month[] = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
        int jour = this.getDateActiviteCompl().get(Calendar.DATE);
        int annee = this.getDateActiviteCompl().get(Calendar.YEAR);
        String mois =month[this.dateActiviteCompl.get(Calendar.MONTH)];
        System.out.println("La date de l'activité est le :");
        System.out.println(jour + " - " + mois + " - " + annee);
        System.out.println("Le lieu de l'activité complémentaire est :");
        System.out.println(this.getLieuActiviteCompl());
        System.out.println("-------------------------------------------");
    }

    /*affichage precedent*/
 /*
    @Override
    public String toString() {
        return "" + this.lieuActiviteCompl+ " " + this.themeActiviteCompl + " ";
    }
     */
}

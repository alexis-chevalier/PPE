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
public class Inviter {

    public int numActiviteCompl;
    public int numPraticien;
    public String specialisteon;

    public int getNumActiviteCompl() {
        return numActiviteCompl;
    }

    public void setNumActiviteCompl(int numActiviteCompl) {
        this.numActiviteCompl = numActiviteCompl;
    }

    public int getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(int numPraticien) {
        this.numPraticien = numPraticien;
    }

    public String getSpecialisteon() {
        return specialisteon;
    }

    public void setSpecialisteon(String specialisteon) {
        this.specialisteon = specialisteon;
    }

    public Inviter() {

    }

    public Inviter(int numActivite, int numPrat, String specialOn) {
        this.setNumActiviteCompl(numActivite);
        this.setNumPraticien(numPrat);
        this.setSpecialisteon(specialOn);
    }

    public void affichageUniqueInviter(Inviter invitation) {
        System.out.println("-------------------------------------------");
        System.out.println("La liason entre l'activité complémentaire et le praticien");
        System.out.println("Le numéro de l'activité complémentaire est :");
        System.out.println(this.getNumActiviteCompl());
        System.out.println("Le numéro du praticien est :");
        System.out.println(this.getNumPraticien());
        System.out.println("Le spécialiste est");
        System.out.println(this.getSpecialisteon());
        System.out.println("-------------------------------------------");
    }
}

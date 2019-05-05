/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Alexis
 */
public class Travailler {

    public Region region;
    public DatePPE dateppe;
    public Visiteur visiteur;
    public String role;

    public Travailler(Region region, DatePPE dateppe, Visiteur visiteur, String role) {
        this.region = region;
        this.dateppe = dateppe;
        this.visiteur = visiteur;
        this.role = role;
    }

    public Travailler(Region region, DatePPE dateppe, Visiteur visiteur) {
        this.region = region;
        this.dateppe = dateppe;
        this.visiteur = visiteur;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public DatePPE getDateppe() {
        return dateppe;
    }

    public void setDateppe(DatePPE dateppe) {
        this.dateppe = dateppe;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.getRegion().getId() + " " + this.getDateppe().getJJMMAA() + " " + this.getVisiteur().getMatricule() + " " + this.role;
    }

}

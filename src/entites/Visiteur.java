package entites;

import java.sql.Date;

public class Visiteur {

    public String matriculeVisiteur;

    private String nomVisiteur;

    private String prenomVisiteur;

    public String adresseVisiteur;

    public String cpVisiteur;

    public String villeVisiteur;

    public Date dateEmbaucheVisiteur;
    
    public int codeSecteur;
    
    public int codeDepartement;

    private Secteur secteurVisiteur;

    //private Role roleVisiteur;

    private Region regionVisiteur;

    private Visiteur visiteur;

    private Departement departementVisiteur;

    /*public Visiteur(String matriculeVisiteur, String nomVisiteur, String prenomVisiteur, String adresseVisiteur, String cpVisiteur, String villeVisiteur, Date dateEmbaucheVisiteur, int codeSecteur, int codeDepartement) {
        this.matriculeVisiteur = matriculeVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.adresseVisiteur = adresseVisiteur;
        this.cpVisiteur = cpVisiteur;
        this.villeVisiteur = villeVisiteur;
        this.dateEmbaucheVisiteur = dateEmbaucheVisiteur;
        this.codeSecteur = codeSecteur;
        this.codeDepartement = codeDepartement;
    }*/

    
    
    public Visiteur(String matriculeVisiteur, String nomVisiteur, String prenomVisiteur, String adresseVisiteur, String cpVisiteur, String villeVisiteur, Date dateEmbaucheVisiteur, Secteur secteurVisiteur, Departement departementVisiteur) {
        this.matriculeVisiteur = matriculeVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.adresseVisiteur = adresseVisiteur;
        this.cpVisiteur = cpVisiteur;
        this.villeVisiteur = villeVisiteur;
        this.dateEmbaucheVisiteur = dateEmbaucheVisiteur;
        this.secteurVisiteur = secteurVisiteur;
        this.departementVisiteur = departementVisiteur;
    }

    /*public Visiteur(String matriculeVisiteur, String nomVisiteur, String prenomVisiteur, String adresseVisiteur, String cpVisiteur, String villeVisiteur, Date dateEmbaucheVisiteur, Secteur secteurVisiteur, Role roleVisiteur, Region regionVisiteur, Departement departementVisiteur) {
        this.matriculeVisiteur = matriculeVisiteur;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.adresseVisiteur = adresseVisiteur;
        this.cpVisiteur = cpVisiteur;
        this.villeVisiteur = villeVisiteur;
        this.dateEmbaucheVisiteur = dateEmbaucheVisiteur;
        this.secteurVisiteur = secteurVisiteur;
        this.roleVisiteur = roleVisiteur;
        this.regionVisiteur = regionVisiteur;
        this.departementVisiteur = departementVisiteur;
    }*/

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public Departement getDepartementVisiteur() {
        return departementVisiteur;
    }

    public Secteur getSecteurVisiteur() {
        return secteurVisiteur;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public String getPrenomVisiteur() {
        return prenomVisiteur;
    }

    public void setPrenomVisiteur(String prenomVisiteur) {
        this.prenomVisiteur = prenomVisiteur;
    }

    public Visiteur(String matriculeVisiteur) {
        this.matriculeVisiteur = matriculeVisiteur;
    }

    public String getMatricule() {
        return matriculeVisiteur;
    }

    public void setMatricule(String matricule) {
        this.matriculeVisiteur = matricule;
    }

    public String getAdresse() {
        return adresseVisiteur;
    }

    public void setAdresse(String adresse) {
        this.adresseVisiteur = adresse;
    }

    public String getCp() {
        return cpVisiteur;
    }

    public void setCp(String cp) {
        this.cpVisiteur = cp;
    }

    public String getVille() {
        return villeVisiteur;
    }

    public void setVille(String ville) {
        this.villeVisiteur = ville;
    }

    public Date getDateEmbauche() {
        return dateEmbaucheVisiteur;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbaucheVisiteur = dateEmbauche;
    }
    
    @Override
    public String toString() {
        return "" + this.matriculeVisiteur + " " + this.nomVisiteur + " " + this.prenomVisiteur + " " + this.adresseVisiteur + " " + this.cpVisiteur + " " + this.villeVisiteur + " " + this.dateEmbaucheVisiteur + " " + this.getSecteurVisiteur().getCode() + " " + this.getDepartementVisiteur().getCode();
    }
}

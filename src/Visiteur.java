class Visiteur {

    public String matriculeVisiteur;

    private String nomVisiteur;

    public String adresseVisiteur;

    public String cpVisiteur;

    public String villeVisiteur;

    public String dateEmbaucheVisiteur;

    private Secteur secteurVisiteur;

    private Role roleVisiteur;

    private Region regionVisiteur;

    private Visiteur visiteur;

    private Departement departementVisiteur;

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

    public String getDateEmbauche() {
        return dateEmbaucheVisiteur;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbaucheVisiteur = dateEmbauche;
    }
    
    
    

}

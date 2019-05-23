package entites;

public class Region {

    public int idRegion;

    public String nomRegion;

    private Secteur secteur;

    /*public Region(int idRegion, String nomRegion, int codeSecteur) {
        this.idRegion = idRegion;
        this.nomRegion = nomRegion;
        this.codeSecteur = codeSecteur;
    }*/

    public Region(int idRegion, String nomRegion, Secteur secteur) {
        this.setId(idRegion);
        this.setNom(nomRegion);
        this.setSecteur(secteur);
    }

    public Region(int idRegion) {
        this.setId(idRegion);
    }

    public int getId() {
        return idRegion;
    }

    public void setId(int id) {
        this.idRegion = id;
    }

    public String getNom() {
        return nomRegion;
    }

    public void setNom(String nom) {
        this.nomRegion = nom;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    
    public Secteur getSecteur() {
        return secteur;
    }

    @Override
    public String toString() {
        return "" + this.idRegion + " " + this.nomRegion + " " + this.getSecteur().getCode();
    }
    
}

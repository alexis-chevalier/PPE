package entites;

public class Region {

    public int idRegion;

    public String nomRegion;

    public int codeSecteur;

    private Secteur secteur;

    /*public Region(int idRegion, String nomRegion, int codeSecteur) {
        this.idRegion = idRegion;
        this.nomRegion = nomRegion;
        this.codeSecteur = codeSecteur;
    }*/

    public Region(int idRegion, String nomRegion, Secteur secteur) {
        this.idRegion = idRegion;
        this.nomRegion = nomRegion;
        this.secteur = secteur;
    }

    public Region(int idRegion) {
        this.idRegion = idRegion;
    }

    public Secteur getSecteur() {
        return secteur;
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

    @Override
    public String toString() {
        return "" + this.idRegion + " " + this.nomRegion + " " + this.getSecteur().getCode();
    }
    
}

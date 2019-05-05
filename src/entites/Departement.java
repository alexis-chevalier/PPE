package entites;

public class Departement {

    public int codeDepartement;

    public String nomDepartement;

    public int chefVente;

    private Visiteur visiteur;

    public Departement(int codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public Departement(int codeDepartement, String nomDepartement, int chefVente) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
        this.chefVente = chefVente;
    }

    public Departement(int codeDepartement, String nomDepartement, int chefVente, Visiteur visiteur) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
        this.chefVente = chefVente;
        this.visiteur = visiteur;
    }

    public int getCode() {
        return codeDepartement;
    }

    public void setCode(int code) {
        this.codeDepartement = code;
    }

    public String getNom() {
        return nomDepartement;
    }

    public void setNom(String nom) {
        this.nomDepartement = nom;
    }

    public int getChefVente() {
        return chefVente;
    }

    public void setChefVente(int chefVente) {
        this.chefVente = chefVente;
    }

    @Override
    public String toString() {
        return "" + this.codeDepartement + " " + this.nomDepartement + " " + this.chefVente;
    }

}

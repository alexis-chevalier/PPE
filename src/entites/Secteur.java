package entites;

public class Secteur {

    public int codeSecteur;

    public String libelleSecteur;

    public Secteur(int codeSecteur) {
        this.codeSecteur = codeSecteur;
    }
    
    public Secteur(int codeSecteur, String libelleSecteur) {
        this.codeSecteur = codeSecteur;
        this.libelleSecteur = libelleSecteur;
    }

    public int getCode() {
        return codeSecteur;
    }

    public void setCode(int code) {
        this.codeSecteur = code;
    }

    public String getLibelle() {
        return libelleSecteur;
    }

    public void setLibelle(String libelle) {
        this.libelleSecteur = libelle;
    }

    @Override
    public String toString() {
        return "" + this.codeSecteur + " " + this.libelleSecteur;
    }

}

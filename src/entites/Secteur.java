package entites;

public class Secteur {

    public int codeSecteur;

    public String libelleSecteur;

    public Secteur(int codeSecteur) {
        this.setCode(codeSecteur);
    }
    
    public Secteur(int codeSecteur, String libelleSecteur) {
        this.setCode(codeSecteur);
        this.setLibelle(libelleSecteur);
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

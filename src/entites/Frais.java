package entites;


class Frais {
  public int codeFrais;

  public String libelleFrais;

  public  float forfait;

  public  int quantite;

  public  float montant;

    public int getCode() {
        return codeFrais;
    }

    public void setCode(int code) {
        this.codeFrais = code;
    }

    public String getLibelle() {
        return libelleFrais;
    }

    public void setLibelle(String libelle) {
        this.libelleFrais = libelle;
    }

    public float getForfait() {
        return forfait;
    }

    public void setForfait(float forfait) {
        this.forfait = forfait;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

  
  
}

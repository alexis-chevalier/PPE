
class Departement {
  public int codeDepartement;

  public String nomDepartement;

  public boolean chefVente;

  private Visiteur visiteur;

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

    public boolean getChefVente() {
        return chefVente;
    }

    public void setChefVente(boolean chefVente) {
        this.chefVente = chefVente;
    }

  
}

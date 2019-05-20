package entites;
import entites.FicheFrais;
import entites.TypeFrais;
import entites.Visiteur;

public class Frais {

  
  public  int quantite;
  public  float montant;
  protected Visiteur visiteur;
  protected FicheFrais ficheFrais;
  protected TypeFrais typeFrais;
  

  public Frais(Visiteur visiteur, FicheFrais ficheFrais, TypeFrais typeFrais, int quantite, float montant){
        getVisiteur().getMatricule();
        getFicheFrais().getMois();
        getTypeFrais().getCodeFrais();
        setQuantite(quantite);
        setMontant(montant);
    }
  
    public FicheFrais getFicheFrais() {
        return ficheFrais;
    }

    public TypeFrais getTypeFrais() {
        return typeFrais;
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

    public Visiteur getVisiteur() {
        return visiteur;
    }
    
  @Override
    public String toString() {
        return "" + this.getVisiteur().getMatricule() + " " + this.getFicheFrais().getMois() + " " + this.getTypeFrais().getCodeFrais() + " " + this.quantite + " " + this.montant;
    }
  
}

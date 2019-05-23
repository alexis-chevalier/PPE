package entites;
import java.util.List;
import table.CTableFrais;

public class FicheFrais {
    
  protected int mois;
  protected int nbHorsClassif;
  protected float montantHorsClassif;
  Visiteur visiteur;
  CTableFrais listefrais;
  
  public FicheFrais(int mois, int nbHorsClassif, float montantHorsClassif, Visiteur visiteur, List<Frais>listeFrais){
        setMois(mois);
        setNbHorsClassif(nbHorsClassif);
        setMontantHorsClassif(montantHorsClassif);
        getVisiteur().getMatricule();
    }
  
  public FicheFrais(int mois) {
        setMois(mois);
    }
  private Frais frais;

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNbHorsClassif() {
        return nbHorsClassif;
    }

    public void setNbHorsClassif(int nbHorsClassif) {
        this.nbHorsClassif = nbHorsClassif;
    }

    public float getMontantHorsClassif() {
        return montantHorsClassif;
    }

    public void setMontantHorsClassif(float montantHorsClassif) {
        this.montantHorsClassif = montantHorsClassif;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }
    
    @Override
    public String toString() {
        return "" + this.getVisiteur().getMatricule() + " " + this.mois + " " + this.nbHorsClassif + " " + this.montantHorsClassif;
    }

}


import java.util.ArrayList;

public class Medicament {
    public int depotLegalMedicament;
    public String nomCommercialMedicament;
    public ArrayList compositionMedicament;
    public String effets;
    public String contreIndic;
    public float prixEchantillon;
    
    private Constituant constituant;
    private Famille famille;
    private Presentation presentation;
    private TypeIndividu typeIndividu;
    private RapportVisite rapport;

    public int getDepotLegal() {
        return depotLegalMedicament;
    }

    public void setDepotLegal(int depotLegal) {
        this.depotLegalMedicament = depotLegal;
    }

    public String getNomCommercial() {
        return nomCommercialMedicament;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercialMedicament = nomCommercial;
    }

    public ArrayList getComposition() {
        return compositionMedicament;
    }

    public void setComposition(ArrayList composition) {
        this.compositionMedicament = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContreIndic() {
        return contreIndic;
    }

    public void setContreIndic(String contreIndic) {
        this.contreIndic = contreIndic;
    }

    public float getPrixEchantillon() {
        return prixEchantillon;
    }

    public void setPrixEchantillon(float prixEchantillon) {
        this.prixEchantillon = prixEchantillon;
    }
    
    
}

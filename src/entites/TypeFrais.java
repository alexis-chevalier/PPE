package entites;

public class TypeFrais {

    public int codeFrais;
    public String libelleFrais;
    public float forfait;

    public TypeFrais(int codeFrais, String libelleFrais, float forfait) {
        setCodeFrais(codeFrais);
        setLibelleFrais(libelleFrais);
        setForfait(forfait);
    }

    public TypeFrais(int codeFrais) {
        this.codeFrais = codeFrais;
    }

    public int getCodeFrais() {
        return codeFrais;
    }

    public void setCodeFrais(int code) {
        this.codeFrais = code;
    }

    public String getLibelleFrais() {
        return libelleFrais;
    }

    public void setLibelleFrais(String libelle) {
        this.libelleFrais = libelle;
    }

    public float getForfait() {
        return forfait;
    }

    public void setForfait(float forfait) {
        this.forfait = forfait;
    }
    private TypeFrais typeFrais;

    @Override
    public String toString() {
        return "" + this.codeFrais + " " + this.libelleFrais + " " + this.forfait;
    }
}

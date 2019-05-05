package entites;

class TypeIndividu {
    public int codeTypeIndividu;
    public String libelleTypeIndividu;
    
    private Dosage dosage;

    public int getCode() {
        return codeTypeIndividu;
    }

    public void setCode(int code) {
        this.codeTypeIndividu = code;
    }

    public String getLibelle() {
        return libelleTypeIndividu;
    }

    public void setLibelle(String libelle) {
        this.libelleTypeIndividu = libelle;
    }
    
    
}

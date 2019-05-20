/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
/**
 *
 * @author Jeremy
 */
public class Presentation {

    public int preCodePresentation;
    public String preLibellePresentation;
    
    public Presentation() {
    }
     
    public Presentation(int preCode, String preLibelle) {
        this.setPreCodePresentation(preCode);
        this.setPreLibellePresentation(preLibelle);
        
    }

    public int getPreCodePresentation() {
        return preCodePresentation;
    }

    public void setPreCodePresentation(int preCodePresentation) {
        this.preCodePresentation = preCodePresentation;
    }

    public String getPreLibellePresentation() {
        return preLibellePresentation;
    }

    public void setPreLibellePresentation(String preLibellePresentation) {
        this.preLibellePresentation = preLibellePresentation;
    }
    @Override
    public String toString() {
        return "" + this.preCodePresentation + " " + this.preLibellePresentation ;
    }
    
     

    

}

    
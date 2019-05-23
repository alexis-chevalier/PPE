/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author admin
 */
public class Realiser {

    public int visMatriculeVisteur;
    public int numActiviteCompl;
    
    public int getVisMatriculeVisteur() {
        return visMatriculeVisteur;
    }
    
    public void setVisMatriculeVisteur(int visMatriculeVisteur) {
        this.visMatriculeVisteur = visMatriculeVisteur;
    }
    
    public int getNumActiviteCompl() {
        return numActiviteCompl;
    }
    
    public void setNumActiviteCompl(int numActiviteCompl) {
        this.numActiviteCompl = numActiviteCompl;
    }

    public Realiser() {
    }

    public Realiser(int matricule, int numActivite) {
        this.setVisMatriculeVisteur(matricule);
        this.setNumActiviteCompl(numActivite);
    }
    /**
     * Méthode qui affiche un unique enregistrement de la table Réaliser.
     * 
     */
    public void affichageUniqueRealiser(){
     System.out.println("-------------------------------------------");
        System.out.println("Liaison entre activité complémentaire et visisteur");
        System.out.println("le Matricule du visiteur est :");
        System.out.println(this.getVisMatriculeVisteur());
        System.out.println("Le numéro de l'activité complémentaire est :");
        System.out.println(this.getNumActiviteCompl());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import Utilitaires.CUtilitaire_dateSQL_PPE;
import java.util.ArrayList;
import entites.ActiviteCompl;

/**
 *
 * @author Clément
 */
public class ListeActiviteCompl {

    public ArrayList<ActiviteCompl> listeActiviteCompl = new ArrayList();

    public ArrayList<ActiviteCompl> getListeActiviteCompl() {
        return listeActiviteCompl;
    }

    public void setListeActiviteCompl(ArrayList<ActiviteCompl> listeActiviteCompl) {
        this.listeActiviteCompl = listeActiviteCompl;
    }

    public int insererActiviteCompl(ActiviteCompl numero) {
        if (numero != null) {
            this.listeActiviteCompl.add(numero);
            return 1;
        }
        return -1;
    }

    public int supprimerActiviteCompl(ActiviteCompl numero) {
        if (numero != null) {
            this.listeActiviteCompl.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherActiviteCompl() {
        for (int i = 0; i < this.listeActiviteCompl.size(); i++) {
            /*
            TypePraticien AffichePraticienAIndexI = new TypePraticien();
            this.getListeTypePraticien().get(i).affichageUniqueTypePraticien(AffichePraticienAIndexI);
            
            ListeActiviteCompl afficheActiviteComplAIndexI = new ListeActiviteCompl();
            this.getListeActiviteCompl().get(i).affichageUniqueActiviteCompl(afficheActiviteComplAIndexI);
             */
            ActiviteCompl afficheActiviteComplAIndexI = new ActiviteCompl();
            this.getListeActiviteCompl().get(i).affichageUniqueActiviteCompl(afficheActiviteComplAIndexI);
            /* ancienne de methode affichage date V2
            System.out.println("Le numéro de l'activité complémentaire est :");
            System.out.println(this.getListeActiviteCompl().get(i).numActiviteCompl);
            System.out.println("La date de l'activite complémentaire est :");

            String month[] = { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" }; 

            int jour = this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.DATE);
            int annee = this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.YEAR);
            String mois = month[this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.MONTH)];
            System.out.println("La date de l'activité est le :");
            System.out.println(jour+" - "+mois+" - "+annee);
            System.out.println("Le lieu de l'activité complémentaire est :");
            System.out.println(this.getListeActiviteCompl().get(i).lieuActiviteCompl);
            System.out.println("Le thème de l'activité complémentaire est :");
            System.out.println(this.getListeActiviteCompl().get(i).themeActiviteCompl);
             */

 /* ancienne de methode affichage date V1
            int jour = new Date(this.getListeActiviteCompl().get(i).dateActiviteCompl.getTimeInMillis()).getDay();
            int mois = new Date(this.getListeActiviteCompl().get(i).dateActiviteCompl.getTimeInMillis()).getMonth();
            int annee = new Date(this.getListeActiviteCompl().get(i).dateActiviteCompl.getTimeInMillis()).getYear() + 1900;
            System.out.println(jour +" - "+ mois +" - "+ annee);
            System.out.println(this.getListeActiviteCompl().get(i).dateActiviteCompl.getTime());
             */
            //System.out.println(this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.DATE));
            //System.out.println(this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.YEAR));
            //System.out.println(month[this.getListeActiviteCompl().get(i).dateActiviteCompl.get(Calendar.MONTH)]);
        }
    }

    public int modifierActiviteCompl(ActiviteCompl numero) {
        if (numero != null) {
            for (int i = 0; i < this.getListeActiviteCompl().size(); i++) {
                this.getListeActiviteCompl().set(i, numero);
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}

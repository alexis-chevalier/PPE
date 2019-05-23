/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste;

import Utilitaires.CUtilitaire_dateSQL_PPE;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import entites.ActiviteCompl;
import java.util.GregorianCalendar;
import entites.Inviter;

/**
 *
 * @author admin
 */
public class ListeInviter {

    public ArrayList<Inviter> listeInviter = new ArrayList();

    public ArrayList<Inviter> getListeInviter() {
        return listeInviter;
    }

    public void setListeInviter(ArrayList<Inviter> listeInviter) {
        this.listeInviter = listeInviter;
    }

    public int insererInviter(Inviter numero) {
        if (numero != null) {
            this.listeInviter.add(numero);
        }
        return -1;
    }

    public int supprimerinviter(Inviter numero) {
        if (numero != null) {
            this.listeInviter.remove(numero);
            return 1;
        }
        return -1;
    }

    public void afficherInviter() {
        for (int i = 0; i < this.listeInviter.size(); i++) {
            Inviter afficheInviterIndexI = new Inviter();
            this.getListeInviter().get(i).affichageUniqueInviter(afficheInviterIndexI);
        }
    }

    public int modifierInviter(Inviter numero) {
        if (numero != null) {
            for (int i = 0; i < this.getListeInviter().size(); i++) {
                this.getListeInviter().set(i, numero);
                return 1;
            }
        }
        return -1;
    }
}

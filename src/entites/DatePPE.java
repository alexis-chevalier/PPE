/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Alexis
 */
public class DatePPE {

    public String JJMMAA;

    public DatePPE(String JJMMAAAA) {
        this.JJMMAA = JJMMAAAA;
    }
    
    public String getJJMMAA() {
        return JJMMAA;
    }

    public void setJJMMAA(String JJMMAA) {
        this.JJMMAA = JJMMAA;
    }

    @Override
    public String toString() {
        return "" + this.JJMMAA;
    }
    
}

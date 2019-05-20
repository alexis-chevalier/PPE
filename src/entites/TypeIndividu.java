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
public class TypeIndividu {
    
    public int tinCodeTypeIndividu;
    public String tinLibelleTypeIndividu;
    
    public TypeIndividu() {
    }
     
    public TypeIndividu(int tinCode, String tinLibelle) {
        this.setTinCodeTypeIndividu(tinCode);
        this.setTinLibelleTypeIndividu(tinLibelle);
        
    }

    public int getTinCodeTypeIndividu() {
        return tinCodeTypeIndividu;
    }

    public void setTinCodeTypeIndividu(int tinCodeTypeIndividu) {
        this.tinCodeTypeIndividu = tinCodeTypeIndividu;
    }

    public String getTinLibelleTypeIndividu() {
        return tinLibelleTypeIndividu;
    }

    public void setTinLibelleTypeIndividu(String tinLibelleTypeIndividu) {
        this.tinLibelleTypeIndividu = tinLibelleTypeIndividu;
    }
    @Override
    public String toString() {
        return "" + this.tinCodeTypeIndividu + " " + this.tinLibelleTypeIndividu ;
    }
       

}


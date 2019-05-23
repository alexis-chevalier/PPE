package Utilitaires;


import java.sql.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class CUtilitaire_dateSQL_PPE {

    /**
     *
     * @param date must be like "yyyy-mm-dd"
     * @return GregorianCalendar format of date
     */
    public static GregorianCalendar convertSQLDatetoGregCal(String date) {
        Date SQLdate = Date.valueOf(date);
        //System.out.println(date);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(SQLdate);
        System.out.println(cal.getTime());
        return cal;
    }
    
    public static void main(String[] args) {
        CUtilitaire_dateSQL_PPE.convertSQLDatetoGregCal("1986-06-23");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DECISION_TABLES;

/**
 *
 * @author nikolai
 */
public class Reimburse {
    private boolean deductible;
    //if false then Hospital visit
    private boolean doctorsOffice;
    
    private double expenses;

    public Reimburse(boolean deductible, boolean doctorsOffice, double expenses) {
        this.deductible = deductible;
        this.doctorsOffice = doctorsOffice;
        this.expenses = expenses;
    }
    
    
    //in kroner
    public double howMuchReimburse(){
        if(!deductible)
            return -1;
        if(doctorsOffice)
            return (expenses * 0.5);
        else
            return (expenses * 0.8);
    }

    public void setDeductible(boolean deductible) {
        this.deductible = deductible;
    }

    public void setDoctorsOffice(boolean doctorsOffice) {
        this.doctorsOffice = doctorsOffice;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savingsaccount;

/**
 *
 * @author hfs5022
 */
public class SavingsAccount {
    
    private static double annualInterestRate;
    private double savingsBalance;
    
    public SavingsAccount(double initialBalance, double initialInterestRate){
       annualInterestRate = initialInterestRate;
       savingsBalance = initialBalance;
    }
    
    public SavingsAccount(double initialBalance){
       this(initialBalance, 0);
    }
    
    public SavingsAccount(){
        this(0,0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SavingsAccount saver1 = new SavingsAccount(2000d, .04d);
        SavingsAccount saver2 = new SavingsAccount(3000d, .04d);
        
        System.out.printf("Savings Account Balances\nMonth\t\tSaver 1\t\tSaver 2\t\n");
      
        for(int i = 0; i < 12; i++){
            
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            System.out.printf("%2d\t\t%8.2f\t%8.2f\n", i+1, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance()
            );
            
        }
        
        SavingsAccount.setInterestRate(.05d);
        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("%2d\t\t%8.2f\t%8.2f\n", 13, 
                saver1.getSavingsBalance(),
                saver2.getSavingsBalance()
        );
        
        
    }
    
    
    private double calculateMonthlyInterest(){
        
        double monthlyInterest = (annualInterestRate*savingsBalance)/12d;
        savingsBalance += monthlyInterest;
        
        return monthlyInterest;
    }
    
    private static void setInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate;
    }
    
    private void setSavingsBalance(double newSavingsBalance){
        savingsBalance = newSavingsBalance;
    }
    
    private double getSavingsBalance(){
        return savingsBalance;
    }
}

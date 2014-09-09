/*
 * SavingsAccount Class
 * Gus (Henry) Smith
 * Instructor Al Verbanec
 * CMPSC 221
 * 9/11/14
 * 
 * An instance of this class represents a single user's savings account, with a
 * field to store their balance, in addition to a method which calculates the i-
 * nterest on their account.
 */

package savingsaccount;

public class SavingsAccount {
    
    
    private static double annualInterestRate;   // The yearly interest rate on ALL accounts.
    private double savingsBalance;              // The specific account's balance.
    
    // Verbose constructor.
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
     
    // The main method runs a test of this class.
    public static void main(String[] args) {
        
        // Create accounts with 4% annual interest.
        SavingsAccount saver1 = new SavingsAccount(2000d, .04d);
        SavingsAccount saver2 = new SavingsAccount(3000d, .04d);
        
        System.out.printf("Savings Account Balances\nMonth\t\tSaver 1\t\tSaver 2\t\n");
        
        // Calculate and print balances for 12 months.
        for(int i = 0; i < 12; i++){
            
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            System.out.printf("%2d\t\t%8.2f\t%8.2f\n", i+1, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance()
            );
            
        }
        
        // Change the interest rate.
        SavingsAccount.setInterestRate(.05d);
           
        // Calculate for one more month.
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("%2d\t\t%8.2f\t%8.2f\n", 13, 
                saver1.getSavingsBalance(),
                saver2.getSavingsBalance()
        );
        
        
    }
    
    /**
     * Calculates the interest gained on a sum of money in a month by dividing
     * the yearly rate by 12, multiplying the current sum by the result, and ad-
     * ding that amount onto the current sum.
     */
    private double calculateMonthlyInterest(){
        
        double monthlyInterest = (annualInterestRate*savingsBalance)/12d;
        savingsBalance += monthlyInterest;
        
        return monthlyInterest;
    }
    
    /**
     * Getters and setters.
     */
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

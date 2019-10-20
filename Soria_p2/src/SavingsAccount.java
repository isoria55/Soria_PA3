public class SavingsAccount {
    private static double annualInterestRate;
    private static double savingsBalance;

    public double inputBalance (double balance) {
        savingsBalance = balance;
        return savingsBalance;
    }

    public double interestRate (double rate) {
        annualInterestRate = rate;
        return annualInterestRate;
    }

    public double interestRateChange (double rate) {
        return (rate += 0.01);
    }

    public double interestValue (double balance, double rate) {
        double interest;
        interest = (balance * rate) / (double) 12;
        return interest;
    }

    public double calculateMonthlyInterest (double balance, double rate) {
        double interest;
        double monthlyInterest = balance;
        interest = interestValue(balance, rate);
        monthlyInterest = monthlyInterest + interest;
        return monthlyInterest;
    }


}

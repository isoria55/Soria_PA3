public class Application {
    public static void main (String [] args) {
        double newBalance;
        double newBalance2;
        int i;

        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        newBalance = saver1.calculateMonthlyInterest(saver1.inputBalance(2000), saver1.interestRate(0.04));
        newBalance2 = saver2.calculateMonthlyInterest(saver2.inputBalance(3000), saver2.interestRate(0.04));

        System.out.println("Month         saver1         saver2");
        for(i = 1; i < 14; i++) {
            if ( i < 10) {
                System.out.print("  " + i );
                System.out.print("          $");
                System.out.printf("%.2f", newBalance);
                System.out.print("       $");
                System.out.printf("%.2f\n", newBalance2);
            }
            else if ((i > 9) && (i < 13)) {
                System.out.print(" " + i );
                System.out.print("          $");
                System.out.printf("%.2f", newBalance);
                System.out.print("       $");
                System.out.printf("%.2f\n", newBalance2);
            }
            else if (i == 13) {
                newBalance = saver1.calculateMonthlyInterest(newBalance, saver1.interestRateChange(0.04));
                newBalance2 = saver2.calculateMonthlyInterest(newBalance2, saver2.interestRateChange(0.04));
                System.out.println("--Updating the Interest Rate to 5.0%--");
                System.out.print(" " + i );
                System.out.print("          $");
                System.out.printf("%.2f", newBalance);
                System.out.print("       $");
                System.out.printf("%.2f\n", newBalance2);
            }
            if (i < 12) {
                newBalance = saver1.calculateMonthlyInterest(newBalance, saver1.interestRate(0.04));
                newBalance2 = saver2.calculateMonthlyInterest(newBalance2, saver2.interestRate(0.04));
            }
        }

    }
}

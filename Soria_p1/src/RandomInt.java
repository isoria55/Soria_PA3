import java.util.Random;
public class RandomInt {
    private int number1;
    private int number2;

    public void  SecureRandom() {
        Random rand = new Random();

        number1 = rand.nextInt(10);
        number2 = rand.nextInt(10);
    }

    public void  Secure2Random() {
        Random rand = new Random();

        number1 = rand.nextInt(100);
        number2 = rand.nextInt(100);
    }
    public void  Secure3Random() {
        Random rand = new Random();

        number1 = rand.nextInt(1000);
        number2 = rand.nextInt(1000);
    }

    public void  Secure4Random() {
        Random rand = new Random();

        number1 = rand.nextInt(10000);
        number2 = rand.nextInt(10000);
    }

    public void getProdPrint(int number1, int number2) {
        System.out.println("How much is " + number1 + " times " + number2 + "?");
    }

    public void getAddPrint(int number1, int number2) {
        System.out.println("How much is " + number1 + " plus " + number2 + "?");
    }

    public void getSubPrint(int number1, int number2) {
        System.out.println("How much is " + number1 + " minus " + number2 + "?");
    }

    public void getDivPrint(int number1, int number2) {
        System.out.println("How much is " + number1 + " divided by " + number2 + "? (Please round to 2 decimal places if you need to.)");
    }

    public double getSolution(int number1, int number2, int z) {
        double solution = 0;
        if (z == 1) {
            solution = (double)number1 + (double)number2;
        }
        else if (z == 2) {
            solution = (double)number1 * (double)number2;
        }
        else if (z == 3) {
            solution = (double)number1 - (double)number2;
        }
        else if (z == 4) {
            solution = (double)number1 / (double)number2;
        }
        return solution;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}

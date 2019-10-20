import java.util.Scanner;
import java.util.Random;
public class problem1 {
    public static int userLevel () {
        Scanner scnr = new Scanner(System.in);
        int x;
        System.out.println("Please input a difficulty level from 1 - 4: ");
        x = scnr.nextInt();
        return x;
    }

    public static void percentValue(int j) {
        double percentCorrect;
        System.out.println("You got " + j + " correct.");
        System.out.println("You got " + (10 - j) + " incorrect.");
        System.out.println("You got a " + (j * 10) + "%.\n");
        percentCorrect = ((double)j) / ((double)10);
        if (percentCorrect < 0.75) {
            System.out.println("Please ask your teacher for extra help.");
        }
        else if (percentCorrect > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    public static int MathQuestions () {
        Scanner scnr = new Scanner(System.in);
        double userSolution;
        double actualSolution;
        int i = 0, j = 0;
        int x = 0, y = 0, z;
        int a, b;

        RandomInt compInstruct = new RandomInt();
        a = userLevel();
        z = questionType();
        while( i != 10) {
            if (a == 1) {
                compInstruct.SecureRandom();
                x = compInstruct.getNumber1();
                y = compInstruct.getNumber2();
            }
            else if (a == 2) {
                compInstruct.Secure2Random();
                x = compInstruct.getNumber1();
                y = compInstruct.getNumber2();
            }
            else if (a == 3) {
                compInstruct.Secure3Random();
                x = compInstruct.getNumber1();
                y = compInstruct.getNumber2();
            }
            else if (a == 4) {
                compInstruct.Secure4Random();
                x = compInstruct.getNumber1();
                y = compInstruct.getNumber2();
            }
            if (y == 0) { // this is used to eliminate the value 0 from the denominator to avoid errors.
                y += 1;
            }
            b = Question(x, y, z);
            actualSolution = compInstruct.getSolution(x, y, b);
            userSolution = scnr.nextDouble();

            if (Math.abs(userSolution - actualSolution) < 0.01) {
                correctResponse();
                j++;
            }
            else if (Math.abs(userSolution - actualSolution) > 0.01) {
                incorrectResponse();
            }
            i++;
        }
        return j;
    }

    public static void incorrectResponse () {
        Random rand = new Random();
        int x;
        x = rand.nextInt(4);
        switch (x) {
            case 0:
                System.out.println("No. Please try again.\n");
                break;
            case 1:
                System.out.println("Wrong. Try once more.\n");
                break;
            case 2:
                System.out.println("Don’t give up!\n");
                break;
            case 3:
                System.out.println("No. Keep trying.\n");
                break;
            default:
                break;
        }

    }

    public static void correctResponse () {
        Random rand = new Random();
        int x;
        x = rand.nextInt(4);
        switch (x) {
            case 0:
                System.out.println("Very good!\n");
                break;
            case 1:
                System.out.println("Excellent!\n");
                break;
            case 2:
                System.out.println("Nice work!\n");
                break;
            case 3:
                System.out.println("Keep up the good work!\n");
                break;
            default:
                break;
        }

    }

    public static int questionType () {
        Scanner scnr = new Scanner(System.in);
        int z;
        System.out.println("Type '1' for Addition, Type '2' for Multiplication, Type '3' for Subtraction, Type '4' for Division, and Type '5' for all of them: ");
        z = scnr.nextInt();
        return z;
    }

    public static int Question (int x, int y, int questionType) {
        int z;
        RandomInt compInstruct = new RandomInt();
        if (questionType == 1) {
            compInstruct.getAddPrint(x, y);
        }
        else if (questionType == 2) {
            compInstruct.getProdPrint(x, y);
        }
        else if (questionType == 3) {
            compInstruct.getSubPrint(x, y);
        }
        else if (questionType == 4) {
            compInstruct.getDivPrint(x, y);
        }
        else if (questionType == 5) {
            Random rand = new Random();
            z = rand.nextInt(4);
            switch (z) {
                case 0:
                    compInstruct.getAddPrint(x, y);
                    questionType = 1;
                    break;
                case 1:
                    compInstruct.getProdPrint(x, y);
                    questionType = 2;
                    break;
                case 2:
                    compInstruct.getSubPrint(x, y);
                    questionType = 3;
                    break;
                case 3:
                    compInstruct.getDivPrint(x, y);
                    questionType = 4;
                default:
                    break;
            }
        }
        System.out.print("Please type your response: ");
        return questionType;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int j;
        char userInput;
        System.out.println("Ready to take the quiz? Please type 'y' or 'Y' if yes: ");
        userInput = scnr.next().charAt(0);

        while ((userInput == 'y') || (userInput == 'Y')) {
            j = MathQuestions();
            percentValue(j);
            System.out.println("Ready to take the quiz? Please type 'y' or 'Y' if yes.");
            userInput = scnr.next().charAt(0);
        }
    }
}
package helgestenstrom;

import java.util.Scanner;

class LocalCalculator {
    public int evaluate(String expression) {
        int sum = 0;
        for (String summand: expression.split("\\+"))
            sum += Integer.valueOf(summand);
        return sum;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        LocalCalculator c = new LocalCalculator();
        int r = c.evaluate("12+3");
        System.out.println(r);

        Calculator c2 = new Calculator();
        System.out.println(c.evaluate(("100+12")));
    }

    public static int testUserInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Give a number between 1 and 10");
        int input = keyboard.nextInt();

        while (input < 1 || input > 10) {
            System.out.println("Wrong number, try again.");
            input = keyboard.nextInt();
        }

        return input;
    }
}

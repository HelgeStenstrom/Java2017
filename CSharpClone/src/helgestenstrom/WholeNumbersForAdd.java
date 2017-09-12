package helgestenstrom;

import java.util.Scanner;

public class WholeNumbersForAdd implements Startable {
    private Scanner input;

    public void start()
    {
        input = new Scanner(System.in);
        Banner();
        int count = GetValueCount();
        int sum = GetAndSumNumbers(count);
        PresentResult(sum);
    }

    private void Banner()
    {
        System.out.println();
        System.out.println("++++++ Summation of whole numbers ++++++");
        System.out.println("             Using a for-statement      ");
        System.out.println();
    }

    private int GetValueCount()
    {
        System.out.print("Number of values to sum? ");
        return input.nextInt();
    }

    private int GetAndSumNumbers(int count)
    // The main loop. We know beforehand how many iterations should be performed.
    {
        int sum = 0;
        for (int i = 1; i <= count; i++)
        {
            sum += PromptForNumber(i);
        }
        return sum;
    }

    private int PromptForNumber(int order)
    {
       System.out.printf("Please give the value no %d (whole number) ", order);
        return input.nextInt();
    }

    private void PresentResult(int sum)
    {
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("The sum is       " + sum);
        System.out.println();
    }
}

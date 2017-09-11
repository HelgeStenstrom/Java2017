package helgestenstrom;

import java.util.Scanner;

public class FloatingPointsNumberWhileAdd implements Startable{
    private Scanner input;

    @Override
    public void start() {
        // System.out.println("FloatingPointsNumberWhileAdd started.");
        input = new Scanner(System.in);
        Banner();
        double sum = GetAndSumNumbers();
        PresentResult(sum);
    }

    private void Banner()
    {
        System.out.println();
        System.out.println("  ++++++ Summation of real numbers ++++++");
        System.out.println("             Using a While-statement      ");
        System.out.println(" Use same decimal character as in " + 3.1415);
        System.out.println();
    }

    private double PromptForNumber()
    {
        System.out.print("Write an amount to sum or zero to finish: ");
        return input.nextDouble(); //
    }

    private double GetAndSumNumbers()
    // The main loop. Probably a do-while loop would work just fine.
    {
        double sum = 0;
        while ( true)
        {
            double f = PromptForNumber();
            sum += f;
            if (f == 0)
                break;
        }
        return sum;
    }

    private void PresentResult(double f)
    {
        System.out.println("------------");
        System.out.println("This sum is " + f);
        System.out.println();

    }


}

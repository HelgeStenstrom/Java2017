package helgestenstrom;

import java.util.Scanner;

public class CurrencyConverter implements Startable {

    private Scanner input;

    public void start()
    {
        input = new Scanner(System.in);

        Banner();

        float sum = GetAndSumNumbers();
        System.out.println();
        String currency = PromptForCurrency();
        float rate = PromptForRate();

        PresentResult(sum, rate, currency);

    }

    private void Banner()
    {
        System.out.println();
        System.out.println("Write 0 to finish input!");
        System.out.println("Make sure to use decimal character like in " + 3.1415);
        System.out.println();
    }

    private float PromptForNumber()
    {
        System.out.print("Write an amount or zero to finish: ");
        return input.nextFloat();
    }

    private String PromptForCurrency()
    {
        System.out.print("Name of foreign currency: ");
        return input.next();
    }

    private float PromptForRate()
    // Probably double would be a better choice, but the instructions say float.
    {
        System.out.print("Exchange rate: ");
        return input.nextFloat();
    }

    private float GetAndSumNumbers()
    {
        float f;
        float sum = 0;
        do
        {
            f = PromptForNumber();
            sum += f;
//            if (f == 0)
//                break;
        }
        while (f != 0);
        return sum;
    }

    private float convert(float val, float rate)
    {
        return val/rate;
    }

    private void PresentResult(float val, float rate, String cur)
    {
        System.out.println();
        System.out.println("----------------");
        System.out.println("This sum is " + val + " kr");
        System.out.println();
//        String s = String.Format("{0:0.00} kr is converted to {1:0.00} {2} at the rate of {3} kr/{2}",
//                val, convert(val,rate), cur, rate);

        System.out.printf("%.2f kr is converted to %.2f %s at the rate of %.3f kr/%s \n", val, convert(val, rate), cur, rate, cur);
        System.out.println();
    }

}

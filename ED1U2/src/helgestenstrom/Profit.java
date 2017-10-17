/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Profit implements Startable  {

    // @Override
    public void start() {
        System.out.println();
        PrintValueExamples(100.0);
        System.out.println();
        PrintValueExamples(200.0);
    }

    private static void PrintValueExamples(double startVal) {
        System.out.printf("Värden av ett konto med olika räntesatser. Ingående balans är %.2f kr. \n",
                            startVal);
        // Åtta metodanrop
        for (double interest = 0.02; interest <= 0.09; interest += 0.01) {
            System.out.printf("Värde med räntan %.1f %% är %.2f kr. \n", interest * 100, CalcValue(startVal, interest));
        }
    }

    // En metod med två parametrar
    private static double CalcValue(double startValue, double interest) {
        return startValue * (1 + interest);
    }


}

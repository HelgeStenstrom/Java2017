/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class Profit {

    static void test() {
        PrintValueExamples(10000.0);
    }

    static void PrintValueExamples(double startVal) {
        System.out.printf("Värden av ett konto med olika räntesatser. Ingående balans är %.2f kr. \n",
                            startVal);
        for (double interest = 0.02; interest <= 0.09; interest += 0.01) {
            System.out.printf("Värde med räntan %.1f %% är %.2f kr. \n", interest * 100, CalcValue(startVal, interest));
        }
    }

    static double CalcValue(double startValue, double interest) {
        return startValue * (1 + interest);
    }


}

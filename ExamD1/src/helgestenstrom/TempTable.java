package helgestenstrom;

import java.util.Scanner;

public class TempTable implements Startable {
    
    private Scanner input;
    public void start()
    {
        input = new Scanner(System.in);
        SelectionBanner();
        ChoiceDialog();
        System.out.println("You selected " + choice);
        PrintTable(choice);
    }

    private String choice;
    private String fromUnit;
    private String toUnit;

    private void SelectionBanner()
    {
        System.out.println();
        System.out.println("Select conversion type:");
        System.out.println("fc:  Celsius -> Fahrenheit");
        System.out.println("cf:  Fahrenheit -> Celsius");
    }

    private void ChoiceDialog()
    {
        while (true)
        {
            System.out.print("Your choice: ");
            String yourchoice = input.next();
            System.out.printf("Your choice is: <%s> \n", yourchoice);
            if (yourchoice.equals("cf")|| yourchoice.equals("fc")) {
                choice = yourchoice;
                break;
            }
            else {
                System.out.printf("Wrong choice '%s', try again!\n", yourchoice);
            }
        }
    }

    private void PrintTable(String choice)
    {
        TableHeader();
        Table();
    }

    private void TableHeader()
    {
        System.out.println("   Temperature Table");
        System.out.println("");
        switch (choice)
        {
            case "fc":
                System.out.println("Changing Fahrenheit (F) to Celsius (C)");
                fromUnit = "°F";
                toUnit = "°C";
                break;

            case "cf":
                System.out.println("Changing Celsius (C) to Fahrenheit (F)");
                fromUnit = "°C";
                toUnit = "°F";
                break;

            default:
                System.out.println("This can't happen!");
                //Assert(false);
                break;
        }
        System.out.println("--------------------------------------");
        System.out.println();
    }

    private void Table()
    {
        for (double temp = 0.0; temp <= 100; temp += 4.0)
        {
            double converted;
            switch (choice)
            {
                case "cf":
                    converted = toF(temp);
                    break;
                default:
                    converted = toC(temp);
                    break;
            }
            System.out.printf("    %.2f %s  = %.2f %s \n",
                    temp, fromUnit, converted, toUnit);
        }
    }

    private double toC(double f)
    {
        return 5.0 / 9.0 * (f - 32.0);
    }

    private double toF (double c)
    {
        return 9.0 / 5.0 * c + 32.0;
    }
}

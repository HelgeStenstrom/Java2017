package helgestenstrom;

import java.util.Scanner;

public class Menu implements Startable {


    Scanner input;
    Menu() {
        input = new Scanner(System.in);
    }

    public void start() {
        cycle();
//        System.out.println("This would start a menu");
//        D1PA d1pa = new D1PA();
//        d1pa.start();
    }

    private static String aline = "--------------------------------------------------\n";

    private String banner()
    {
        String header = "                MAIN MENU                         \n";
        return aline+header+aline;
    }

    private void printBanner()
    {
        System.out.print(banner());
    }

    private void cycle() {
        while (true) {
            printchoices();
            String choice = getChoice();
            if (choice.equals("0"))
                break;
            else
                System.out.printf("You selected %s \n", choice);
                runChoice(choice);
        }
    }

    private String menuItem(String text) {
        return "   " + text;
    }

    private void PC (String text) {
        System.out.println(menuItem(text));
    }

    private void printchoices() {
        printBanner();
        PC("Whole Numbers with For                : 1");
        PC("Floating Point Numbers with While     : 2");
        PC("Currency Converter with Do While loop : 3");
        PC("Work Schedule                         : 4");
        PC("Temperature Table                     : 5");
        PC("Exit the program                      : 0");
        System.out.print(aline);
    }


    private String getChoice()
    {
        System.out.print("Your choice: ");
        return input.nextLine();
    }


    private void runChoice(String choice)
    {
        Startable exercise;
        exercise = new NoExercise();
        switch (choice)
        // objects created here have names that are abbreviations of class names.
        {
            case "0":
                System.out.println("This can't happen!");
                // Can't happen because we will not call the
                // method if choice == 0.
                break;

            case "1":
                exercise = new WholeNumbersForAdd();
                break;

            case "2":
                exercise = new FloatingPointsNumberWhileAdd();
                break;

            case "3":
                exercise = new CurrencyConverter();
                break;

            case "4":
                exercise = new WorkingSchedule();
                break;

            case "5":
                exercise = new TempTable();
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
        exercise.start();
    }
}

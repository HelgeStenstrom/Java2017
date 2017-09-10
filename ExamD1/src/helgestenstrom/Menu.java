package helgestenstrom;

import javax.annotation.processing.SupportedSourceVersion;

public class Menu {
    public void start() {
        System.out.println("This would start a menu");
        D1PA d1pa = new D1PA();
        d1pa.start();
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
        return Console.ReadLine();
    }



}

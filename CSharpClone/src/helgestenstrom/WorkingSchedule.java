package helgestenstrom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingSchedule implements Startable   {

    private Scanner input;

    public void start()
    {
        input = new Scanner(System.in);

        Banner();
        SelectAndRun();
    }

    private void Banner()
    {
        System.out.println("                     YOUR SCHEDULE PROGRAM");
        System.out.println("Select from the menu which type of schedule you want to see.");
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

    private void SelectAndRun()
    {
        while (true)
        // This type of loop allows me to break out of the loop 
        // before the action would take place. I need to have the 
        // test in the middle. At least it seems to be the simplest 
        // solution.
        {
            int choice = GetChoice();
            if (choice == 0) break;
            RunChoice(choice);
        }
    }

    private void PrintChoices()
    {
        System.out.println(" 1 Show a list of the weekends to work");
        System.out.println(" 2 Show a list of the nights to work");
        System.out.println(" 0 Return to main menu");
        System.out.println();
    }

    private int GetChoice()
    {
        PrintChoices();
        System.out.print("Your choice: ");
        return input.nextInt();
    }

    private void RunChoice(int choice)
    {
        System.out.println();
        switch (choice)
        {
            case 1:
                PrintSchedule(1, 3, 52);
                break;

            case 2:
                PrintSchedule(6, 5, 52);
                break;

            default:
                System.out.println("Invalid choice, try again!");
                break;
        }
    }

    private void PrintSchedule(int start, int step, int end)
    {
        System.out.println("Your schedule of the above option is as follows:");
        System.out.println();
        List<Integer> weeks = new ArrayList<>();
        for (int w = start; w <= end; w += step)
        {
            weeks.add(w);
        }

        int col = 1;

        for (Integer week: weeks)
        {
            PrintWeek(week);
            col += 1;
            if (col > 3)
            {
                System.out.println();
                col = 1;
            }
        }
        System.out.println();
        System.out.println("------------------");
        System.out.println();

    }

    private void PrintWeek(int w)
    {
        System.out.printf("           Week %d", w);
    }

}

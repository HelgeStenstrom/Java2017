/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import java.util.Scanner;


public class Account {
    // Banken kan ha flera Account. Varje Account har en ägare (Person)
    // När en nyu Bank() skapas, försöker jag ha pseudo-rimliga värden, som sedan fylls med vettiga värden.

    private String accountNumber;
    private final Person owner;
    private final Scanner input = new Scanner(System.in);

    private double balance;
    public double getBalance() {
        return balance;
    }

    public Account() {
        accountNumber = "(undefined)";
        owner = new Person();
        balance = 0;
    }


    void enterInfo() {
        owner.enterAccountInfo();
        while (true) {
            accountNumber = askAccountNumber();
            balance = askBalance();
            System.out.println();
            System.out.print("Är du nöjd? (j/n) ");
            String answer = input.nextLine();
            if (answer.equals("j"))
                break;
            System.out.println("Försök igen" );
        }
    }

    private String askAccountNumber() {
        System.out.print("Ange kontonummer: ");
        return input.nextLine();
    }

    private double askBalance() {
        return askFloat("Ange ingående balans: ");
    }

    private double askFloat(String prompt) {
        // En funktion som potentiellt är användbar i flera sammanhang där ett flyttal efterfrågas.
        // Dock har jag inte återanvänt funktionen. Det beror mycket på att den inte ligger
        // åtkomlig för andra klasser.
        double answer;
        System.out.print(prompt);
        String str = input.nextLine();
        // parse the string
        try {
            answer = (double) Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
            answer = -999999;
        }
        input.reset();
        return answer;
    }

    void printInfo() {
        System.out.printf("Kontonummer: %s \n", accountNumber);
        owner.printInfo();
        System.out.printf("Saldo:       %.2f \n", balance);
        System.out.println();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    void makeDeposit() {
        System.out.println("Sätt in pengar! ");
        double amount = askAmount();
        deposit(amount);
    }

    void makeWithdrawal() {
        System.out.println("Ta ut pengar! ");
        double amount = askAmount();
        withdraw(amount);
    }

    private double askAmount() {
        System.out.printf("Belopp: ");
        String answer = input.nextLine();
        return (double) Float.parseFloat(answer);
    }
}

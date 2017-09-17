package helgestenstrom;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Scanner;

public class Account {
    private String accountNumber;
    private Person owner;

    public BigDecimal getBalance() {
        return balance;
    }

    private BigDecimal balance;

    private Scanner input = new Scanner(System.in);

    public Account() {
        accountNumber = "(undefined)";
        owner = Person.nullPerson();
        balance = new BigDecimal(0.0);
    }


    void enterInfo() {
        while (true) {
            accountNumber = askAccountNumber();
            owner = Person.getOwner();
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

    private BigDecimal askBalance() {
        return askBigDecimal("Ange ingående balans: ");
    }

    private BigDecimal askBigDecimal(String prompt) {
        BigDecimal answer;
        System.out.print(prompt);
        // BigDecimal answer = input.nextBigDecimal();
        String str = input.nextLine();

        // Code from https://stackoverflow.com/questions/18231802/how-can-i-parse-a-string-to-bigdecimal
        // Create a DecimalFormat that fits your requirements
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        //symbols.setGroupingSeparator('');
        symbols.setDecimalSeparator(',');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        // parse the string
        try {
            answer = (BigDecimal) decimalFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            answer = new BigDecimal(-999999);
        }


        input.reset();
        return answer;
    }

    public void printInfo() {
        System.out.printf("Kontonummer: %s \n", accountNumber);
        owner.printInfo();
        System.out.printf("Saldo:       %.2f \n", balance);
        System.out.println();
    }
}

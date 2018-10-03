package Test;

import java.util.Scanner;

public class TestAtm {

    public static Scanner input = new Scanner(System.in);

    // The checkID method determines if acctNum is a valid account number
    // and pwd is the correct password for the account.  If the account information
    // is valid, the method returns the current account balance, as a string.
    // If the account information is invalid, the method returns the string "error".



    public static String checkID(String acctNum, String pin) {
        String result = "Invalid Account number or PIN";

        // Strings a, b, and c contain the valid account numbers and passwords.
        // For each string, the account number is listed first, followed by
        // a space, followed by the password for the account, followed by a space,
        // followed by the current balance.
        String a = "12345 0000 520.36";
        String b = "67890 1111 48.20";
        String c = "54321 2222 96.74";

        if (acctNum.equals(a.substring(0, a.indexOf(" "))) &&
                pin.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" "))))
            return result = a.substring(a.lastIndexOf(" ") + 1);

        if (acctNum.equals(b.substring(0, b.indexOf(" "))) &&
                pin.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" "))))
            return result = b.substring(b.lastIndexOf(" ") + 1);

        if (acctNum.equals(c.substring(0, c.indexOf(" "))) &&
                pin.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" "))))
            return result = c.substring(c.lastIndexOf(" ") + 1);

        return result;
    }

    public static int menu() {
        int menuChoice;
        do {
            System.out.print("\nPlease Choose From the Following Options:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");

            menuChoice = input.nextInt();

            if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("error");
            }

        } while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }

    public static void displayBalance(double x) {
        System.out.printf("\nYour Current Balance is $%.2f\n", x);
    }

    public static double deposit(double x, double y) {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;

        System.out.printf("Your New Balance is $%.2f\n", newBalance);

        return newBalance;
    }

    public static double withdraw(double x, double y) {
        double withdrawAmt = y, currentBal = x, newBalance;

        newBalance = currentBal - withdrawAmt;
        System.out.printf("Your New Balance is %.2f\n", newBalance);

        return newBalance;

    }
}
import java.util.Scanner;

public class Atm {

    private double amount;


    static Scanner input = new Scanner(System.in);

    static String[] user = {"12345", "98745", "36987"};
    static String[] pin = {"0000", "1111", "2222"};
    static double[] balance = {500.0, 690.0, 789.0};


    private static boolean validatePin(String accountNumber, String pin2) {

        int count = 0;

        do {

            for (int i = 0; i < 3; i++) {
                if ((accountNumber.equals(user[i])) && (pin2.equals(pin[i]))) {
                    System.out.println("Choose the type of service that you want ! 1. deposit 2. withdraw 3. check balance");

                    int number = input.nextInt();
                    if (number == 1) {
                        //double totalBalance = balance[0];
                        deposit(balance[i]);
                        break;
                    } else if (number == 2) {
                        withdraw(balance[i]);
                    } else {
                        checkBalance(balance[i]);
                    }

                }else
                    System.out.println("Invalid Input");

            }


            count++;

        } while (count != 3);
        return false;

    }

    public static void deposit(double balance) {
        System.out.println("Enter the amount you want to deposit");
        double deposit = input.nextDouble();
        balance = balance + deposit;
        System.out.println("Your current balance is:" + balance);

    }

    public static void withdraw(double balance) {
        System.out.println("Enter the amount you want to Withdraw");
        double withdraw = input.nextDouble();

        balance = balance -withdraw;
        System.out.println("Your Remaining balance is:" + balance);


    }

    public static void checkBalance(double balance) {
        System.out.println("Your current balance is:" + balance);
    }

    public static void main(String[] args) {


        Account account1 = new Account();
        int count = 0;

        do {

            System.out.println("Enter the Account number");
            String accNum = input.nextLine();
            account1.setAccountNumber(accNum);
            System.out.println("Enter the PIN number");
            String pin1 = input.nextLine();
            account1.setPin(pin1);
            // validate the pin


            boolean check = validatePin(account1.getAccountNumber(), account1.getPin());

            if (check) {
                System.out.println("Wrong PIN try again!");
                System.out.println("");
                //deposit ()
                //withdraw()
                //checkBalance()
            } else {
                //block the user
            }


        } while (count != 3);


    }


}

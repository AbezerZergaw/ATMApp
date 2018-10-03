package Test;

import static Test.TestAtm.checkID;
import static Test.TestAtm.input;

public class TestMain {
    public static void main(String[] args) {


        TestAtm testObj = new TestAtm();


        String accNum, pass, origBal = "Invalid Account number or PIN";
        int count = 0, menuOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal=0;
        //loop that will count the number of login attempts
        //you make and will exit program if it is more than 3.
        //as long as oriBal equals an error.





        do{
            System.out.println("Please Enter Your Account Number: ");
            accNum = testObj.input.next();

            System.out.println("Enter Your PIN");
            pass = testObj.input.next();

            origBal = checkID(accNum, pass);

            count++;

            if (count >= 3 && origBal.equals("Invalid Account number or PIN")){
                System.out.print("Maximum Login Attempts Reached.");
                System.exit(0);
            }
            if (!(origBal.equals("Invalid Account number or PIN"))){
                System.out.println("\nYour New Balance is: $ "+ origBal);
            }
            else
                System.out.println(origBal);


        }while(origBal.equals("Invalid Account number or PIN"));

        currentBal=Double.parseDouble(origBal);
        //this loop will keep track of the options that
        //the user inputs in for the menu. and will
        //give the option of deposit, withdraw, or logout.

        while (menuOption != 4)
        {
            menuOption=testObj.menu();
            switch (menuOption)
            {
                case 1:
                    testObj.displayBalance(currentBal);
                    break;
                case 2:
                    System.out.print("Enter Amount You Wish to Deposit: $\n");
                    depositAmt = testObj.input.nextDouble();
                    currentBal=testObj.deposit(depositAmt, currentBal);
                    break;
                case 3:
                    System.out.print("Enter Amount You Wish to Withdraw: $\n");
                    withdrawAmt = testObj.input.nextDouble();

                    while(withdrawAmt>currentBal){
                        System.out.print("ERROR: INSUFFICIENT FUNDS!! "
                                + "PLEASE ENTER A DIFFERENT AMOUNT: $");
                        withdrawAmt = testObj.input.nextDouble();
                    }

                    currentBal = testObj.withdraw(currentBal, withdrawAmt);
                    break;
                case 4:
                    System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
                    System.exit(0);
                    break;
            }
        }
    }

}

package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main (String[]args){

        LinkedList IOllist = new LinkedList();
        LinkedList TEllist = new LinkedList();
        LinkedList assetList = new LinkedList();
        LinkedList liabilitiesList = new LinkedList();

        Scanner scanner = new Scanner(System.in);

        // BLOCK: Greeting Message
//        System.out.println("Hello and welcome to Prism - a budgeting software designed for students");
//        System.out.println("-------------------------------------------------------------------------");
//        System.out.println("What is your name?");
//
//        String name = scanner.nextLine();
//        String[] split = name.split(" ");
        System.out.println("When were you born? (Please input in this format: YYYY-MM-DD");
        String birthDate = scanner.nextLine();

//
//        System.out.println("Welcome to your budget " + split[0]);
//        System.out.println("You are about to be a world-class budgeter. To get you there, you’ll find (look up!) six quick getting-started steps at the top of your budget (so handy!). We'll also send bits of budgeting wisdom to b1480898@nwytg.net, so make sure that address is correct.\n" +
//                "\n" +
//                "That's enough chit-chat, are you ready? Of course you are!");
//
//        System.out.println("I'd like to get to know a bit about you first. Please select the monthly expenses that you would like to budget.");

        System.out.println("First, let's go through your assets and liabilities. Please enter your information.\n");

        // BLOCK: ASSETS AND LIABILITIES SECTION
        char ch1;
        do{
            System.out.println("1. Assets");
            System.out.println("2. Liabilities");

            int choice1 = scanner.nextInt();
            switch(choice1){
                case 1:
                    System.out.println("\nAssets\n");
                    System.out.println("Please select all assets you would like to include in your budget. If done, or none, enter -1");
                    System.out.println("1. Chequings");
                    System.out.println("2. Savings");
                    System.out.println("3. High-Interest Savings Account");
                    System.out.println("4. Guaranteed Investments Certificate");
                    System.out.println("5. Tax-Free Savings Account");
                    System.out.println("6. Registered Retirement Savings Plan");

                    do {
                        int assetChoice = scanner.nextInt();
                        if (assetChoice == -1) {
                            break;
                        } else {
                            assetList.add(assetChoice);
                        }
                    }while (true);
                    break;

                case 2:
                    System.out.println("\nLiabilities\n");
                    System.out.println("Please select all liabilities you would like to include in your budget. If done, or none, enter -1");
                    System.out.println("1. Student Loans");
                    System.out.println("2. Student Line of Credit");

                    do {
                        int liabilitiesChoice = scanner.nextInt();
                        if (liabilitiesChoice == -1) {
                            break;
                        } else {
                            liabilitiesList.add(liabilitiesChoice);
                        }
                    }while (true);
                    break;
            }

            System.out.println("\nReturn to menu? (Type y or n) \n");
            ch1 = scanner.next().charAt(0);
        }while(ch1 == 'Y'|| ch1 == 'y');


        // BLOCK: BUDGETING SECTION
        char ch2;
        do{
            System.out.println("\n--Budget Categories-- \n");
            System.out.println("1. Immediate Obligations");
            System.out.println("2. True Expenses");
            System.out.println("3. Debt Payments");
            System.out.println("4. Quality of Life Goals");
            System.out.println("5. Just for Fun");

            int choice2 = scanner.nextInt();
            switch(choice2){
                case 1:
                    System.out.println("\nImmediate Obligations \n");
                    System.out.println("Please select all immediate obligations you'd like to include. If done, or none, enter -1.");
                    System.out.println("1. Rent/Mortgage");
                    System.out.println("2. Electric");
                    System.out.println("3. Water");
                    System.out.println("4. Internet");
                    System.out.println("5. Groceries");
                    System.out.println("6. Transportation");
                    System.out.println("7. Interest & Fees");

                    do{
                        int IOChoice = scanner.nextInt();
                        if(IOChoice == -1){
                            break;
                        }else{
                            IOllist.add(IOChoice);
                        }
                    }while(true);
                    break;

                case 2:
                    System.out.println("\nTrue Expenses \n");
                    System.out.println("Please select all true expenses you'd like to include. If done, or none, enter -1.");
                    System.out.println("1. Auto Maintenance");
                    System.out.println("2. Home Maintenance");
                    System.out.println("3. Renter's/Home Insurance");
                    System.out.println("4. Medical");
                    System.out.println("5. Clothing");
                    System.out.println("6. Gifts");
                    System.out.println("7. Computer Replacement");
                    System.out.println("8. Software Subscriptions");
                    System.out.println("9. Stuff I Forgot to Budget For");

                    do{
                        int TEChoice = scanner.nextInt();
                        if(TEChoice == -1){
                            break;
                        }else{
                            TEllist.add(TEChoice);
                        }
                    }while(true);
                    break;
            }

            System.out.println("\nReturn to menu? (Type y or n) \n");
            ch2 = scanner.next().charAt(0);
        }while (ch2 == 'Y'|| ch2 == 'y');


        // ----------------------TESTS--------------------------------R----
        // test if IOBudget.java is working
        double IOtotal = IOBudget.budgeting(IOllist);

        // test if TEBudget.java is working
        double TEtotal = TEBudget.budgeting(TEllist);

        IOBudget.displayIOBudget();
        TEBudget.displayTEBudget();

        double budgetTotal = IOtotal + TEtotal;
        System.out.println("\nIn total, you've budgeted for this month:  $" + budgetTotal);

        // test if llinkedlists are working
//        System.out.println(IOllist);
//        System.out.println(TEllist);


    }
}
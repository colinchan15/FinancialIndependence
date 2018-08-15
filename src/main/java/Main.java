package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main (String[]args){
        IOBudget IOBudget = new IOBudget();
        LinkedList IOllist = new LinkedList();
        LinkedList TEllist = new LinkedList();

        Scanner scanner = new Scanner(System.in);

        // Greeting Message
//        System.out.println("Hello and welcome to Prism - a budgeting software designed for students");
//        System.out.println("-------------------------------------------------------------------------");
//        System.out.println("What is your name?");
//
//        String name = scanner.nextLine();
//        String[] split = name.split(" ");
//
//        System.out.println("Welcome to your budget " + split[0]);
//        System.out.println("You are about to be a world-class budgeter. To get you there, you’ll find (look up!) six quick getting-started steps at the top of your budget (so handy!). We'll also send bits of budgeting wisdom to b1480898@nwytg.net, so make sure that address is correct.\n" +
//                "\n" +
//                "That's enough chit-chat, are you ready? Of course you are!");
//
//        System.out.println("I'd like to get to know a bit about you first. Please select the monthly expenses that you would like to budget.");

        char ch;
        do{
            System.out.println("\n--Budget Categories-- \n");
            System.out.println("1. Immediate Obligations");
            System.out.println("2. True Expenses");
            System.out.println("3. Debt Payments");
            System.out.println("4. Quality of Life Goals");
            System.out.println("5. Just for Fun");

            int choice = scanner.nextInt();
            switch(choice){
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
                    System.out.println("7. Giving");
                    System.out.println("4. Computer Replacement");
                    System.out.println("5. Software Subscriptions");
                    System.out.println("6. Stuff I Forgot to Budget For");

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
            ch = scanner.next().charAt(0);
        }while (ch == 'Y'|| ch == 'y');

        // test if IOBudget.java is working
        double IOtotal = IOBudget.budgeting(IOllist);

        // test if llinkedlists are working
        System.out.println(IOllist);
        System.out.println(TEllist);


    }
}
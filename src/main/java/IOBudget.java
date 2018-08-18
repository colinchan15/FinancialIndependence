package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class IOBudget {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmIO = new HashMap();

    public static void main(String[] args) {
        IOBudget ioBudget = new IOBudget();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        ioBudget.budgeting(linkedList);

        ioBudget.displayIOBudget();
    }

    public static double budgeting(LinkedList<Integer> linkedList) {
        double IOTotal = 0;
        System.out.println("\nImmediate Obligations budget inputting section");
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("Rent/Mortgage to be budgeted: ");
                    Double rentMortgage = scanner.nextDouble();
                    hmIO.put("Rent and Mortgage", rentMortgage);
                    IOTotal += rentMortgage;
                    break;
                case 2:
                    System.out.println("Electric costs to be budgeted: ");
                    Double electric = scanner.nextDouble();
                    hmIO.put("Electric", electric);
                    IOTotal += electric;
                    break;
                case 3:
                    System.out.println("Water costs to be budgeted: ");
                    Double water = scanner.nextDouble();
                    hmIO.put("Water", water);
                    IOTotal += water;
                    break;
                case 4:
                    System.out.println("Internet costs to be budgeted: ");
                    Double internet = scanner.nextDouble();
                    hmIO.put("Internet", internet);
                    IOTotal += internet;
                    break;
                case 5:
                    System.out.println("Grocery costs to be budgeted: ");
                    Double groceries = scanner.nextDouble();
                    hmIO.put("Groceries", groceries);
                    IOTotal += groceries;
                    break;
                case 6:
                    System.out.println("Transportation costs to be budgeted: ");
                    Double transportation = scanner.nextDouble();
                    hmIO.put("Transportation", transportation);
                    IOTotal += transportation;
                    break;
                case 7:
                    System.out.println("Interest and fees to be budgeted: ");
                    double interestFees = scanner.nextDouble();
                    hmIO.put("Interest Fees", interestFees);
                    IOTotal += interestFees;
                    break;
            }
        }
        return(IOTotal);
    }

    public static void displayIOBudget(){
        System.out.println("\n----------Immediate Obligations budgeted items---------- ");
        for (HashMap.Entry <String, Double> entry : hmIO.entrySet()){
            System.out.println(entry.getKey() + ":  $" + entry.getValue());
        }
    }

    public HashMap<String, Double> getIOHashMap (){
        return hmIO;
    }

}


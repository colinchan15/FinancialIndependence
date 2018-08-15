package main.java;

import java.util.LinkedList;
import java.util.Scanner;


public class IOBudget {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IOBudget ioBudget = new IOBudget();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        ioBudget.budgeting(linkedList);
    }

    public void budgeting(LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("Rent/Mortgage to be budgeted: ");
                    Double rentMortgage = scanner.nextDouble();
                    System.out.println(rentMortgage);
                    break;
                case 2:
                    System.out.println("Electric costs to be budgeted: ");
                    Double electric = scanner.nextDouble();
                    System.out.println(electric);
                    break;
                case 3:
                    System.out.println("Water costs to be budgeted: ");
                    Double water = scanner.nextDouble();
                    System.out.println(water);
                    break;
                case 4:
                    System.out.println("Internet costs to be budgeted: ");
                    Double internet = scanner.nextDouble();
                    System.out.println(internet);
                    break;
                case 5:
                    System.out.println("Grocery costs to be budgeted: ");
                    Double groceries = scanner.nextDouble();
                    System.out.println(groceries);
                    break;
                case 6:
                    System.out.println("Transportation costs to be budgeted: ");
                    Double transportation = scanner.nextDouble();
                    System.out.println(transportation);
                    break;
                case 7:
                    System.out.println("Interest and fees to be budgeted: ");
                    double interestFees = scanner.nextDouble();
                    System.out.println(interestFees);
                    break;
            }
        }
    }
}


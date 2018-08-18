package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class TEBudget {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hm2 = new HashMap();

    public static void main(String[] args) {
        TEBudget teBudget = new TEBudget();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        teBudget.budgeting(linkedList);

        // need to fix this
        teBudget.displayTEBudget();
    }

    public static double budgeting(LinkedList<Integer> linkedList) {
        double TETotal = 0;
        System.out.println("\nTrue Expenses budget inputting section");
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("Auto Maintenance costs to be budgeted: ");
                    Double autoMaintenance = scanner.nextDouble();
                    hm2.put("Auto Maintenance", autoMaintenance);
                    TETotal += autoMaintenance;
                    break;
                case 2:
                    System.out.println("Home Maintenance costs to be budgeted: ");
                    Double homeMaintenance = scanner.nextDouble();
                    hm2.put("Home Maintenance", homeMaintenance);
                    TETotal += homeMaintenance;
                    break;
                case 3:
                    System.out.println("Renter's/Home Insurance costs to be budgeted: ");
                    Double rentHomeIns = scanner.nextDouble();
                    hm2.put("Renter's/Home Insurance", rentHomeIns);
                    TETotal += rentHomeIns;
                    break;
                case 4:
                    System.out.println("Medical costs to be budgeted: ");
                    Double medical = scanner.nextDouble();
                    hm2.put("Medical", medical);
                    TETotal += medical;
                    break;
                case 5:
                    System.out.println("Clothing costs to be budgeted: ");
                    Double clothing = scanner.nextDouble();
                    hm2.put("Clothing", clothing);
                    TETotal += clothing;
                    break;
                case 6:
                    System.out.println("Gift costs to be budgeted: ");
                    Double gift = scanner.nextDouble();
                    hm2.put("Gifts", gift);
                    TETotal += gift;
                    break;
                case 7:
                    System.out.println("Computer Replacement costs to be budgeted: ");
                    Double compRepla = scanner.nextDouble();
                    hm2.put("Computer Replacement", compRepla);
                    TETotal += compRepla;
                    break;
                case 8:
                    System.out.println("Software Subscription costs to be budgeted: ");
                    Double softwareSub = scanner.nextDouble();
                    hm2.put("Software Subscription", softwareSub);
                    TETotal += softwareSub;
                    break;
                case 9:
                    System.out.println("Stuff I forgot to budget for... costs to be budgeted: ");
                    Double stuff = scanner.nextDouble();
                    hm2.put("Stuff I forgot to budget for", stuff);
                    TETotal += stuff;
                    break;
            }
        }
        return(TETotal);
    }

    public static void displayTEBudget(){
        System.out.println("\n----------True Expenses budgeted items----------");
        for (HashMap.Entry <String, Double> entry : hm2.entrySet()){
            System.out.println(entry.getKey() + ":  $" + entry.getValue());
        }
    }

    public HashMap<String, Double> getIOHashMap (){
        return hm2;
    }

}


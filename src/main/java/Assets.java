package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Assets {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmAssets = new HashMap();

    public static void main(String[] args) {
        IOBudget ioBudget = new IOBudget();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        ioBudget.budgeting(linkedList);

        ioBudget.displayIOBudget();
    }

    public static double assets(LinkedList<Integer> linkedList) {
        double assetsTotal = 0;
        System.out.println("\nAssets inflow and outflow inputting section");
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("How many chequing accounts do you have? ");
                    int chequingAccTotal = scanner.nextInt();
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    String chequingArray [] = new String [chequingAccTotal];
                    for(int j = 0; j < chequingAccTotal; j++){
                        String chequingInput = scanner.next();
                        String chequingInpNoSpace = chequingInput.replaceAll("\\s","");
                        
                        //
                    }

                    // may not need this block but just saving it for convenience for now
//                    Double rentMortgage = scanner.nextDouble();
//                    hm1.put("Rent and Mortgage", rentMortgage);
//                    assetsTotal += rentMortgage;
//                    break;

            }
        }
        return(assetsTotal);
    }

    public static void displayIOBudget(){
        System.out.println("\n----------Immediate Obligations budgeted items---------- ");
        for (HashMap.Entry <String, Double> entry : hmAssets.entrySet()){
            System.out.println(entry.getKey() + ":  $" + entry.getValue());
        }
    }

    public HashMap<String, Double> getIOHashMap (){
        return hmAssets;
    }

}


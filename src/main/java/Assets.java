package main.java;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Double.*;

//@SuppressWarnings("Duplicates")
public class Assets {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmAssets = new HashMap();

    public static void main(String[] args) {
        Assets assets = new Assets();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(assets.assets(linkedList));
        assets.displayAssets();

    }

    public static double assets(LinkedList<Integer> linkedList) {
        Assets assets = new Assets();
        double assetsTotal = 0;
        System.out.println("\nAssets inflow and outflow inputting section");
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("How many chequing accounts do you have?");
                    int chequingAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    Double chequingTotal = 0.0;
                    Double chequingBalance = assets.setHmAssets(chequingAccNum, hmAssets, chequingTotal);
                    assetsTotal += chequingBalance;
                    break;
                case 2:
                    System.out.println("How many savings accounts do you have?");
                    int savingsAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    double savingsTotal = 0.0;
                    Double savingsBalance = assets.setHmAssets(savingsAccNum, hmAssets, savingsTotal);
                    assetsTotal += savingsBalance;
                    break;
                case 3:
                    System.out.println("");
            }
        }
        return assetsTotal;
    }

    public static void displayAssets(){
        System.out.println("\n----------Total Assets---------- ");
        for (HashMap.Entry <String, Double> entry : hmAssets.entrySet()){
            System.out.println(entry.getKey() + ":  $" + entry.getValue());
        }
    }

    public HashMap<String, Double> getHmAssets (){
        return hmAssets;
    }

    public static double setHmAssets(int numOfAccounts, HashMap<String, Double> hmAssets, Double assetsTotal) {
        for(int i = 0; i < numOfAccounts; i++){
            String assetsInput = scanner.nextLine();
            String [] assetsSplit = assetsInput.replaceAll("\\s","").split(",");
            String assetsAccName = assetsSplit[0];
            Double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
            hmAssets.put(assetsAccName,assetsAccBalance);
            assetsTotal += assetsAccBalance;
        }
        return assetsTotal;
    }
}


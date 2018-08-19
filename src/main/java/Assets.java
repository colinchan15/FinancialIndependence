package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//@SuppressWarnings("Duplicates")
public class Assets {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmAssets = new HashMap();
    private static HashMap <String, Double> hmInterest = new HashMap();

    public static void main(String[] args) {
        Assets assets = new Assets();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(assets.assets(linkedList));
        assets.displayAssets();
        assets.displayInterests();

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
                    Double chequingBalance = assets.setHmAssets(false, chequingAccNum, hmAssets, hmInterest, chequingTotal);
                    assetsTotal += chequingBalance;
                    break;
                case 2:
                    System.out.println("How many savings accounts do you have?");
                    int savingsAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    double savingsTotal = 0.0;
                    Double savingsBalance = assets.setHmAssets(true, savingsAccNum, hmAssets, hmInterest, savingsTotal);
                    assetsTotal += savingsBalance;
                    break;
                case 3:
                    System.out.println("How many high-interest savings accounts do you have?");
                    int HISavingsAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, and its interest rate separated by a comma");
                    double HISavingsTotal = 0.0;
                    Double HISavingsBalance = assets.setHmAssets(true, HISavingsAccNum, hmAssets, hmInterest, HISavingsTotal);
                    assetsTotal += HISavingsBalance;
                    break;
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

    public static void displayInterests(){
        System.out.println();
        for(HashMap.Entry <String, Double> entry : hmInterest.entrySet()){
            System.out.println(entry.getKey() + ": %" + entry.getValue());
        }
    }

    public HashMap<String, Double> getHmAssets (){
        return hmAssets;
    }

    public static double setHmAssets(boolean notChequing, int numOfAccounts, HashMap<String, Double> hmAssets, HashMap <String, Double> hmInterests, Double assetsTotal) {
        for (int i = 0; i < numOfAccounts; i++) {
            String assetsInput = scanner.nextLine();
            String[] assetsSplit = assetsInput.replaceAll("\\s", "").split(",");
            String assetsAccName = assetsSplit[0];
            Double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
            Double assetsAccInterest = 0.0;
            if (notChequing == true) {
                assetsAccInterest = Double.parseDouble(assetsSplit[2]);
            }
//            } else if (!notChequing) {
//                assetsAccInterest = 0.0;
//            }
            hmAssets.put(assetsAccName, assetsAccBalance);
            hmInterests.put(assetsAccName, assetsAccInterest);
            assetsTotal += assetsAccBalance;
        }
        return assetsTotal;
    }
}


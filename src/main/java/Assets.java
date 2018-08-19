package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//@SuppressWarnings("Duplicates")
public class Assets {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmAssets = new HashMap();
    private static HashMap <String, Double> hmInterest = new HashMap();
    private static HashMap <String, Double> hmFixedTerm = new HashMap();

    public static void main(String[] args) {
        Assets assets = new Assets();
        LinkedList linkedList = new LinkedList();
        AgeCalculator ageCalculator = new AgeCalculator();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        System.out.println(assets.assets(linkedList));
//        assets.displayAssets();
//        assets.displayInterests();
//        assets.displayFixedTermLength();
        String currentDate = "2018-08-19";
        String birthDate = "1996-05-06";
        System.out.println(ageCalculator.ageCalculator(birthDate,currentDate));

    }

    public static double assets(LinkedList<Integer> linkedList, String birthDate) {
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
                    Double chequingBalance = assets.setHmAssets(false, false, "- Chequing Account", chequingAccNum, hmAssets, hmInterest, hmFixedTerm, chequingTotal);
                    assetsTotal += chequingBalance;
                    break;
                case 2:
                    System.out.println("How many savings accounts do you have?");
                    int savingsAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    double savingsTotal = 0.0;
                    Double savingsBalance = assets.setHmAssets(true, false, "- Savings Account", savingsAccNum, hmAssets, hmInterest, hmFixedTerm, savingsTotal);
                    assetsTotal += savingsBalance;
                    break;
                case 3:
                    System.out.println("How many high-interest savings accounts do you have?");
                    int HISavingsAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, and its interest rate separated by a comma");
                    double HISavingsTotal = 0.0;
                    Double HISavingsBalance = assets.setHmAssets(true, false, "- High-Interest Savings Account", HISavingsAccNum, hmAssets, hmInterest, hmFixedTerm, HISavingsTotal);
                    assetsTotal += HISavingsBalance;
                    break;
                case 4:
                    System.out.println("How many Guaranteed Investment Certificates (GICs) have you invested in?");
                    int GICAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, its interest rate, and length of fixed term (in years) separated by a comma");
                    double GICTotal = 0.0;
                    Double GICBalance = assets.setHmAssets(true, true, "- GIC Investment", GICAccNum, hmAssets, hmInterest, hmFixedTerm, GICTotal);
                    assetsTotal += GICBalance;
                    break;
                case 5:
                    System.out.println("How many Tax-Free Savings Accounts have you invested in?");
                    int TFSAAccNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, its interest rate, amount you've invested this year, and amount you've withdrawn this year");
                    double TFSATotal = 0.0;
                    Double TFSABalance = assets.setHmAssets(true, true, "- TFSA Investment", TFSAAccNum, hmAssets, hmInterest, hmFixedTerm, TFSATotal);
                    assetsTotal += TFSABalance;
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
        System.out.println("\n----------Interest Rates---------- ");
        System.out.println();
        for(HashMap.Entry <String, Double> entry : hmInterest.entrySet()){
            System.out.println(entry.getKey() + ": %" + entry.getValue());
        }
    }

    public static void displayFixedTermLength(){
        System.out.println("\n----------Fixed Term Lengths---------- ");
        System.out.println();
        for(HashMap.Entry <String, Double> entry : hmFixedTerm.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " years");
        }
    }

    public HashMap<String, Double> getHmAssets (){
        return hmAssets;
    }

    public static double setHmAssets(boolean notChequing, boolean fixedTerm, String accountType, int numOfAccounts, HashMap<String, Double> hmAssets, HashMap <String, Double> hmInterests, HashMap <String, Double> hmFixedTerm, Double assetsTotal) {
        for (int i = 0; i < numOfAccounts; i++) {
            String assetsInput = scanner.nextLine();
            String[] assetsSplit = assetsInput.replaceAll("\\s", "").split(",");
            String assetsAccName = assetsSplit[0] + " " + accountType;
            Double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
            Double assetsAccInterest = 0.0;
            Double assetsFixedTermLength = 0.0;
            if (notChequing == true) {
                assetsAccInterest = Double.parseDouble(assetsSplit[2]);
            }
            if (fixedTerm == true){
                assetsFixedTermLength = Double.parseDouble(assetsSplit[3]);
            }

            hmAssets.put(assetsAccName, assetsAccBalance);
            hmInterests.put(assetsAccName, assetsAccInterest);
            hmFixedTerm.put(assetsAccName, assetsFixedTermLength);
            assetsTotal += assetsAccBalance;
        }
        return assetsTotal;
    }
}


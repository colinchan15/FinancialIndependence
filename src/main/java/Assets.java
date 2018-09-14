package main.java;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

//@SuppressWarnings("Duplicates")
public class Assets {

    private static Scanner scanner = new Scanner(System.in);
    private static HashMap <String, Double> hmAssets = new HashMap();
    private static HashMap <String, Double> hmInterest = new HashMap();
    private static HashMap <String, Double> hmFixedTerm = new HashMap();
    private static HashMap <String, Double> hmRoR = new HashMap();
    private static Double TFSADepositedCurr;
    private static Double TFSAWithdrawnCurr;
    private static Double TFSAAvailableContributionRoomCurr;
    private static Double TFSAAvailableContributionRoomNext;

    public static void main(String[] args) {
//        main.java.Assets assets = new main.java.Assets();
        Assets assets = new Assets();
        LinkedList linkedList = new LinkedList();
        AgeCalculator ageCalculator = new AgeCalculator();

//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
        linkedList.add(6);

        System.out.println("What is your birth date?");
        String birthDate = scanner.nextLine();
        int clientAge = ageCalculator.getAge(birthDate);
        System.out.println(assets.assets(linkedList, clientAge));
//        System.out.println(TFSAAvailableContributionRoomCurr);
//        System.out.println(TFSAAvailableContributionRoomNext);

        assets.displayAssets();
        assets.displayInterests();
        assets.displayFixedTermLength();
        assets.displayRoR();

    }

    // Main function for returning $total assets
    public static double assets(LinkedList<Integer> linkedList, int clientAge) {
        main.java.MainUIMod MUIM= new main.java.MainUIMod();
        main.java.Assets assets = new main.java.Assets();
        double assetsTotal = 0;
        System.out.println("\nAssets inflow and outflow inputting section");
        System.out.println();
        for (int i = 0; i < linkedList.size(); i++) {
            switch (linkedList.get(i)) {
                case 1:
                    System.out.println("How many chequing accounts do you have?");
                    int chequingAccNum = MUIM.chequingsAssets;
                    System.out.println("Please enter the name of the account and its current balance separated by a comma");
                    double chequingTotal = 0.0;
                    double chequingBalance = assets.setChequing(chequingAccNum,chequingTotal);
                    assetsTotal += chequingBalance;
                    break;
                case 2:
                    System.out.println("How many savings accounts do you have?");
                    int savingsAccNum = nonNegativeInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, and its interest rate separated by a comma");
                    double savingsTotal = 0.0;
                    double savingsBalance = assets.setSavings(savingsAccNum, savingsTotal, false);
                    assetsTotal += savingsBalance;
                    break;
                case 3:
                    System.out.println("How many high-interest savings accounts do you have?");
                    int HISavingsAccNum = nonNegativeInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, and its interest rate separated by a comma");
                    double HISavingsTotal = 0.0;
                    double HISavingsBalance = assets.setSavings(HISavingsAccNum, HISavingsTotal, true);
                    assetsTotal += HISavingsBalance;
                    break;
                case 4:
                    System.out.println("How many Guaranteed Investment Certificates (GICs) have you invested in?");
                    int GICAccNum = nonNegativeInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name of the account, its current balance, its interest rate, and length of fixed term (in years) separated by a comma");
                    double GICTotal = 0.0;
                    double GICBalance = assets.setGIC(GICAccNum, GICTotal);
                    assetsTotal += GICBalance;
                    break;
                case 5:
                    AgeCalculator ageCalculator = new AgeCalculator();
                    TFSAAnnualLimitHM tfsaLimitTable = new TFSAAnnualLimitHM();
                    System.out.println("Please enter the name of the account, its current balance, its interest rate, amount you've invested this year, amount you've withdrawn this year, and the expected annual rate of return separated by a comma");
                    System.out.println("|Name of account | $ current balance | % interest rate | $ invested this year | $ withdrawn this year | % annual rate of return|");
                    double TFSATotal = 0.0;
                    double TFSABalance = assets.setTFSA(TFSATotal);
                    tfsaLimitTable.setTFSAALHM();
                    String yearEighteen = Integer.toString(ageCalculator.yearEighteen(clientAge));
                    double TFSACumulativeLimit = tfsaLimitTable.getTFSAValue(yearEighteen, "Cumulative");
                    TFSAAvailableContributionRoomCurr = TFSACumulativeLimit - TFSABalance;
                    TFSAAvailableContributionRoomNext = TFSAAvailableContributionRoomCurr + tfsaLimitTable.getTFSAValue(yearEighteen, "Annual") + TFSAWithdrawnCurr;
                    assetsTotal += TFSABalance;
                    break;
                case 6:
                    System.out.println("Please enter the name of the account, its current balance, and the expected annual rate of return separated by a comma");
                    double RRSPTotal = 0.0;
                    double RRSPBalance = assets.setRRSP(RRSPTotal);
                    assetsTotal += RRSPBalance;
                    break;
            }
        }
        return assetsTotal;
    }

    // functions for displaying hash maps storing the asset information
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

    public static void displayRoR(){
        System.out.println("\n----------Rate of Returns---------- ");
        System.out.println();
        for(HashMap.Entry <String, Double> entry : hmRoR.entrySet()){
            System.out.println(entry.getKey() + ": %" + entry.getValue());
        }
    }

    public HashMap<String, Double> getHmAssets (){
        return hmAssets;
    }

    public static Double setChequing(int numOfAccounts, Double assetsTotal){
        Chequing setChequing;
        for(int i = 0; i < numOfAccounts; i++){
            boolean executed = false;
            do {
                try {
//                    String assetsInput = scanner.nextLine();
//                    String[] assetsSplit = assetsInput.replaceAll("\\s", "").replaceAll("\\$", "").replaceAll("\\%", "").split(",");
//                    String assetsAccName = assetsSplit[0] + " " + "- Chequing Account";
//                    double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
//                    setChequing = new Chequing(assetsAccName, assetsAccBalance);
//                    hmAssets.put(setChequing.getAccName(), setChequing.getCurrentBalance());
//                    assetsTotal += assetsAccBalance;
//                    executed = true;


                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You did not enter all the information correct, or you are missing some information. Please try again");
                } catch (NumberFormatException e){
                    System.out.println("There is an incorrect value in your entry. Please try again.");
                }
            } while (executed == false);
        }
        return assetsTotal;
    }

    // set savings, chequing, high-interest saving, GIC, TFSA, and RRSP info to respective hashmaps
    public static Double setSavings(int numOfAccounts, Double assetsTotal, boolean HISavings){
        Savings setSavings;
        for(int i = 0; i < numOfAccounts; i++){
            boolean executed = false;
            do {
                try {
                    String assetsInput = scanner.nextLine();
                    String[] assetsSplit = assetsInput.replaceAll("\\s", "").replaceAll("\\$", "").replaceAll("\\%", "").split(",");
                    if (HISavings == false) {
                        String assetsAccName = assetsSplit[0] + " " + "- Savings Account";
                        Double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
                        Double assetsInterest = Double.parseDouble(assetsSplit[2]);
                        setSavings = new Savings(assetsAccName, assetsAccBalance, assetsInterest);
                        hmAssets.put(setSavings.getAccName(), setSavings.getCurrentBalance());
                        hmInterest.put(setSavings.getAccName(), setSavings.getInterest());
                        assetsTotal += assetsAccBalance;
                        executed = true;
                    } else {
                        String assetsAccName = assetsSplit[0] + " " + "- High-Interest Savings Account";
                        Double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
                        Double assetsInterest = Double.parseDouble(assetsSplit[2]);
                        setSavings = new Savings(assetsAccName, assetsAccBalance, assetsInterest);
                        hmAssets.put(setSavings.getAccName(), setSavings.getCurrentBalance());
                        hmInterest.put(setSavings.getAccName(), setSavings.getInterest());
                        assetsTotal += assetsAccBalance;
                        executed = true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You did not enter all the information correct, or you are missing some information. Please try again");
                } catch (NumberFormatException e){
                    System.out.println("There is an incorrect value in your entry. Please try again.");
                }
            }while (executed == false);
        }
        return assetsTotal;
    }

    public static Double setGIC(int numOfAccounts, Double assetsTotal){
        GIC gic;
        for(int i = 0; i < numOfAccounts; i++){
            boolean executed = false;
            do {
                try {
                    String assetsInput = scanner.nextLine();
                    String[] assetsSplit = assetsInput.replaceAll("\\s", "").replaceAll("\\$", "").replaceAll("\\%", "").split(",");
                    String assetsAccName = assetsSplit[0] + " " + "- GIC Account";
                    double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
                    double assetsInterest = Double.parseDouble(assetsSplit[2]);
                    double assetsFixedTermLength = Double.parseDouble(assetsSplit[3]);
                    gic = new GIC(assetsAccName, assetsAccBalance, assetsInterest, assetsFixedTermLength);
                    hmAssets.put(gic.getAccName(), gic.getCurrentBalance());
                    hmInterest.put(gic.getAccName(), gic.getInterest());
                    hmFixedTerm.put(gic.getAccName(), gic.getFixedTermLength());
                    assetsTotal += assetsAccBalance;
                    executed = true;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You did not enter all the information correct, or you are missing some information. Please try again");
                } catch (NumberFormatException e){
                    System.out.println("There is an incorrect value in your entry. Please try again.");
                }
            }while (executed == false);
        }
        return assetsTotal;
    }

    // finish up the tfsa function and case Aug 20
    public static Double setTFSA(Double assetsTotal ){
        boolean executed = false;
        do {
            try {
                TFSA tfsa;
                String assetsInput = scanner.nextLine();
                String[] assetsSplit = assetsInput.replaceAll("\\s", "").replaceAll("\\$", "").replaceAll("\\%", "").split(",");
                String assetsAccName = assetsSplit[0] + " " + "- TFSA Account";
                double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
                double assetsInterest = Double.parseDouble(assetsSplit[2]);
                double TFSAAmtDeposited = Double.parseDouble(assetsSplit[3]);
                double TFSAAmtWithdrawn = Double.parseDouble(assetsSplit[4]);
                double TFSAROR = Double.parseDouble(assetsSplit[5]);
                tfsa = new TFSA(assetsAccName, assetsAccBalance, assetsInterest, TFSAAmtDeposited, TFSAAmtWithdrawn, TFSAROR);
                hmAssets.put(tfsa.getAccName(), tfsa.getCurrentBalance());
                hmInterest.put(tfsa.getAccName(), tfsa.getInterest());
                hmRoR.put(tfsa.getAccName(), tfsa.getTFSAROR());
                TFSADepositedCurr = TFSAAmtDeposited;
                TFSAWithdrawnCurr = TFSAAmtWithdrawn;
                assetsTotal += assetsAccBalance;
                executed = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You did not enter all the information correct, or you are missing some information. Please try again");
            } catch (NumberFormatException e){
                System.out.println("There is an incorrect value in your entry. Please try again.");
            }
        } while (executed == false);
        return assetsTotal;
    }

    public static Double setRRSP(Double assetsTotal){
        boolean executed = false;
        do {
            try {
                RRSP rrsp;
                String assetsInput = scanner.nextLine();
                String[] assetsSplit = assetsInput.replaceAll("\\s", "").replaceAll("\\$", "").replaceAll("\\%", "").split(",");
                String assetsAccName = assetsSplit[0] + " " + "- RRSP Account";
                double assetsAccBalance = Double.parseDouble(assetsSplit[1]);
                double RRSPROR = Double.parseDouble(assetsSplit[2]);
                rrsp = new RRSP(assetsAccName, assetsAccBalance, RRSPROR);
                hmAssets.put(rrsp.getAccName(), rrsp.getCurrentBalance());
                hmRoR.put(rrsp.getAccName(), rrsp.RRSPROR);
                assetsTotal += assetsAccBalance;
                executed = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You did not enter all the information correct, or you are missing some information. Please try again");
            } catch (NumberFormatException e){
                System.out.println("There is an incorrect value in your entry. Please try again.");
            }
        } while (executed == false);
        return assetsTotal;
    }

    private static int nonNegativeInt(){
        boolean properValue = false;
        int variable = 0;
        do {
            try {
                while (true) {
                    variable = scanner.nextInt();
                    if (variable < 0) {
                        System.out.println("Please enter a positive value");
                    } else if (variable >= 0) {
                        break;
                    }
                }
                properValue = true;
            } catch (InputMismatchException e){
                System.out.println("That is not a valid value.");
                scanner.next();
            }
        } while (properValue == false);
        return variable;
    }

    private static double nonNegativeDouble(){
        boolean properValue = false;
        double variable = 0;
        do {
            try {
                while (true) {
                    variable = scanner.nextDouble();
                    if (variable < 0) {
                        System.out.println("Please enter a positive value");
                    } else if (variable >= 0) {
                        break;
                    }
                }
                properValue = true;
            } catch (InputMismatchException e){
                System.out.println("That is not a valid value");
                scanner.next();
            }
        } while (properValue == false);
        return variable;
    }

}
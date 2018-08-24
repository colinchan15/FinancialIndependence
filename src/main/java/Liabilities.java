package main.java;

import java.util.LinkedList;
import java.util.Scanner;

public class Liabilities {

    private static Scanner scanner = new Scanner(System.in);
    private static Double OSAPFunding;
    private static Double OSAPLoans;
    private static Double OSAPGrants;
    private static Double OSAPFederalLoans;
    private static Double OSAPProvincialLoans;
    private static Double OSAPCalculatedMonthlyInterest;
    private static Double LOCBalance;
    private static Double LOCInterest;
    private static Double primeRate;

    public static void main (String[]args){
        Liabilities lb = new Liabilities();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
//        linkedList.add(2);
        System.out.println(lb.liabilities(linkedList));
    }

    public static double liabilities(LinkedList<Integer> linkedList){
        Liabilities liabilities = new Liabilities();
        double liabilitiesTotal = 0;
        System.out.println("\nLiabilities inputting section\n");
        for(int i = 0; i < linkedList.size(); i++){
            switch(linkedList.get(i)){
                case 1:
                    System.out.println("To date, how much funding have you received from OSAP?");
                    double OSAPFundVar = scanner.nextDouble();
                    System.out.println("How much of this funding was made up of grants, bursaries and other assets?");
                    double OSAPGrantVar = scanner.nextDouble();
                    System.out.println("Are you applying for the six month grace period? (Type y or n)");
                    String sixMonthGracePeriod = scanner.next();
                    double OSAPBalanceFun = liabilities.setOSAP(OSAPFundVar, OSAPGrantVar, liabilities.sixMonthGracePeriodChoice(sixMonthGracePeriod));
                    System.out.println("What is the prime rate set by the Bank of Canada?");
                    liabilities.setPrimeRate(scanner.nextDouble());

                    OSAPFederalLoans = OSAPBalanceFun*0.7;
                    OSAPProvincialLoans = OSAPBalanceFun*0.3;
                    OSAPCalculatedMonthlyInterest = (((OSAPFederalLoans * ((primeRate+2.5)/100)) + (OSAPProvincialLoans * ((primeRate + 1.0)/100)))/12);
                    System.out.println(OSAPCalculatedMonthlyInterest);



                    liabilitiesTotal += OSAPBalanceFun ;
                    break;
                case 2:
                    System.out.println("To date, how much have you borrowed from your student line of credit?");
                    double LOCFundVar = scanner.nextDouble();
                    System.out.println("What is the interest rate on your Student Line of Credit?");
                    double LOCInterestVar = scanner.nextDouble();
                    double LOCBalanceFun = liabilities.setLOC(LOCFundVar, LOCInterestVar);
                    liabilitiesTotal += LOCBalanceFun;
                    break;
            }
        }
        return liabilitiesTotal;
    }

    public static double setOSAP (double funding, double grants, boolean sixMonthGrace){
        OSAPLoans = funding - grants;
        OSAPGrants = grants;
        System.out.println(sixMonthGrace);
        return OSAPLoans;
    }

    public static boolean sixMonthGracePeriodChoice(String smgp){
        return smgp.equals("y") ? true : false;
    }

    public static double setLOC(double balance, double interest){
        LOCBalance = balance;
        LOCInterest = interest;
        return LOCBalance;
    }

    public static void setPrimeRate (double primeRateSet){
        primeRate = primeRateSet;
    }

    public static Double getPrimeRate(){
        return primeRate;
    }

}

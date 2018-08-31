package main.java;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Liabilities {

    private static Scanner scanner = new Scanner(System.in);
    private static Double OSAPLoans;
    private static Double OSAPGrants;
    private static Double OSAPMonthlyPayment;
    private static Double LOCBalance;
    private static Double LOCInterest;
    private static Double LOCMonthlyPayment;
    private static Double primeRate;

    public static void main (String[]args){
        Liabilities lb = new Liabilities();
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
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
                    double OSAPGrantsVar = scanner.nextDouble();
//                    System.out.println("Are you applying for the six month grace period? (Type y or n)");
//                    String sixMonthGracePeriod = scanner.next();
                    double OSAPBalanceFun = liabilities.setOSAP(OSAPFundVar, OSAPGrantsVar);
                    System.out.println("What is the prime rate set by the Bank of Canada?");
                    liabilities.setPrimeRate(scanner.nextDouble());
                    System.out.println("Over how many months do you want to take to pay off the loans?");
                    int OSAPMonths = scanner.nextInt();

                    // loan split assumptions
                    double OSAPFederalLoans = OSAPBalanceFun*0.7;
                    double OSAPProvincialLoans = OSAPBalanceFun*0.3;

                    // loan payment formulas - federal/provincial
                    double federalPayment = (((((primeRate + 2.5)/100)/12) * OSAPFederalLoans) / (1 - Math.pow((1 + ((primeRate + 2.5)/12)/100), -OSAPMonths ))); // TECHNICALLY ONLY REALLY NEED THIS FOR OUTPUT
                    double provincialPayment = (((((primeRate + 1.0)/100)/12) * OSAPProvincialLoans) / (1 - Math.pow((1 + ((primeRate + 1.0)/12)/100), -OSAPMonths )));

                    // AMORTIZATION SCHEDULE BLOCK--------------------------------------------
//                    while(OSAPFederalLoans >= 0){
//                        double federalInterest = (((primeRate+2.5)/100)/12)*OSAPFederalLoans;
//                        double federalPrinciple = federalPayment - federalInterest;
//                        OSAPFederalLoans = OSAPFederalLoans - federalPrinciple;
//                        System.out.println(federalInterest);
//                        System.out.println(federalPrinciple);
//                        System.out.println(OSAPFederalLoans);
//                        System.out.println();
//                        count1++;
//                    }
//
//                    while(OSAPProvincialLoans >= 0){
//                        double provincialInterest = (((primeRate+2.5)/100)/12)*OSAPProvincialLoans;
//                        double provincialPrinciple = provincialPayment - provincialInterest;
//                        OSAPProvincialLoans = OSAPProvincialLoans - provincialPrinciple;
//                        System.out.println(provincialInterest);
//                        System.out.println(provincialPrinciple);
//                        System.out.println(OSAPProvincialLoans);
//                        System.out.println();
//                        count2++;
//                    }
                    // AMORTIZATION SCHEDULE BLOCK---------------------------------------------------

                    // amortized OSAP monthly payment
                    OSAPMonthlyPayment = federalPayment + provincialPayment;
                    System.out.println(federalPayment + provincialPayment);

                    liabilitiesTotal += OSAPBalanceFun ;
                    break;
                case 2:
                    System.out.println("To date, how much have you borrowed from your student line of credit?");
                    double LOCFundVar = scanner.nextDouble();
                    System.out.println("What is the interest rate on your Student Line of Credit?");
                    double LOCInterestVar = scanner.nextDouble();
                    System.out.println("Over how many months do you want to take to pay off the loans?");
                    int LOCMonths = scanner.nextInt();
                    double LOCBalanceFun = liabilities.setLOC(LOCFundVar, LOCInterestVar);

                    // amortized LOC monthly payment
                    LOCMonthlyPayment = (((((LOCInterest)/100)/12) * LOCBalance) / (1 - Math.pow((1 + ((LOCInterest)/12)/100), -LOCMonths )));
                    System.out.println(LOCMonthlyPayment);

                    liabilitiesTotal += LOCBalanceFun;
                    break;
            }
        }
        return liabilitiesTotal;
    }

    public static double setOSAP (double funding, double grants){
        OSAPLoans = funding - grants;
        OSAPGrants = grants;
        return OSAPLoans;
    }
// probably not going to implement smgp, can delete from here and block up top (scanner)
//    public static boolean sixMonthGracePeriodChoice(String smgp){
//        return smgp.equals("y") ? true : false;
//    }

    public static double setLOC(double balance, double interest){
        LOCBalance = balance;
        LOCInterest = interest;
        return LOCBalance;
    }

    public static void setPrimeRate (double primeRateSet){
        primeRate = primeRateSet;
    }

    public static double getPrimeRate(){
        return primeRate;
    }

    public static double getOSAPMonthlyPayment(){
        return OSAPMonthlyPayment;
    }

    public static double getLOCMonthlyPayment(){
        return LOCMonthlyPayment;
    }

}

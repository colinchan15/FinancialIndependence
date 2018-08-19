package main.java;

public class ChequingAccounts {

    String accountName;
    Double accountBalance;

    public ChequingAccounts(String accountName, Double accountBalance){
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public String getAccountName(){
        return accountName;
    }

    public Double getAccountBalance(){
        return accountBalance;
    }
}

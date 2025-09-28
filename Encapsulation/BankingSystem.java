package Assigned10;

import java.util.*;

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setHolderName(String holderName) { this.holderName = holderName; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();
}

// Interface
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private String loanPolicyCode;

    public SavingsAccount(String accountNumber, String holderName, double balance, String loanPolicyCode) {
        super(accountNumber, holderName, balance);
        this.loanPolicyCode = loanPolicyCode;
    }

    public double calculateInterest() {
        return getBalance() * 0.04; // 4% annual interest
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2; // Eligible for 2x balance
    }

    public String getLoanPolicyDetails() {
        return "Loan Policy Code: ****" + loanPolicyCode.substring(loanPolicyCode.length() - 4);
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private String loanPolicyCode;

    public CurrentAccount(String accountNumber, String holderName, double balance, String loanPolicyCode) {
        super(accountNumber, holderName, balance);
        this.loanPolicyCode = loanPolicyCode;
    }

    public double calculateInterest() {
        return getBalance() * 0.02; // 2% annual interest
    }

    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    public double calculateLoanEligibility() {
        return getBalance() * 1.5; // Eligible for 1.5x balance
    }

    public String getLoanPolicyDetails() {
        return "Loan Policy Code: ****" + loanPolicyCode.substring(loanPolicyCode.length() - 4);
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA101", "Amit Sharma", 50000, "LOAN7890"));
        accounts.add(new CurrentAccount("CA202", "Neha Gupta", 80000, "LOAN4567"));

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: ₹" + acc.getBalance());
            System.out.println("Interest Earned: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println("Loan Eligibility: ₹" + loan.calculateLoanEligibility());
                System.out.println(((SavingsAccount.class.isInstance(acc) || CurrentAccount.class.isInstance(acc)) ?
                    ((SavingsAccount.class.isInstance(acc)) ?
                        ((SavingsAccount) acc).getLoanPolicyDetails() :
                        ((CurrentAccount) acc).getLoanPolicyDetails()) : ""));
            }

            System.out.println("-----------------------------");
        }
    }
}

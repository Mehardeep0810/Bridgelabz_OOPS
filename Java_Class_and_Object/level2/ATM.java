package Assigned6.level2;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.accountHolder = "Mehardeep";
        account.accountNumber = "PB123456789";
        account.balance = 10000.00;

        account.displayBalance();
        account.deposit(2500.00);
        account.withdraw(4000.00);
        account.withdraw(10000.00); 
        account.displayBalance();
    }
}

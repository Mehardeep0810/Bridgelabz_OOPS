
class BankAccount{
    String accountNumber = "123456789";
    int balance = 10000;

    public BankAccount() {
        System.out.println("Account Number: " + accountNumber);
    }
}
class SavingsAccount extends BankAccount{
    int interestRate = 20;
    public SavingsAccount() {
        System.out.println("Savings Account");
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount{
    int withdrawalLimit = 2000;
    public CheckingAccount() {
        System.out.println("Checking Account");
        System.out.println("Balance: " + balance);
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}
class  FixedDepositAccount extends BankAccount{
    int tenure = 5;
    public FixedDepositAccount() {
        System.out.println("Fixed Deposit Account");
        System.out.println("Balance: " + balance);
        System.out.println("Tenure: " + tenure + " years");
    }
}
public class BankAccountTypes {
    public static void main(String[] args) {
    SavingsAccount savings = new SavingsAccount(); 
    CheckingAccount checking = new CheckingAccount(); 
    System.out.println();
    FixedDepositAccount fixedDeposit = new FixedDepositAccount();
    }
}

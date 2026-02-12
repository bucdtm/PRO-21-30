package practicaEncapsulacion;

public class BankAccount {
    // TODO: Make these fields private (encapsulation!)
    private String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // TODO: Add getter methods for all fields

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // TODO: Add a setter for ownerName only (balance should only change through deposit/withdraw)

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // TODO: Add validation in deposit - amount must be positive
    public void deposit(double amount) {
        if(amount < 0){
            System.out.println("Amount not valid! Must be positive!");
        }else {
            balance += amount;
        }
    }

    // TODO: Add validation in withdraw - amount must be positive and not exceed balance
    public void withdraw(double amount) {
        if(amount <= 0){
            System.out.println("Amount not valid! Must be positive!");
        } else if (amount > this.balance){
            System.out.println("Not enough funds! Increase your balance or withdraw less money!");
        } else {
            balance -= amount;
        }
    }

    public void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: $" + balance);
    }
}

// Test class (already done for you)
class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC001", "John Doe", 1000.0);

        // After you encapsulate, these direct accesses should cause compile errors:
        // account.balance = -5000;  // Bad! Should not be allowed
        // account.accountNumber = "HACKED";  // Bad! Should not be allowed

        // These should work through your methods:
        account.deposit(500);
        account.withdraw(200);
        account.displayInfo();

        // Test your validation:
        account.withdraw(10000);  // Should fail gracefully
        account.deposit(-100);    // Should fail gracefully
    }
}

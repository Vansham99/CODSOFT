import java.util.Scanner;

// Class to represent the Bank Account
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor to initialize the account with a balance
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful! Your new balance is: $" + balance;
        } else {
            return "Invalid deposit amount. Please enter a positive number.";
        }
    }

    // Method to withdraw money
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid withdrawal amount. Please enter a positive number.";
        } else if (amount > balance) {
            return "Insufficient balance. Your current balance is: $" + balance;
        } else {
            balance -= amount;
            return "Withdrawal successful! Your new balance is: $" + balance;
        }
    }

    // Method to check balance
    public String checkBalance() {
        return "Your current balance is: $" + balance;
    }
}

// Class to represent the ATM
class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    // Method to handle user interaction and transactions
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(account.withdraw(withdrawAmount));
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(account.deposit(depositAmount));
                    break;

                case 3:
                    System.out.println(account.checkBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

// Main class to run the ATM system
public class ATMmachine {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount("123456789", 500.0);

        // Create an ATM and link it to the bank account
        ATM atm = new ATM(myAccount);

        // Start the ATM
        atm.start();
    }
}

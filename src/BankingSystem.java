import java.util.Scanner;

public class BankingSystem {
    private BankAccount[] accounts;
    private int numAccounts;

    public BankingSystem(int capacity) {
        accounts = new BankAccount[capacity];
        numAccounts = 0;
    }

    public void createAccount(String accountNumber, String name) {
        if (findAccount(accountNumber) != null) {
            System.out.println("Account number already exists. Please choose a different account number.");
            return;
        }

        BankAccount account = new BankAccount(accountNumber, name);
        accounts[numAccounts] = account;
        numAccounts++;
        System.out.println("Account created successfully!");
    }

    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void displayAccountDetails(String accountNumber) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account number does not exist.");
            return;
        }

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Account Balance: " + account.getAccountBalance());
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account number does not exist.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getAccountBalance());
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account number does not exist.");
            return;
        }

        if (account.getAccountBalance() < amount) {
            System.out.println("Insufficient funds.");
            return;
        }

        account.withdraw(amount);
        System.out.println("Withdrawal successful. New balance: " + account.getAccountBalance());
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, double amount) {
        BankAccount senderAccount = findAccount(senderAccountNumber);
        BankAccount receiverAccount = findAccount(receiverAccountNumber);

        if (senderAccount == null || receiverAccount == null) {
            System.out.println("One or both account numbers do not exist.");
            return;
        }

        if (senderAccount.getAccountBalance() < amount) {
            System.out.println("Insufficient funds in the sender's account.");
            return;
        }

        senderAccount.withdraw(amount);
        receiverAccount.deposit(amount);
        System.out.println("Transfer successful. New balance in sender's account: " + senderAccount.getAccountBalance());
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem(100); // Set the capacity of the banking system
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Banking System Menu ----");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer (Card-to-Card)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();

                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.next();

                    bankingSystem.createAccount(accountNumber, name);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();

                    bankingSystem.displayAccountDetails(accountNumber);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();

                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextDouble();

                    bankingSystem.deposit(accountNumber, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();

                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();

                    bankingSystem.withdraw(accountNumber, withdrawalAmount);
                    break;
                case 5:
                    System.out.print("Enter Sender's Account Number: ");
                    String senderAccountNumber = scanner.next();

                    System.out.print("Enter Receiver's Account Number: ");
                    String receiverAccountNumber = scanner.next();

                    System.out.print("Enter Amount to Transfer: ");
                    double transferAmount = scanner.nextDouble();

                    bankingSystem.transfer(senderAccountNumber, receiverAccountNumber, transferAmount);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



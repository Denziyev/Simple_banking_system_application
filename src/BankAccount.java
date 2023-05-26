class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        accountBalance -= amount;
    }
}

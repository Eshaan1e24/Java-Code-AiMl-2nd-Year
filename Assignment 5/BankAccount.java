// -------------------- Custom Exception --------------------
class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// -------------------- Base Class --------------------
class BankAccount {

    String accountNo;
    String holderName;
    double balance;

    // Constructor
    public BankAccount(String accountNo, String holderName, double balance) {
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited " + amount + " to " + accountNo);
    }

    // Withdraw money (basic rule: cannot exceed balance)
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive.");
        }
        if (amount > balance) {
            throw new BankingException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount + " from " + accountNo);
    }

    // Print account details
    public void printSummary() {
        System.out.println("Account: " + accountNo + " | Holder: " + holderName + " | Balance: " + balance);
    }
}

// -------------------- Savings Account --------------------
class SavingsAccount extends BankAccount {

    double minBalance;
    double interestRate; // yearly %

    public SavingsAccount(String accountNo, String holderName, double balance,
                          double minBalance, double interestRate) {
        super(accountNo, holderName, balance);
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    // Cannot go below minimum balance
    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive.");
        }
        if ((balance - amount) < minBalance) {
            throw new BankingException("Cannot withdraw! Minimum balance of " + minBalance + " must be maintained.");
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount + " from savings account " + accountNo);
    }

    // Add annual interest to balance
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " applied to " + accountNo);
    }
}

// -------------------- Current Account --------------------
class CurrentAccount extends BankAccount {

    double overdraftLimit; // can go into negative up to this limit

    public CurrentAccount(String accountNo, String holderName, double balance, double overdraftLimit) {
        super(accountNo, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Allow withdrawal even if balance goes negative, up to overdraft limit
    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive.");
        }
        if ((balance - amount) < -overdraftLimit) {
            throw new BankingException("Cannot withdraw! Overdraft limit of " + overdraftLimit + " exceeded.");
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount + " from current account " + accountNo);
    }
}

public class BankingDemo {

    public static void main(String[] args) {

        try {

            // Create accounts
            SavingsAccount savings = new SavingsAccount("SA-101", "Ayaan", 5000, 1000, 4.0);
            CurrentAccount current = new CurrentAccount("CA-201", "Isha", 2000, 3000);
            BankAccount basic = new BankAccount("BA-301", "Rahul", 1500);

            // Show initial balances
            System.out.println("---- Initial Balances ----");
            savings.printSummary();
            current.printSummary();
            basic.printSummary();

            // Deposit in all accounts
            System.out.println("\n---- Depositing 1000 in each account ----");
            savings.deposit(1000);
            current.deposit(1000);
            basic.deposit(1000);

            // Withdraw from all accounts
            System.out.println("\n---- Withdrawals ----");
            savings.withdraw(4500);   // Savings: checks min balance
            current.withdraw(6000);  // Current: checks overdraft limit
            basic.withdraw(500);     // Basic: checks available balance

            // Apply interest on savings
            System.out.println("\n---- Applying Interest on Savings ----");
            savings.applyInterest();

            // Final balances
            System.out.println("\n---- Final Balances ----");
            savings.printSummary();
            current.printSummary();
            basic.printSummary();

        } catch (BankingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

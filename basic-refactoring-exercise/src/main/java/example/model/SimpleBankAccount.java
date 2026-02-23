package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    public static final double LOWEST_BALANCE = 0.0;

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        if (holder == null) {
            throw new IllegalArgumentException("Account holder cannot be null.");
        }
        this.holder = holder;
        this.balance = Math.max(balance, LOWEST_BALANCE);
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    private boolean checkUser(final int id) {
        return this.holder.id() == id;
    }

    private boolean checkAmountPositive(final double amount) {
        return amount > 0.0;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && checkAmountPositive(amount)) {
            this.balance += amount;
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return checkAmountPositive(amount) && this.balance >= amount;
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }
}

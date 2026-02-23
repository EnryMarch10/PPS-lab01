import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

import static example.model.SimpleBankAccount.LOWEST_BALANCE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAW_AMOUNT = 70;
    private static final int ID = 1;
    private static final int NEXT_ID = ID + 1;
    private static final double INITIAL_BALANCE = LOWEST_BALANCE;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    private void depositDefaultAmount() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
    }

    private void assertBankAccountBalanceIsDefaultAmount() {
        assertBankAccountBalanceIs(DEPOSIT_AMOUNT);
    }

    @Test
    void testInvalidDeposit() {
        depositDefaultAmount();
        bankAccount.deposit(accountHolder.id(), -DEPOSIT_AMOUNT);
        assertBankAccountBalanceIsDefaultAmount();
    }

    @Test
    void testInvalidWithdraw() {
        depositDefaultAmount();
        bankAccount.withdraw(accountHolder.id(), -DEPOSIT_AMOUNT);
        assertBankAccountBalanceIsDefaultAmount();
    }

    @Test
    void testValidHolder() {
        assertThrows(IllegalArgumentException.class, () -> new SimpleBankAccount(null, INITIAL_BALANCE));
    }

    private void assertBankAccountBalanceIs(double expectedBalance) {
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testInitialBalance() {
        assertBankAccountBalanceIs(INITIAL_BALANCE);
    }

    @Test
    void testWrongBalance() {
        var tmpBank = new SimpleBankAccount(accountHolder, LOWEST_BALANCE - 1);
        assert(tmpBank.getBalance() >= LOWEST_BALANCE);
    }

    @Test
    void testDeposit() {
        depositDefaultAmount();
        assertBankAccountBalanceIsDefaultAmount();
    }

    @Test
    void testWrongDeposit() {
        depositDefaultAmount();
        bankAccount.deposit(NEXT_ID, DEPOSIT_AMOUNT);
        assertBankAccountBalanceIsDefaultAmount();
    }

    private void withdrawDefaultAmount(int withdrawId) {
        bankAccount.withdraw(withdrawId, WITHDRAW_AMOUNT);
    }

    @Test
    void testWithdraw() {
        depositDefaultAmount();
        withdrawDefaultAmount(accountHolder.id());
        assertBankAccountBalanceIs(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT);
    }

    @Test
    void testWrongWithdraw() {
        depositDefaultAmount();
        withdrawDefaultAmount(NEXT_ID);
        assertBankAccountBalanceIsDefaultAmount();
    }
}

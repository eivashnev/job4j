package bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {

    @Test
    public void whenAddOneAccount() {
        Bank bank = new Bank();
        String pasp1 = "123";
        User user1 = new User("Anton", pasp1);
        Account account = new Account(1000, "1234567890");
        bank.addUser(user1);
        bank.addAccountToUser(pasp1, account);

        assertThat(bank.getUserAccounts(pasp1).get(0), is(account));
    }

    @Test
    public void whenAddTwoAccount() {
        Bank bank = new Bank();
        String pasp1 = "123";
        User user1 = new User("Anton", pasp1);
        Account account1 = new Account(1000, "1234567890");
        Account account2 = new Account(1000, "6464646545");

        bank.addUser(user1);
        bank.addAccountToUser(pasp1, account1);
        bank.addAccountToUser(pasp1, account2);

        List<Account> expected = Arrays.asList(account1, account2);

        assertThat(bank.getUserAccounts(pasp1), is(expected));
    }

    @Test
    public void testDuplicateAccountCantBeAdded() {
        Bank bank = new Bank();
        String pasp1 = "123";
        User user1 = new User("Anton", pasp1);
        Account account = new Account(1000, "1234567890");
        bank.addUser(user1);
        bank.addAccountToUser(pasp1, account);
        bank.addAccountToUser(pasp1, account);

        assertThat(bank.getUserAccounts(pasp1).size(), is(1));
    }

    @Test
    public void whenAmountLessThenSrcValueThenTransferSucceeded() {
        Bank bank = new Bank();
        String pasp1 = "123";
        String pasp2 = "345";
        User user1 = new User("Anton", pasp1);
        User user2 = new User("Alex", pasp2);
        String requisites1 = "1234567890";
        String requisites2 = "6464646545";
        Account account1 = new Account(1000, requisites1);
        Account account2 = new Account(1000, requisites2);

        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(pasp1, account1);
        bank.addAccountToUser(pasp2, account2);

        bank.transferMoney(pasp1, requisites1, pasp2, requisites2, 500);

        assertThat(bank.getUserAccounts(pasp1).get(0).getValue(), is(500.0));
        assertThat(bank.getUserAccounts(pasp2).get(0).getValue(), is(1500.0));
    }

    @Test
    public void whenAmountGreaterThenSrcValueThenTransferFailed() {
        Bank bank = new Bank();
        String pasp1 = "123";
        String pasp2 = "345";
        User user1 = new User("Anton", pasp1);
        User user2 = new User("Alex", pasp2);
        String requisites1 = "1234567890";
        String requisites2 = "6464646545";
        Account account1 = new Account(1000, requisites1);
        Account account2 = new Account(1000, requisites2);

        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(pasp1, account1);
        bank.addAccountToUser(pasp2, account2);

        bank.transferMoney(pasp1, requisites1, pasp2, requisites2, 2000);

        assertThat(bank.getUserAccounts(pasp1).get(0).getValue(), is(1000.0));
        assertThat(bank.getUserAccounts(pasp2).get(0).getValue(), is(1000.0));
    }
}

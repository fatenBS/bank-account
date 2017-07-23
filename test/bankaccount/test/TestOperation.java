package bankaccount.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bankaccount.model.Account;
import bankaccount.model.Customer;
import bankaccount.model.Transaction;
import bankaccount.model.TransactionType;
import bankaccount.services.AccountService;
import bankaccount.services.UnsufficientBalanceException;

public class TestOperation {

	private Account account;
	private AccountService accountService = new AccountService();

	@Before
	public void setUp() {
		Customer customer = new Customer();
		customer.setNom("Alice");
		customer.setPrenom("Brittnay");
		account = new Account(BigDecimal.ZERO);
		account.setId(Integer.valueOf(1234567890));
		account.setCustomer(customer);
	}

	@Test
	public void testDeposit() throws UnsufficientBalanceException {
		accountService.doTransaction(account, new BigDecimal(500), TransactionType.DEPOSIT);
		Assert.assertEquals(new BigDecimal(500), account.getBalance());
	}

	@Test(expected = UnsufficientBalanceException.class)
	public void testWithdrawalFailed() throws UnsufficientBalanceException {
		accountService.doTransaction(account, new BigDecimal(500), TransactionType.WITHDRAWAL);
	}

	@Test
	public void testWithdrawalSuccess() throws UnsufficientBalanceException {
		account.setBalance(new BigDecimal(500));
		accountService.doTransaction(account, new BigDecimal(200), TransactionType.WITHDRAWAL);
		Assert.assertEquals(new BigDecimal(300), account.getBalance());
	}

	@Test
	public void testShowHistory() throws UnsufficientBalanceException {
		accountService.doTransaction(account, new BigDecimal(500), TransactionType.DEPOSIT);
		accountService.doTransaction(account, new BigDecimal(100), TransactionType.DEPOSIT);
		accountService.doTransaction(account, new BigDecimal(300), TransactionType.WITHDRAWAL);
		Assert.assertEquals(3, account.getTransactions().size());
		for (Transaction transaction : account.getTransactions()) {
			System.out.println(transaction.toString());

		}
	}
}

package bankaccount.services;

import java.math.BigDecimal;
import java.time.Instant;

import bankaccount.model.Account;
import bankaccount.model.Transaction;
import bankaccount.model.TransactionType;
import bankaccount.transaction.TransactionFunctionFactory;
import bankaccount.transaction.TransactionFunctionFactory.TransactionFunction;

public class AccountService {

	public void doTransaction(Account account, BigDecimal amount, TransactionType transactionType)
			throws UnsufficientBalanceException {
		TransactionFunction transaction = TransactionFunctionFactory.getTransactionFunction(transactionType);
		BigDecimal result = transaction.doTransaction(amount, account);
		if (result == null) {
			throw new UnsufficientBalanceException();
		}
		String customerName = new StringBuilder().append(account.getCustomer().getNom()).append(" ")
				.append(account.getCustomer().getPrenom()).toString();
		Transaction transactionHistory = new Transaction(customerName, Instant.now(), amount, account.getBalance(),
				transactionType, account.getId());
		account.getTransactions().add(transactionHistory);
	}
}

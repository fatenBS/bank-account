package bankaccount.transaction;

import java.math.BigDecimal;

import bankaccount.model.Account;
import bankaccount.model.TransactionType;

public interface TransactionFunctionFactory {

	@FunctionalInterface
	public interface TransactionFunction {
		BigDecimal doTransaction(BigDecimal amount, Account account);
	}

	public static TransactionFunction getTransactionFunction(TransactionType transacctionType) {
		TransactionFunction function = null;
		switch (transacctionType) {
		case DEPOSIT:
			function = new TransactionFunction() {

				@Override
				public BigDecimal doTransaction(BigDecimal amount, Account account) {
					account.setBalance(account.getBalance().add(amount));
					return account.getBalance();
				}
			};
			break;
		case WITHDRAWAL:

			function = new TransactionFunction() {

				@Override
				public BigDecimal doTransaction(BigDecimal amount, Account account) {
					if (account.getBalance().compareTo(amount) < 0) {
						return null;

					} else {
						account.setBalance(account.getBalance().subtract(amount));
						return account.getBalance();
					}

				}
			};
			break;
		default:

			break;
		}

		return function;

	}
}

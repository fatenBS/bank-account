package bankaccount.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

	private Integer id;
	private BigDecimal balance;
	private List<Transaction> transactions;
	private Customer customer;

	public Account(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Transaction> getTransactions() {
		if (transactions == null) {
			transactions = new ArrayList<>();
		}
		return transactions;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

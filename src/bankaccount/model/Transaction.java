package bankaccount.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {

	@Override
	public String toString() {
		return "Transaction [customerName=" + customerName + ", idAccount=" + idAccount + ", operationTime="
				+ operationTime + ", amount=" + amount + ", balance=" + balance + ", transactionType=" + transactionType
				+ "]";
	}

	private String customerName;
	private Integer idAccount;
	private Instant operationTime;
	private BigDecimal amount;
	private BigDecimal balance;
	private TransactionType transactionType;

	

	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public Instant getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Instant operationTime) {
		this.operationTime = operationTime;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Transaction(String customerName, Instant operationTime, BigDecimal amount, BigDecimal balance,
			TransactionType transactionType, Integer idAccount) {
		super();
		this.customerName = customerName;
		this.operationTime = operationTime;
		this.amount = amount;
		this.balance = balance;
		this.transactionType = transactionType;
		this.idAccount = idAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}

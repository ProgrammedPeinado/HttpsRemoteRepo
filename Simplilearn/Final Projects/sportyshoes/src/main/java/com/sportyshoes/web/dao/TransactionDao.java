package com.sportyshoes.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Transaction;

@Repository
public interface TransactionDao 
{
	public boolean addTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	public Transaction searchTransaction(int id);
	public void deleteTransaction(int id);
}

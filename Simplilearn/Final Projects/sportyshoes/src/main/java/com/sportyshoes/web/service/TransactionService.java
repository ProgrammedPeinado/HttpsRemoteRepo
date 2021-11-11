package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportyshoes.web.model.Transaction;

@Service
public interface TransactionService 
{
	public boolean addTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	public Transaction searchTransaction(int id);
	public void deleteTransaction(int id);
}

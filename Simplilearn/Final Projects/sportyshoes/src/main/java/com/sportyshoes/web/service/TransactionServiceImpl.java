package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.dao.TransactionDaoImpl;
import com.sportyshoes.web.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService 
{
	@Autowired
	private TransactionDaoImpl transactionDao;
	
	@Override
	public boolean addTransaction(Transaction transaction) 
	{
		return transactionDao.addTransaction(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() 
	{
		return transactionDao.getAllTransactions();
	}

	@Override
	public Transaction searchTransaction(int id) 
	{
		return transactionDao.searchTransaction(id);
	}

	@Override
	public void deleteTransaction(int id) 
	{
		transactionDao.deleteTransaction(id);
	}

}

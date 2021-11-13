package com.sportyshoes.web.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Transaction;

@Repository
public class TransactionDaoImpl extends JdbcDaoSupport implements TransactionDao 
{
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public boolean addTransaction(Transaction transaction) {
		boolean flag = false;
		String sql = "insert into transactions values(?,?,?,?,?)";
		int val = getJdbcTemplate().update(sql, new Object[] {transaction.getTransaction_id(), transaction.getBuyer_id(), transaction.getProduct_id(), transaction.getCategory(), transaction.getTransaction_date()});
		if(val > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		String sql = "select * from transactions ORDER BY category,transaction_date ASC";
		List<Map<String, Object>> transactionData = getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> t: transactionData)
		{
			Transaction trans = new Transaction();
			trans.setTransaction_id((Integer)t.get("transaction_id"));
			trans.setBuyer_id((Integer)t.get("Buyer_id"));
			trans.setProduct_id((Integer)t.get("product_id"));
			trans.setCategory((String)t.get("category"));
			trans.setTransaction_date((LocalDateTime)t.get("transaction_date"));
			
			if(trans !=null)
			{	
				transactions.add(trans);	
			}
		}
		
		return transactions;
	}

	@Override
	public Transaction searchTransaction(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransaction(int id) {
		// TODO Auto-generated method stub

	}

}

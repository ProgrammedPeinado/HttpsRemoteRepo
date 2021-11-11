package com.sportyshoes.web.model;

import java.sql.Date;

public class Transaction 
{
	private int transaction_id;
	private int buyer_id;
	private int product_id;
	private String category;
	private Date transaction_date;

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", buyer_id=" + buyer_id + ", product_id=" + product_id
				+ ", category=" + category + ", transaction_date=" + transaction_date + "]";
	}
}

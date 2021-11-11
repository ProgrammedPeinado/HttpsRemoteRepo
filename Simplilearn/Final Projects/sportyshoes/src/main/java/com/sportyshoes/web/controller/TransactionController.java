package com.sportyshoes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.web.model.Transaction;
import com.sportyshoes.web.service.TransactionService;

@Controller
public class TransactionController 
{
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("getTransactions")
	public ModelAndView getAllTransactions()
	{
		List<Transaction> transactions = transactionService.getAllTransactions();
		ModelAndView modelAndView = new ModelAndView("displaytransactions");
		return modelAndView;
	}
}

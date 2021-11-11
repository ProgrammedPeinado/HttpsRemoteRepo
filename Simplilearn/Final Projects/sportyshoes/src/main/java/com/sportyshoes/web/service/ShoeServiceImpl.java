package com.sportyshoes.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.dao.ShoeDaoImpl;
import com.sportyshoes.web.model.Shoe;

@Service
public class ShoeServiceImpl implements ShoeService 
{
	@Autowired
	private ShoeDaoImpl shoeDao;
	
	@Override
	public boolean addShoe(Shoe shoe) 
	{
		return shoeDao.addShoe(shoe);
	}

	@Override
	public List<Shoe> getAllShoes() 
	{
		return shoeDao.getAllShoes();
	}

	@Override
	public Map<String, ArrayList<Shoe>> getShoeTags() 
	{
		return shoeDao.getShoeTags();
	}

	@Override
	public Shoe searchShoe(int id) 
	{
		return shoeDao.searchShoe(id);
	}

	@Override
	public boolean updateShoe(int shoe_id, String tag) {
		return shoeDao.updateShoe(shoe_id, tag);
	}

	@Override
	public void deleteShoe(int id) 
	{
		shoeDao.deleteShoe(id);
	}

}

package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Shoe;

@Repository
public interface ShoeDao 
{
	public boolean addShoe(Shoe shoe);
	public List<Shoe> getAllShoes();
	public Map<String, ArrayList<String>> getShoeTags();
	public Shoe searchShoe(int id);
	public boolean updateShoe(int shoe_id, String tag);
	public void deleteShoe(int id);
}

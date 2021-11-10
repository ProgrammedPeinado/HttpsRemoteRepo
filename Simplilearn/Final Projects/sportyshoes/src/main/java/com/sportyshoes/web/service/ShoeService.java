package com.sportyshoes.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.model.Shoe;

@Service
public interface ShoeService 
{
	public boolean addShoe(Shoe shoe);
	public List<Shoe> getAllShoes();
	public Map<String, ArrayList<String>> getShoeTags();
	public Shoe searchShoe(int id);
	public boolean updateShoe(int shoe_id, String tag);
	public void deleteShoe(int id);
}

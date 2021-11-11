package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Shoe;
import com.sportyshoes.web.model.User;

@Repository
public class ShoeDaoImpl extends JdbcDaoSupport implements ShoeDao 
{
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public boolean addShoe(Shoe shoe) {
		boolean flag = false;
		String sql = "insert into shoes values(?,?,?,?)";
		int val = getJdbcTemplate().update(sql, new Object[] {shoe.getShoe_id(), shoe.getShoe_name(), shoe.getTag(), shoe.getThumbnail()});
		if(val > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public List<Shoe> getAllShoes() {
		List<Shoe> shoes = null;
		String sql = "select * from shoes";
		List<Map<String, Object>> shoeData = getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> s: shoeData)
		{
			Shoe shoe = new Shoe();
			shoe.setShoe_id((Integer)s.get("shoe_id"));
			shoe.setShoe_name((String)s.get("shoe_name"));
			shoe.setTag((String)s.get("tag"));
			shoe.setThumbnail((String)s.get("thumbnail"));
			shoes.add(shoe);
		}
		
		return shoes;
	}

	@Override
	public Map<String, ArrayList<Shoe>> getShoeTags() {
		Map<String, ArrayList<Shoe>> shoes = new HashMap<>();
		
		
		String sql = "select * from shoes";
		List<Map<String, Object>> shoeData = getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> keys: shoeData)
		{
			ArrayList<Shoe> values = new ArrayList<Shoe>();
			
			for(Map<String, Object> value : shoeData)
			{
				if(value.get("tag").equals(keys.get("tag")))
				{
					Shoe shoe = new Shoe();
					shoe.setShoe_id((Integer)value.get("shoe_id"));
					shoe.setShoe_name((String)value.get("shoe_name"));
					shoe.setTag((String)value.get("tag"));
					shoe.setThumbnail((String)value.get("thumbnail"));
					values.add(shoe);	
				}
				
			}
					
			shoes.put((String)keys.get("tag"), values);
			values=null;
		}
		
		//Returns a Map of <Tags, Products with the Tag>
		return shoes;
	}

	@Override
	public Shoe searchShoe(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateShoe(int shoe_id, String tag) 
	{
		boolean isShoeUpdated = false;
		String sql = "update shoes set tag=? where shoe_id=?";
		int val = getJdbcTemplate().update(sql, tag, shoe_id);
		if(val > 0)
			isShoeUpdated = true;
			
		return isShoeUpdated;
	}

	@Override
	public void deleteShoe(int id) 
	{
	}

}

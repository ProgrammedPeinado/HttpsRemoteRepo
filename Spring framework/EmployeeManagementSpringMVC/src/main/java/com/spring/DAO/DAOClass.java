package com.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.spring.model.User;

@Component
public class DAOClass 
{
	@Autowired
	static DataSource ds;

	public static int insertData(User userObject)
	{
		int i = 0; //if its 1, insertion was successful
		
		try 
		{
			Connection con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement("insert into USER1 values (?,?,?)"); //Every question mark corresponds to a field in the table
			pst.setString(1, userObject.getFirstName()); // every number correspond to the respective question mark
			pst.setString(2, userObject.getLastName());
			pst.setInt(3, (int)userObject.getMobileNumber());
			i = pst.executeUpdate();
			
			pst.close();
			con.close();
		} 	
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

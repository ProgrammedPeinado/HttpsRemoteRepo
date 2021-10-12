package springdemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component(value="customerDaoImpl")
public class CustomerDaoImpl implements CustomerDAO
{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource; // property of JDBC database 
	
	public CustomerDaoImpl()
	{
		System.out.println("CustomerDaoImpl Constructor");
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addCustomer(Customer customer)
	{
		String sql = "insert into customer values(?,?,?)";
		int i = jdbcTemplate.update(sql, new Object[] {customer.getCustomerId(), customer.getName(), customer.getAddress()});
		if( i > 0)
		{
			System.out.println("Customer added");
		}
	}
	
	@Override
	public List<Customer> getAllCustomers()
	{
		String sql = "select * from customer";
		//2 interfaces
		//1 resultsetextractor
		//2 rowmapper
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() 
				{
					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
					{
						Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
						return customer;
					}
				});
		
		/* ---------------USING RESULT EXTRACTOR
		//Since we want a list back, we need to return the results by using the template -- This is the Result Extractor way
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Customer>>()
				{
					@Override
					public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException
					{
						List<Customer> customers = new ArrayList<Customer>();
						while(rs.next())
						{
							Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
							customers.add(customer);
						}
						return customers;
					}
				}); //End of the return
				
			*/
	}
}

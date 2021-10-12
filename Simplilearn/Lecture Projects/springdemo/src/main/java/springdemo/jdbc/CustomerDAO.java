package springdemo.jdbc;

import java.util.List;

public interface CustomerDAO
{
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}

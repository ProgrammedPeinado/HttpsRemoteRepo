package springdemo.collections;

import java.util.Map;
import java.util.Set;

public class Customer
{
	private int customerId;
	private String customerName;
	private Set<String> address;
	private Map<String, String> specificAddress;
	private Map<Integer, Order> orders;
	
	public Customer()
	{
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customeId)
	{
		this.customerId = customeId;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public Set<String> getAddress()
	{
		return address;
	}

	public void setAddress(Set<String> address)
	{
		this.address = address;
	}

	public Map<String, String> getSpecificAddress()
	{
		return specificAddress;
	}

	public void setSpecificAddress(Map<String, String> specificAddress)
	{
		this.specificAddress = specificAddress;
	}

	public Map<Integer, Order> getOrders()
	{
		return orders;
	}

	public void setOrders(Map<Integer, Order> orders)
	{
		this.orders = orders;
	}

	@Override
	public String toString()
	{
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", specificAddress=" + specificAddress + ", orders=" + orders + "]";
	}

	
}

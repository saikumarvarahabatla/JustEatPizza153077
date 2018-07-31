package com.cg.pizzaorder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.cg.pizzaorder.CustException.PizzaException;
import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;

public class PizzaOrderDAO implements IPizzaOrderDAO {
	
	static int orderId=(int)Math.random();
	static int customerId=(int)Math.random();
	
	Map<Integer,Customer> customerEntry=new HashMap<>();
	Map<Integer,PizzaOrder> pizzaEntry=new HashMap<>();
	Scanner sc=new Scanner(System.in);

	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
	try {
		
		customerId++;
		customer.setCustomerId(customerId);
		customerEntry.put(customerId,customer);
		
		orderId++;
		pizza.setOrderId(orderId);
		pizzaEntry.put(orderId,pizza);
		
		return orderId;
	}
		catch(Exception exception)
	{
			throw new PizzaException();
	}
	}

	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		
		try
		{
			Set set=pizzaEntry.entrySet();
			
			Iterator iter=set.iterator();
			while(iter.hasNext())
			{
				Map.Entry mapEntry=(Map.Entry)iter.next();
				if((Integer)mapEntry.getKey()==orderId)
	{
	System.out.println(mapEntry.getValue()+"\n");
}

			}
			return null;
		}
		
		catch(Exception exception)
		{
				throw new PizzaException();
		}
	}
}

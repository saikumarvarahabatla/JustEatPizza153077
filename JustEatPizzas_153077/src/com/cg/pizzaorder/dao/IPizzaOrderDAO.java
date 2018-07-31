package com.cg.pizzaorder.dao;

import com.cg.pizzaorder.CustException.PizzaException;
import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;

public interface IPizzaOrderDAO {
	
	public abstract int placeOrder(Customer customer, PizzaOrder pizza)throws PizzaException;
	public abstract PizzaOrder getOrderDetails(int orderid)throws PizzaException;

}

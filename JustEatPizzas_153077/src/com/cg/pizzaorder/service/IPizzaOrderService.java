package com.cg.pizzaorder.service;

import com.cg.pizzaorder.CustException.PizzaException;
import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;

public interface IPizzaOrderService {
	
	public int placeOrder(Customer customer,PizzaOrder pizza)throws PizzaException;
	public PizzaOrder getOrderDetails(int orderid)throws PizzaException;

	public Boolean validatePhoneNumber(String phone)throws PizzaException;

}

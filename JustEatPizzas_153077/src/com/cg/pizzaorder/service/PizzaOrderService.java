package com.cg.pizzaorder.service;

import java.util.Scanner;

import com.cg.pizzaorder.CustException.PizzaException;
import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.dao.PizzaOrderDAO;

public class PizzaOrderService implements IPizzaOrderService{

	PizzaOrderDAO serviceDao = new PizzaOrderDAO();
	
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		
		int orderId= serviceDao.placeOrder(customer, pizza);
		
		return orderId;
	}

	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		
		return serviceDao.getOrderDetails(orderid);
	}

	@Override
	public Boolean validatePhoneNumber(String phone) throws PizzaException {
		String pattern="[1-9][0-9]";
		if(phone.matches(pattern))
		return true;
		else
			return false;
	}
public void acceptPhoneNumber(Customer customer)throws PizzaException{
	try {
		Scanner sc=new Scanner(System.in);
		while(true) {
			if(validatePhoneNumber(customer.getPhone()))
				break;
			else
			{
				System.err.println("wrong phone number entered!!!\n please enter 10 digit number");
				System.out.println("Enter phone number again(eg:8341730575");
				customer.setPhone(sc.next());
			}
				
			}
		}catch(Exception exception)
	{
			throw new PizzaException();
	}
}

		
		


	

	
}

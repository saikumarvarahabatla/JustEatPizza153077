package com.cg.pizzaorder.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cg.pizzaorder.CustException.PizzaException;
import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderService;



public class Client {
	public static void main(String[] args)throws PizzaException {
		IPizzaOrderService service;
		{
			service=new PizzaOrderService();
		}
	     List myList;
		
		Scanner sc= new Scanner(System.in);
		String ans;
		int no;
		do{
			System.out.println("*****JustEatPizzas order*****");
			System.out.println("********MENU*******\n");
			System.out.println("1.Place order");
			System.out.println("2.Display order");
			System.out.println("3.Exit");
			
			System.out.println("Please enter your choice: ");
			no = sc.nextInt();
			switch(no)
			{
			case 1:
				System.out.println("*****Enter customer details*****\n");
				System.out.println("Enter the name of the customer");
				String name=sc.next();
				
				System.out.println("Enter customer address");
				String address=sc.next();
				
				System.out.println("Enter customer phone number");
				String phone=sc.next();
				
				Customer customer=new Customer(name, address, phone);
				System.out.println("Enter the type of pizza topping preferred");
				String topping=sc.next();
				
				long basePrice = 350;
				long totalPrice = 0;
				
				if (topping.equals("Mushroom"))
				{
					totalPrice = basePrice+50;
				}
				
				else if (topping.equals("Capsicum"))
				{
					totalPrice = basePrice+30;
				}
				
				else if (topping.equals("Jalapeno"))
				{
					totalPrice = basePrice+70;
				}
				
				else if (topping.equals("Paneer"))
				{
					totalPrice = basePrice+85;
				}
				else
				{
					System.out.println("Enter a valid topping from the list");
				}
				
				PizzaOrder pizza = new PizzaOrder(totalPrice);
				System.out.println("OrderDate:"+LocalDate.now()+"\n");
				int orderId=service.placeOrder(customer, pizza);
			
				System.out.println("Pizza Order successfully placed with order Id:"+orderId);
			break;
				
			case 2:
				System.out.println("enter the order id to display the pizza order");
				int ordid=sc.nextInt();
			
				service.getOrderDetails(ordid);
			
				break;
			
			case 3:
				System.out.println("exit");
				System.exit(0);
				break;
				
				default:
					System.out.println("some error in switch case");
					break;
			}
			System.out.println("Do you want to continue yes/no");
			ans=sc.next();
		}
		while (ans.equals("yes")||ans.equals("y")||ans.equals("yes"));
		
			
	}
		

}

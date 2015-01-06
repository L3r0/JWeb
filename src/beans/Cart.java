package beans;

import java.util.HashMap;

public class Cart {
	HashMap<String, Integer> sessionCart;
	
	public Cart()
	{
		this.sessionCart = new HashMap<String, Integer>();
	}
	
	public void setCart(HashMap<String, Integer> cart)
	{
		this.sessionCart = cart;
	}	
	
	public HashMap<String, Integer> getCart()
	{
		return this.sessionCart;
	}
	
	public void setValue(String productName, Integer value)
	{
		this.sessionCart.put(productName, value);
	}	
	
	public Integer getValue(String productName)
	{
		if (this.sessionCart.containsKey(productName))
			return this.sessionCart.get(productName);
		else
			return 0;
	}
}

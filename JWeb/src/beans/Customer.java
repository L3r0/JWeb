package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	private Integer id;
	private String name;
	private String firstName;
	private String adress;
	private String phone;
	private String mail;
	
	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	public String getAdress()
	{
		return adress;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getMail()
	{
		return mail;
	}
}

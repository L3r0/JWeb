package beans;

public class Customer {
	private Integer id;
	private String nickName;
	private String password;
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
	
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
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

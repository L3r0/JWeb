package beans;

public class Product {
	private Integer id;
	private String name;
	private String description;
	private String price;
	
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

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getPrice()
	{
		return price;
	}
}

package dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import beans.Product;

public class DaoProduct {
	private Connection connection;

    public DaoProduct() {
    	if (connection == null)
        {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("/dataAccessObject/properties");

            try {
                Properties properties = new Properties();
            	properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Products(name, description, price) values (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int Id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Products WHERE id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Products SET name=?, description=?, price=?" + "WHERE id=?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Products");
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setDescription(result.getString("description"));
                product.setPrice(result.getString("price"));
                productList.add(product);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    public Product getProduct(String name)
    {
    	Product product = new Product();
    	try {
    			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Products WHERE name=?");
                preparedStatement.setString(1, name);
                ResultSet result = preparedStatement.executeQuery();
                while ( result.next() )
                {
                    product.setId(result.getInt("id"));
                    product.setName(result.getString("name"));
                    product.setDescription(result.getString("description"));
                    product.setPrice(result.getString("price"));
                }
                result.close();
                preparedStatement.close();
        	}
    	
    	catch (SQLException e) {
        e.printStackTrace();
    	}
    	return product;
    }
}

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

import beans.Customer;

public class DaoCustomer {
	private Connection connection;

    public DaoCustomer() {
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

    public void addCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(nickname, password, name, firstname, adress, phone, mail) values (?, MD5(?), ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, customer.getNickName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getFirstName());
            preparedStatement.setString(5, customer.getAdress());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getMail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int Id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Users SET nickname=?, password=?, name=?, firstname=?, adress=?, phone=?, mail=?" + "WHERE id=?");
            preparedStatement.setString(1, customer.getNickName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getFirstName());
            preparedStatement.setString(5, customer.getAdress());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getMail());
            preparedStatement.setInt(8, customer.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Users");
            while (result.next()) {
                Customer customer = new Customer();
                customer.setId(result.getInt("id"));
                customer.setNickName(result.getString("nickname"));
                customer.setPassword(result.getString("password"));
                customer.setName(result.getString("name"));
                customer.setFirstName(result.getString("firstname"));
                customer.setAdress(result.getString("adress"));
                customer.setPhone(result.getString("phone"));
                customer.setMail(result.getString("mail"));
                customers.add(customer);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
    public Customer getCustomer(String nickName, String password)
    {
    	Customer customer = new Customer();
    	try {
    			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE nickname=? AND password=?");
                preparedStatement.setString(1, nickName);
                preparedStatement.setString(2, password);
                ResultSet result = preparedStatement.executeQuery();
                while ( result.next() )
                {
                    customer.setId(result.getInt("id"));
                    customer.setNickName(result.getString("nickname"));
                    customer.setPassword(result.getString("password"));
                    customer.setName(result.getString("name"));
                    customer.setFirstName(result.getString("firstname"));
                    customer.setAdress(result.getString("adress"));
                    customer.setPhone(result.getString("phone"));
                    customer.setMail(result.getString("mail"));
                }
                result.close();
                preparedStatement.close();
        	}
    	
    	catch (SQLException e) {
        e.printStackTrace();
    	}
    	return customer;
    }
}

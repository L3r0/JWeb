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

import beans.News;

public class DaoNews {
	private Connection connection;

    public DaoNews() {
    	if (connection != null)
            connection = connection;
        else {
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

    public void addNews(News news) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO News(name, content) values (?, ?)");
            preparedStatement.setString(1, news.getName());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNews(int Id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM News WHERE id=?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNews(News news) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE News SET name=?, content=?" + "WHERE id=?");
            preparedStatement.setString(1, news.getName());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setInt(3, news.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<News>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM News");
            while (result.next()) {
                News news = new News();
                news.setId(result.getInt("id"));
                news.setName(result.getString("name"));
                news.setContent(result.getString("content"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}

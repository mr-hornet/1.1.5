package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    private final String URL = "jdbc:mysql://localhost:3306/kata1";
    private final String USER = "root";
    private final String PASSWORD = "Cc125643!";

    private SessionFactory sessionFactory;

    public Util() {

//        Connection connection;
//        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            connection.setAutoCommit(false);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", URL);
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.username", USER);
        properties.setProperty("hibernate.connection.password", PASSWORD);
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hdm2ddl.auto", "create");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(jm.task.core.jdbc.model.User.class);

        sessionFactory = configuration.buildSessionFactory();


        System.out.println("Connection OK");

//        return connection;
    }

    public SessionFactory getSessionFactory (){
        return sessionFactory;
    }

}

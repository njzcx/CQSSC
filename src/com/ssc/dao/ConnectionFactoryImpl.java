package com.ssc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactoryImpl implements ConnectionFactory {

	public Connection getConnection() throws Exception {
		Properties prop = new Properties();
		prop.load(this.getClass().getResourceAsStream("/com/ssc/conf/jdbc.properties"));
		Class.forName(prop.getProperty("driverClassName"));
		Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		return conn;
	}

}

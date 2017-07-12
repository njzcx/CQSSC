package com.ssc.dao;

import java.sql.Connection;

public abstract class BaseDao {

	ConnectionFactory cf;
	
	public BaseDao() {
		super();
		cf = new ConnectionFactoryImpl();
	}
	
	public Connection getConnection() throws Exception {
		return cf.getConnection();
	}

}
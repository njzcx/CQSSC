package com.ssc.dao;

import java.sql.Connection;

public interface ConnectionFactory {
	
	public Connection getConnection() throws Exception;
	
}

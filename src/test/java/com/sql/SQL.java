package com.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class SQL {
	private static Connection vConnection;
	@BeforeSuite
	public void connect() throws SQLException{
		String host="localhost";
		String port="3306";
		vConnection=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/world?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
	}
	
	public static Connection getConnection(){
		return vConnection;		
	}
	
}

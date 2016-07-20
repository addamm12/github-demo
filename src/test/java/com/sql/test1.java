package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
   @Test
   public void Test1() throws SQLException{
		String host="localhost";
		String port="3306";
		Connection vConnection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/world?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
	    //Connection vConnection=SQL.getConnection();   
		Statement vStatemanet=vConnection.createStatement();
		ResultSet vResultSet=vStatemanet.executeQuery("select * from city where Population>9000000");
		vResultSet.next();
		System.out.println(vResultSet.getString("Name"));
		System.out.println(vResultSet.getString(3));
		Assert.assertEquals(vResultSet.getString(3), "BRA");
   }
}

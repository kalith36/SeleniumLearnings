package com.seleniumInterviewQuestions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTesting {

	

	public static void main(String[] args) throws SQLException {
		
		//Database validation
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306//openshop","root","");

		Statement createStatement = connection.createStatement();
		
		String query ="select * from customer";
		
		ResultSet executeQuery = createStatement.executeQuery(query);
		
		List<String> list= new ArrayList<String>();
	}

}

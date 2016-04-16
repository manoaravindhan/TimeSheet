/**
 * 
 */
package com.timesheet;

/**
 * @author Mano
 *
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserData{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "org.postgresql.Driver";  
		static final String DB_URL = "jdbc:postgresql://localhost:5433/timesheet";

		//  Database credentials
		static final String USER = "postgres";
		static final String PASS = "root";
	public List<UserBean> getAllUserBeans(){
		Connection connection= null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<UserBean> UserBeanList = null;
		try {
			System.out.println(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = connection.createStatement();
			String sqlQuery;
			sqlQuery = "SELECT * FROM userdata";
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()){
				UserBean UserBean = new UserBean(resultSet.getInt("empid"), resultSet.getString("empname"), resultSet.getString("project"));
	            UserBeanList = new ArrayList<UserBean>();
	            UserBeanList.add(UserBean);
		      }
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}	 	
	      return UserBeanList;
	   }
}
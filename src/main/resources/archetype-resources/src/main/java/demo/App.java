#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class App {

	public static void main (String[] args) {
		System.out.println(testRun("lol"));
		readDB();
		System.out.println(new String("hello"));

	}
	
	/*
	 * EXAMPLE OF SIMPLE FUNCTION
	 */
	public static String testRun (String input) {
		return input;
	}
	
	/*
	 * EXAMPLE OF DATABASE
	 */
	public static String readDB (){
	    String url = "";  
	    String name = "";  
	    String user = "";  
	    String password = "";
	    StringBuffer res = new StringBuffer();
	    try {
			Class.forName(name);
			Connection conn = (Connection) DriverManager.getConnection(url,user,password);
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("");
			int count = 0;
			while(rs.next()) {
				System.out.println(rs.getString(1));
				if (count == 0)
					res.append(rs.getString(1));
				else
					res.append(",").append(rs.getString(1));
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res.toString();
	}
}

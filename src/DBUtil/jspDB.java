package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Object.GymClass;
import Object.Item;

public class jspDB {
	private String jdbcURL = "jdbc:mysql://localhost:3306/JavaFP";
    private String dbUser = "root";
    private String dbPassword = "12345";
    
	public jspDB() {
		
	}
	
	public List<GymClass> getClasses() throws Exception {
		
		List<GymClass> classes = new ArrayList<>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        cn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "Select * from GymClass";/* + 
	        		"Inner Join showtimes " + 
	        		"On movies.movieID = showtimes.movieID " + 
	        		"Where showtimes.date = ? ";*/
	        ps = cn.prepareStatement(sql);
	        //ps.setString(1, date);
	        
	        rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id"); 
				String name=rs.getString("name");
				String desc=rs.getString("desc");
				String trainername=rs.getString("trainername");
				String tempDate=rs.getDate("date").toString();
				String time=Integer.toString(rs.getInt("time"));
				String spots=Integer.toString(rs.getInt("spots"));
				
				GymClass tempClass = new GymClass(id, name, desc, trainername, tempDate, time, spots);
				classes.add(tempClass);
			}
			
			return classes;
		}finally {
			close(cn,rs,ps);
		}
	}
	
public List<Item> getItems() throws Exception {
		
		List<Item> items = new ArrayList<>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        cn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "Select * from ShopItem";/* + 
	        		"Inner Join showtimes " + 
	        		"On movies.movieID = showtimes.movieID " + 
	        		"Where showtimes.date = ? ";*/
	        ps = cn.prepareStatement(sql);
	        //ps.setString(1, date);
	        
	        rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id"); 
				String name=rs.getString("name");
				Double price=Double.parseDouble(rs.getString("price"));
				int quantity=rs.getInt("quantity");
				String imgPath=rs.getString("imgPath");
				
				Item tempitem = new Item(id, name, quantity, imgPath, price);
				items.add(tempitem);
			}
			
			return items;
		}finally {
			close(cn,rs,ps);
		}
	}
	
	private void close(Connection myConn, ResultSet myrs, Statement mystmt) throws SQLException{
		// TODO Auto-generated method stub
		if(myConn!=null)
			myConn.close();
		if(myrs!=null)
			myrs.close();
		if(mystmt!=null)
			mystmt.close();
	}
}

package DBUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import Object.User;


public class DataBaseFunctions {
	private DataSource dataSource;
	
	public DataBaseFunctions(DataSource theDataSource) {
		dataSource=theDataSource;
		
	}
	
	
	private void close(Connection myConn, ResultSet myrs, Statement mystmt)
	throws SQLException{
		// TODO Auto-generated method stub
		if(myConn!=null)
			myConn.close();
		if(myrs!=null)
			myrs.close();
		if(mystmt!=null)
			mystmt.close();
	}
	
	/*Student theStudent = null;
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	int studentId;
	
	try {
		//convert Student Id to int
		studentId = Integer.parseInt(theStudentId);
		//get connection to database
		myConn = dataSource.getConnection();
		//create our sql statement
		String sql = "select * from student where id=?";
		myStmt = myConn.prepareStatement(sql);
		//set parameters
		myStmt.setInt(1, studentId);
		myRs=myStmt.executeQuery();
		
		//retrieve data from our result set row
		//.next()
		if(myRs.next()) {
			
			String firstName = myRs.getString("first_name");
			String lastName = myRs.getString("last_name");
			String email = myRs.getString("email");
			
			theStudent = new Student(studentId,firstName,lastName,email);
		}
		else {
			throw new Exception("Could not find StudentId "+studentId);
		}
		return theStudent;
	}
	finally {
		
		close(myConn,null,myStmt);
	}*/
	
	public User findUser(String username, String password)throws Exception{
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String fName;
    	String lName;
    	String userName;
    	String pwd;
    	String email;
    	int age;
    	boolean isAdmin, isTrainer; 
		
		try {
			String hashedPwd = hashThis(password);
	        cn = dataSource.getConnection();
	        String sql = "Select * from Users where username = ? AND password = ?";
	        ps= cn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, hashedPwd);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	        	fName = rs.getString("fName");
	        	lName = rs.getString("lName");
	        	userName = rs.getString("userName");
	        	pwd = rs.getString("password");
	        	age = rs.getInt("age");
	        	isAdmin = rs.getBoolean("isAdmin");
	        	isTrainer = rs.getBoolean("isTrainer");
	        	email = rs.getString("email");
	    		User user = new User(fName, lName, age, email, userName, pwd, isAdmin, isTrainer);
	    		return user;
	        }else {
	        	return null;
	        }
		}finally {
			close(cn, rs, ps);
		}
	}
	
	
	public static String hashThis(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pwd.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}

}
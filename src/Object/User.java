package Object;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	private String fName;
	private String lName;
	private String email;
	private int age;
	private String userName;
	private String hashedPassword;
	boolean isAdmin;
	boolean isTrainer;
	ArrayList<Item> cart;
	
	public User() {
		
	}
	
	public User(String fName, String lName, int age, String email, 
			String userName, String pwd, boolean isAdmin, boolean isTrainer) {
		
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.email = email;
		this.userName = userName;
		setHashedPassword(pwd);
		this.isAdmin = isAdmin;
		this.isTrainer = isTrainer;
		this.cart = new ArrayList<Item>();
		
	}

	/**
	 * @return the cart
	 */
	public ArrayList<Item> getCart() {
		return cart;
	}

	
	public void addToCart(Item item) {
		this.cart.add(item);
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * algorithm modified and taken from
	 * "https://www.geeksforgeeks.org/md5-hash-in-java/"
	 * 
	 * @param normiePassword
	 */
	public void setHashedPassword(String normiePassword) {
		this.hashedPassword = hashThis(normiePassword);

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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isTrainer() {
		return isTrainer;
	}

	public void setTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}
}

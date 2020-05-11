package model;

public class User {
	private int uId;
	private String username;
	private String password;
	private String name;
	private int role;
	
	public User(String username,String password, String name, int role) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getuId() {
		return uId;
	}
	
}

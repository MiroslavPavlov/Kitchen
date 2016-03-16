package model;

public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;

	public User(String username, String password, String firstname,String lastname, String email){
		this.firstname=firstname;
		this.lastname=lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	
	

}

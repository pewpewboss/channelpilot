package de.channelpilot.shopsystem.dtos;

public class SigninRequest {

	private String email;
	private String password;

	public SigninRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public SigninRequest(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

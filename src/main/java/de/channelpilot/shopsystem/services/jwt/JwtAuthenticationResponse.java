package de.channelpilot.shopsystem.services.jwt;

public class JwtAuthenticationResponse {

	private String jwt;
	
	public JwtAuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtAuthenticationResponse(String jwt) {
		this.setJwt(jwt);
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}

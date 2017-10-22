package model;

public class UserLoginModel {
	private String _email;
	private String _password;
	
	public UserLoginModel(String email, String password){
		this._email = email;
		this._password = password;
	}
	
	public String getEmail(){
		return this._email;
	}
	
	public String getPassword(){
		return this._password;
	}
	
	
}

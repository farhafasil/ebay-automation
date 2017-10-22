package mock;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import model.UserLoginModel;

public class UserManagerMock {
	
	private JSONArray _users;
	
	
	public UserManagerMock() throws Exception{
		InputStream userStream = UserManagerMock.class.getResourceAsStream("../data/users.json");
		String data = IOUtils.toString(userStream);
		this._users = new JSONArray(data);
	}
	
	public JSONArray getAllUsers(){
		return this._users;
	}
	
	public UserLoginModel getValidUser() throws Exception{
		for(int i=0; i<this._users.length(); i++){
			JSONObject user = this._users.getJSONObject(i);
			if(user.getBoolean("valid")){
				return new UserLoginModel(user.getString("email"), user.getString("password"));
			}
		}
		return null;
	}
	
	public UserLoginModel getInValidUser() throws Exception{
		for(int i=0; i<this._users.length(); i++){
			JSONObject user = this._users.getJSONObject(i);
			if(!user.getBoolean("valid")){
				return new UserLoginModel(user.getString("email"), user.getString("password"));
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(new UserManagerMock().getInValidUser().getEmail());
	}
	
}

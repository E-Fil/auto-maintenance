package am.android.model.dao;

import org.json.JSONObject;

import android.R.bool;

public class User {

	private Integer iduser;
	private String username;
	private String password;
	private String result;

	public User(JSONObject object) throws Exception {
		try {
			username = object.getString("username");
			password = object.getString("password");
		} catch (Exception e) {
			if (username == null) {
				throw new Exception(object.getString("ErrorMessage"));
			}
			else if (result.equals("ok"))
			{
				
			}
		}
	}
}

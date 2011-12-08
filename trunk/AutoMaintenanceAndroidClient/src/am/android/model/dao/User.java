package am.android.model.dao;

import org.json.JSONObject;

public class User {

	private String username;
	private String result;

	public User(JSONObject object) throws Exception {
		try {
			username = object.getString("username");	
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

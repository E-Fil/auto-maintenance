package am.android.screens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import am.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterScreen extends Activity {
	private EditText registerEmailAddress;
	private EditText registerPassword;
	private EditText registerConfirmPassword;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		registerEmailAddress = (EditText) findViewById(R.id.registerEmailField);
		registerPassword = (EditText) findViewById(R.id.registerPasswordField);
		registerConfirmPassword = (EditText) findViewById(R.id.registerConfirmPasswordField);
		((Button) findViewById(R.id.registerButton)).setOnClickListener(PerformRegister);
	}
	
	OnClickListener PerformRegister = new OnClickListener() {
		public void onClick(View v) {
			regButton_onClick(v);
		};
	};
	
	public void regButton_onClick(View v) {
		if (registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString())) {
			try
			{
				HttpClient hc = new DefaultHttpClient();
				HttpPost post = new HttpPost("http://e-fil.no-ip.com:8084/AutoMaintenanceJServer/index.jsp/UsersServlet");
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("action", "createUser"));
		        nameValuePairs.add(new BasicNameValuePair("user", registerEmailAddress.getText().toString()));
		        nameValuePairs.add(new BasicNameValuePair("pass", registerPassword.getText().toString()));
		        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	
				ResponseHandler<String> responseHandler=new BasicResponseHandler();
		        String responseBody = hc.execute(post, responseHandler);
		        try {
					JSONObject jsonResponse=new JSONObject(responseBody);
					if (jsonResponse.get("result").equals("ok")) {
						Toast.makeText(this, "User registered successfully!", Toast.LENGTH_LONG).show();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
				}	        
			}
			catch(IOException e)
			{ 
				e.printStackTrace();
			}
		}
		else {
			Toast.makeText(this, "Password do not match!", Toast.LENGTH_LONG).show();
		}
	}
}

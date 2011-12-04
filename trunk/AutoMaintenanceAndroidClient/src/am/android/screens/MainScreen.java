package am.android.screens;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import am.android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreen extends Activity {
	private EditText loginEmailAddress;
	private EditText loginPassword;

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        loginEmailAddress = (EditText) findViewById(R.id.loginEmailAddress);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        ((Button) findViewById(R.id.mainPageLoginButton)).setOnClickListener(Login);
        ((Button) findViewById(R.id.mainPageRegisterButton)).setOnClickListener(Register);
	}
	
	OnClickListener Login = new OnClickListener() {
		public void onClick(View v) {
			loginButton_onClick(v);
		};
	};

	public void loginButton_onClick(View v) {
		try
		{
			HttpClient hc = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://e-fil.no-ip.com:8084/AutoMaintenanceJServer/index.jsp/UsersServlet?action=login&user=" + loginEmailAddress.getText() + "&pass=" + loginPassword.getText());	
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
	        String responseBody = hc.execute(post, responseHandler);
	        
	        Intent i = new Intent(this, Screen1Screen.class);
	        i.putExtra("r", responseBody);
	        startActivity(i);
	        
		}
		catch(IOException e)
		{ 
			e.printStackTrace();
		}
	}
	
	OnClickListener Register = new OnClickListener() {
		public void onClick(View v) {
			new RegisterScreen();
		};
	};	
}

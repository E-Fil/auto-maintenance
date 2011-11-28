package am.android.screens;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import am.android.R;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreen extends BaseScreen {
	private EditText loginEmailAddress;
	private EditText loginPassword;

	public MainScreen(Activity parentActivity) {
		super(parentActivity);
        parentActivity.setContentView(R.layout.main);
        
        loginEmailAddress = (EditText) parentActivity.findViewById(R.id.loginEmailAddress);
        loginPassword = (EditText) parentActivity.findViewById(R.id.loginPassword);
        ((Button) parentActivity.findViewById(R.id.mainPageLoginButton)).setOnClickListener(Login);
        ((Button) parentActivity.findViewById(R.id.mainPageRegisterButton)).setOnClickListener(Register);
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}

	OnClickListener Login = new OnClickListener() {

		public void onClick(View v) {
			try
			{
				HttpClient hc = new DefaultHttpClient();
				HttpPost post = new HttpPost("http://e-fil.no-ip.com:8084/AutoMaintenanceJServer/index.jsp/UsersServlet?action=login&user=" + loginEmailAddress.getText() + "&pass=" + loginPassword.getText());	
				ResponseHandler<String> responseHandler=new BasicResponseHandler();
		        String responseBody = hc.execute(post, responseHandler);
		        
		        Screen1Screen ss = new Screen1Screen(parentActivity);
		        try {
					ss.populateVehicles(responseBody);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(parentActivity, e.getMessage(), Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
				
				Thread.sleep(1000);
			}
			catch(IOException e)
			{ 
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	OnClickListener Register = new OnClickListener() {

		public void onClick(View v) {
			new RegisterScreen(parentActivity);
		}
	};
	
}

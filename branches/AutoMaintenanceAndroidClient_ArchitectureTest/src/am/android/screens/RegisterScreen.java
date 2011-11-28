package am.android.screens;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import am.android.R;
import am.android.model.dao.User;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterScreen extends BaseScreen {
	private EditText registerEmailAddress;
	private EditText registerPassword;

	public RegisterScreen(Activity parentActivity) {
		super(parentActivity);
		parentActivity.setContentView(R.layout.register);
		registerEmailAddress = (EditText) parentActivity.findViewById(R.id.registerEmailField);
		registerPassword = (EditText) parentActivity.findViewById(R.id.registerPasswordField);
		((Button) parentActivity.findViewById(R.id.registerButton)).setOnClickListener(PerformRegister);
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}

	OnClickListener PerformRegister = new OnClickListener() {
		
		public void onClick(View v) {
			try
			{
				HttpClient hc = new DefaultHttpClient();
				HttpPost post = new HttpPost("http://e-fil.no-ip.com:8084/AutoMaintenanceJServer/index.jsp/UsersServlet?action=createUser&user=" + registerEmailAddress.getText() + "&pass=" + registerPassword.getText());
	
				ResponseHandler<String> responseHandler=new BasicResponseHandler();
		        String responseBody = hc.execute(post, responseHandler);
		        try {
					JSONObject jsonResponse=new JSONObject(responseBody);
					new User(jsonResponse);
					parentActivity.setContentView(R.layout.screen1);
				} catch (Exception e) {	
					// TODO Auto-generated catch block
					Toast.makeText(parentActivity, e.getMessage(), Toast.LENGTH_LONG).show();
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
	
}

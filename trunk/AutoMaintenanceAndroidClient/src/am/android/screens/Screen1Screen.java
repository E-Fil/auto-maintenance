package am.android.screens;

import org.json.JSONException;
import org.json.JSONObject;

import am.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Screen1Screen extends Activity {
	private TextView carName;
	private TextView licensePlate;
	private TextView ownership;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Intent i = getIntent();
		String responseBody = getIntent().getStringExtra("r");
		JSONObject jsonResponse;
		try {
			jsonResponse = new JSONObject(responseBody);
			//new User(jsonResponse);
			setContentView(R.layout.screen1);
	        carName = (TextView) findViewById(R.id.nameValue);
	        licensePlate = (TextView) findViewById(R.id.licensePlateValue);
	        ownership = (TextView) findViewById(R.id.ownershipValue);
			carName.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("vehicle").getString("description"));
			licensePlate.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("vehicle").getString("lic_plate_number"));
			ownership.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("accessType").getString("name"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

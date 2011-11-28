package am.android.screens;

import org.json.JSONObject;

import am.android.R;
import android.app.Activity;
import android.widget.TextView;

public class Screen1Screen extends BaseScreen {
	private TextView carName;
	private TextView licensePlate;
	private TextView ownership;
		

	public Screen1Screen(Activity parentActivity) {
		super(parentActivity);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void populateVehicles(String responseBody) throws Exception {
		JSONObject jsonResponse=new JSONObject(responseBody);
		//new User(jsonResponse);
		parentActivity.setContentView(R.layout.screen1);
        carName = (TextView) parentActivity.findViewById(R.id.nameValue);
        licensePlate = (TextView) parentActivity.findViewById(R.id.licensePlateValue);
        ownership = (TextView) parentActivity.findViewById(R.id.ownershipValue);
		carName.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("vehicle").getString("description"));
		licensePlate.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("vehicle").getString("lic_plate_number"));
		ownership.setText(jsonResponse.getJSONArray("vehicles").getJSONObject(0).getJSONObject("accessType").getString("name"));
		
		
	}

}

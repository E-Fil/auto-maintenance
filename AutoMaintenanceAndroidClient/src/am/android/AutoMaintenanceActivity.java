package am.android;

import am.android.screens.MainScreen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AutoMaintenanceActivity extends Activity {
	
	public void onContentChanged() {	
		
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainScreen.class));
    }
}
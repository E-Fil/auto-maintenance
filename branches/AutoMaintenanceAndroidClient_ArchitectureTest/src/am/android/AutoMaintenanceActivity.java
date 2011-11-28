package am.android;

import am.android.screens.MainScreen;
import android.app.Activity;
import android.os.Bundle;

public class AutoMaintenanceActivity extends Activity {
	
	public void onContentChanged() {
		
		
		
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MainScreen(this);
    }
}
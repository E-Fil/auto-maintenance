package am.android.screens;

import android.app.Activity;

public abstract class BaseScreen {
	Activity parentActivity;
	public BaseScreen(Activity parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	protected abstract void init();
	
	protected abstract void destroy();
}

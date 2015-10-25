package cz.united121.rxandroid;

import android.app.Application;
import android.content.Context;

/**
 * TODO add class description
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public class RxAndroid extends Application {
	public static final String TAG = RxAndroid.class.getName();

	public static RxAndroid sRxAndroid;

	public static Context getAppContext() {
		return sRxAndroid.getApplicationContext();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		sRxAndroid = this;
	}
}

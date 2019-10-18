package uk.co.navigators.encounters;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.provider.*;

public class Prefs extends PreferenceActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// 160329: Implement this method
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
}

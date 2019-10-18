package uk.co.navigators.encounters;

import android.app.Activity;
import android.os.Bundle;
import android.os.*;
import android.content.Intent;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ScrollView;



public class About extends Activity
{
	ScrollView av;
	TextView aboutcontent;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		//get parameter - row clicked by user
		Intent myIntent = getIntent(); // gets the previously created intent
		String tour_row = myIntent.getStringExtra("tour_row"); // will return "FirstKeyValue"
		if (tour_row.length()!=0) {
			//av=(TextView)findViewById(R.id.about_content);
			aboutcontent = (TextView) findViewById(R.id.about_content);
			aboutcontent.setText(tour_row);
		}		
	}
}

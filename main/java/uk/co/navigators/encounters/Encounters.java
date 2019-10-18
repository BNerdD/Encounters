package uk.co.navigators.encounters;

import android.app.*;
import android.os.*;
// Start EncounterCard and About Activities
import android.content.Intent;
// Create a Settings menu
import android.view.View;
import android.widget.ExpandableListView.*;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
// 160331 New Encounters Dialog
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;




public class Encounters extends Activity implements OnClickListener {

    
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		//relativeLayout.setBackgroundResource(R.drawable/britishmuseum_court); 
		
		//Set up a listener for all the buttons
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		//View newButton = findViewById(R.id.new_button);
		//newButton.setOnClickListener(this);
		//View aboutButton = findViewById(R.id.about_button);
		//aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);

    }

	@Override
	public void onClick(View v)
	{
		// 160329: Implement this method
		switch(v.getId()) {
			case R.id.continue_button:
			    Intent i = new Intent(this, EncounterViews.class);
				startActivity(i);
				break;
			/*
				case R.id.about_button:
				Intent j = new Intent(this, About.class);
				startActivity(j);
				break;
				// 160331 New encounters dialog
			case R.id.new_button:
				openNewEncounterDialog();
				break;
				// 160331 Exit button - just to be clean
			*/
				case R.id.exit_button:
				finish();
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// 160329: Implement this method
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// 160329: Implement this method
		switch (item.getItemId()) {
			case R.id.settings:
				startActivity(new Intent(this, Prefs.class));
				return true;
		}
		return false;
	}

	// 160331 New Encounters Dialog method
	private static final String TAG = "Encounter";

	private void openNewEncounterDialog() {
		new AlertDialog.Builder(this)
			.setTitle(R.string.new_encounter_title)
			.setItems(R.array.encounters,
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialoginterface,int i) {
					startEncounter(i);
				}
			})
			.show();
	}

	private void startEncounter(int i) {
		Log.d(TAG, "Clicked on "+i);
		//Start Encounter here

	}
    
}


package uk.co.navigators.encounters;

import android.app.*;
import android.os.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.EditText;
import java.sql.*;
import android.database.sqlite.*;
import android.content.Intent; 

//Imports for SQLite
import static uk.co.navigators.encounters.Constants.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class EncounterViewDetail extends Activity  {

	ScrollView dv;
	TextView detailitem;
	TextView detailheading;
	TextView detailname;
	TextView detailtext;
	TextView detailreference;
	EditText detailnotes;
	ImageView detailphoto;
	EncounterViewTour tour;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tourdetail);
		
		dv=(ScrollView)findViewById(R.id.dv);
		detailname = (TextView) findViewById(R.id.detail_name);
		detailitem = (TextView) findViewById(R.id.detail_item);
		detailheading = (TextView) findViewById(R.id.detail_heading);
		detailreference = (TextView) findViewById(R.id.detail_reference);
		detailtext = (TextView) findViewById(R.id.detail_text);
		detailnotes = (EditText) findViewById(R.id.detail_notes);
		detailphoto = (ImageView) findViewById(R.id.detail_photo);
	
		//get parameter - row clicked by user
		Intent myIntent = getIntent(); // gets the previously created intent
		String tour_row = myIntent.getStringExtra("tour_row"); // will return "FirstKeyValue"
	
		//Retrieve database connection and the tour row to display and amend
		CardData cards = new CardData(this);
		//retrieve data from database uses a try and catch
		SQLiteDatabase dbr = cards.getReadableDatabase();
		Cursor cursor = cards.getRow(dbr, tour_row);
		startManagingCursor(cursor);
	
		
		tour = new EncounterViewTour(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6));
		
			
		detailitem.setText(tour_row);
        /*
		detailheading.setText(tour.heading);
        detailname.setText(tour.name);
        detailtext.setText(tour.text);
        detailreference.setText(tour.reference);
        detailnotes.setText(tour.notes);
        detailphoto.setImageResource(tour.photoId);
*/		
		//	SQLiteDatabase dbw = cards.getWritableDatabase();
		//	cards.updateRow(dbw, );
		}
		
	
	
}


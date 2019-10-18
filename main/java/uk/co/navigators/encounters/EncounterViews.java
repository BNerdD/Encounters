package uk.co.navigators.encounters;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.CardView;
//import android.support.v7.widget.LinearLayoutManager;
import androidx.appcompat.StaggeredGridLayoutManager;
import androidx.appcompat.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.appcompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

//Imports for SQLite
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


// 160403 A new activity screen registeted in manifest to put up a new RecyclerView card list filled with a study
// Called from Encounters class only
// At the time of writing, less than 2% of Android devices run Android Lollipop.However, thanks to the v7 Support Library, you can use the RecyclerView andCardView widgets on devices that run older versions of Android by adding thefollowing lines to the dependencies section in your project's build.grade file:2. Creating a CardView A CardView is a ViewGroup. Like any other ViewGroup, it can be added to yourActivity or Fragment using a layout XML file. To create an empty CardView, you would have to add the following code to yourlayout XML as shown in the following snippet:As a more realistic example, let us now create a LinearLayout and place aCardView inside it. The CardView could represent, for example, a person andcontain the following: 12compile 'com.android.support:cardview-v7:21.0.+'compile 'com.android.support:recyclerview-v7:21.0.+'
public class EncounterViews extends AppCompatActivity {

    private List<EncounterViewTour> tour;
    private RecyclerView rv;
	private CardData cards;
	private StaggeredGridLayoutManager mStaggeredLayoutManager;
	private boolean isListView;
	private Menu tmenu;
	private Toolbar toolbar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);
		
		//Add a toggle on the action bar to toggle grid size
		// NB need this in manifest android:theme="@android:style/Theme.WithActionBar" >
		//toolbar = (Toolbar) findViewById(R.id.toolbar);
		setUpActionBar();
		
		// Unlike a ListView, a RecyclerView needs a LayoutManager to manage the positioning of its items. 
		// You could define your own LayoutManager by extending the RecyclerView.LayoutManager class. 
		// However, in most cases, you could simply use one of the predefined LayoutManager subclasses: LinearLayoutManager GridLayoutManager StaggeredGridLayoutManager 
		// In this tutorial, I am going to use a LinearLayoutManager. 
		// This LayoutManager subclass will, by default, make your RecyclerView look like aListView. 
		//LinearLayoutManager llm = new LinearLayoutManager(this);
		mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
		rv.setLayoutManager(mStaggeredLayoutManager);
        
		// IMPORTANT!!! If you are sure that the size of the RecyclerView won't be changing, 
		// you can addthe following to improve performance:
		rv.setHasFixedSize(true);		
		
        // A method below for filling our Tour/Encounter CardView array list with data
		// using SQLite
		// Create the database if it not already there
		cards = new CardData(this);
		//retrieve data from database uses a try and catch
		SQLiteDatabase dbr = cards.getReadableDatabase();
		Cursor cursor = cards.getData(dbr);
		//Check if cursor is empty, if so add
		if (cursor.getCount()==0) {
			SQLiteDatabase dbw = cards.getWritableDatabase();
			cards.addData(dbw);
			//cursor = cards.getData(dbr);
		}
		// Tell the Activity to manage query, it will handle closing and requerying as needed
		startManagingCursor(cursor);
		
			
		//populate views with card data
		initializeData(cursor);
		
		// A method below to iniialise our modified adapter and start it running
		// Adapter fills screen with data
		
		initializeAdapter();
	}

	private void setUpActionBar() {
		// for some reason this fails when toolbar is set in oncreate
		if (toolbar != null) {
			setActionBar(toolbar);
			getActionBar().setDisplayHomeAsUpEnabled(false);
			getActionBar().setDisplayShowTitleEnabled(true);
			getActionBar().setElevation(7);
		}
		isListView=true;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu tmenu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, tmenu);
		this.tmenu = tmenu;
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_toggle) {
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void toggle() {
		MenuItem item = tmenu.findItem(R.id.action_toggle);
		if (isListView) {
			mStaggeredLayoutManager.setSpanCount(2);
			item.setIcon(R.drawable.ic_action_list);
			item.setTitle("Show as list");
			isListView = false;
		} else {
			mStaggeredLayoutManager.setSpanCount(1);
			item.setIcon(R.drawable.ic_action_grid);
			item.setTitle("Show as grid");
			isListView = true;
		}
	}
	
			
	//Fill the card views with data from the Cards database table
    private void initializeData(Cursor cursor){
        tour = new ArrayList<>();
		//tour.add(new EncounterViewTour("1", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
		//tour.add(new EncounterViewTour("2", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
		//tour.add(new EncounterViewTour("3", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
		
		while (cursor.moveToNext()) {
			tour.add(new EncounterViewTour(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6)));
		}
	}

    // See comments in RVAdapter.java
	// Once  the  adapter  is  ready, initialize and  then start  our version of the  adapter  
	// by  calling  the  adapter's  constructor  and  the RecyclerView's setAdapter method:
	private void initializeAdapter(){
        // Create the Adapter with our apps people list
		RVAdapter adapter = new RVAdapter(tour);
        // Run the adapter fill screen with data
		rv.setAdapter(adapter);
		adapter.setOnItemClickListener(onItemClickListener);
		
    }

	RVAdapter.OnItemClickListener onItemClickListener = new RVAdapter.OnItemClickListener() { 
		@Override 
		public void onItemClick(View v, int position) { 
			Intent myIntent = new Intent(EncounterViews.this, About.class);
			myIntent.putExtra("tour_row",tour.get(position).text);
			startActivity(myIntent);
		} 
	};			
}


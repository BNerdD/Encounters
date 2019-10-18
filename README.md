# Encounters
A simple Android App to walk people through a tour of artefacts in the British Museum.
The tour asks the question 'How far back into the Old Testament story can we walk and touch artefacts on display in the museum?'
The App was built for an earlier version of Android using CardViews and RecyclerViews.

Design:
  The Encounters.class sets up an initial arrivals activity view with 2 buttons options and a menu
  
    1. Enter the British Museum - Starts the Activity from EncounterViews.class
    
    2. Exit the Encounters App
    
    3. A menu option bar is inflated to allow The Prefs class to offer settings and then two options to be set/unset.
   
  The EncounterViews.class to put up a new RecyclerView card list filled with all museum tour artefacts - Called from Encounters class only
    1. sets up an actionbar to toggle between card layout views - StaggeredGridLayoutManager show as grid or show as list
    2. Sets up a recycler view adapter within a linearLayout view
    3. Fill our Tour/Encounter CardView array list with data using SQLite
		Create the database if it not already there - cards = new CardData(this);
		Retrieve data from database uses a try and catch - SQLiteDatabase dbr = cards.getReadableDatabase();
  		Tell the Activity to manage query, it will handle closing and requerying as needed - startManagingCursor(cursor);
		Populate views with card data -  initializeData(cursor);
	      	The adapter holds a tour.class that contains a list of EncounterViewTour.class items 
              		tour.add(new EncounterViewTour("1", "Room 70 Case 27 Coin 3", "26-36AD", "image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
			tour.add(new EncounterViewTour("2", "Room 70 Case 27 Coin 3", "26-36AD", "image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
        Initialise our modified adapter and start it running, Adapter fills screen with data - initializeAdapter();
    4. Set up an onclick intent for the RecyclerView adapter 
      if the tour artefact is clicked the About.class activity is called with the rowid to display addition details of the artefact

The RVadapter.class builds a dynamic layout made up of LinearLayouts and textviews
  	placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
	nameHolder = (LinearLayout) itemView.findViewById(R.id.nameHolder);
	headingHolder = (LinearLayout) itemView.findViewById(R.id.headingHolder);
	touritem = (TextView)itemView.findViewById(R.id.tour_item);
        tourheading = (TextView)itemView.findViewById(R.id.tour_heading);
        tourname = (TextView)itemView.findViewById(R.id.tour_name);
        tourreference = (TextView)itemView.findViewById(R.id.tour_reference);
        //tournotes = (TextView)itemView.findViewById(R.id.tour_notes);
        tourphoto = (ImageView)itemView.findViewById(R.id.tour_photo);
  
  The EncounterViewTour.class simply defines a 'row' of artefact data:
        EncounterViewTour(String item, String heading, String name, String text, String reference,  String notes, int photoId) {
            this.item = item;
            this.heading = heading;
	    this.name = name;
	    this.text = text;
	    this.reference = reference; 
	    this.notes = notes;
            this.photoId = photoId;
	
  The CardView.class just handles the sqllite table creation, loading hardcoded data into tables and querying back of data.
      db.execSQL("CREATE TABLE " + tEncCards + " (" 
		    	+ cEC_ID      	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			    + cEC_Heading 	+ " TEXT NOT NULL, "
			    + cEC_Name 		+ " TEXT, "
			    + cEC_Text 		+ " TEXT, "
			    + cEC_Reference + " TEXT, "
	 	      + cEC_Notes 	+ " TEXT, "
			    + cEC_PhotoId   + " INTEGER NOT NULL);");

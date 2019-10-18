package uk.co.navigators.encounters;
import java.util.*;

// Used in EncounterCard Activity and RVAdapter class and xml/tour_data.xml
class EncounterViewTour {
    String item;	//auto generated key
	String heading;  //room no
	String name;	//title of exhibit 
	String text;	//including year 
	String reference; //Bible reference
	String notes;	//for the user to edit
    int photoId;

    EncounterViewTour(String item, String heading, String name, String text, String reference,  String notes, int photoId) {
        this.item = item;
        this.heading = heading;
		this.name = name;
		this.text = text;
		this.reference = reference; 
		this.notes = notes;
        this.photoId = photoId;
    }


	private List<EncounterViewTour> tour;

// This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
// Room 70: Roman Empire 26-36 AD Case 27 No3 Coin - ‘Inflammatory image’ Pontius Pilate (p105) John 19:12 You are no friend of Caesar
//	private void initializeData(){
//		tour = new ArrayList<>();
//		tour.add(new EncounterViewTour("1", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
//		tour.add(new EncounterViewTour("2", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
//		tour.add(new EncounterViewTour("3", "Room 70 Case 27 Coin 3", "26-36AD", "Inflammatory image - Pontius Pilate", "John 19:12", "Enter notes here...", R.drawable.emma));
//	}

}


package uk.co.navigators.encounters;

import android.provider.BaseColumns;

//160412 SqlLite implementation for CardView data

public interface Constants extends BaseColumns {

	//Database name
	String DATABASE_NAME = "encounters.db";
	int DATABASE_VERSION = 16;
	
	//Table Names
	String tEncTypes = "encounter_types";
	String tEncCards = "encounter_cards";
	String tEncItems = "encounter_items";
	
	//tEncTypes Column Names - "Museum Tour"
	String cET_Id = "et_id";
	String cET_Name = "et_name";
	
	//tEncCards Column Names - "Room 1"
	//public static final String cEC_ET_ID = "ec_et_id";
	String cEC_ID = "ec_id";
	String cEC_Heading = "ec_heading";
	String cEC_Name = "ec_name";
	String cEC_Text = "ec_text";
	String cEC_Reference = "ec_reference";
	String cEC_Notes = "ec_notes";
	String cEC_PhotoId = "ec_photoid";
	
	
	
}

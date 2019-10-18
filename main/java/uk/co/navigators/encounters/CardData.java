package uk.co.navigators.encounters;

import static uk.co.navigators.encounters.Constants.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Imports for adding and getting data
import android.content.ContentValues;
import android.database.Cursor;


//160412 Create and update database - provide the context cursor into the database


public class CardData extends SQLiteOpenHelper {

	//Create a Helper Object to handle data via the cursor context
	public CardData(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**   
	 */
	// 160412 Called by SQLiteOpenHelper if the database does not exist.
	@Override
	public void onCreate() {
		onCreate();
	}

	/**
	 * @param db 
	 */
	// 160412 Called by SQLiteOpenHelper if the database does not exist.
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		//db.execSQL("CREATE TABLE " + tEncTypes + " (" 
		//	+ cET_Id   + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
		//	+ cET_Name + " TEXT NOT NULL);");
		//NB the primary key needs to include the foreign key
		db.execSQL("CREATE TABLE " + tEncCards + " (" 
			+ cEC_ID      	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ cEC_Heading 	+ " TEXT NOT NULL, "
			+ cEC_Name 		+ " TEXT, "
			+ cEC_Text 		+ " TEXT, "
			+ cEC_Reference + " TEXT, "
	 	    + cEC_Notes 	+ " TEXT, "
			+ cEC_PhotoId   + " INTEGER NOT NULL);");
		//System.out.println("onCreate");
	}
	
	// Called automatically by android when it notices a change in version number
	// 160412 Dirty upgrade just drops old tables and recreates new tables
	// Better to do an alter table
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//db.execSQL("DROP TABLE IF EXISTS " + tEncTypes);
		db.execSQL("DROP TABLE IF EXISTS " + tEncCards);
		
		onCreate(db);
	}

	private static String[] COLS = {cEC_ID, cEC_Heading, cEC_Name, cEC_Text, cEC_Reference, cEC_Notes, cEC_PhotoId};
	private static String ORDER_BY = cEC_ID + " ASC";
	public Cursor getData(SQLiteDatabase db) {

		Cursor cursor = db.query(tEncCards, COLS, null, null, null, null, ORDER_BY);
		//System.out.println("getdata");
		
		return cursor;
	}
	public Cursor getRow(SQLiteDatabase db, String tour_row) {

		Cursor cursor = db.query(tEncCards, 
								 COLS, 
								 cEC_ID+" = "+tour_row, 
								 null, 
								 null, 
								 null, ORDER_BY);
		return cursor;
	}
	
	public void addData(SQLiteDatabase db) {

		try {
			ContentValues values = new ContentValues();
			//db.beginTransaction();
			
			values.put(cEC_Heading, "Room 70 (P104)");
			values.put(cEC_Name, "Pontius Pilate Inflammatory Coin");
			values.put(cEC_Text, "www.biblegateway.com/passage?search=John+19%3A12\n\nPilate inflames Jewish Riots - During his ten years in office, according to Josephus, Pilate was far from the worst Roman governor the Jews had seen, but he managed, deliberately or no, to provoke several bloody skirmishes with religious Jews who resented, for example, his bringing Roman standards, which had pagan sacral associations, into the holy city of Jerusalem. In 36, Tiberius recalled Pilate to Rome, after Pilate’s troops massacred a crowd of followers of a Samaritan prophet.");
			values.put(cEC_Reference, "Jesus Period - 30-31AD - John 19:12");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.pilate_coin);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 59 (P99)");
			values.put(cEC_Name, "Bad Edh-Dhra Possible site of Sodom");
			values.put(cEC_Text, "www.biblegateway.com/passage?search=Genesis+13%3A12\n\nIdentified by many scholars as the site of biblical Sodom - finally abandoned in 2100BC");
			values.put(cEC_Reference, "Patriarch's Period - 2100BC - Genesis 13:12");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.fig3_bab_edh_dhra);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 57 (P97)");
			values.put(cEC_Name, "Amarna Tablets");
			values.put(cEC_Text, "www.biblegateway.com/passage?search=Joshua+13%3A1-5\n\nClay tablet inscribed in Babylonian cuneiform; letter from the ruler Yapahu of Gezer to the Egyptian pharaoh Amenhotep III or Amenhotep IV (Akhenaten), including a request for help against marauders named as Hapiru (the Biblical Hebrews), a group known in the Near East since the early 2nd millennium BC as raiders, mercenaries and labourers, and later as simply dispossessed and homeless people; 4+4 columns?; 26 lines; complete. - Quote British Museum \n\nhttp://www.britishmuseum.org/research/collection_online/collection_object_details.aspx?objectId=327261&partId=1&place=35484&object=20008&museumno=29832&page=1");
			values.put(cEC_Reference, "Judges Period - 1340-1404BC - Joshua 13:1-5");
			values.put(cEC_Notes, "From Abdi-Heba, mayor of Jerusalem to king Pharaoh: The Habiru have taken all the cities. Not a single mayor remains. Turbazu & Yaptih-Hadda were slain in the city gate of Silu (Shiloh). Habiru killed Zimredda of Lachish The king did nothing. Why? Amarna Letter EA288");
			values.put(cEC_PhotoId, R.drawable.amana_gezer);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 57 (P93-4)");
			values.put(cEC_Name, "Nebuchadnezzar - Lachish Letter II");
			values.put(cEC_Text, "Jeremiah 34:7 - A hastily scribbled message: May YHWH cause my lord to hear news of peace, even now, even now... from an Jewish outpost to Lachish Commander as Babylonian army advances on Jerusalem. \n\nhttp://www.britishmuseum.org/research/collection_online/collection_object_details.aspx?objectId=364095&partId=1&place=35484&object=20008&museumno=125702&page=1");
			values.put(cEC_Reference, "Kings Period - 587BC - Jeremiah 34:7");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.lachish_yhwh);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 57 (P92)");
			values.put(cEC_Name, "Hezekiah – Shebna's Tomb Lintel");
			values.put(cEC_Text, "Isaiah 22:15-19: Three line Hebrew funerary inscription from the entrance of a tomb which may have contained the remains of Shebna, the royal steward of King Hezekiah; much damaged. \n\nhttp://www.britishmuseum.org/research/collection_online/collection_object_details/collection_image_gallery.aspx?partid=1&assetid=29403001&objectid=369626");
			values.put(cEC_Reference, "Kings Period - 700BC - Isaiah 22:15-19");
			values.put(cEC_Notes, "See Shebna seal - Limestone seal from Lachish.");
			values.put(cEC_PhotoId, R.drawable.shebna);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 56 (P79)");
			values.put(cEC_Name, "Culture – Teaching Tablet");
			values.put(cEC_Text, "Genesis 13:12: Literacy in Abraham's times - school tablet with proverb; this is the teacher's version; the pupil's copy is on the other side.");
			values.put(cEC_Reference, "Patriarch's Period - 1700BC - Genesis 13:12");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.r56_early_teaching);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 55 (P66)");
			values.put(cEC_Name, "Nabonidus Chronicle");
			values.put(cEC_Text, "Daniel 5:1,29 - The chronicle goes on to describe in several entries the self-imposed exile of Nabonidus in the Arabian oasis of Tema (mentioned as Teiman in Hebrew in the Dead Sea Scrolls fragment 4Q242 known as the Testimony of Nebonidus dated to 150 BC.[10][11] and the disruption that this caused to the Akitu (New Year) festival for a period of ten years. The king spent ten years in Arabia and left Babylonia administered by his son");
			values.put(cEC_Reference, "Exile Period - 539BC - Daniel 5:1,29");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.nabonidus_away);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 55 (P68)");
			values.put(cEC_Name, "Nabonidus Cylinder");
			values.put(cEC_Text, "Daniel 5:1,29 - Complete clay cylinder, of Nabonidus, 2 columns of inscription, 26 lines, Late Babylonian; describes work on the temple of the moon god Sin at Ur by Nabonidus and includes a prayer for the king himself and Belshazzar, his son.");
			values.put(cEC_Reference, "Exile Period - 539BC - Daniel 5:1,29");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.nabonidus_belshazzar);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 55 (P65)");
			values.put(cEC_Name, "Tablet of Chief Eunuch of Nebuchadnezzar II");
			values.put(cEC_Text, "Jeremiah 39:3 - Nebo-Sarsekim (Nabu-sharussu-ukin) Clay tablet with six and one and four lines of inscription; Late Babylonian; administrative. The tablet gives the name and title of a high-ranking Babylonian officer who, according to Jeremiah, was present at the historic siege of Jerusalem in 587 BC with King Nebuchadnezzar II himself.");
			values.put(cEC_Reference, "Kings Period - 587BC - Jeremiah 39:3");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.nebo_sarsekin_jer39_3);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 55 (P72)");
			values.put(cEC_Name, "Hezekiah - Taylor Prism");
			values.put(cEC_Text, "2 Kings 18:13-15 - Sennacherib records that he shut up Hezekiah in his royal city 'like a caged bird' - 'The terrifying splendour of my majesty overcame Hezekiah' The king then lists the tribute that Hezekiah sent to him.");
			values.put(cEC_Reference, "Kings Period - 701BC - 2 Kings 18:13-15");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.taylor_prism);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 52 (P56)");
			values.put(cEC_Name, "Cyrus Cylinder");
			values.put(cEC_Text, "2 Chronicles 36:23 - On the cylinder Cyrus declares that he repaired the ruined temples in the cities he conquered, restored their cults, and returned their sacred images as well as their former inhabitants, which Nabonidus had taken to Babylon. 2 Chronicles 36:23 says 'King of Persia Cyrus declaration This is what Cyrus king of Persia says: The Lord, the God of heaven, has given me all the kingdoms of the earth and he has appointed me to build a temple for him at Jerusalem in Judah. Any of his people among you may go up, and may the Lord their God be with them.");
			values.put(cEC_Reference, "Exile Period - 539BC - 2 Chronicles 36:23");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.cyrus_cylinder);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 4 (P46)");
			values.put(cEC_Name, "Rosetta Stone and King Taharqa");
			values.put(cEC_Text, "2 Kings 19:9 - Hezekiah is rescued by Tirhakah king of Cush - doubted as historic until Rosetta stone, NB also Ramesses II statue.");
			values.put(cEC_Reference, "Kings Period - 700BC - 2 Kings 19:9");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.taharqa_rosetta2k19_9);
			db.insertOrThrow(tEncCards, null, values);

			values.put(cEC_Heading, "Room 4 (P44)");
			values.put(cEC_Name, "4 Missing Shamed Kings");
			values.put(cEC_Text, "Exodus 12:31 - The 4 kings of the Exodus period are missing from this list including Tutankhamun and Akhenaten - wiped from Egypts history for worshiping one God at Amarna.");
			values.put(cEC_Reference, "Exodus Period - 1250BC - Exodus 12:41");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.missing4pharoahs);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 4 (P47)");
			values.put(cEC_Name, "Ramesses II Mud Brick (not on display)");
			values.put(cEC_Text, "Exodus 5:5-6 - Tuthmosis is probably the Pharoah of Israel's slavery. Though probably 200yrs after the exodus - Ramesses is still making bricks with straw.");
			values.put(cEC_Reference, "Exodus Period - 1250BC - Exodus 5:5-6");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.ramesses_ii_straw_brick);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 10c (P32)");
			values.put(cEC_Name, "Shalmaneser,Sargon and Sennacherib");
			values.put(cEC_Text, "2 Kings 18:9-15 - Sargon mentioned in Isaiah 20:1 takes over the seige of Samaria from Shalmaneser V and records repopulating Samaria with other people. Sennacherib records his tribute Hezekiah pays in 2 Kings 18:13-15");
			values.put(cEC_Reference, "Kings Period - 721-701BC - 2 Kings 18:9-15");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.gypsum_slab_samaria);
			db.insertOrThrow(tEncCards, null, values);
	
			values.put(cEC_Heading, "Room 10b (P32)");
			values.put(cEC_Name, "Sennacharib - Seige of Lachish");
			values.put(cEC_Text, "2 Kings 18-19 - The burial tomb walls celebrating Sennacharib taking the 2nd city in Judah - there is no celebration of the fall of Jerusalem the 1st city");
			values.put(cEC_Reference, "Kings Period - 701BC - 2 Kings 18-19");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.lachish_reliefs);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 6 (P28)");
			values.put(cEC_Name, "The Kurkh Stela");
			values.put(cEC_Text, "2 Kings 6:24 - Shalmaneser III - (NB not V) Writing describes Ben Hadad and military campaigns around 853BC Though not mentioned in the Bible directly the reverse side refers to Ahab the Israelite and claims Ahabs army had 2,000 chariots and 10,000 infantry");
			values.put(cEC_Reference, "Kings Period - 853BC - 2 Kings 6:24");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.kurkh_stela);
			db.insertOrThrow(tEncCards, null, values);
			
			values.put(cEC_Heading, "Room 6 (P27)");
			values.put(cEC_Name, "The Black Obelisk");
			values.put(cEC_Text, "2 Kings 8:7-15 - Shalmaneser III - Black limestone obelisk of Shalmaneser III; glorifies achievements of king and minister; inscription; illustrations show tribute from all directions; tribute bearers in five rows, identified by captions; each row has four panels, one on each side of the obelisk; 1. Gilzanu (North West Iran) tribute includes horses; 2. House of Omri (Ancient Israel- tribute from Biblical King Jehu 841BC); 3. Musri, or Egypt tribute or gift of elephant, ape and other exotic animals; 4. Suhi on the Euphrates, scene of animal hunting; 5. Patina in Southern Turkey.");
			values.put(cEC_Reference, "Kings Period - 841BC - 2 Kings 6:24");
			values.put(cEC_Notes, "Enter notes here...");
			values.put(cEC_PhotoId, R.drawable.kurkh_stela);
			db.insertOrThrow(tEncCards, null, values);

            //db.endTransaction();
            // core dump db.setTransactionSuccessful();
			db.close();
		} finally {
				//System.out.println("finally");
				db.close();
			}
			
	}
}

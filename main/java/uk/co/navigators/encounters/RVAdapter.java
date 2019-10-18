package uk.co.navigators.encounters;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;


import java.util.List;

// To create an adapter that a RecyclerView can use, you must extend RecyclerView.Adapter. 
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TourViewHolder> {

	OnItemClickListener mItemClickListener;
	
    // This adapter follows the view holder design pattern, which means that 
	// it is up to you to define a custom personviewholder class that extends RecyclerView.ViewHolder. 
	public class TourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		
        CardView cv;
        TextView touritem;
        TextView tourheading;
        TextView tourname;
		TextView tourtext;
		TextView tourreference;
        TextView tournotes;
        ImageView tourphoto;
		public LinearLayout placeHolder;
		public LinearLayout nameHolder;
		public LinearLayout headingHolder;

		
		// Formatting for CardView
		//float corner=(float) 10.2;
		
		

        // Constructor for personviewholder
		// This pattern minimizes the number of calls to the costly findViewById method. 
		TourViewHolder(View itemView) {
            //Run all the default stuff then our own code..
			super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
			//cv.setRadius(corner);
			//cv.setCardElevation(corner);
		
			placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
			nameHolder = (LinearLayout) itemView.findViewById(R.id.nameHolder);
			headingHolder = (LinearLayout) itemView.findViewById(R.id.headingHolder);
			touritem = (TextView)itemView.findViewById(R.id.tour_item);
            tourheading = (TextView)itemView.findViewById(R.id.tour_heading);
            tourname = (TextView)itemView.findViewById(R.id.tour_name);
            tourreference = (TextView)itemView.findViewById(R.id.tour_reference);
            //tournotes = (TextView)itemView.findViewById(R.id.tour_notes);
            tourphoto = (ImageView)itemView.findViewById(R.id.tour_photo);

			// 160414 implement click on recyclerview
			placeHolder.setOnClickListener(this);
		}

		// 160414 implement click on recyclerview
		@Override
		public void onClick(View v) {
			if (mItemClickListener != null) {
				mItemClickListener.onItemClick(itemView, getPosition());
			}
		}

	}
	// 160414 implement click on recyclerview
	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}

	// 160414 implement click on recyclerview
	public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
		this.mItemClickListener = mItemClickListener;
	}
	
    // We are using a list of the persons class
	List<EncounterViewTour> tour;

	// Add a class constructor to the custom adapter 
	// Tell the adapter we are using a list of persons
	// so that it has a handle to the data that the RecyclerView displays. 
    RVAdapter(List<EncounterViewTour> tour){
        this.tour = tour;
    }

    // RecyclerView.Adapter has four abstract methods that we must override.
	
	// just run all the default stuff for this method
	@Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // When the next view in the list needs to be displayed...
	// then inflate a new person view holder (for this adapter)
	@Override
    public TourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tour, viewGroup, false);
        TourViewHolder pvh = new TourViewHolder(v);
        return pvh;
    }
    
	// Override the onBindViewHolder to specify the contents of each item of theRecyclerView. 
	// This method is very similar to the getView method of a ListView's adapter. 
	// Create the initial list and then when the next view in the list needs to be displayed...
	// Add the people details into the new view of the person
    @Override
    public void onBindViewHolder(TourViewHolder tourViewHolder, int i) {
       
		tourViewHolder.touritem.setText(tour.get(i).item);
        tourViewHolder.tourheading.setText(tour.get(i).heading);
        tourViewHolder.tourname.setText(tour.get(i).name);
        //tourViewHolder.tourtext.setText(tour.get(i).text);
        tourViewHolder.tourreference.setText(tour.get(i).reference);
        //tourViewHolder.tournotes.setText(tour.get(i).notes);
        tourViewHolder.tourphoto.setImageResource(tour.get(i).photoId);
	}
    // How many people do we have in the tour class
	@Override
    public int getItemCount() {
        return tour.size();
    }
}


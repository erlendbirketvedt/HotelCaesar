package hulitax.no.hotelcaesar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erlend on 24.05.17.
 */

public class GuestAdapter extends ArrayAdapter<Guest> {


    public GuestAdapter(Context context, ArrayList<Guest> guests) {
        super(context, 0, guests);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Guest guest = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.guest_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.guest_name);
        TextView tvCard = (TextView) convertView.findViewById(R.id.credit_card);

        // Populate the data into the template view using the data object
        tvName.setText(guest.getfName() + " " + guest.getlName());
        tvCard.setText(guest.getCcnr());
        // Return the completed view to render on screen
        return convertView;
    }


}

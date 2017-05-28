package hulitax.no.hotelcaesar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends android.support.v4.app.Fragment {

    private ListView guestView;
    GuestDataSource dataSource;
    ArrayList<Guest> guestsArray;
    GuestAdapter guestAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onCreate(savedInstance);
        guestView = (ListView) getView().findViewById(R.id.listView);
        guestsArray = new ArrayList<>();
        dataSource = new GuestDataSource(this.getActivity());
        dataSource.open();
        getAllGuests();
        guestAdapter = new GuestAdapter(this.getContext(), guestsArray);
        guestView.setAdapter(guestAdapter);

    }

    public void getAllGuests() {
        List<Guest> guests = dataSource.getAllGuest();
        for (Guest g : guests) {
            guestsArray.add(g);
            System.out.println(getId() + "SOKBAR");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        dataSource.open();
        guestAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        dataSource.open();
        guestAdapter.notifyDataSetChanged();
    }

}
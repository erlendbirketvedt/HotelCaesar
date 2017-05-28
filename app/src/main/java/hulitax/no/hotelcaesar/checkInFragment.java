package hulitax.no.hotelcaesar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class checkInFragment extends android.support.v4.app.Fragment {

    GuestDataSource dataSource;
    Button checkinConfirmbtn;
    EditText et1, et2, et3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkin_resnr, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onCreate(savedInstance);
        final Intent intent = new Intent(this.getActivity(), ReceptionActivity.class);
        dataSource = new GuestDataSource(this.getActivity());
        checkinConfirmbtn = (Button) getView().findViewById(R.id.check_in_confirm);
        et1 = (EditText) getView().findViewById(R.id.first_name);
        et2 = (EditText) getView().findViewById(R.id.last_name);
        et3 = (EditText) getView().findViewById(R.id.ccnr);
        checkinConfirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.createGuest(et1.getText().toString(), et2.getText().toString(), et3.getText().toString());
                Toast.makeText(getActivity(), "Guest registered", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        dataSource.open();
    }

    @Override
    public void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }

    public void getAllGuests() {
        List<Guest> guests = dataSource.getAllGuest();
        for (Guest g : guests) {
            System.out.println(g.toString());
        }
    }
}
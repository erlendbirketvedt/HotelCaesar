package hulitax.no.hotelcaesar;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReceptionActivity extends AppCompatActivity {

    Button btnCheckInResNr, btnMap, btnShowAllGuests, btnCheckOut;
    GuestDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);
        dataSource = new GuestDataSource(this);
        dataSource.open();
        final Intent intent = new Intent(this, MainActivity.class);
        btnCheckInResNr = (Button) findViewById(R.id.check_in_resnr_btn);
        btnCheckInResNr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Fragmentcode", 1);
                startActivity(intent);
            }
        });

        btnShowAllGuests = (Button) findViewById(R.id.show_all_btn);
        btnShowAllGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Fragmentcode", 2);
                startActivity(intent);
            }
        });


        btnMap = (Button) findViewById(R.id.map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Fragmentcode", 3);
                startActivity(intent);
            }
        });

        btnCheckOut = (Button) findViewById(R.id.check_out_btn);
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CheckoutTask().execute();
            }
        });
    }

    private class CheckoutTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            dataSource.deleteGuest();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(ReceptionActivity.this, "Guest checked out", Toast.LENGTH_LONG).show();
        }
    }
}

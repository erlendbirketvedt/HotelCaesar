package hulitax.no.hotelcaesar;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity {
    FragmentManager fml;
    checkInFragment checkInFragmentResNr;
    MapFragment mapFragment;
    ListFragment listFragment;
    int fragmentcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcode = getIntent().getIntExtra("Fragmentcode", 1);
        fml = getSupportFragmentManager();
        checkInFragmentResNr = new checkInFragment();
        mapFragment = new MapFragment();
        listFragment = new ListFragment();
        if (fragmentcode == 1) {
            fml.beginTransaction().replace(R.id.fragment_container, checkInFragmentResNr)
                    .commit();
        } else if (fragmentcode == 2) {
            fml.beginTransaction().replace(R.id.fragment_container, listFragment)
                    .commit();
        }else if (fragmentcode == 3) {
            fml.beginTransaction().replace(R.id.fragment_container, mapFragment)
                    .commit();
        }
    }
}

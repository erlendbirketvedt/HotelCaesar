package hulitax.no.hotelcaesar;

import java.util.Random;
import java.util.UUID;

/**
 * Created by erlend on 28.05.17.
 */

public class Guest {
    private int mId;
    private String fName;
    private String lName;
    private String ccnr;

    public Guest() {

    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCcnr() {
        return ccnr;
    }

    public void setCcnr(String ccnr) {
        this.ccnr = ccnr;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "mId=" + mId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", ccnr='" + ccnr + '\'' +
                '}';
    }
}

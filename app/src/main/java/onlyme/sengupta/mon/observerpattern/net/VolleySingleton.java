package onlyme.sengupta.mon.observerpattern.net;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import onlyme.sengupta.mon.observerpattern.OverserPatternApp;

/**
 * Created by mondrita on 11/11/16.
 */
public class VolleySingleton {

    private static RequestQueue mRequestQueue;

    private VolleySingleton() {

    }

    public static RequestQueue getRequestQueue() {
        if(mRequestQueue==null) {
            mRequestQueue = Volley.newRequestQueue(OverserPatternApp.getInstance().getApplicationContext());
        }
        return mRequestQueue;
    }
}

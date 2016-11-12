package onlyme.sengupta.mon.observerpattern.net;

import android.util.Log;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by mondrita on 11/11/16.
 */
public class RequestExecutor {

    public static void execute(StringRequest request ) {
        Log.d("TAG", "ADDED");
        VolleySingleton.getRequestQueue().add(request);
    }

}

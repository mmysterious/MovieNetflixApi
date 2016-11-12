package onlyme.sengupta.mon.observerpattern.net.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import onlyme.sengupta.mon.observerpattern.net.response.MovieResponse;

/**
 * Created by mondrita on 11/11/16.
 */
public class MovieRequest {

    private final String URL= "http://netflixroulette.net/api/api.php?actor=Leonardo%20DiCaprio";

    public StringRequest buildRequest() {

        StringRequest jsonRequest= new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", response);
                Type listType= new TypeToken<List<MovieResponse>>(){}.getType();
                ArrayList<MovieResponse> movieList= new Gson().fromJson(response, listType);
                EventBus.getDefault().post(movieList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        return jsonRequest;
    }
}

package onlyme.sengupta.mon.observerpattern.presenter;

import java.util.ArrayList;
import java.util.List;

import onlyme.sengupta.mon.observerpattern.net.RequestExecutor;
import onlyme.sengupta.mon.observerpattern.net.request.MovieRequest;
import onlyme.sengupta.mon.observerpattern.net.response.MovieResponse;

/**
 * Created by mondrita on 11/11/16.
 */
public class MoviePresenter {

    public static void getMovieList() {
        RequestExecutor.execute(new MovieRequest().buildRequest());
    }
}

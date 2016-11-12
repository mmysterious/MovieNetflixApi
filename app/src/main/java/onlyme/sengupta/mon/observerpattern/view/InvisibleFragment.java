package onlyme.sengupta.mon.observerpattern.view;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import onlyme.sengupta.mon.observerpattern.R;
import onlyme.sengupta.mon.observerpattern.presenter.MoviePresenter;

/**
 * Created by mondrita on 11/11/16.
 */
public class InvisibleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        MoviePresenter.getMovieList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.invi_frag, container, false);
    }
}

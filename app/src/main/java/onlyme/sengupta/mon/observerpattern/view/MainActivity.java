package onlyme.sengupta.mon.observerpattern.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Observable;
import android.graphics.drawable.Drawable;
import android.support.annotation.MainThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import onlyme.sengupta.mon.observerpattern.R;
import onlyme.sengupta.mon.observerpattern.net.response.MovieResponse;
import onlyme.sengupta.mon.observerpattern.presenter.MoviePresenter;

public class MainActivity extends AppCompatActivity {

    MovieAdapter adapter;
    RecyclerView movieListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();



    }


    @Override
    protected void onResume() {
        super.onResume();
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }


    public void initUI() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InvisibleFragment fragment= new InvisibleFragment();
        fragmentTransaction.add(R.id.fragmentcontainer, fragment);
        fragmentTransaction.commit();

        adapter = new MovieAdapter(new ArrayList<MovieResponse>());
        movieListView= (RecyclerView) findViewById(R.id.movieList);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        movieListView.setLayoutManager(layoutManager);
        Drawable dividerDrawable= ContextCompat.getDrawable(this, R.drawable.divider);
        movieListView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        movieListView.setAdapter(adapter);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getMovieList(List<MovieResponse> list) {
        EventBus.getDefault().removeStickyEvent(list);
        adapter.updateList(list);
    }


}

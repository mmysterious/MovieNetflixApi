package onlyme.sengupta.mon.observerpattern.view;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import onlyme.sengupta.mon.observerpattern.R;
import onlyme.sengupta.mon.observerpattern.net.response.MovieResponse;
import onlyme.sengupta.mon.observerpattern.presenter.MoviePresenter;

/**
 * Created by mondrita on 11/11/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<MovieResponse> movieList;

    MovieAdapter(List<MovieResponse> list) {
        movieList= list;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        TextView txtMovieName;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtMovieName = (TextView) itemView.findViewById(R.id.txtMovieName);
        }
    }


    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MovieAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        holder.txtMovieName.setText(movieList.get(position).getShowTitle());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateList(List<MovieResponse> list) {
        movieList= list;
        notifyDataSetChanged();
    }
}

package ariska.submission1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private ArrayList<Movie> movies;
    private OnClickListener callback;

    public MovieAdapter(ArrayList<Movie> movies, OnClickListener callback) {
        this.movies = movies;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {

        final Movie movie = movies.get(i);

        Glide.with(listViewHolder.itemView.getContext()).load(movie.getImage())
                .apply(new RequestOptions().override(144, 144)).into(listViewHolder.img_poster);
        listViewHolder.tv_title.setText(movie.getTitle());
        listViewHolder.tv_overview.setText(movie.getOverview());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(movie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView img_poster;
        TextView tv_title;
        TextView tv_overview;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            img_poster = itemView.findViewById(R.id.img_photo);
            tv_overview = itemView.findViewById(R.id.tv_mov_overview);
            tv_title = itemView.findViewById(R.id.tv_mov_title);
        }
    }

    interface OnClickListener {
        void onClick(Movie movie);
    }
}

package ariska.submission1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieAdapter.OnClickListener {

    private RecyclerView rvMovies;
    private ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rv_listMovie);
        rvMovies.setHasFixedSize(true);

        movies.addAll(MovieData.getMovies());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter movieAdapter = new MovieAdapter(movies, this);
        rvMovies.setAdapter(movieAdapter);
    }

    @Override
    public void onClick(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}

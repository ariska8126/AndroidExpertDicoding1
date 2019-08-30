package ariska.submission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    private TextView tv_title, tv_date, tv_status, tv_language, tv_runtime, tv_director, tv_overview;
    private ImageView img_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tv_title = findViewById(R.id.tv_dm_title);
        img_photo = findViewById(R.id.img_dm_photo);
        tv_date= findViewById(R.id.tv_dm_releaseDate);
        tv_status = findViewById(R.id.tv_dm_status);
        tv_language = findViewById(R.id.tv_dm_language);
        tv_runtime = findViewById(R.id.tv_dm_runtime);
        tv_director = findViewById(R.id.tv_dm_director);
        tv_overview = findViewById(R.id.tv_dm_overview);


        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String title = movie.getTitle();
        String date = movie.getReleaseDate();
        String status = movie.getStatus();
        String language = movie.getLanguage();
        String runtime = movie.getLanguage();
        String director = movie.getDirector();
        String over = movie.getOverview();
        int img = movie.getImage();

        tv_title.setText(title);
        tv_date.setText(date);
        tv_status.setText(status);
        tv_language.setText(language);
        tv_runtime.setText(runtime);
        tv_director.setText(director);
        tv_overview.setText(over);
        Glide.with(this).load(img).into(img_photo);
    }
}

package ariska.submission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestMoveParcelActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tv_obj_receiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_move_parcel);

        tv_obj_receiv = findViewById(R.id.tv_object_received);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String text = "title: "+movie.getTitle() + ",\nOverview: "+movie.getOverview();
        tv_obj_receiv.setText(text);

    }
}

package coding.insight.bigmanspizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ImageSlider imageSliderHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Remove title
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize views
        initViews();

        // Set image slider
        List<SlideModel> sliderImages = new ArrayList<>();
        sliderImages.add(new SlideModel(R.drawable.slider_image1, null));
        sliderImages.add(new SlideModel(R.drawable.slider_image2, null));
        sliderImages.add(new SlideModel(R.drawable.slider_image3, null));
        imageSliderHomeActivity.setImageList(sliderImages, true); // Second parameter is for center crop
    }

    /**
     * Create menu in {@link HomeActivity}
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_activity, menu);
        return true;
    }

    /**
     * Initialize views
     */
    private void initViews() {
        imageSliderHomeActivity = findViewById(R.id.image_slider_home_activity);
    }
}
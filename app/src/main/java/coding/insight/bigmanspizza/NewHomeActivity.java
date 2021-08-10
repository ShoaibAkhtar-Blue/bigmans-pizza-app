package coding.insight.bigmanspizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class NewHomeActivity extends AppCompatActivity {
    private ImageSlider imageSliderHomeActivity;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_home);

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

        // Setup navigation drawer
        DrawerLayout drawerLayout = findViewById(R.id.layout_drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Enable navigation drawer items
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(NewHomeActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_my_orders:
                        Toast.makeText(NewHomeActivity.this, "My Orders is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_profile:
                        Toast.makeText(NewHomeActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_contact_us:
                        Toast.makeText(NewHomeActivity.this, "Contact Us is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_share_app:
                        Toast.makeText(NewHomeActivity.this, "Share App is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_facebook:
                        Toast.makeText(NewHomeActivity.this, "Facebook is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_instagram:
                        Toast.makeText(NewHomeActivity.this, "Instagram is clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    /**
     * Create menu in {@link NewHomeActivity}
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

    /**
     * Enable menu items and navigation drawer
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Open and close the drawer
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Select menu items
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "Search is clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cart:
                Toast.makeText(this, "Cart is clicked", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
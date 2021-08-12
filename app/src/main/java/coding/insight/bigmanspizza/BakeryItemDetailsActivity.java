package coding.insight.bigmanspizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BakeryItemDetailsActivity extends AppCompatActivity {
    private RecyclerView bakeryItemDetailsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_item_details);

        //Enable Home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get intent and its data
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("Item Name");

        // Set title of the activity
        setTitle(itemName);

        // Initialize views
        initViews();

        // Setup adapter
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        BakeryItemDetailsRecyclerViewAdapter adapter = new BakeryItemDetailsRecyclerViewAdapter(this, list);

        // Set adapter to recycler view
        bakeryItemDetailsRecyclerView.setAdapter(adapter);
        bakeryItemDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Enable menu in the avtivity
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
     * Enable menu functionality
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "Search is clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cart:
                Toast.makeText(this, "Cart is clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Initialize views
     */
    private void initViews() {
        bakeryItemDetailsRecyclerView = findViewById(R.id.recyclerView_bakery_item_details);
    }
}
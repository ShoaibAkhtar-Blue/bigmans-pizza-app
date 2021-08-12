package coding.insight.bigmanspizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BakeryActivity extends AppCompatActivity {
    private RecyclerView bakeryRecyclerView;
    private BakeryRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);

        // Set title of the activity
        setTitle("Bakery");

        // Enable Home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize views
        initView();

        // Setup Adapter
        List<String> list = new ArrayList<>();
        list.add("Cake");
        list.add("Mithai");
        list.add("Baverage");
        adapter = new BakeryRecyclerViewAdapter(this, list);

        // Set adapter to recycler view
        bakeryRecyclerView.setAdapter(adapter);
        bakeryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Enable Home button functionality
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Initialize views
     */
    private void initView() {
        bakeryRecyclerView = findViewById(R.id.recyclerView_bakery);
    }
}
package coding.insight.bigmanspizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import coding.insight.bigmanspizza.Model.CakeItem;

public class BakeryItemDetailsActivity extends AppCompatActivity {
    private final String LOG_TAG = BakeryItemDetailsActivity.class.getSimpleName();
    private RecyclerView bakeryItemDetailsRecyclerView;

    // Initialize Firebase Database
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference table_reference;

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

        List<CakeItem> cakeList = new ArrayList<>();

        // Setup adapter
        BakeryItemDetailsRecyclerViewAdapter adapter = new BakeryItemDetailsRecyclerViewAdapter(this, cakeList);

        // Set adapter to recycler view
        bakeryItemDetailsRecyclerView.setAdapter(adapter);
        bakeryItemDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get data from Firebase Database

        Log.i(LOG_TAG, "Table Name: " + itemName);

        table_reference = firebaseDatabase.getReference(itemName);
        table_reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i(LOG_TAG, "In onDataChange");

                for (DataSnapshot dataSnapshot :
                        snapshot.getChildren()) {
                    CakeItem cakeItem = dataSnapshot.getValue(CakeItem.class);
                    cakeList.add(cakeItem);
                }

                Log.i(LOG_TAG, "Total cakes: " + cakeList.size());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
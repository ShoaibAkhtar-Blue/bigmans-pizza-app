package coding.insight.bigmanspizza;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BakeryRecyclerViewAdapter extends RecyclerView.Adapter<BakeryRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public BakeryRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bakery_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bakeryItemTextView.setText(list.get(position));
        holder.bakeryItemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate the user to a new activity for the details of the selected item
                Intent intent = new Intent(context, BakeryItemDetailsActivity.class);
                intent.putExtra("Item Name", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bakeryItemTextView;
        private CardView bakeryItemCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bakeryItemTextView = itemView.findViewById(R.id.textView_bakery_item);
            bakeryItemCardView = itemView.findViewById((R.id.cardView_bakery_item));
        }
    }
}

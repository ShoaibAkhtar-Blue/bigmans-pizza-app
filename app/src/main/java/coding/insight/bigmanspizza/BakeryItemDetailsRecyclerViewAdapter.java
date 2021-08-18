package coding.insight.bigmanspizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import coding.insight.bigmanspizza.Model.CakeItem;

public class BakeryItemDetailsRecyclerViewAdapter  extends RecyclerView.Adapter<BakeryItemDetailsRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<CakeItem> itemList;

    public BakeryItemDetailsRecyclerViewAdapter(Context context, List<CakeItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bakery_item_detail, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemNameTextView.setText(itemList.get(position).getName());
        holder.itemPriceTextView.setText(itemList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemNameTextView;
        private TextView itemPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.textView_item_name);
            itemPriceTextView = itemView.findViewById(R.id.textView_item_price);
        }
    }
}

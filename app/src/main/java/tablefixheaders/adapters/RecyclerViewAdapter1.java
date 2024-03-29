package tablefixheaders.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;
import mainscreen.govt.maidi.com.maidi.TextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.TextItemViewHolder;

/**
 * Created by anupamchugh on 05/10/16.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<TextItemViewHolder> {

    String[] items;

    public RecyclerViewAdapter1(String[] items) {
        this.items = items;
    }

    @Override
    public TextItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item1, parent, false);

        return new TextItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextItemViewHolder holder, int position) {
       // holder.bind(items[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

package tablefixheaders.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;
import mainscreen.govt.maidi.com.maidi.TextItemViewHolder4;

/**
 * Created by anupamchugh on 05/10/16.
 */

public class RecyclerViewAdapter5 extends RecyclerView.Adapter<TextItemViewHolder4> {

    String[] items;

    public RecyclerViewAdapter5(String[] items) {
        this.items = items;
    }

    @Override
    public TextItemViewHolder4 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item5, parent, false);
        return new TextItemViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(TextItemViewHolder4 holder, int position) {
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

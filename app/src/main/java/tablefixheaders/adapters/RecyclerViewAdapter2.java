package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;
import mainscreen.govt.maidi.com.maidi.TextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.TextItemViewHolder2;

/**
 * Created by anupamchugh on 05/10/16.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<TextItemViewHolder1> {

    String[] items;

    public RecyclerViewAdapter2(String[] items) {
        this.items = items;
    }

    @Override
    public TextItemViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item2, parent, false);
        return new TextItemViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(TextItemViewHolder1 holder, int position) {
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

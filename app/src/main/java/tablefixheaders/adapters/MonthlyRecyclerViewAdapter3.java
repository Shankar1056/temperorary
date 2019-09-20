package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import mainscreen.govt.maidi.com.maidi.R;

public class MonthlyRecyclerViewAdapter3 extends RecyclerView.Adapter<MonthlyTextItemViewHolder2> {

    String[] items;

    public MonthlyRecyclerViewAdapter3(String[] items) {
        this.items = items;
    }

    @Override
    public MonthlyTextItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.monthly_view_list_item3, parent, false);

        return new MonthlyTextItemViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(MonthlyTextItemViewHolder2 holder, int position) {
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

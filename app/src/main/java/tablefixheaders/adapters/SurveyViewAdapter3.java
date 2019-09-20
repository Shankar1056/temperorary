package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;

public class SurveyViewAdapter3 extends RecyclerView.Adapter<SurveyTextItemViewHolder3> {

    String[] items;

    public SurveyViewAdapter3(String[] items) {
        this.items = items;
    }

    @Override
    public SurveyTextItemViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servey2_view_item_row, parent, false);
        return new SurveyTextItemViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(SurveyTextItemViewHolder3 holder, int position) {
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


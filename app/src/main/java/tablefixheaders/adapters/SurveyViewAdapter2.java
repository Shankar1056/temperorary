package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;

public class SurveyViewAdapter2 extends RecyclerView.Adapter<SurveyTextItemViewHolder2> {

    String[] items;

    public SurveyViewAdapter2(String[] items) {
        this.items = items;
    }

    @Override
    public SurveyTextItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servey1_view_item_row, parent, false);
        return new SurveyTextItemViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(SurveyTextItemViewHolder2 holder, int position) {
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


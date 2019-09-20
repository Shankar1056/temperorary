package tablefixheaders.adapters;

import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.R;

public class SurveyViewAdapter1 extends RecyclerView.Adapter<SurveyTextItemViewHolder1>
        /*implements NavigationView.OnNavigationItemSelectedListener*/ {

    String[] items;

    public SurveyViewAdapter1(String[] items) {
        this.items = items;
    }

    @Override
    public SurveyTextItemViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servey_view_item_row, parent, false);
        return new SurveyTextItemViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(SurveyTextItemViewHolder1 holder, int position) {
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


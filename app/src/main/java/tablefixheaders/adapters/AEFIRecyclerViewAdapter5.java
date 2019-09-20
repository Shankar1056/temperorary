package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder2;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder3;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder5;
import mainscreen.govt.maidi.com.maidi.R;

public class AEFIRecyclerViewAdapter5 extends RecyclerView.Adapter<AefiTextItemViewHolder5> {

    String[] items;

    public AEFIRecyclerViewAdapter5(String[] items) {
        this.items = items;
    }

    @Override
    public AefiTextItemViewHolder5 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aefi_view_list_item5, parent, false);

        return new AefiTextItemViewHolder5(view);
    }

    @Override
    public void onBindViewHolder(AefiTextItemViewHolder5 holder, int position) {
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


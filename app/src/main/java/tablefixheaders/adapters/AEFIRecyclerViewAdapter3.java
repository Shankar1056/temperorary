package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder2;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder3;
import mainscreen.govt.maidi.com.maidi.R;

public class AEFIRecyclerViewAdapter3 extends RecyclerView.Adapter<AefiTextItemViewHolder3> {

    String[] items;

    public AEFIRecyclerViewAdapter3(String[] items) {
        this.items = items;
    }

    @Override
    public AefiTextItemViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aefi_view_list_item3, parent, false);

        return new AefiTextItemViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(AefiTextItemViewHolder3 holder, int position) {
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


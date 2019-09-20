package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder2;
import mainscreen.govt.maidi.com.maidi.R;

public class AEFIRecyclerViewAdapter2 extends RecyclerView.Adapter<AefiTextItemViewHolder2> {

    String[] items;

    public AEFIRecyclerViewAdapter2(String[] items) {
        this.items = items;
    }

    @Override
    public AefiTextItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aefi_view_list_item2, parent, false);

        return new AefiTextItemViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(AefiTextItemViewHolder2 holder, int position) {
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


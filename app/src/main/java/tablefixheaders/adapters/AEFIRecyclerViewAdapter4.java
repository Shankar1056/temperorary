package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder4;
import mainscreen.govt.maidi.com.maidi.R;

public class AEFIRecyclerViewAdapter4 extends RecyclerView.Adapter<AefiTextItemViewHolder4> {

    String[] items;

    public AEFIRecyclerViewAdapter4(String[] items) {
        this.items = items;
    }

    @Override
    public AefiTextItemViewHolder4 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aefi_view_list_item4, parent, false);

        return new AefiTextItemViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(AefiTextItemViewHolder4 holder, int position) {
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


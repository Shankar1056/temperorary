package tablefixheaders.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mainscreen.govt.maidi.com.maidi.AefiTextItemViewHolder1;
import mainscreen.govt.maidi.com.maidi.R;

    public class AEFIRecyclerViewAdapter1 extends RecyclerView.Adapter<AefiTextItemViewHolder1> {

        String[] items;

        public AEFIRecyclerViewAdapter1(String[] items) {
            this.items = items;
        }

        @Override
        public AefiTextItemViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aefi_view_list_item1, parent, false);

            return new AefiTextItemViewHolder1(view);
        }

        @Override
        public void onBindViewHolder(AefiTextItemViewHolder1 holder, int position) {
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


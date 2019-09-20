package mainscreen.govt.maidi.com.maidi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tablefixheaders.adapters.RecyclerViewAdapter5;

public class Fragmentweek5 extends Fragment {

    RecyclerView recyclerView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.activity_week5, container, false);
        return rootView;

        /**The below code was when the ListView was used in place of RecyclerView. **/

        /*View view = inflater.inflate(R.layout.fragment_list, container, false);

        list = (ListView) view.findViewById(R.id.list);
        ArrayList stringList= new ArrayList();

        stringList.add("Item 2A");
        stringList.add("Item 2B");
        stringList.add("Item 2C");
        stringList.add("Item 2D");
        stringList.add("Item 2E");
        stringList.add("Item 2F");
        stringList.add("Item 2G");
        stringList.add("Item 2H");
        stringList.add("Item 2I");
        stringList.add("Item 2J");
        stringList.add("Item 2K");
        stringList.add("Item 2L");
        stringList.add("Item 2M");
        stringList.add("Item 2N");
        stringList.add("Item 2O");
        stringList.add("Item 2P");
        stringList.add("Item 2Q");
        stringList.add("Item 2R");
        stringList.add("Item 2S");
        stringList.add("Item 2T");
        stringList.add("Item 2U");
        stringList.add("Item 2V");
        stringList.add("Item 2W");
        stringList.add("Item 2X");
        stringList.add("Item 2Y");
        stringList.add("Item 2Z");

        CustomAdapter adapter = new CustomAdapter(stringList,getActivity());
        list.setAdapter(adapter);

        return view;*/
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] items = getResources().getStringArray(R.array.tab_E);
        RecyclerViewAdapter5 adapter = new RecyclerViewAdapter5(items);
        recyclerView4 = (RecyclerView) view.findViewById(R.id.recycler_view5);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView4.setLayoutManager(layoutManager);
        recyclerView4.setAdapter(adapter);
    }
}
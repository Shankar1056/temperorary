package mainscreen.govt.maidi.com.maidi;
import android.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import tablefixheaders.adapters.SurveyViewAdapter2;

public class Page2Fragment extends Fragment {

    RecyclerView recyclerView;
    ListView list;
    TextView txtData;

    //SendMessage SM;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment2, container, false);
        return rootView;


        /**The below code was when the ListView was used in place of RecyclerView. **/

        /*View view = inflater.inflate(R.layout.fragment_list, container, false);

        list = (ListView) view.findViewById(R.id.list);
        ArrayList stringList= new ArrayList();

        stringList.add("Item 1A");
        stringList.add("Item 1C");
        stringList.add("Item 1D");
        stringList.add("Item 1B");
        stringList.add("Item 1E");
        stringList.add("Item 1F");
        stringList.add("Item 1G");
        stringList.add("Item 1H");
        stringList.add("Item 1I");
        stringList.add("Item 1J");
        stringList.add("Item 1K");
        stringList.add("Item 1L");
        stringList.add("Item 1M");
        stringList.add("Item 1N");
        stringList.add("Item 1O");
        stringList.add("Item 1P");
        stringList.add("Item 1Q");
        stringList.add("Item 1R");
        stringList.add("Item 1S");
        stringList.add("Item 1T");
        stringList.add("Item 1U");
        stringList.add("Item 1V");
        stringList.add("Item 1W");
        stringList.add("Item 1X");
        stringList.add("Item 1Y");
        stringList.add("Item 1Z");

        CustomAdapter adapter = new CustomAdapter(stringList,getActivity());
        list.setAdapter(adapter);

        return view;*/


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnPassData = (Button) view.findViewById(R.id.button2);
        final EditText houseno = (EditText) view.findViewById(R.id.family_head);
        final EditText family_head = (EditText) view.findViewById(R.id.family_head);
        final EditText fathername = (EditText) view.findViewById(R.id.fathername);
        final Spinner member = (Spinner) view.findViewById(R.id.member);
        final CheckBox newbornYes = (CheckBox) view.findViewById(R.id.newbornYes);
        final CheckBox newbornNo = (CheckBox) view.findViewById(R.id.newbornNo);
        final CheckBox childYes = (CheckBox) view.findViewById(R.id.childYes);
        final CheckBox childNo = (CheckBox) view.findViewById(R.id.childNo);
       /* btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*SM.sendData(houseno.getText().toString().trim());
                SM.sendData(family_head.getText().toString().trim());
                SM.sendData(fathername.getText().toString().trim());
                SM.sendData(member.getSelectedItem().toString().trim());
                SM.sendData(newbornYes.getText().toString().trim());
                SM.sendData(newbornNo.getText().toString().trim());
                SM.sendData(childYes.getText().toString().trim());
                SM.sendData(childNo.getText().toString().trim());*//*

                Intent child = new Intent(v.getContext(), Page3Fragment.class);
                startActivity(child);
            }
        });*/


        String[] items = getResources().getStringArray(R.array.tab_A);
        SurveyViewAdapter2 adapter = new SurveyViewAdapter2(items);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



}
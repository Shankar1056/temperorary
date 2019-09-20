package mainscreen.govt.maidi.com.maidi;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import tablefixheaders.adapters.SurveyViewAdapter3;


public class Page3Fragment extends Fragment {

    RecyclerView recyclerView;
    ListView list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment3, container, false);
        return rootView;


        /**The below code was when the ListView was used in place of RecyclerView. **/

        /*View view = inflater.inflate(R.layout.fragment_list, container, false);

        list = (ListView) view.findViewById(R.id.list);
        ArrayList stringList= new ArrayList();

        stringList.add("Item 1A");
        stringList.add("Item 1B");
        stringList.add("Item 1C");
        stringList.add("Item 1D");
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
         EditText houseno = (EditText) view.findViewById(R.id.houseno);
         EditText pregnantwomen = (EditText) view.findViewById(R.id.pregnantwomen);
         EditText age_year = (EditText) view.findViewById(R.id.age_year);
         EditText husband_name = (EditText) view.findViewById(R.id.husband_name);
         EditText mobile = (EditText) view.findViewById(R.id.mobile);
         EditText expected_date = (EditText) view.findViewById(R.id.expected_date);
         Spinner tetanus = (Spinner) view.findViewById(R.id.tetanus);
         Spinner ante_natal_check_up = (Spinner) view.findViewById(R.id.ante_natal_check_up);
       // final Spinner for_anm_only = (Spinner) view.findViewById(R.id.for_anm_only);

/*
        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                */
/*SM.sendData(houseno.getText().toString().trim());
                SM.sendData(pregnantwomen.getText().toString().trim());
                SM.sendData(age_year.getText().toString().trim());
                SM.sendData(husband_name.getText().toString().trim());
                SM.sendData(mobile.getText().toString().trim());
                SM.sendData(expected_date.getText().toString().trim());
                SM.sendData(tetanus.getSelectedItem().toString().trim());
                SM.sendData(ante_natal_check_up.getSelectedItem().toString().trim());
                SM.sendData(for_anm_only.getSelectedItem().toString().trim());
*//*

            }
        });
*/

        String[] items = getResources().getStringArray(R.array.tab_A);
        SurveyViewAdapter3 adapter = new SurveyViewAdapter3(items);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    /*interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
    protected void displayReceivedData(String message)
    {
*//*
        txtData.setText("Data received: "+message);
*/
    }

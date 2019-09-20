package mainscreen.govt.maidi.com.maidi;
import android.app.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import tablefixheaders.adapters.SurveyViewAdapter1;


/* Fragment used as page 1 */

public class Page1Fragment extends Fragment {

    RecyclerView recyclerView;
    ListView list;
    //SendMessage SM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment1, container, false);
        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnPassData = (Button) view.findViewById(R.id.button2);
        final EditText edtextfrist = (EditText) view.findViewById(R.id.edtextfrist);
        final EditText edtextlast = (EditText) view.findViewById(R.id.edtextlast);
        final EditText mobile = (EditText) view.findViewById(R.id.mobile);
        final EditText btn_date1 = (EditText) view.findViewById(R.id.btn_date1);
        final EditText sub_center = (EditText) view.findViewById(R.id.sub_center);
        final EditText anm = (EditText) view.findViewById(R.id.edtextfrist);
        final EditText area = (EditText) view.findViewById(R.id.edtextfrist);
        final EditText areacode = (EditText) view.findViewById(R.id.edtextfrist);

        String[] items = getResources().getStringArray(R.array.tab_A);
        SurveyViewAdapter1 adapter = new SurveyViewAdapter1(items);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }



    }




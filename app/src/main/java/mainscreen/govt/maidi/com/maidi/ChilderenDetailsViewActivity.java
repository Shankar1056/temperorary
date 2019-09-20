package mainscreen.govt.maidi.com.maidi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ChilderenDetailsViewActivity extends AppCompatActivity {

    ArrayList<HashMap<String,String>> getDatalist;
    private RecyclerView mrecyclerView;
    RecyclerViewAdapter mAdapter;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_reg_activity);

        random = new Random();

        getDatalist = new ArrayList<>();
        for(int aind = 0 ; aind < 1; aind++){
            HashMap<String,String> map = new HashMap<>();
            map.put("KEY_NAME","android" + aind);
            map.put("KEY_ADDRESS","android" + aind);;
            getDatalist.add(map);
        }

        mrecyclerView = (RecyclerView) findViewById(R.id.mRecyclerview);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(ChilderenDetailsViewActivity.this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new RecyclerViewAdapter(ChilderenDetailsViewActivity.this, getDatalist, mrecyclerView);
        mrecyclerView.setAdapter(mAdapter);

        // set RecyclerView on item click listner
        mAdapter.setOnItemListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HashMap<String, String> item) {
                String mName = "";
                String mAddress = "";
                try{
                    Intent its = new Intent(getApplicationContext(),SimpleTableVaccine.class);
                    startActivity(its);
                    mName = item.get("KEY_Name");
                    mAddress = item.get("KEY_Address");
                }catch (Exception ev){
                    System.out.print(ev.getMessage());
                }
                Toast.makeText(ChilderenDetailsViewActivity.this,"Clicked row: \nName: "+mName+", Address: "+mName,Toast.LENGTH_LONG).show();
            }
        });


        //set load more listener for the RecyclerView adapter
        mAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (getDatalist.size() <= 40) {
                    getDatalist.add(null);
                    mAdapter.notifyItemInserted(getDatalist.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getDatalist.remove(getDatalist.size() - 1);
                            mAdapter.notifyItemRemoved(getDatalist.size());

                            //Generating more data
                            int index = getDatalist.size();
                            int end = index + 20;
                            for (int i = index; i < end; i++) {
                                HashMap<String,String> map = new HashMap<>();
                                map.put("KEY_EMAIL","android" + i + "@gmail.com");
                                map.put("KEY_PHONE",phoneNumberGenerating());
                                getDatalist.add(map);
                            }
                            mAdapter.notifyDataSetChanged();
                            mAdapter.setLoaded();
                        }
                    }, 5000);
                } else {
                    Toast.makeText(ChilderenDetailsViewActivity.this, "Loading data completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String phoneNumberGenerating() {
        int low = 100000000;
        int high = 999999999;
        int randomNumber = random.nextInt(high - low) + low;

        return "0" + randomNumber;
    }
}

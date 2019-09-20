package mainscreen.govt.maidi.com.maidi;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by lenovo on 7/29/2019.
 */

public class DashboardScreen extends Activity {
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_screen);

        gridLayout=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

    }

    // we are setting onClickListener for each element
    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Toast.makeText(DashboardScreen.this,"Clicked at index "+ finalI,
                            Toast.LENGTH_SHORT).show();*/


                    if(finalI==0){
                        int ss = gen();
                        String val = Integer.toString(ss);
                        Intent child = new Intent(getApplicationContext(),Beneficiary1Activity.class);
                       // child.putExtra("ss","MP"+ss);
                        startActivity(child);

                    }else {
                        Intent child = new Intent(getApplicationContext(),MyRegistrationActivity.class);
                        startActivity(child);

                    }
                }
            });
        }

    }
    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}

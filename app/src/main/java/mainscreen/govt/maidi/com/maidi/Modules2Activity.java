package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;

public class Modules2Activity extends Activity {
    GridLayout gridLayout;
    int ss;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_modules2);
        gridLayout=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);


    }
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
                        ss = gen();
                        String val = Integer.toString(ss);
                        Intent child = new Intent(getApplicationContext(),Child2Activity.class);
                        child.putExtra("ss","MP"+val);

                        startActivity(child);
                    }else if(finalI==1) {
                        Intent child = new Intent(getApplicationContext(),Underconstruction.class);
                        startActivity(child);
                    }else if(finalI==2){
                        Intent child = new Intent(getApplicationContext(),MonthlyWorkActivity.class);
                        startActivity(child);
                    }else if(finalI==3) {
                        Intent child = new Intent(getApplicationContext(),SurveyActivity.class);
                        startActivity(child);
                    }else if(finalI==4) {
                        /*Intent child = new Intent(getApplicationContext(),AefiMainActivityTab.class);
                        // Intent child = new Intent(getApplicationContext(),MainActivityTabAEFI.class);
                        startActivity(child);*/

                    }else if(finalI==5) {
                        Intent child = new Intent(getApplicationContext(),ViewReportActivity.class);
                        startActivity(child);
                    }/*else if(finalI==6) {
                        Intent child = new Intent(getApplicationContext(),ViewReportActivity.class);
                        startActivity(child);
                    }*/
                }
            });
        }
    }
    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}

package mainscreen.govt.maidi.com.maidi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class MonthlyWorkActivity1 extends AppCompatActivity {
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_work1);
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
                        // Intent child = new Intent(getApplicationContext(),ViewActivity.class);
                        Intent child = new Intent(getApplicationContext(),MonthlyworkplanActivity.class);
                        startActivity(child);

                    }else {
                        Intent child = new Intent(getApplicationContext(),UpdateActivity.class);
                        startActivity(child);

                    }
                }
            });
        }
    }

}

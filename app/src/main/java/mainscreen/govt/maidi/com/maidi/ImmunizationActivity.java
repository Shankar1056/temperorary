package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import opensrp.OcrMainActivity;


/**
 * Created by lenovo on 7/30/2019.
 */

public class ImmunizationActivity extends Activity {
    GridLayout gridLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);
        gridLayout = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

    }

    private void setSingleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Toast.makeText(DashboardScreen.this,"Clicked at index "+ finalI,
                            Toast.LENGTH_SHORT).show();*/
                    if (finalI == 0) {
                       // Intent child = new Intent(getApplicationContext(), ImmunizationCardActivity.class);
                        Intent child = new Intent(getApplicationContext(), OcrMainActivity.class);
                        startActivity(child);

                    } else if (finalI == 1) {
                        Intent child = new Intent(getApplicationContext(), SessionWiseVaccineActivity.class);
                        startActivity(child);

                    }
                }
            });
        }
    }
}

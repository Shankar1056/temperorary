package mainscreen.govt.maidi.com.maidi;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import pojo.ChildViewRequest;
import pojo.ChildViewResponse;
import pojo.monthlyViewRequest;
import pojo.monthlyViewResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonthlyWorkActivity extends AppCompatActivity {
    GridLayout gridLayout;
    ProgressDialog pd = null;
    String TxtName, Textasha, Village, Hour, TxtName1, Textasha1, Village1, Hour1, TxtName2, Textasha2, Village2, Hour2, TxtName3, Textasha3, Village3, Hour3, TxtName4, Textasha4, Village4, Hour4,
            TxtName5, Textasha5, Village5, Hour5;
    TextView txtName1, textasha1,village1, hour1;
      /*      txtName1, textasha1, village1, hour1, txtName2, textasha2, village2, hour2, txtName3, textasha3, village3, hour3, txtName4, textasha4, village4, hour4, txtName5, textasha5, village5, hour5*/;
    CalendarView simpleCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_work);
        gridLayout = (GridLayout) findViewById(R.id.mainGrid);
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView);
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
                        // Intent child = new Intent(getApplicationContext(),ViewActivity.class);
                        Intent child = new Intent(getApplicationContext(), MonthlyworkplanActivity.class);
                        startActivity(child);

                    } else {
                        Intent child = new Intent(getApplicationContext(), UpdateActivity.class);
                        startActivity(child);

                    }
                }
            });



                                /*String childNames1 = response.body().getChildName();
                                String ashaname1 = response.body().getFatherName();
                                String village1 = response.body().getMothername();
                                String hour1 = response.body().getMobileNum();
                                String childNames2 = response.body().getChildName();
                                String ashaname2 = response.body().getFatherName();
                                String village2 = response.body().getMothername();
                                String hour2 = response.body().getMobileNum();
                                String childNames3 = response.body().getChildName();
                                String ashaname3 = response.body().getFatherName();
                                String village3 = response.body().getMothername();
                                String hour3 = response.body().getMobileNum();
                                String childNames4 = response.body().getChildName();
                                String ashaname4 = response.body().getFatherName();
                                String village4 = response.body().getMothername();
                                String hour4 = response.body().getMobileNum();
                                String childNames5 = response.body().getChildName();
                                String ashaname5 = response.body().getFatherName();
                                String village5 = response.body().getMothername();
                                String hour5 = response.body().getMobileNum();*/

                        }


                }


           /*simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    // display the selected date by using a toast

                    Intent child = new Intent(getApplicationContext(), SimpleTable.class);
                    startActivity(child);
                }
            });*/
        }



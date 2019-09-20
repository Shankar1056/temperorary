package mainscreen.govt.maidi.com.maidi;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;

/*import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;*/

/*import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;*/

public class Child1Activity extends Activity
        /*,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener*/{
    GridLayout gridLayout;
    String userName,userRol,stat,dist,villg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_work1);
        gridLayout=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

        Intent intent = getIntent();
         userName = intent.getStringExtra("username");
         userRol = intent.getStringExtra("userRol");
         stat = intent.getStringExtra("state");
         dist = intent.getStringExtra("dist");
         villg = intent.getStringExtra("villg");
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
                        Intent child = new Intent(getApplicationContext(),ChildViewActivity.class);
                        startActivity(child);

                    }else {
                        String ss = gen();

                        Intent child = new Intent(getApplicationContext(),Beneficiary1Activity.class);
                        child.putExtra("ss",ss);

                        child.putExtra("userName", userName);
                        child.putExtra("userRol", userRol);
                        child.putExtra("stat", stat);
                        child.putExtra("dist", dist);
                        child.putExtra("villg", villg);
                        startActivity(child);

                    }
                }
            });
        }
    }
    public String gen() {
       /* Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));*/
        int num = 0;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String yrs = String.valueOf(year);
        String state = "OD";
        String Dates = "2019";
        String rand = "01";
        num = num+1;
        String numbers = String.valueOf(num);
        String randam = "000";
        String uid = state+yrs+numbers+randam+numbers;
        return uid;
    }

}
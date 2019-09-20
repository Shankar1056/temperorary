package mainscreen.govt.maidi.com.maidi;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

import Database.DataBaseHelper.LoginSQLiteHelper;
import pojo.ChildRegisterResponse;
import pojo.ChildRequest;
import pojo.SmsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/*
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
*/

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

public class Beneficiary1Activity extends Activity  implements NavigationView.OnNavigationItemSelectedListener {
    ProgressDialog pd = null;
    int day;
    int month;
  //  private GoogleApiClient mGoogleApiClient;
    private Location mLocation;
    private LocationManager mLocationManager;
    Button CaptureImageFromCamera,UploadImageToServer;

    ImageView ImageViewHolder;

    private static Button date, time;
    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;
    URL url;
    String responseText;
    StringBuffer response;
    String status_message = null;
    LoginSQLiteHelper myDb;
    GetCurrentLocation currentLoc;
    String GetImageNameFromEditText;

    String ImageNameFieldOnServer = "image_name" ;

    String ImagePathFieldOnServer = "image_path" ;

    String ImageUploadPathOnSever ="https://androidjsonblog.000webhostapp.com/capture_img_upload_to_server.php" ;

    public static final int RequestPermissionCode = 1;
    String username;
    int year;
    int mYear, mMonth, mDay, mHour, mMinute;
    EditText Uid, Long1, childname, Village, mothername, mobile, dob, PoB, birthtype, gestication, remarks, fathername, Long2;
    Spinner spinner1, spinner2, spinner3, btn_social, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11;
    ImageButton location, imageButton2;
    Button button1, button2;
    Boolean EditTextEmptyHolder;
    private String latitude, longitude;

    Intent intent;
    String uid, childName, EmailHolder, PasswordHolder, altitude, Mothername, Mobile, Dob, PoBs, btn_social1, Birthtype, Gestication, Remarks, Fathername, Spinner1, Spinner2, Spinner3, Spinner4, Spinner5,
            Spinner6, Spinner7, Spinner8, Spinner9, Spinner10, ImageButton1, ImageButton2, CheckBox1, CheckBox2, CheckBox3, CheckBox4;
    String SQLiteDataBaseQueryHolder;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    String userName, userRol, stat, dist, villg;
    String F_Result = "Not_Found";
    private static final String TAG = "Beneficiary1Activity";

    //     GoogleApiClient mGoogleApiClient;
   /* Location mLocation;
    LocationManager mLocationManager;*/

    //   LocationRequest mLocationRequest;
    // com.google.android.gms.location.LocationListener listener;
    long UPDATE_INTERVAL = 2 * 1000;  /* 10 secs */
    long FASTEST_INTERVAL = 2000; /* 2 sec */

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initControls();
        currentLoc = new GetCurrentLocation(this);
        Uid = (EditText) findViewById(R.id.btn_uid);
        Long1 = (EditText) findViewById(R.id.btn_long);
        Long2 = (EditText) findViewById(R.id.btn_long1);
        username = getIntent().getExtras().getString("ss");
        //Village = (EditText) findViewById(R.id.btn_Village);
        childname = (EditText) findViewById(R.id.btn_childname);
        mothername = (EditText) findViewById(R.id.btn_mothername);
        fathername = (EditText) findViewById(R.id.btn_fathername);
        mobile = (EditText) findViewById(R.id.btn_mobile);
        dob = (EditText) findViewById(R.id.btn_dob1);
        PoB = (EditText) findViewById(R.id.btn_PoB);
        birthtype = (EditText) findViewById(R.id.btn_birthtype);
        gestication = (EditText) findViewById(R.id.btn_gestication);
        remarks = (EditText) findViewById(R.id.btn_remarks);
        //EditText editText17=(EditText)findViewById(R.id.btn_uid);
        spinner1 = (Spinner) findViewById(R.id.btn_State);
        spinner2 = (Spinner) findViewById(R.id.btn_district);
        spinner3 = (Spinner) findViewById(R.id.btn_Block);
        spinner4 = (Spinner) findViewById(R.id.btn_Village);
        spinner5 = (Spinner) findViewById(R.id.btn_tola);
        btn_social = (Spinner) findViewById(R.id.btn_social);
        spinner7 = (Spinner) findViewById(R.id.spinner2);
        spinner8 = (Spinner) findViewById(R.id.spinner3);
        spinner9 = (Spinner) findViewById(R.id.spinner4);
        spinner10 = (Spinner) findViewById(R.id.spinner1);
         location = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        button1 = (Button) findViewById(R.id.btn_submit);
        button2 = (Button) findViewById(R.id.btn_cancel);
        Uid.setText(username);
        EnableRuntimePermission();
        ImageViewHolder = (ImageView)findViewById(R.id.imageView);
        UploadImageToServer = (Button) findViewById(R.id.button2);
        Intent intents = getIntent();
        userName = intents.getStringExtra("username");
        userRol = intents.getStringExtra("userRol");
        stat = intents.getStringExtra("state");
        dist = intents.getStringExtra("dist");
        spinner10.setVisibility(View.INVISIBLE);
        spinner7.setVisibility(View.INVISIBLE);
        spinner8.setVisibility(View.INVISIBLE);
        spinner9.setVisibility(View.INVISIBLE);
        myDb = new LoginSQLiteHelper(this);
               checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {
                    spinner10.setVisibility(View.VISIBLE);
                    spinner7.setVisibility(View.VISIBLE);

                } else {
                    spinner10.setVisibility(View.INVISIBLE);
                    spinner7.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {
                    spinner8.setVisibility(View.VISIBLE);
                    spinner9.setVisibility(View.VISIBLE);

                } else {
                    spinner8.setVisibility(View.INVISIBLE);
                    spinner9.setVisibility(View.INVISIBLE);
                }
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                latitude = currentLoc.latitude;
                longitude = currentLoc.longitude;

                /*if (TextUtils.isEmpty(latitude) || TextUtils.isEmpty(longitude)) {
                    latitude = "currentLoc.latitude;";
                    longitude = "currentLoc.longitude";
                }*/
                //    private String latitude, longitude;

                Long1.setText(latitude);
                Long2.setText(longitude);


            }

        });


        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);
            }
        });
        dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Date dialog
                showDialog(0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                uid = Uid.getText().toString();
                EmailHolder = Long1.getText().toString();
                altitude = Long2.getText().toString();
                childName = childname.getText().toString();
                // PasswordHolder = Village.getText().toString();
                Mothername = mothername.getText().toString();
                Fathername = fathername.getText().toString();
                Mobile = mobile.getText().toString();
                PoBs = PoB.getText().toString();
                Dob = dob.getText().toString();
                Birthtype = birthtype.getText().toString();
                Gestication = gestication.getText().toString();
                Remarks = remarks.getText().toString();
                /*Spinner1 = spinner1.getSelectedItem().toString();
                Spinner2 = spinner2.getSelectedItem().toString();
                Spinner3 = spinner3.getSelectedItem().toString();
                Spinner4 = spinner4.getSelectedItem().toString();
                Spinner5 = spinner5.getSelectedItem().toString();*/
                btn_social1 = btn_social.getSelectedItem().toString();
                Spinner7 = spinner7.getSelectedItem().toString();
                Spinner8 = spinner8.getSelectedItem().toString();
                Spinner9 = spinner9.getSelectedItem().toString();
                Spinner10 = spinner10.getSelectedItem().toString();

                CheckBox1 = checkBox1.getText().toString();
                CheckBox2 = checkBox2.getText().toString();
                CheckBox3 = checkBox3.getText().toString();
                CheckBox4 = checkBox4.getText().toString();

                // add new code
                Boolean str = validation(uid, EmailHolder, childName, Mothername, Fathername, Mobile, PoBs, Dob, Birthtype, Gestication, Remarks, btn_social1, Spinner7, Spinner8, Spinner9, Spinner10, CheckBox1, CheckBox2, CheckBox3, CheckBox4);
                if (str == true) {
                    String dataResponse = postServerData();
                    AddData();

                }



                   }              // ChildDetails user = new ChildDetails(first_name, last_name,do_b,sex,mother_name,"sts","dis","asdha",village_name);
                // Users user = new Users(NameHolder, childName,Fathername,Mothername,Mobile,PoBs,"MBC","Normal","Test");



        });

        UploadImageToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //ImageUploadToServerFunction();

            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new FirstFragment())
                    .commit();
        } else if (id == R.id.nav_second_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new SecondFragment())
                    .commit();
        } else if (id == R.id.nav_third_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new ThirdFragment())
                    .commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class GetServerData extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... dat) {

            String data = getWebServiceResponseData(dat);

            return data;
        }

        @Override
        protected void onPostExecute(String da) {
            super.onPostExecute(da);

            // Dismiss the progress dialog

        }

        protected String getWebServiceResponseData(String val[]) {
            String details = null;
            String country = null;
            //String getOtp = "https://2factor.in/API/V1/6c45af7c-b385-11e9-ade6-0200cd936042/SMS/+91" + val[0] + "/AUTOGEN";
            String getSms = "https://2factor.in/API/R1/?module=TRANS_SMS&apikey=6c45af7c-b385-11e9-ade6-0200cd936042&to=" + val[0] + "&from=MAIDIA&msg=" + val[1];

            try {

                url = new URL(getSms);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();


                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    // Reading response from input Stream
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String output;
                    response = new StringBuffer();

                    while ((output = in.readLine()) != null) {
                        response.append(output);
                    }
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            responseText = response.toString();
            //Call ServerData() method to call webservice and store result in response
            //  response = service.ServerData(path, postDataParams);

            try {
                // JSONArray jsonarray = new JSONArray(responseText);
                JSONObject object = new JSONObject(responseText);

                details = object.getString("Details");


                System.out.print(details);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return details;
        }

    }

    protected Dialog onCreateDialog(int id) {

        // Get the calander
        Calendar c = Calendar.getInstance();

        // From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        switch (id) {
            case Date_id:

                // Open the datepicker dialog
                return new DatePickerDialog(Beneficiary1Activity.this, date_listener, year,
                        month, day);
        }
        return null;

    }

    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            String date1 = String.valueOf(month) + "/" + String.valueOf(day)
                    + "/" + String.valueOf(year);
            dob.setText(date1);
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageButton2.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(Beneficiary1Activity.this,
                Manifest.permission.CAMERA)) {

            // Toast.makeText(Beneficiary1Activity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(Beneficiary1Activity.this, new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    //  Toast.makeText(Beneficiary1Activity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();


                } else {

                    //   Toast.makeText(Beneficiary1Activity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }


    public String postServerData() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        ChildRequest user = new ChildRequest(uid, EmailHolder, childName, Mothername, Fathername, Mobile, PoBs, btn_social1, Birthtype, Gestication, Spinner7, Spinner9, Remarks);
        Call<ChildRegisterResponse> call1 = apiInterface.childReg(user);
        String message = "Welcome to MAIDI From GOVT OF INDIA" + " " + "Thanks For Registering " + " " + childName + " " + "User ID " + uid;
        new GetServerData().execute(Mobile, message);
        call1.enqueue(new Callback<ChildRegisterResponse>() {

            public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                ChildRegisterResponse user1 = response.body();
                //String sms_temp = getSmsTemplate();

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        Beneficiary1Activity.this);
                builder.setTitle("Child Register");
                builder.setMessage("Successfully Child is registered");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent child = new Intent(getApplicationContext(), Child1Activity.class);
                                startActivity(child);
                            }
                        });
                builder.show();

                //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

            }

            public void onFailure(Call<ChildRegisterResponse> call, Throwable t) {
                call.cancel();
                pd.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        Beneficiary1Activity.this);
                builder.setTitle("Child Register");
                builder.setMessage("Child register Error");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                        /*Intent child = new Intent(getApplicationContext(), BeneficiaryActivity.class);
                                        startActivity(child);*/
                                pd.dismiss();
                            }
                        });
                builder.show();
            }
        });


        return status_message;

    }

    public boolean validation(String NameHolder, String EmailHolder, String childName, String Mothername, String Fathername, String Mobile, String PoBs, String Dob, String Birthtype
            , String Gestication, String Remarks, String btn_social1, String Spinner7, String Spinner8, String Spinner9, String Spinner10, String CheckBox1, String CheckBox2,
                              String CheckBox3, String CheckBox4) {
        boolean data;
        if ((NameHolder.equals("")) || (NameHolder == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Child Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((EmailHolder.equals("")) || (EmailHolder == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }

        if ((childName.equals("")) || (childName == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter child Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Mothername.equals("")) || (Mothername == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Fathername.equals("")) || (Fathername == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Father Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Mobile.equals("")) || (Mobile == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((PoBs.equals("")) || (PoBs == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Place of Birth ", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Dob.equals("")) || (Dob == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter  Date of Birth", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Birthtype.equals("")) || (Birthtype == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Gestication.equals("")) || (Gestication == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Birth Type", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Remarks.equals("")) || (Remarks == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Remarks", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((btn_social1.equals("")) || (btn_social1 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Social Category", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Spinner7.equals("")) || (Spinner7 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter the Kg child ", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Spinner8.equals("")) || (Spinner8 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter the gram child", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Spinner9.equals("")) || (Spinner9 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Abnormality", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
        if ((Spinner10.equals("")) || (Spinner10 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }

 /* String Spinner7,String Spinner8,String Spinner9,String Spinner10,String CheckBox1,String CheckBox2,
                String CheckBox3,String CheckBox4*/

        if ((CheckBox1.equals("")) || (CheckBox1 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
       /* if((CheckBox2.equals(""))||(CheckBox2==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Mother Name",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }*/
        if ((CheckBox3.equals("")) || (CheckBox3 == null)) {
            Toast.makeText(getApplicationContext(), "Please Enter Mother Name", Toast.LENGTH_LONG).show();
            data = false;
        } else {
            data = true;
        }
       /* if((CheckBox4.equals(""))||(CheckBox4==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Mother Name",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }*/
        return data;
    }

    public void AddData() {


        boolean isInserted = myDb.insertData1(uid, EmailHolder, altitude, childName, Mothername, Fathername, Mobile, Dob, PoBs, btn_social1, Birthtype, Gestication, CheckBox1, Spinner7, Spinner8, CheckBox2, CheckBox3, Spinner9, Spinner10, CheckBox4, Remarks);
        if (isInserted == true)
            Toast.makeText(Beneficiary1Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(Beneficiary1Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

    }
    private void initControls() {


    }




    @Override
    protected void onResume() {
        super.onResume();
        currentLoc.connectGoogleApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentLoc.disConnectGoogleApi();
    }
}


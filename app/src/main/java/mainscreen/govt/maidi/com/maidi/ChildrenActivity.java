package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


import pojo.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 7/30/2019.
 */

public class ChildrenActivity extends Activity implements View.OnClickListener {

    SQLiteDatabase mDatabase;
    String first_name;
    String last_name;
    String do_b ;
    String sex ;
    String mother_name ;
    String state_name ;
    String dist_name ;
    String block_name ;
    String village_name ;
    String birth_type ;
    String gstin_age ;
    String birth_status ;
    String birth_status1 ;
    String birt_weight ;
    String birth_place ;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private int day;
    private int month;
    private int year;
     ProgressDialog pd = null;
    EditText uuid ,firstName, lastName,dob,motherName,village,birthType,gstinAge,birthWeight,birthPlace , lat;
   Spinner gender , state,dist,block;
    ImageButton ib,imageButton2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_register);
       // Intent intent = getIntent();
        String username = getIntent().getExtras().getString("ss");
       // String id = intent.getStringExtra("ss");
        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        lat= (EditText)findViewById(R.id.editText14);
        ib = (ImageButton) findViewById(R.id.imageButton1);
        uuid= (EditText)findViewById(R.id.editText7);
         firstName = (EditText)findViewById(R.id.editText2);
         lastName = (EditText)findViewById(R.id.editText3);
        dob = (EditText)findViewById(R.id.editText4);
         gender = (Spinner)findViewById(R.id.spinner);
          motherName = (EditText)findViewById(R.id.editText5);
         state = (Spinner)findViewById(R.id.spinner2);
         dist = (Spinner)findViewById(R.id.spinner3);
         block =(Spinner)findViewById(R.id.spinner4);
         village = (EditText)findViewById(R.id.editText6);
         birthType = (EditText)findViewById(R.id.editText8);
         gstinAge =  (EditText)findViewById(R.id.editText9);
        CheckBox birthStatus = (CheckBox)findViewById(R.id.checkbox1);
        CheckBox birthStatus1 = (CheckBox)findViewById(R.id.checkbox);
         birthWeight = (EditText)findViewById(R.id.editText10);
         birthPlace = (EditText)findViewById(R.id.editText12);

        dob.setOnClickListener(this);
        ib.setOnClickListener(this);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lat.setText("48.1265479"+"79.1536242");

            }
        });

      /*  dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // Get Current Date
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(),
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    dob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();

            }
        });*/
       // String text = gender.getSelectedItem().toString();

        Button bts = (Button)findViewById(R.id.button2);


        uuid.setText(username);

        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first_name = firstName.getText().toString();
                last_name = lastName.getText().toString();
                do_b = dob.getText().toString();
                sex = gender.getSelectedItem().toString();
                mother_name = motherName.getText().toString();
                state_name = state.getSelectedItem().toString();
                dist_name = dist.getSelectedItem().toString();
                block_name = block.getSelectedItem().toString();
                village_name  =village.getText().toString();
                birth_type = birthType.getText().toString();
                gstin_age = gstinAge.getText().toString();
                //birth_status = birthStatus.getText().toString();
                //birth_status1 = birthStatus1.getText().toString();
                birt_weight = birthWeight.getText().toString();
                birth_place = birthPlace.getText().toString();
                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                // for testing we added
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        ChildrenActivity.this);
                builder.setTitle("Child Register");
                builder.setMessage("Successfully Child is registered");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent child = new Intent(getApplicationContext(), ModulesActivity.class);
                                startActivity(child);
                            }
                        });
                builder.show();
               /* pd = new ProgressDialog(ChildrenActivity.this);
                pd.setMessage("loading");
                pd.show();*/
                // ChildDetails user = new ChildDetails(first_name, last_name,do_b,sex,mother_name,"sts","dis","asdha",village_name);
               /* Users user = new Users(first_name, last_name,do_b,sex,mother_name,state_name,dist_name,123,village_name);
                Call<Users> call1 = apiInterface.createUser(user);
                call1.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Users user1 = response.body();
                        pd.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                ChildrenActivity.this);
                        builder.setTitle("Child Register");
                        builder.setMessage("Successfully Child is registered");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Intent child = new Intent(getApplicationContext(), ModulesActivity.class);
                                        startActivity(child);
                                    }
                                });
                        builder.show();

                      //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        call.cancel();
                    }
                });
*/

               /* call1.enqueue(new Callback<ChildDetails>() {
                    @Override
                    public void onResponse(Call<ChildDetails> call, Response<ChildDetails> response) {
                        ChildDetails user1 = response.body();

                       Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onFailure(Call<ChildDetails> call, Throwable t) {
                        call.cancel();
                    }
                });*/

               /* AlertDialog.Builder builder = new AlertDialog.Builder(
                        ChildrenActivity.this);
                builder.setTitle("Child Register");
                builder.setMessage("Successfully Child is registered");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent child = new Intent(getApplicationContext(),DashboardScreen.class);
                                startActivity(child);
                            }
                        });
                builder.show();*/
            }
        });

    }
    public void onClick(View v) {
        showDialog(0);

    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            dob.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };
}

package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import Database.DataBaseHelper.LoginSQLiteHelper;
import Database.DataBaseHelper.SQLiteHelper;
import Database.DataBaseHelper.ViewSQLiteHelper;
import pojo.ChildRegisterResponse;
import pojo.ChildRequest;
import pojo.Reportwriting;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class ViewReportActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{
    ViewSQLiteHelper sqLiteHelper;
    ProgressDialog pd = null;

    SQLiteDatabase sqLiteDatabaseObj;
    Button bnt_Submit,bnt_cancel;
    EditText houseno,childname,age_month,fathername,booster,for_completely,mobile;
    CheckBox  checkmale,checkfemale,checkyes,checkno;
    String Houseno,Childname,Age_month,Fathername,Booster,Mobile,Checkmale,Checkfemale,Checkyes,Checkno,Vaccine_birth,Week_6,Week_10,Week_14,Week_9to12,For_completely;
    Spinner vaccine_birth,week_6,week_10,week_14,week_9to12;
    String status_message = null;
     LoginSQLiteHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        houseno = (EditText) findViewById(R.id.houseno);
        childname = (EditText) findViewById(R.id.childname);
        age_month = (EditText) findViewById(R.id.age_month);
        mobile = (EditText) findViewById(R.id.mobile);
        checkmale = (CheckBox) findViewById(R.id.checkmale);
        checkfemale = (CheckBox) findViewById(R.id.checkfemale);
        vaccine_birth = (Spinner) findViewById(R.id.vaccine_birth);
        week_6 = (Spinner) findViewById(R.id.week_6);
        week_10 = (Spinner) findViewById(R.id.vaccine_birth);
        week_14 = (Spinner) findViewById(R.id.vaccine_birth);
        week_9to12 = (Spinner) findViewById(R.id.week_9to12);
        booster = (EditText) findViewById(R.id.booster);

        for_completely = (EditText) findViewById(R.id.for_completely);
        checkyes = (CheckBox) findViewById(R.id.checkyes);
        checkno = (CheckBox) findViewById(R.id.checkno);
        fathername = (EditText) findViewById(R.id.fathername);
        bnt_Submit = (Button) findViewById(R.id.bnt_Submit);
        bnt_cancel = (Button) findViewById(R.id.bnt_Cancel);
        //  EditText mcp = (EditText)findViewById(R.id.)
        myDb = new LoginSQLiteHelper(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        bnt_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Houseno = houseno.getText().toString();
                Childname = childname.getText().toString();
                Age_month = age_month.getText().toString();
                Checkmale = checkmale.getText().toString();
                Checkfemale = checkfemale.getText().toString();
                Fathername = fathername.getText().toString();
                Mobile = mobile.getText().toString();
                Checkyes = checkyes.getText().toString();
                Checkno = checkno.getText().toString();
                Vaccine_birth = vaccine_birth.getSelectedItem().toString();

                Week_6 = week_6.getSelectedItem().toString();
                Week_10 = week_10.getSelectedItem().toString();
                Week_14 = week_14.getSelectedItem().toString();
                Week_9to12 = week_9to12.getSelectedItem().toString();
                Booster = booster.getText().toString();

                For_completely = for_completely.getText().toString();
                AddData2();

                Boolean str = validation(Houseno,Childname,Age_month,Fathername,Booster,Mobile,Checkmale,Checkfemale,Checkyes,Checkno,Vaccine_birth,Week_6,Week_10,Week_14,Week_9to12,For_completely);
                if (str == true) {
                    String dataResponse = postServerData();
                }
            }
            });

        bnt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent child = new Intent(getApplicationContext(),Modules1Activity.class);
                startActivity(child);

            }
        });

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public String postServerData(){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        pd = new ProgressDialog(ViewReportActivity.this);
        pd.setMessage("loading");
        pd.show();



        // ChildDetails user = new ChildDetails(first_name, last_name,do_b,sex,mother_name,"sts","dis","asdha",village_name);
        // Users user = new Users(NameHolder, childName,Fathername,Mothername,Mobile,PoBs,"MBC","Normal","Test");
        Reportwriting report = new Reportwriting(Houseno, Childname, Age_month, Checkmale, Fathername, Mobile, Checkyes, Vaccine_birth, Week_6, Week_10, Week_14, Week_9to12, Booster, For_completely);
        Call<ChildRegisterResponse> call1 = apiInterface.reportWriting(report);
        call1.enqueue(new Callback<ChildRegisterResponse>() {

            public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                ChildRegisterResponse user1 = response.body();
                pd.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        ViewReportActivity.this);
                builder.setTitle(" Report Writing");
                builder.setMessage("Successfully Report is registered");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                               /* Intent child = new Intent(getApplicationContext(), Modules1Activity.class);
                                startActivity(child);*/
                                pd.dismiss();

                            }
                        });
                builder.show();

                //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

            }

            public void onFailure(Call<ChildRegisterResponse> call, Throwable t) {
                call.cancel();
                pd.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        ViewReportActivity.this);
                builder.setTitle("Report Writing");
                builder.setMessage("Report Writing register Error");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                        /*Intent child = new Intent(getApplicationContext(), Modules1Activity.class);
                                        startActivity(child);*/
                                pd.dismiss();
                            }
                        });
                builder.show();
            }
        });





        return status_message;
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    public boolean validation(String Houseno,String Childname,String Age_month,String Fathername,String Booster,String Mobile,String Checkmale,String Checkfemale,String Checkyes,String Checkno
            ,String Vaccine_birth,String Week_6,String Week_10,String Week_14,String Week_9to12,String For_completely){
        boolean data;
        if((Houseno.equals(""))||(Houseno==null)){
            Toast.makeText(getApplicationContext(),"Please Enter House No",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }
        if((Childname.equals(""))||(Childname==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Child Name",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Age_month.equals(""))||(Age_month==null)){
            Toast.makeText(getApplicationContext(),"Please Enter  Age Month ",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Fathername.equals(""))||(Fathername==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Father Name",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Booster.equals(""))||(Booster==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Booster",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Mobile.equals(""))||(Mobile==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Mobile",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } //String Houseno,String Childname,String Age_month,String Fathername,String Booster,String Mobile,String Checkmale,String Checkfemale,String Checkyes,String Checkno
            //,String Vaccine_birth,String Week_6,String Week_10,String Week_14,String Week_9to12,String For_completely
        if((Checkmale.equals(""))||(Checkmale==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Checkmale",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Checkyes.equals(""))||(Checkyes==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Check Yes",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Vaccine_birth.equals(""))||(Vaccine_birth==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Vaccine Birth",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Week_6.equals(""))||(Week_6==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Vaccine Week 6",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Week_10.equals(""))||(Week_10==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Vaccine Week 10",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        } if((Week_14.equals(""))||(Week_14==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Vaccine Week 14",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }

        if((Week_9to12.equals(""))||(Week_9to12==null)){
            Toast.makeText(getApplicationContext(),"Please Enter Vaccine Week 9 to 12",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }
        if((For_completely.equals(""))||(For_completely==null)){
            Toast.makeText(getApplicationContext(),"Please Enter For_completely",Toast.LENGTH_LONG).show();
            data=false;
        }else{
            data=true;
        }
        return data;
    }

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             // Handle navigation view item clicks here.
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
     public  void AddData2() {

         boolean isInserted = myDb.insertData2(Houseno,Childname,Age_month,Checkmale,Checkfemale,Fathername,Mobile,Checkyes,Checkno,Vaccine_birth,Week_6,Week_10,Week_14,Week_9to12,Booster,For_completely);
         if(isInserted == true)
             Toast.makeText(ViewReportActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
         else
             Toast.makeText(ViewReportActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

     }

 }



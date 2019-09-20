package mainscreen.govt.maidi.com.maidi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import Database.DataBaseHelper.LoginSQLiteHelper;
import Database.DataBaseHelper.SQLiteHelper;
import pojo.Login;
import pojo.LoginResponse;
import pojo.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActvity extends Activity {
    //LoginDataBaseAdapter loginDataBaseAdapter;
   private String user = null;
   private String pass = null;
    ProgressDialog pd = null;
    EditText userName, password;
    LoginSQLiteHelper myDb;

    String userNameRes, userRol, state, dist, villg, tola;
    int finalI = 0;
    String status_message = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        userName = (EditText) findViewById(R.id.text1);
        password = (EditText) findViewById(R.id.textView1);
        final Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);
        myDb = new LoginSQLiteHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = null;
                user = userName.getText().toString();
                pass = password.getText().toString();
                AddData1();
                Boolean str = validation(user,pass);
               if(str==true){
                String dataResponse = postServerData();
                   pd = new ProgressDialog(LoginActvity.this);
                   pd.setMessage("loading");
                   pd.show();

               }

                // New Code is added





            }

            public String postServerData(){
                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                // ChildDetails user = new ChildDetails(first_name, last_name,do_b,sex,mother_name,"sts","dis","asdha",village_name);
                Login userda = new Login(user, pass);
                Call<LoginResponse> call1 = apiInterface.maidLogin(userda);
                call1.enqueue(new Callback<LoginResponse>() {

                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            /*Intent child = new Intent(getApplicationContext(), Modules1Activity.class);
                            startActivity(child);*/
                            pd.dismiss();
                            LoginResponse user1 = response.body();
                            status_message = response.body().getStatus_message();
                            userNameRes = response.body().getUserName();
                            userRol = response.body().getUserRole();
                            state = response.body().getStates();
                            dist = response.body().getDist();
                            villg = response.body().getVillage();
                            if (userRol.equalsIgnoreCase("0")) {
                                Intent childs = new Intent(getApplicationContext(), Modules1Activity.class);
                                childs.putExtra("username", userNameRes);
                                childs.putExtra("userRol", userRol);
                                childs.putExtra("state", state);
                                childs.putExtra("dist", dist);
                                childs.putExtra("villg", villg);
                                startActivity(childs);

                            } else  {

                                Intent i = new Intent(getApplicationContext(), Modules2Activity.class);


                                startActivity(i);


                            }

                           /* AlertDialog.Builder builder = new AlertDialog.Builder(
                                    LoginActvity.this);
                            builder.setTitle("Login");
                            builder.setMessage("Successfully Login is registered");
                            builder.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {

                                        }
                                    });
                            builder.show();*/


                        }


                    }

                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        call.cancel();
                        pd.dismiss();
                        /*Intent child = new Intent(LoginActvity.this,Modules1Activity.class);
                        startActivity(child);*/
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                LoginActvity.this);
                        builder.setTitle("Login");
                        builder.setMessage("Unable to register Login details . Please after Sometime");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        pd.dismiss();

                                        /*Intent child = new Intent(getApplicationContext(), Modules2Activity.class);
                                        startActivity(child);*/
                                    }
                                });
                        builder.show();
                    }

                });

                return status_message;
            }


            public boolean validation(String user , String pass){
                boolean data;
                if((user.equals(""))||(user==null)){
                    Toast.makeText(getApplicationContext(),"Please Enter User Name",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((pass.equals(""))||(pass==null)){
                    Toast.makeText(getApplicationContext(),"Please Enter Password",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                return data;
            }
        });

    }

    public  void AddData1() {

        boolean isInserted = myDb.insertData(user,pass);
        if(isInserted == true)
            Toast.makeText(LoginActvity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(LoginActvity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

    }

    }





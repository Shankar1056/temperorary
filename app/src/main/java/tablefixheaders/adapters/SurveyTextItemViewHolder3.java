package tablefixheaders.adapters;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;
import Database.DataBaseHelper.SQLiteHelper;
import mainscreen.govt.maidi.com.maidi.Modules1Activity;
import mainscreen.govt.maidi.com.maidi.R;
import pojo.ChildRegisterResponse;
import pojo.Pregnantwomen;
import pojo.Survey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurveyTextItemViewHolder3 extends RecyclerView.ViewHolder {

    private TextView textView;
    private Calendar cal;
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabaseObj;
    private int day;
    private int month;
    private int year;
    EditText et, houseno, pregnantWomen, age_year, husband_name, moblie, expected_date;
    Spinner Member, tetanus, ante_natal_check_up, for_anm_only;
    String Houseno, PregnantWomen, Age_year, Husband_name, Moblie, McpYes, Mcpno, Expected_date, Tetanus, Ante_natal_check_up, For_anm_only;
    private Button submit, cancel, Next;
    CheckBox mcpYes, mcpno;
    ProgressDialog pd = null;
    String status_message = null;
    LoginSQLiteHelper myDb;
    private Context context1;
    public SurveyTextItemViewHolder3(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        houseno = (EditText) itemView.findViewById(R.id.houseno);
        pregnantWomen = (EditText) itemView.findViewById(R.id.pregnantwomen);
        age_year = (EditText) itemView.findViewById(R.id.age_year);
        husband_name = (EditText) itemView.findViewById(R.id.husband_name);
        moblie = (EditText) itemView.findViewById(R.id.mobile);
        expected_date = (EditText) itemView.findViewById(R.id.expected_date);
        tetanus = (Spinner) itemView.findViewById(R.id.tetanus);
        ante_natal_check_up = (Spinner) itemView.findViewById(R.id.ante_natal_check_up);
        //for_anm_only = (Spinner) itemView.findViewById(R.id.for_anm_only);
        mcpYes = (CheckBox) itemView.findViewById(R.id.mcpYes);
        myDb = new LoginSQLiteHelper(context1);

        mcpno = (CheckBox) itemView.findViewById(R.id.mcpNo);
        submit = (Button) itemView.findViewById(R.id.button2);
        cancel = (Button) itemView.findViewById(R.id.button1);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                itemView.getContext().startActivity(child);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            APIInterface1 apiInterface = APIClient1.getClient().create(APIInterface1.class);

            @Override
            public void onClick(View v) {
                AddData();

                Houseno = houseno.getText().toString();
                PregnantWomen = pregnantWomen.getText().toString();
                Age_year = age_year.getText().toString();
                Husband_name = husband_name.getText().toString();
                Moblie = moblie.getText().toString();
                McpYes = mcpYes.getText().toString();
                Mcpno = mcpno.getText().toString();
                Expected_date = expected_date.getText().toString();
                Tetanus = tetanus.getSelectedItem().toString();
                Ante_natal_check_up = ante_natal_check_up.getSelectedItem().toString();
                Boolean str = validation(Houseno, PregnantWomen, Age_year, Husband_name, Moblie, McpYes, Expected_date, Tetanus, Ante_natal_check_up);

                if (str == true) {
                    String dataResponse = postServerData();

                }
                pd = new ProgressDialog(itemView.getContext());
                pd.setMessage("loading");
                pd.show();

            }

            private String postServerData() {
                // For_anm_only = for_anm_only.getSelectedItem().toString();
                Pregnantwomen user = new Pregnantwomen(Houseno, PregnantWomen, Age_year, Husband_name, Moblie, McpYes, Expected_date, Tetanus, Ante_natal_check_up);
                Call<ChildRegisterResponse> call1 = apiInterface.pregantwoman(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" Survey");
                        builder.setMessage("Successfully  is Survey registered");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        houseno.setText("");
                                        pregnantWomen.setText("");
                                        age_year.setText("");
                                        husband_name.setText("");
                                        moblie.setText("");
                                        mcpYes.setText("");
                                        mcpno.setText("");
                                        expected_date.setText("");
                                        tetanus.setAdapter(null);
                                    }
                                });
                        builder.show();

                        //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

                    }


                    public void onFailure(Call<ChildRegisterResponse> call, Throwable t) {
           /*     call.cancel();
                pd.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        itemView.getContext());
                builder.setTitle("Pregnant Women");
                builder.setMessage("Pregnant Women register Error");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                itemView.getContext().startActivity(child);
                         }
                  });
                builder.show();*/

                    }
                });
                return status_message;
            }

            public boolean validation(String Houseno, String PregnantWomen, String Age_year, String Husband_name, String Moblie, String McpYes, String Expected_date
                    , String Tetanus, String Ante_natal_check_up) {
                boolean data;
                if ((Houseno.equals("")) || (Houseno == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter User Name", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((PregnantWomen.equals("")) || (PregnantWomen == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Age_year.equals("")) || (Age_year == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Husband_name.equals("")) || (Husband_name == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Moblie.equals("")) || (Moblie == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((McpYes.equals("")) || (McpYes == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Tetanus.equals("")) || (Tetanus == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Expected_date.equals("")) || (Expected_date == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Ante_natal_check_up.equals("")) || (Ante_natal_check_up == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                return data;
            }

        });
    }
    public  void AddData() {

        boolean isInserted = myDb.insertData5( Houseno, PregnantWomen, Age_year, Husband_name, Moblie, McpYes, Mcpno, Expected_date, Tetanus, Ante_natal_check_up);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }

}






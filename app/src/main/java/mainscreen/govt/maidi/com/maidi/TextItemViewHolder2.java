package mainscreen.govt.maidi.com.maidi;


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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;
import Database.DataBaseHelper.SQLiteHelper;

import pojo.ChildRegisterResponse;
import pojo.Monthlyworkupdate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.adapters.APIInterface1;

public class TextItemViewHolder2 extends RecyclerView.ViewHolder {
    private TextView textView;
    private Calendar cal;
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabaseObj;
    private int day;
    private int month;
    private int year;
    private EditText et;
    ProgressDialog pd = null;
    LoginSQLiteHelper myDb;
    private Context context1;
    private Spinner select_week, select_village, Select_state, select_block, select_vaccine, select_planhours;
    private Button submit, cancel, Next;
    String status_message = null;

    String Et, Select_week, Select_village, select_state, Select_block, Select_vaccine, Select_planhours;

    public TextItemViewHolder2(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        textView = (TextView) itemView.findViewById(R.id.list_item);
        submit = (Button) itemView.findViewById(R.id.button2);
        // spinner1 = (Spinner) itemView.findViewById(R.id.spinner1);
        et = (EditText) itemView.findViewById(R.id.editText1);
        //et = (EditText) itemView.findViewById(R.id.editText1);
        select_week = (Spinner) itemView.findViewById(R.id.select_week);
        select_village = (Spinner) itemView.findViewById(R.id.select_village);
        Select_state = (Spinner) itemView.findViewById(R.id.Select_state);
        select_block = (Spinner) itemView.findViewById(R.id.select_block);
        select_vaccine = (Spinner) itemView.findViewById(R.id.select_vaccine);
        select_planhours = (Spinner) itemView.findViewById(R.id.select_planhours);
        // spinner3 = (Spinner) itemView.findViewById(R.id.Select_state);
        //spinner3 = (Spinner) itemView.findViewById(R.id.spinner4);
        //  spinner4 = (Spinner) itemView.findViewById(R.id.spinner5);
        // spinner5 = (Spinner) itemView.findViewById(R.id.spinner2);
        //submit = (Button)itemView.findViewById(R.id.button2);
        cancel = (Button) itemView.findViewById(R.id.button1);
        // myDb = new ANMLoginSQLiteHelper(context1);
        myDb = new LoginSQLiteHelper(context1);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(itemView.getContext(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yyyy");
                        et.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent child = new Intent(itemView.getContext(), MonthlyWorkActivity.class);
                itemView.getContext().startActivity(child);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {

            APIInterface1 apiInterface = APIClient.getClient().create(APIInterface1.class);

            @Override
            public void onClick(View v) {


                Et = et.getText().toString();
                Select_week = select_week.getSelectedItem().toString();
                Select_village = select_village.getSelectedItem().toString();
                select_state = Select_state.getSelectedItem().toString();
                Select_block = select_block.getSelectedItem().toString();
                Select_vaccine = select_vaccine.getSelectedItem().toString();
                Select_planhours = select_planhours.getSelectedItem().toString();
                AddData1();
                Boolean str = validation(Et, Select_week, Select_village, select_state, Select_block, Select_vaccine, Select_planhours);
                if (str == true) {
                    String dataResponse = postServerData();
                    postToDB();
                    pd = new ProgressDialog(itemView.getContext());
                    pd.setMessage("loading");
                    pd.show();
                }
            }

            private String postServerData() {

                Monthlyworkupdate user = new Monthlyworkupdate(Et, Select_week, Select_village, select_state, Select_block, Select_vaccine);
                Call<ChildRegisterResponse> call1 = apiInterface.Monthlyworkupdate(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {
                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();

                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" Monthly work Plan Updated ");
                        builder.setMessage("Successfully  is Update");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                       /* Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                        itemView.getContext().startActivity(child);*/

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
                                itemView.getContext());
                        builder.setTitle("Update");
                        builder.setMessage("Report Writing register Error");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                        itemView.getContext().startActivity(child);
                                    }
                                });
                        builder.show();
                    }

                });


                return status_message;

            }

            public boolean validation(String Et,String Select_week,String Select_village,String select_state,String Select_block,String Select_vaccine,String Select_placehours) {
                boolean data;
                if ((Et.equals("")) || (Et == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Date", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Select_week.equals("")) || (Select_week == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Select Week", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Select_village.equals("")) || (Select_village == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Select Village", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((select_state.equals("")) || (select_state == null)) {
                    Toast.makeText(itemView.getContext(), "Please Select State", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Select_block.equals("")) || (Select_block == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Select Block ", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Select_vaccine.equals("")) || (Select_vaccine == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Select Vaccine", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Select_placehours.equals("")) || (Select_placehours == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Area Code ", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                return data;
            }
        });
    }

    private void postToDB() {

        boolean isInserted = myDb.insertData10(Et, Select_week, Select_village, select_state, Select_block, Select_vaccine, Select_planhours);
    }



    public  void AddData1() {

        boolean isInserted = myDb.insertData12(Et, Select_week, Select_village, select_state, Select_block, Select_vaccine, Select_planhours);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}

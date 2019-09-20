package mainscreen.govt.maidi.com.maidi;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import pojo.ChildRegisterResponse;
import pojo.Diluent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.adapters.APIInterface1;

public class AefiTextItemViewHolder3 extends RecyclerView.ViewHolder   {
    private TextView textView;
    private Calendar cal;
    ProgressDialog pd = null;

    private int day;
    private int month;
    private int year;
    EditText diluent,batch_lot,date,time ,expiry_date;
    Button submit, cancel;
    LoginSQLiteHelper myDb;
    private Context context1;
String Diluent,Batch_lot,Expiry_date,Date,Time;
    public AefiTextItemViewHolder3(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        diluent=(EditText) itemView.findViewById(R.id.diluent);
        batch_lot=(EditText)itemView.findViewById(R.id.batch_lot);
        date=(EditText)itemView.findViewById(R.id.date);
        time=(EditText) itemView.findViewById(R.id.time);
        expiry_date=(EditText)itemView.findViewById(R.id.expiry_date);
        submit=(Button) itemView.findViewById(R.id.button2);
        myDb = new LoginSQLiteHelper(context1);

        cancel=(Button) itemView.findViewById(R.id.button1);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent child = new Intent(itemView.getContext(),Modules1Activity.class);

                itemView.getContext().startActivity(child);

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                APIInterface1 apiInterface = APIClient.getClient().create(APIInterface1.class);
                Diluent=    diluent.getText().toString();
                Batch_lot= batch_lot.getText().toString();
                Expiry_date= expiry_date.getText().toString();
                date.getText().toString();
                Date= time.getText().toString();
                AddDataaefi3();

                pd = new ProgressDialog( itemView.getContext());
                pd.setMessage("loading");
                pd.show();
                Diluent user = new Diluent(Diluent,Batch_lot,Expiry_date,Date,Time);
                Call<ChildRegisterResponse> call1 = apiInterface.diluent(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();
                        pd.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" Diluent");
                        builder.setMessage("Successfully  is Diluent ");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        /*Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
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
                builder.setTitle("Report Writing");
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
            }
        });
        expiry_date.setOnClickListener(new View.OnClickListener() {
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
                        expiry_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
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
                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }
    public  void AddDataaefi3() {

        boolean isInserted = myDb.insertData6(Diluent,Batch_lot,Expiry_date,Date,Time);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}

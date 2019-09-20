package mainscreen.govt.maidi.com.maidi;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import pojo.AEIVaccineDetails;
import pojo.AefiReportwriting;
import pojo.ChildRegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.adapters.APIInterface1;

public class AefiTextItemViewHolder2 extends RecyclerView.ViewHolder   {
    private TextView textView;
    private Calendar cal;
    ProgressDialog pd = null;
    String status_message = null;
    LoginSQLiteHelper myDb;
    private Context context1;
    private int day;
    private int month;
    private int year;
    EditText vaccine_date,vaccine_time,batch_lot,expriy_date,contant_number,address,area_code;
    Spinner vaccine_name, vaccine_dose, spinner3, spinner4, spinner5;
    Button submit, cancel;
String vaccine_name1,vaccine_date1,vaccine_time1,vaccine_dose1,batch_lot1,expriy_date1;
    public AefiTextItemViewHolder2(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        vaccine_name=(Spinner)itemView.findViewById(R.id.vaccine_name);
        vaccine_date=(EditText)itemView.findViewById(R.id.vaccine_date);
        vaccine_time=(EditText)itemView.findViewById(R.id.vaccine_time);
        vaccine_dose=(Spinner) itemView.findViewById(R.id.vaccine_dose);
        batch_lot=(EditText)itemView.findViewById(R.id.batch_lot);
        expriy_date=(EditText)itemView.findViewById(R.id.expriy_date);
        submit=(Button) itemView.findViewById(R.id.button2);
cancel=(Button) itemView.findViewById(R.id.button1);
        myDb = new LoginSQLiteHelper(context1);

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
                                          Boolean str = validation(vaccine_name1, vaccine_date1, vaccine_time1, vaccine_dose1, batch_lot1, expriy_date1);
                                          if (str == true) {
                                              String dataResponse = postServerData();
                                              pd = new ProgressDialog(itemView.getContext());
                                              pd.setMessage("loading");
                                              pd.show();
                                              AddDataaefi2();
                                          }

                                      }

                                      public String postServerData() {


                                          APIInterface1 apiInterface = APIClient.getClient().create(APIInterface1.class);

                                          vaccine_name1 = vaccine_name.getSelectedItem().toString();
                                          vaccine_date1 = vaccine_date.getText().toString();
                                          vaccine_time1 = vaccine_time.getText().toString();
                                          vaccine_dose1 = vaccine_dose.getSelectedItem().toString();
                                          batch_lot1 = batch_lot.getText().toString();
                                          expriy_date1 = expriy_date.getText().toString();
                                          pd = new ProgressDialog(itemView.getContext());
                                          pd.setMessage("loading");
                                          pd.show();
                                          AefiReportwriting user = new AefiReportwriting(vaccine_name1, vaccine_date1, vaccine_time1, vaccine_dose1, batch_lot1, expriy_date1);
                                          Call<ChildRegisterResponse> call1 = apiInterface.reportdetails(user);
                                          call1.enqueue(new Callback<ChildRegisterResponse>() {

                                              public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                                                  ChildRegisterResponse user1 = response.body();
                                                  pd.dismiss();
                                                  android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(
                                                          itemView.getContext());
                                                  builder.setTitle(" Report Details ");
                                                  builder.setMessage("Successfully  is Report Details");
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
                                                  android.app.AlertDialog.Builder builder = new AlertDialog.Builder(
                                                          itemView.getContext());
                                                  builder.setTitle("Vacine Details");
                                                  builder.setMessage("Vacine Details register Error");
                                                  builder.setPositiveButton("OK",
                                                          new DialogInterface.OnClickListener() {
                                                              public void onClick(DialogInterface dialog,
                                                                                  int which) {
                                       /* Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                        itemView.getContext().startActivity(child);*/
                                                              }
                                                          });
                                                  builder.show();
                                              }



                                          });
                                          return status_message;
                                      }
            public boolean validation(String vaccine_name1,String vaccine_date1,String vaccine_time1,String
                    vaccine_dose1, String batch_lot1,String expriy_date1) {
                boolean data;
                if ((vaccine_name1.equals("")) || (vaccine_name1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Vaccine Name", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((vaccine_date1.equals("")) || (vaccine_date1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Vaccine Date", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((vaccine_time1.equals("")) || (vaccine_time1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Vaccine Time", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((vaccine_dose1.equals("")) || (vaccine_dose1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Vaccine Dose", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((batch_lot1.equals("")) || (batch_lot1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Lot number", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((expriy_date1.equals("")) || (expriy_date1 == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Expriy Date", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }

                return data;
            }
                                  });
        vaccine_date.setOnClickListener(new View.OnClickListener() {
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
                        vaccine_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        expriy_date.setOnClickListener(new View.OnClickListener() {
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
                        expriy_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }
    public  void AddDataaefi2() {

        boolean isInserted = myDb.insertData9(vaccine_name1,vaccine_date1,vaccine_time1,vaccine_dose1,batch_lot1,expriy_date1);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}

package mainscreen.govt.maidi.com.maidi;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;
import pojo.AefiReportwriting;
import pojo.ChildRegisterResponse;
import pojo.Survey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.adapters.APIInterface1;

public class AefiTextItemViewHolder1 extends RecyclerView.ViewHolder {
    private TextView textView;
    private Calendar cal;
    ProgressDialog pd = null;

    private int day;
    private int month;
    private int year;
    EditText reporter_aefi, location, designation, email, contant_number, address, area_code;
    String Reporter_aefi, Location, Designation, Email, Contant_number, Address, Area_code;
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    Button submit, cancel;
    String status_message = null;
    LoginSQLiteHelper myDb;
    private Context context1;
    public AefiTextItemViewHolder1(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        reporter_aefi = (EditText) itemView.findViewById(R.id.reporter_aefi);
        location = (EditText) itemView.findViewById(R.id.location);
        designation = (EditText) itemView.findViewById(R.id.designation);
        email = (EditText) itemView.findViewById(R.id.email);
        contant_number = (EditText) itemView.findViewById(R.id.contant_number);
        address = (EditText) itemView.findViewById(R.id.address);
        area_code = (EditText) itemView.findViewById(R.id.area_code);
        submit = (Button) itemView.findViewById(R.id.button2);
        cancel = (Button) itemView.findViewById(R.id.button1);
        myDb = new LoginSQLiteHelper(context1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reporter_aefi = reporter_aefi.getText().toString();
                Location = location.getText().toString();
                Designation = designation.getText().toString();
                Email = email.getText().toString();
                Contant_number = contant_number.getText().toString();
                Address = address.getText().toString();
                Area_code = area_code.getText().toString();
                Boolean str = validation(Reporter_aefi, Location, Designation, Contant_number, Address, Area_code);
                if (str == true) {
                    String dataResponse = postServerData();
                    pd = new ProgressDialog(itemView.getContext());
                    pd.setMessage("loading");
                    pd.show();
                    AddDataaefi1();

                }
            }
                private String postServerData() {
                    APIInterface1 apiInterface = APIClient.getClient().create(APIInterface1.class);

                AefiReportwriting user = new AefiReportwriting(Reporter_aefi, Location, Designation, Email, Contant_number, Address);
                Call<ChildRegisterResponse> call1 = apiInterface.reportdetails(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" Report Details ");
                        builder.setMessage("Successfully  is Report Details");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                       /* Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                        itemView.getContext().startActivity(child);*/

                                        pd.dismiss();
                                        reporter_aefi.setText("");
                                        location.setText("");
                                        designation.setText("");
                                        email.setText("");
                                        contant_number.setText("");
                                        address.setText("");
                                        area_code.setText("");
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
                                    }
                                });
                        builder.show();
                    }
                });
                    return status_message;


                }
            public boolean validation(String Reporter_aefi,String Location,String Designation,String Contant_number,String Address,
                                      String   Area_code) {
                boolean data;
                if ((Reporter_aefi.equals("")) || (Reporter_aefi == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Reporter Aefi", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Location.equals("")) || (Location == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Institution/Location", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Designation.equals("")) || (Designation == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Designation/Department", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Contant_number.equals("")) || (Contant_number == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Contant Number", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Address.equals("")) || (Address == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Address", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Area_code.equals("")) || (Area_code == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter  Area Code", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }

               return data;
            }
        });




        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent child = new Intent(itemView.getContext(),Modules1Activity.class);

                itemView.getContext().startActivity(child);

            }
        });
    }
    public  void AddDataaefi1() {

        boolean isInserted = myDb.insertData7(Reporter_aefi, Location, Designation, Email, Contant_number, Address, Area_code);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}

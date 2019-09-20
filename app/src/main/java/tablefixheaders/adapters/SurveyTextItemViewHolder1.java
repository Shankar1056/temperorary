package tablefixheaders.adapters;

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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;
import mainscreen.govt.maidi.com.maidi.Modules1Activity;
import mainscreen.govt.maidi.com.maidi.R;
import pojo.ChildRegisterResponse;
import pojo.Survey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SurveyTextItemViewHolder1 extends RecyclerView.ViewHolder {
    private Context context1;
    private TextView textView;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    EditText et, edtextfrist, edtextlast, mobile, btn_date1, sub_center, anm, area, areacode;
    Button submit, cancel;
    String firstName, lastName, mobileNum, date, Sub_center, anmDet, areaDet, areaCode;
    ProgressDialog pd = null;
    String status_message = null;
    LoginSQLiteHelper myDb;

    public SurveyTextItemViewHolder1(final View itemView) {
        super(itemView);
        context1 = itemView.getContext();
        edtextfrist = (EditText) itemView.findViewById(R.id.edtextfrist);
        edtextlast = (EditText) itemView.findViewById(R.id.edtextlast);
        mobile = (EditText) itemView.findViewById(R.id.mobile);
        btn_date1 = (EditText) itemView.findViewById(R.id.btn_date1);
        sub_center = (EditText) itemView.findViewById(R.id.sub_center);
        anm = (EditText) itemView.findViewById(R.id.anm);
        area = (EditText) itemView.findViewById(R.id.area);
        areacode = (EditText) itemView.findViewById(R.id.areacode);
        submit = (Button) itemView.findViewById(R.id.button2);
        cancel = (Button) itemView.findViewById(R.id.button1);
        myDb = new LoginSQLiteHelper(context1);

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

                firstName = edtextfrist.getText().toString();
                lastName = edtextlast.getText().toString();
                mobileNum = mobile.getText().toString();
                date = btn_date1.getText().toString();
                Sub_center = sub_center.getText().toString();
                anmDet = anm.getText().toString();
                areaDet = area.getText().toString();
                areaCode = areacode.getText().toString();
                AddData();


                Boolean str = validation(firstName, lastName, mobileNum, date, Sub_center, anmDet, areaDet, areaCode);
                if (str == true) {
                    String dataResponse = postServerData();
                    pd = new ProgressDialog(itemView.getContext());
                    pd.setMessage("loading");
                    pd.show();
                }

            }

            private String postServerData() {
                Survey user = new Survey(firstName, mobileNum, date, Sub_center, anmDet, areaDet, areaCode);
                Call<ChildRegisterResponse> call1 = apiInterface.createServy(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();

                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" ANM/AWW Detail");
                        builder.setMessage("Successfully  is ANM/AWW Detail");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {

                                        pd.dismiss();
                                        edtextfrist.setText("");
                                        edtextlast.setText("");
                                        mobile.setText("");
                                        btn_date1.setText("");
                                        sub_center.setText("");
                                        anm.setText("");
                                        area.setText("");
                                        areacode.setText("");
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
                        builder.setTitle("Survey");
                        builder.setMessage(t.getMessage());
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
                    //Toast.makeText(itemView.getContext(), ""+edtextfrist.getText().toString(), Toast.LENGTH_SHORT).show();

                });


                return status_message;

            }

            public boolean validation(String firstName, String lastName, String mobileNum, String date, String Sub_center
                    , String anmDet, String areaDet, String areaCode) {
                boolean data;
                if ((firstName.equals("")) || (firstName == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Frist Name", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((lastName.equals("")) || (lastName == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Last Name", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((mobileNum.equals("")) || (mobileNum == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((date.equals("")) || (date == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Date", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((Sub_center.equals("")) || (Sub_center == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Sub Center ", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((areaDet.equals("")) || (anmDet == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Name of ANM", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                if ((areaCode.equals("")) || (areaCode == null)) {
                    Toast.makeText(itemView.getContext(), "Please Enter Area Code ", Toast.LENGTH_LONG).show();
                    data = false;
                } else {
                    data = true;
                }
                return data;
            }

  /* public void bind(String text){
            et.setText(text);
        }
*/


        });
        btn_date1.setOnClickListener(new View.OnClickListener() {
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
                        btn_date1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });
    }

    public void AddData() {

        boolean isInserted = myDb.insertData3(firstName, lastName, mobileNum, date, Sub_center, anmDet, areaDet, areaCode);
        if (isInserted == true)
            Toast.makeText(itemView.getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();

    }


}
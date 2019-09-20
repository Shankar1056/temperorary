package tablefixheaders.adapters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DataBaseHelper.LoginSQLiteHelper;
import mainscreen.govt.maidi.com.maidi.ChildViewActivity;
import mainscreen.govt.maidi.com.maidi.Modules1Activity;
import mainscreen.govt.maidi.com.maidi.MonthlyViewRequest;
import mainscreen.govt.maidi.com.maidi.R;
import pojo.ChildRegisterResponse;
import pojo.ChildViewResponse;
import pojo.Monthlyworkupdate;
import pojo.Monthlyworkview;
import pojo.Serveyhousedetail;
import pojo.monthlyViewRequest;
import pojo.monthlyViewResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonthlyTextItemViewHolder extends RecyclerView.ViewHolder {
    TextView txtName, textasha, txtvillage,txthour,txtplacehour, txtName1, textasha1, txtvillage1, txthour1, txtName2, textasha2, txtvillage2, txthour2, txtName3, textasha3, txtvillage3, txthour3, txtName4, textasha4, txtvillage4,txthour4, txtName5, textasha5, txtvillage5, txthour5;
    CalendarView simpleCalendarView;
    String TxtName, Textasha, Village, Hour, TxtName1, Textasha1, Village1, Hour1, TxtName2, Textasha2, Village2, Hour2, TxtName3, Textasha3, Village3, Hour3, TxtName4, Textasha4, Village4, Hour4,
            TxtName5, Textasha5, Village5, Hour5;
    ProgressDialog pd = null;
    LoginSQLiteHelper myDb;
    private Context context1;

    public MonthlyTextItemViewHolder(final View itemView) {
        super(itemView);
        // simpleCalendarView = (CalendarView)itemView.findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        /*Button button = (Button)itemView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), MonthlyFragment2.class);
                itemView.getContext().startActivity(intent);
            }
        });*/
        txtName = (TextView) itemView.findViewById(R.id.txtName);
        textasha = (TextView) itemView.findViewById(R.id.textasha);
        txtvillage = (TextView) itemView.findViewById(R.id.village);
        txthour = (TextView) itemView.findViewById(R.id.hour);
        txtName1 = (TextView) itemView.findViewById(R.id.txtName1);
        textasha1 = (TextView) itemView.findViewById(R.id.textasha1);
        txtvillage1 = (TextView) itemView.findViewById(R.id.village1);
        txthour1 = (TextView) itemView.findViewById(R.id.hour1);

        txtName2 = (TextView) itemView.findViewById(R.id.txtName2);
        textasha2 = (TextView) itemView.findViewById(R.id.textasha2);
        txtvillage2 = (TextView) itemView.findViewById(R.id.village2);
        txthour2 = (TextView) itemView.findViewById(R.id.hour2);
        txtName3 = (TextView) itemView.findViewById(R.id.txtName3);
        textasha3 = (TextView) itemView.findViewById(R.id.textasha3);
        txtvillage3 = (TextView) itemView.findViewById(R.id.village3);
        txthour3 = (TextView) itemView.findViewById(R.id.hour3);
        context1=itemView.getContext();

        txtName4 = (TextView) itemView.findViewById(R.id.txtName4);
        textasha4 = (TextView) itemView.findViewById(R.id.textasha4);
        txtvillage4 = (TextView) itemView.findViewById(R.id.village4);
        txthour4 = (TextView) itemView.findViewById(R.id.hour4);
        txtName5 = (TextView) itemView.findViewById(R.id.txtName5);
        textasha5 = (TextView) itemView.findViewById(R.id.textasha5);
        txtvillage5 = (TextView) itemView.findViewById(R.id.village5);
        txthour5 = (TextView) itemView.findViewById(R.id.hour5);
        myDb = new LoginSQLiteHelper(context1);

        /*simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast

                Intent child = new Intent(itemView.getContext(), SimpleTable.class);
                itemView.getContext().startActivity(child);
                Toast.makeText(itemView.getContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });*/


        TxtName = txtName.getText().toString();
        Textasha = textasha.getText().toString();
        Village = txtvillage.getText().toString();
        Hour = txthour.getText().toString();
        TxtName1 = txtName1.getText().toString();
        Textasha1 = textasha1.getText().toString();
        Village1 = txtvillage1.getText().toString();
        Hour1 = txthour1.getText().toString();
        TxtName2 = txtName2.getText().toString();
        Textasha2 = textasha2.getText().toString();
        Village2 = txtvillage2.getText().toString();
        Hour2 = txthour2.getText().toString();
        TxtName3 = txtName3.getText().toString();
        Textasha3 = textasha3.getText().toString();
        Village3 = txtvillage3.getText().toString();
        Hour3 = txthour3.getText().toString();
        TxtName4 = txtName4.getText().toString();
        Textasha4 = textasha4.getText().toString();
        Village4 = txtvillage4.getText().toString();
        Hour4 = txthour4.getText().toString();
        TxtName5 = txtName5.getText().toString();
        Textasha5 = textasha5.getText().toString();
        Village5 = txtvillage5.getText().toString();
        Hour5 = txthour5.getText().toString();
        // String SimpleCalendarView = simpleCalendarView.getRootView().toString();

        // monthlyViewRequest user = new monthlyViewRequest(SimpleCalendarView);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        MonthlyViewRequest monthly = new MonthlyViewRequest("13-12-1989");

        Call<monthlyViewResponse> call1 = apiInterface.monthlyview(monthly);
        call1.enqueue(new Callback<monthlyViewResponse>() {
            public void onResponse(Call<monthlyViewResponse> call, Response<monthlyViewResponse> response) {
                monthlyViewResponse user1 = response.body();
                if (response.isSuccessful()) {
                    String childNames = response.body().getChildNames();
                    String ashaname = response.body().getAshaWorkerDetails();
                    String village = response.body().getVillageName();
                    String hour = response.body().getWeekHours();
                    String childNames1 = response.body().getChildNames();
                    String ashaname1 = response.body().getAshaWorkerDetails();
                    String village1 = response.body().getVillageName();
                    String hour1 = response.body().getWeekHours();
                    String childNames2 = response.body().getChildNames();
                    String ashaname2 = response.body().getAshaWorkerDetails();
                    String village2 = response.body().getVillageName();
                    String hour2 = response.body().getWeekHours();
                    String childNames3 = response.body().getChildNames();
                    String ashaname3 = response.body().getAshaWorkerDetails();
                    String village3 = response.body().getVillageName();
                    String hour3 = response.body().getWeekHours();
                    String childNames4 = response.body().getChildNames();
                    String ashaname4 = response.body().getAshaWorkerDetails();
                    String village4 = response.body().getVillageName();
                    String hour4 = response.body().getWeekHours();
                    String childNames5 = response.body().getChildNames();
                    String ashaname5 = response.body().getAshaWorkerDetails();
                    String village5 = response.body().getVillageName();
                    String hour5 = response.body().getVillageName();
                    txtName.setText(childNames);
                    textasha.setText(ashaname);
                    txtvillage.setText(village);
                    txthour.setText(hour);
                    txtName1.setText(childNames1);
                    textasha1.setText(ashaname1);
                    txtvillage1.setText(village1);
                    txthour1.setText(hour1);
                    txtName2.setText(childNames2);
                    textasha2.setText(ashaname2);
                    txtvillage2.setText(village2);
                    txthour2.setText(hour2);
                    txtName3.setText(childNames3);
                    textasha3.setText(ashaname3);
                    txtvillage3.setText(village3);
                    txthour3.setText(hour3);
                    txtName4.setText(childNames4);
                    textasha4.setText(ashaname4);
                    txtvillage4.setText(village4);
                    txthour4.setText(hour4);
                    txtName5.setText(childNames5);
                    textasha5.setText(ashaname5);
                    txtvillage5.setText(village5);
                    txthour5.setText(hour5);
                                    }
            }

            @Override
            public void onFailure(Call<monthlyViewResponse> call, Throwable t) {

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        itemView.getContext());
                builder.setTitle("Monthly View");
                builder.setMessage("Week One register Error");
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
            }
        });
    }
    public void AddData() {
        //  String uids = uid.getText().toString();
//childName, motherName,fatherName,mobile,dob,pob,soc,brtype,gstAge,bithWeight,abnormal,remarks

        monthlyViewResponse childDetails = myDb.getfetch();
        Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        txtName.setText(childDetails.getChildNames());

        textasha.setText(childDetails.getAshaWorkerDetails());
/*
        txtvillage.setText(childDetails.getVillageName());
        txthour.setText(childDetails.getWeekHours());
        txtName1.setText(childDetails.getChildNames());
        textasha1.setText(childDetails.getAshaWorkerDetails());
        txtvillage1.setText(childDetails.getVillageName());
        txthour1.setText(childDetails.getWeekHours());
        txtName2.setText(childDetails.getChildNames());
        textasha2.setText(childDetails.getAshaWorkerDetails());
        txtvillage2.setText(childDetails.getVillageName());
        txthour2.setText(childDetails.getWeekHours());
        txtName3.setText(childDetails.getChildNames());
        textasha3.setText(childDetails.getAshaWorkerDetails());
        txtvillage3.setText(childDetails.getVillageName());
        txthour3.setText(childDetails.getWeekHours());
        txtName4.setText(childDetails.getChildNames());
        textasha4.setText(childDetails.getAshaWorkerDetails());
        txtvillage4.setText(childDetails.getVillageName());
        txthour4.setText(childDetails.getWeekHours());
        txtName5.setText(childDetails.getChildNames());
        textasha5.setText(childDetails.getAshaWorkerDetails());
        txtvillage5.setText(childDetails.getVillageName());
        txthour5.setText(childDetails.getWeekHours());
*/


    }
}



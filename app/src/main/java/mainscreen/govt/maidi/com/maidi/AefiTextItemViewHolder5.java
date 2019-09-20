package mainscreen.govt.maidi.com.maidi;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import tablefixheaders.adapters.APIInterface1;

public class AefiTextItemViewHolder5 extends RecyclerView.ViewHolder   {
    private TextView textView;
    private Calendar cal;
    ProgressDialog pd = null;

    private int day;
    private int month;
    private int year;
     EditText past,specify,date_investigation,date_done;
     Spinner outcome,finalclassification;
     Button submit ,cancel;
    CheckBox  severeyes,severeno,deathyes,deathno,life_threateningyes,life_threateningno,persistententyes,persistententno,congantalyes,congantalno,otheryes,otherno;
String Severeyes,Severeno,Deathyes,Deathno,Life_threateningyes,Life_threateningno,Persistententyes,Persistententno,Congantalyes,Congantalno,Otheryes,Otherno,Specify
        ,Past,Date_investigation,Date_done,Finalclassification,Outcome;
    public AefiTextItemViewHolder5(final View itemView) {
        super(itemView);
        severeyes=(CheckBox)itemView.findViewById(R.id.severeyes);
        severeno=(CheckBox)itemView.findViewById(R.id.severeno);
        deathyes=(CheckBox)itemView.findViewById(R.id.deathyes);
        deathno=(CheckBox)itemView.findViewById(R.id.deathno);
        life_threateningyes=(CheckBox)itemView.findViewById(R.id.life_threateningyes);
        life_threateningno=(CheckBox)itemView.findViewById(R.id.life_threateningno);
        persistententyes=(CheckBox)itemView.findViewById(R.id.persistententno);
        persistententno=(CheckBox)itemView.findViewById(R.id.persistententno);
        congantalyes=(CheckBox)itemView.findViewById(R.id.congantalyes);
        congantalno=(CheckBox)itemView.findViewById(R.id.congantalno);
        otherno=(CheckBox)itemView.findViewById(R.id.otherno);
        otheryes=(CheckBox)itemView.findViewById(R.id.otheryes);
        specify=(EditText) itemView.findViewById(R.id.specify);
        date_investigation=(EditText) itemView.findViewById(R.id.date_investigation);
        date_done=(EditText) itemView.findViewById(R.id.date_done);
        outcome=(Spinner) itemView.findViewById(R.id.outcome);
        past=(EditText) itemView.findViewById(R.id.past);
        finalclassification=(Spinner) itemView.findViewById(R.id.finalclassification);
        submit=(Button) itemView.findViewById(R.id.button2);
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

                Severeyes=  severeyes.getText().toString();
                Severeno=   severeno.getText().toString();
                Deathyes=  deathyes.getText().toString();
                Deathno=  deathno.getText().toString();
                Life_threateningyes=    life_threateningyes.getText().toString();
                Life_threateningno=  life_threateningno.getText().toString();
                Persistententyes=   persistententyes.getText().toString();
                Persistententno=persistententno.getText().toString();
                Congantalyes=  congantalyes.getText().toString();
                Congantalno=  congantalno.getText().toString();
                Otherno=  otherno.getText().toString();
                Otheryes=  otheryes.getText().toString();
                Specify= specify.getText().toString();
                Date_investigation=   date_investigation.getText().toString();
                Date_done=   date_done.getText().toString();
                Outcome=    outcome.getSelectedItem().toString();

                Finalclassification=   finalclassification.getSelectedItem().toString();
                pd = new ProgressDialog( itemView.getContext());
                pd.setMessage("loading");
                pd.show();
/* Survey user = new Survey(firstName,mobileNum,date,Sub_center,anmDet,areaDet,areaCode);
                Call<ChildRegisterResponse> call1 = apiInterface.createServy(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();
                        pd.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" Survey");
                        builder.setMessage("Successfully  is Survey registered");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                                        itemView.getContext().startActivity(child);
                                    }
                                });
                        builder.show();

                        //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

                    }

                    public void onFailure(Call<ChildRegisterResponse> call, Throwable t) {
             *//*   call.cancel();
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
*//*                         //   }
                        //   });
                        // builder.show();
                    }
                });*/

            }
        });
        date_investigation.setOnClickListener(new View.OnClickListener() {
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
                        date_investigation.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        date_done.setOnClickListener(new View.OnClickListener() {
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
                        date_done.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }
}

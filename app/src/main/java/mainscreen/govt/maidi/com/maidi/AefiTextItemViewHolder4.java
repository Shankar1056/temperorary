package mainscreen.govt.maidi.com.maidi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import Database.DataBaseHelper.LoginSQLiteHelper;
import pojo.Adverseevent;
import pojo.ChildRegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tablefixheaders.adapters.APIInterface1;

public class AefiTextItemViewHolder4 extends RecyclerView.ViewHolder   {
    private TextView textView;
    private Calendar cal;
    ProgressDialog pd = null;
    LoginSQLiteHelper myDb;
    private Context context1;
    String severeyes,severeno,seizuresyes,seizuresno,abscessyes,abscessno,sepsisyes,sepsisno,encephalopathyyes,encephalopathyno,
        toxicyes,toxicno,thromboctpeniayes,thromboctpeniano,anaphylaxisyes,anaphylaxisno,feveryes,feverno,otheryes,otherno,specify_other,event_time
        ,severe;
EditText Specify_other,Event_time,Severe;
CheckBox Severeyes,Severeno,Seizuresyes,Seizuresno,Abscessyes,Abscessno,Sepsisyes,Sepsisno,Encephalopathyyes,Encephalopathyno,
        Toxicyes,Toxicno,Thromboctpeniayes,Thromboctpeniano,Anaphylaxisyes,Anaphylaxisno,Feveryes,Feverno,Otheryes,Otherno;
    private int day;
    private int month;
    private int year;
    private EditText et;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
     Button submit, cancel;

    public AefiTextItemViewHolder4(final View itemView) {
        super(itemView);
        Severeyes=(CheckBox) itemView.findViewById(R.id.severeyes);
        Severeno=(CheckBox) itemView.findViewById(R.id.severeno);
        Seizuresyes=(CheckBox) itemView.findViewById(R.id.seizuresyes);
        Seizuresno=(CheckBox) itemView.findViewById(R.id.seizuresno);
        Abscessyes=(CheckBox) itemView.findViewById(R.id.abscessyes);
        Abscessno=(CheckBox) itemView.findViewById(R.id.abscessno);
        Sepsisyes=(CheckBox) itemView.findViewById(R.id.sepsisyes);
        Sepsisno=(CheckBox) itemView.findViewById(R.id.sepsisno);
        Encephalopathyyes=(CheckBox) itemView.findViewById(R.id.encephalopathyyes);
        Encephalopathyno=(CheckBox) itemView.findViewById(R.id.encephalopathyno);
        Toxicyes=(CheckBox) itemView.findViewById(R.id.toxicyes);
        Toxicno=(CheckBox) itemView.findViewById(R.id.toxicno);
        Thromboctpeniayes=(CheckBox) itemView.findViewById(R.id.thromboctpeniayes);
        Thromboctpeniano=(CheckBox) itemView.findViewById(R.id.thromboctpeniano);
        Anaphylaxisyes=(CheckBox) itemView.findViewById(R.id.anaphylaxisyes);
        Anaphylaxisno=(CheckBox) itemView.findViewById(R.id.anaphylaxisno);
        Feveryes=(CheckBox) itemView.findViewById(R.id.feveryes);
        Feverno=(CheckBox) itemView.findViewById(R.id.otheryes);
        Otheryes=(CheckBox) itemView.findViewById(R.id.otherno);
        Otherno=(CheckBox) itemView.findViewById(R.id.otherno);
        Specify_other=(EditText) itemView.findViewById(R.id.specify_other);
        Event_time=(EditText) itemView.findViewById(R.id.event_time);
        Severe=(EditText) itemView.findViewById(R.id.severe);
        submit=(Button) itemView.findViewById(R.id.button2);
        cancel=(Button) itemView.findViewById(R.id.button1);
        context1=itemView.getContext();
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

                APIInterface1 apiInterface = APIClient.getClient().create(APIInterface1.class);

                severeyes=  Severeyes.getText().toString();
                severeno=   Severeno.getText().toString();
                seizuresyes=  Seizuresyes.getText().toString();
                seizuresno=  Seizuresno.getText().toString();
                abscessyes=  Abscessyes.getText().toString();
                abscessno=    Abscessno.getText().toString();
                sepsisyes=  Sepsisyes.getText().toString();
                sepsisno=   Sepsisno.getText().toString();
                encephalopathyyes=Encephalopathyyes.getText().toString();
                encephalopathyno=  Encephalopathyno.getText().toString();
                toxicyes=  Toxicyes.getText().toString();
                toxicno=  Toxicno.getText().toString();
                thromboctpeniayes=  Thromboctpeniayes.getText().toString();
                thromboctpeniano= Thromboctpeniano.getText().toString();
                anaphylaxisyes=   Anaphylaxisyes.getText().toString();
                feveryes=   Feveryes.getText().toString();
                feverno=    Feverno.getText().toString();
                otheryes=  Otheryes.getText().toString();
                specify_other=   Specify_other.getText().toString();
                event_time=  Event_time.getText().toString();
                severe=  Severe.getText().toString();
                pd = new ProgressDialog( itemView.getContext());
                pd.setMessage("loading");
                pd.show();
                AddDataaefi4();

                Adverseevent user = new Adverseevent(severeyes,seizuresyes,abscessyes,sepsisyes,encephalopathyyes,toxicyes,thromboctpeniayes,anaphylaxisyes,feveryes,otheryes,specify_other,event_time,severe
                );
                Call<ChildRegisterResponse> call1 = apiInterface.adverseevent(user);
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

    }
    public  void AddDataaefi4() {

        boolean isInserted = myDb.insertData7(severeyes,severeno,seizuresyes,seizuresno,abscessyes,abscessno,sepsisyes,sepsisno,encephalopathyyes,encephalopathyno,
                toxicyes,toxicno,thromboctpeniayes,thromboctpeniano,anaphylaxisyes,anaphylaxisno,feveryes,feverno,otheryes,otherno,specify_other,event_time
                );
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}

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
import mainscreen.govt.maidi.com.maidi.Page3Fragment;
import mainscreen.govt.maidi.com.maidi.R;
import pojo.ChildRegisterResponse;
import pojo.Serveyhousedetail;
import pojo.Survey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurveyTextItemViewHolder2 extends RecyclerView.ViewHolder {

    private TextView textView;
    private Calendar cal;
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabaseObj;
    private int day;
    private int month;
    private int year;
    private Context context;

    EditText et, houseno, family_head, fathername;
    Spinner Member, tetanus, ante_natal_check_up, for_anm_only, member;
    String houseno1, family_head1, fathername1, member1, newbornyes, newbornno, childyes, childno;
    private Button submit, cancel, Next;
    CheckBox newbornYes, newbornNo, childYes, childNo;
    ProgressDialog pd = null;
    String status_message = null;
    LoginSQLiteHelper myDb;
    private Context context1;

    public SurveyTextItemViewHolder2(final View itemView) {
        super(itemView);
        context1=itemView.getContext();

        houseno = (EditText) itemView.findViewById(R.id.houseno);
        family_head = (EditText) itemView.findViewById(R.id.family_head);
        fathername = (EditText) itemView.findViewById(R.id.fathername);
        member = (Spinner) itemView.findViewById(R.id.member);

        newbornYes = (CheckBox) itemView.findViewById(R.id.newbornYes);
        newbornNo = (CheckBox) itemView.findViewById(R.id.newbornNo);
        childYes = (CheckBox) itemView.findViewById(R.id.childYes);
        childNo = (CheckBox) itemView.findViewById(R.id.childNo);
        submit = (Button) itemView.findViewById(R.id.button2);
        cancel = (Button) itemView.findViewById(R.id.button1);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent child = new Intent(itemView.getContext(), Modules1Activity.class);
                itemView.getContext().startActivity(child);
            }
        });
        myDb = new LoginSQLiteHelper(context1);

        submit.setOnClickListener(new View.OnClickListener() {
            APIInterface1 apiInterface = APIClient1.getClient().create(APIInterface1.class);

            @Override
            public void onClick(View v) {
                AddData();

                context=itemView.getContext();

                houseno1 = houseno.getText().toString();
                family_head1 = family_head.getText().toString();
                fathername1 = fathername.getText().toString();
                member1 = member.getSelectedItem().toString();
                newbornyes = newbornYes.getText().toString();
                newbornno = newbornNo.getText().toString();
                childyes = childYes.getText().toString();
                childno = childNo.getText().toString();
                myDb = new LoginSQLiteHelper(context);

                Boolean str = validation(family_head1, fathername1, member1, newbornyes, newbornno, childyes, childno);

                if (str == true) {
                    String dataResponse = postServerData();
                    pd = new ProgressDialog(itemView.getContext());
                    pd.setMessage("loading");
                    pd.show();


                }


            }
            public String postServerData() {
                Serveyhousedetail user = new Serveyhousedetail(houseno1, family_head1, fathername1, member1, newbornyes, childyes);
                Call<ChildRegisterResponse> call1 = apiInterface.housdetail(user);
                call1.enqueue(new Callback<ChildRegisterResponse>() {

                    public void onResponse(Call<ChildRegisterResponse> call, Response<ChildRegisterResponse> response) {
                        ChildRegisterResponse user1 = response.body();
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                itemView.getContext());
                        builder.setTitle(" House Details");
                        builder.setMessage("Successfully  is House Details");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        houseno.setText("");
                                        family_head.setText("");
                                        fathername.setText("");
                                        member.setAdapter(null);
                                        newbornYes.setText("");
                                        newbornNo.setText("");
                                        childYes.setText("");
                                        childNo.setText("");
                                        ;
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

                return status_message;


            }
            public boolean validation(String Houseno,String family_head1,String fathername1,String member1,String newbornyes,String newbornno,
                                      String childyes){
                boolean data;
                if((Houseno.equals(""))||(Houseno==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter House No",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((family_head1.equals(""))||(family_head1==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter head of the Family",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((fathername1.equals(""))||(fathername1==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter Father Name",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((member1.equals(""))||(member1==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter how many Member in your Family ",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((newbornyes.equals(""))||(newbornyes==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter New Born Child yes",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }
                if((childyes.equals(""))||(childyes==null)){
                    Toast.makeText(itemView.getContext(),"Please Enter User Name",Toast.LENGTH_LONG).show();
                    data=false;
                }else{
                    data=true;
                }

                return data;

            }
        });


    }
    public  void AddData() {

        boolean isInserted = myDb.insertData3(houseno1, family_head1, fathername1, member1, newbornyes, newbornno, childyes, childno);
        if(isInserted == true)
            Toast.makeText(itemView.getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(itemView.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();

    }

}


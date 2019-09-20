package tablefixheaders.adapters;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import mainscreen.govt.maidi.com.maidi.ChildrenActivity;
import mainscreen.govt.maidi.com.maidi.ModulesActivity;
import mainscreen.govt.maidi.com.maidi.MonthlyWorkActivity;
import mainscreen.govt.maidi.com.maidi.R;
import mainscreen.govt.maidi.com.maidi.UpdateActivity;

public class TextItemViewHolder extends RecyclerView.ViewHolder   {
    private TextView textView;
    private Calendar cal;

    private int day;
    private int month;
    private int year;
    private EditText et;
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    private Button submit, cancel;

    public TextItemViewHolder(final View itemView) {
        super(itemView);
        //textView = (TextView) itemView.findViewById(R.id.list_item);
       // spinner1 = (Spinner) itemView.findViewById(R.id.spinner1);
        et = (EditText) itemView.findViewById(R.id.btn_date1);
        //et = (EditText) itemView.findViewById(R.id.editText1);
       // spinner2 = (Spinner) itemView.findViewById(R.id.spinner3);
        //spinner3 = (Spinner) itemView.findViewById(R.id.spinner4);
      //  spinner4 = (Spinner) itemView.findViewById(R.id.spinner5);
       // spinner5 = (Spinner) itemView.findViewById(R.id.spinner2);
       // submit = (Button)itemView.findViewById(R.id.button2);
       // cancel = (Button)itemView.findViewById(R.id.button1);
      /*et.setOnClickListener(new View.OnClickListener() {
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
        });*/

       /* submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                builder.setTitle("Weekly Plan");
                builder.setMessage("Successfully Submited Weekly Plan");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                                *//**//*

                            }
                        });
                builder.show();

            }
        });*/
        /*cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent child = new Intent(itemView.getContext(),MonthlyWorkActivity.class);
                itemView.getContext().startActivity(child);
            }
        });*/
   /* public void bind(String text){
            et.setText(text);
        }
*/
    }
}

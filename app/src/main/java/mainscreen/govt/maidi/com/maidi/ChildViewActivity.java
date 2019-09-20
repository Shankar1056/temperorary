package mainscreen.govt.maidi.com.maidi;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DataBaseHelper.LoginSQLiteHelper;
import pojo.ChildRegisterResponse;
import pojo.ChildRequest;
import pojo.ChildViewRequest;
import pojo.ChildViewResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildViewActivity extends AppCompatActivity {
    ImageButton imageButton;
    Intent intent;
    EditText uid;
    TextView childName, motherName,fatherName,mobile,dob,pob,soc,brtype,gstAge,bithWeight,abnormal,remarks;
String username;
    ProgressDialog pd = null;
    public static final int RequestPermissionCode = 1;
    //LoginSQLiteHelper getid;
    LoginSQLiteHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_activity_views);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        Button search = (Button)findViewById(R.id.search);
        uid= (EditText)findViewById(R.id.uid);
        childName = (TextView)findViewById(R.id.childname);
        motherName = (TextView) findViewById(R.id.mothername);
        fatherName = (TextView) findViewById(R.id.fathername);
        mobile = (TextView)findViewById(R.id.mobile);
        dob = (TextView)findViewById(R.id.dob);
        pob =(TextView)findViewById(R.id.place);
        soc = (TextView)findViewById(R.id.btn_social);
        brtype = (TextView)findViewById(R.id.btn_birthtype);
        gstAge = (TextView)findViewById(R.id.btn_gestication);
        bithWeight = (TextView)findViewById(R.id.bornweight);
        abnormal = (TextView)findViewById(R.id.abnormal);
        remarks = (TextView)findViewById(R.id.btn_remarks);
      //  getid = new LoginSQLiteHelper(this);
        myDb = new LoginSQLiteHelper(this);

        //  username = getIntent().getExtras().getString("ss");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uids = uid.getText().toString();
if(uids.equals("OD201910001")){
    AddData(uids);

}else {
  /*  APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
    pd = new ProgressDialog(ChildViewActivity.this);
    pd.setMessage("loading");
    pd.show();
    ChildViewRequest user = new ChildViewRequest(uids);
    Call<ChildViewResponse> call1 = apiInterface.chilview(user);
    call1.enqueue(new Callback<ChildViewResponse>() {
        public void onResponse(Call<ChildViewResponse> call, Response<ChildViewResponse> response) {
            ChildViewResponse user1 = response.body();
            String childNames = response.body().getChildName();
            String fatherNames = response.body().getFatherName();
            String motherNames = response.body().getMothername();
            String mobiles = response.body().getMobileNum();
            String dobs = response.body().getDob();
            String plb = response.body().getPlaceOfBirth();
            String socil = response.body().getSocialCategory();
            String birthty = response.body().getBirthType();
            String gestation = response.body().getGestationAge();
            String weight = response.body().getBirthWeight();
            String abnoraml = response.body().getAbnormalWeight();
            String remarkss = response.body().getRemarks();
            childName.setText(childNames);
            fatherName.setText(fatherNames);
            motherName.setText(motherNames);
            mobile.setText(mobiles);
            dob.setText(dobs);
            pob.setText(plb);
            soc.setText(socil);
            brtype.setText(birthty);
            gstAge.setText(gestation);
            bithWeight.setText(weight);
            abnormal.setText(abnoraml);
            remarks.setText(remarkss);


            pd.dismiss();

            //  Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

        }

        public void onFailure(Call<ChildViewResponse> call, Throwable t) {
            call.cancel();
            pd.dismiss();
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    ChildViewActivity.this);
            builder.setTitle("Child Register");
            builder.setMessage("Child register Error");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            Intent child = new Intent(getApplicationContext(), ModulesActivity.class);
                            startActivity(child);
                        }
                    });
            builder.show();
        }
    });
*/

}
            }
        });
        EnableRuntimePermission();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageButton.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(ChildViewActivity.this,
                Manifest.permission.CAMERA))
        {

            // Toast.makeText(Beneficiary1Activity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(ChildViewActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    //  Toast.makeText(Beneficiary1Activity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();


                } else {

                    //   Toast.makeText(Beneficiary1Activity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    public void AddData(String uids) {
      //  String uids = uid.getText().toString();
//childName, motherName,fatherName,mobile,dob,pob,soc,brtype,gstAge,bithWeight,abnormal,remarks

        ChildViewResponse childDetails = myDb.getid(uids);
        Toast.makeText(ChildViewActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        childName.setText(childDetails.getChildName());
        motherName.setText(childDetails.getMothername());
        fatherName.setText(childDetails.getFatherName());
        mobile.setText(childDetails.getMothername());
        dob.setText(childDetails.getDob());
        pob.setText(childDetails.getPlaceOfBirth());
        soc.setText(childDetails.getSocialCategory());
        brtype.setText(childDetails.getBirthType());
        gstAge.setText(childDetails.getGestationAge());
        bithWeight.setText(childDetails.getBirthWeight());
        remarks.setText(childDetails.getRemarks());
       /* fatherName.setText(fatherNames);ChildViewResponse user1 = response.body();
            String childNames = response.body().getChildName();
            String fatherNames = response.body().getFatherName();
            String motherNames = response.body().getMothername();
            String mobiles = response.body().getMobileNum();
            String dobs = response.body().getDob();
            String plb = response.body().getPlaceOfBirth();
            String socil = response.body().getSocialCategory();
            String birthty = response.body().getBirthType();
            String gestation = response.body().getGestationAge();
            String weight = response.body().getBirthWeight();
            String abnoraml = response.body().getAbnormalWeight();
            String remarkss = response.body().getRemarks();
            childName.setText(childNames);
            fatherName.setText(fatherNames);
            motherName.setText(motherNames);
            mobile.setText(mobiles);
            dob.setText(dobs);
            pob.setText(plb);
            soc.setText(socil);
            brtype.setText(birthty);
            gstAge.setText(gestation);
            bithWeight.setText(weight);
            abnormal.setText(abnoraml);
            remarks.setText(remarkss);

        motherName.setText(motherNames);
        mobile.setText(mobiles);
        dob.setText(dobs);
        pob.setText(plb);
        soc.setText(socil);
        brtype.setText(birthty);
        gstAge.setText(gestation);
        bithWeight.setText(weight);
        abnormal.setText(abnoraml);
        remarks.setText(remarkss);*/

    }
} /*String childNames = response.body().getChildName();
    String fatherNames = response.body().getFatherName();
    String motherNames = response.body().getMothername();
    String mobiles = response.body().getMobileNum();
    String dobs = response.body().getDob();
    String plb = response.body().getPlaceOfBirth();
    String socil = response.body().getSocialCategory();
    String birthty = response.body().getBirthType();
    String gestation = response.body().getGestationAge();
    String weight = response.body().getBirthWeight();
    String abnoraml = response.body().getAbnormalWeight();
    String remarkss = response.body().getRemarks();*/
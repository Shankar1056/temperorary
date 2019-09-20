package Database.DataBaseHelper;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import mainscreen.govt.maidi.com.maidi.R;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserData";

    public static final String TABLE_NAME="UserTable";

    public static final String Uid="Uid";

    public static final String Long1="Long1";

    public static final String Village="Village";

    public static final String childname="childname";
    public static final String mothername="mothername";
    public static final String fathername="fathername";
    public static final String mobile="mobile";
    public static final String dob="dob";
    public static final String PoB="PoB";
    public static final String birthtype="birthtype";
    public static final String gestication="gestication";
    public static final String remarks="remarks";
    /*public static final String spinner1="spinner1";
    public static final String spinner2="spinner2";
    public static final String spinner3="spinner3";
    public static final String spinner4="spinner4";
    public static final String spinner5="spinner5";*/
    public static final String spinner7="spinner7";
    public static final String spinner8="spinner8";
    public static final String spinner9="spinner9";
    public static final String spinner10="spinner10";
    public static final String checkBox1="checkBox1";
    public static final String checkBox2="checkBox2";
    public static final String checkBox3="checkBox3";
    public static final String checkBox4="spinner4";
    public static final String imageButton1="imageButton1";
    public static final String imageButton2="imageButton2";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }
 /*   Uid = (EditText) findViewById(R.id.btn_uid);
    Long1 = (EditText) findViewById(R.id.btn_long);
    //  username = getIntent().getExtras().getString("ss");
    Village = (EditText) findViewById(R.id.btn_Village);
    childname = (EditText) findViewById(R.id.btn_childname);
    mothername = (EditText) findViewById(R.id.btn_mothername);
    fathername = (EditText) findViewById(R.id.btn_fathername);
    mobile = (EditText) findViewById(R.id.btn_mobile);
    dob = (EditText) findViewById(R.id.btn_dob1);
    PoB = (EditText) findViewById(R.id.btn_PoB);
    birthtype = (EditText) findViewById(R.id.btn_birthtype);
    gestication = (EditText) findViewById(R.id.btn_gestication);
    remarks = (EditText) findViewById(R.id.btn_remarks);
    //EditText editText17=(EditText)findViewById(R.id.btn_uid);
    spinner1 = (Spinner) findViewById(R.id.btn_State);
    spinner2 = (Spinner) findViewById(R.id.btn_district);
    spinner3 = (Spinner) findViewById(R.id.btn_Block);
    spinner4 = (Spinner) findViewById(R.id.btn_social);
    spinner5 = (Spinner) findViewById(R.id.btn_tola);
    spinner7 = (Spinner) findViewById(R.id.spinner2);
    spinner8 = (Spinner) findViewById(R.id.spinner3);
    spinner9 = (Spinner) findViewById(R.id.spinner4);
    spinner10 = (Spinner) findViewById(R.id.spinner1);

*//*
        spinner11 = (Spinner) findViewById(R.id.spinner);
*//*

    imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
    imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
    checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
    checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
    checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
    checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
    button1 = (Button) findViewById(R.id.btn_submit);
    button2 = (Button) findViewById(R.id.btn_cancel);*/
    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Uid+" INTEGER PRIMARY KEY, "+Long1+" VARCHAR, "+Village+" VARCHAR, "+childname+" " +
                "VARCHAR,"+mothername+"VARCHAR,"+fathername+"VARCHAR,"+mobile+"INTEGER PRIMARY KEY,"+dob+"INTEGER,"+PoB+"VARCHAR,"+birthtype+"VARCHAR,"
                +gestication+"VARCHAR,"+remarks+"VARCHAR,"+spinner7+"VARCHAR,"+spinner8+"VARCHAR,"+spinner9+"VARCHAR,"+spinner10+"VARCHAR,"
                +imageButton1+"VARCHAR,"+imageButton2+"VARCHAR," +
                checkBox1+"VARCHAR,"+checkBox2+"VARCHAR,"+checkBox3+"VARCHAR,"+checkBox4+"VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
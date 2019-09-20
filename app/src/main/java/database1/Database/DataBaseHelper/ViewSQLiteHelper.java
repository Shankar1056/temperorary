package Database.DataBaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ViewSQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="Report Writing";

    public static final String TABLE_NAME="Report";

    public static final String House_no="house no";

    public static final String Name_of_child="name of child";

    public static final String Age_and_month="age and month";

    public static final String Sex="sex";
    public static final String Name_of_father="name of father";
    public static final String MCP="MCP";
    public static final String Vaccines_at_brith ="Vaccines_at_brith";
    public static final String Vaccines_at_6week="Vaccines_at_6week";
    public static final String Vaccines_at_10week="Vaccines_at_10week";
    public static final String Vaccines_at_9to12week="Vaccines_at_9to12week";
    public static final String Vaccines_at_16to24week="Vaccines_at_16to24week";
    public static final String immunized_asha="immunized_asha";


    public ViewSQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+House_no+"INTEGER PRIMARY KEY, "+Name_of_child+" VARCHAR, "
                +Age_and_month+" VARCHAR, "+Sex+" VARCHAR, "+Name_of_father+" VARCHAR, "+MCP+" VARCHAR, "+Vaccines_at_brith+" VARCHAR, "+Vaccines_at_6week+" VARCHAR," +
                ""+Vaccines_at_10week+" VARCHAR,"+Vaccines_at_9to12week+" VARCHAR,"+Vaccines_at_16to24week+" VARCHAR,"+immunized_asha+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
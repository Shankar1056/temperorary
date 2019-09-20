package Database.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mainscreen.govt.maidi.com.maidi.Beneficiary1Activity;
import mainscreen.govt.maidi.com.maidi.LoginActvity;
import mainscreen.govt.maidi.com.maidi.ViewReportActivity;
import pojo.ChildViewResponse;
import pojo.monthlyViewResponse;

public class LoginSQLiteHelper extends SQLiteOpenHelper {
    SQLiteDatabase db = this.getReadableDatabase();
    static String DATABASE_NAME = "MAIDI";

    public static final String TABLE_NAME = "Login";
    public static final String TABLE_NAME2 = "Report";
    public static final String TABLE_NAME3 = "SurveyANM";
    public static final String  TABLE_NAME44= "Monthupdate_week1";
    public static final String  TABLE_NAME45= "Monthupdate_week2";
    public static final String  TABLE_NAME46= "Monthupdate_week3";
    public static final String  TABLE_NAME47= "Monthupdate_week4";

    public static final String Table_Column_ID = "User_Name";

    public static final String Table_Column_1_Name = "Password";
    public static final String TABLE_NAME1 = "child_reg";
    public static final String Uid = "Uid";
    public static final String Long1 = "Longutide";
    public static final String Long2 = "Altitude";
    /*public static final String State = "State";
    public static final String District = "District";
    public static final String Block = "Block";
    public static final String Village = "Village";
    public static final String Tola = "tola";*/
    public static final String childname = "childname";
    public static final String Mothername = "mothername";
    public static final String fathername = "fathername";
    public static final String Mobile_1 = "Mobile";
    public static final String dob = "Date_of_birth";
    public static final String PoB = "Place_of_Birth";
    public static final String social = "Social_Category";
    public static final String birthtype = "Birthtype";
    public static final String gestication = "Gestication";
    public static final String spinner7 = "select_Kg";
    public static final String spinner8 = "Select_gram";
    public static final String spinner9 = "Baby_normality";
    public static final String Spinner10 = "Baby_normality_other";
    public static final String checkBox1 = "Baby_Yes";
    public static final String checkBox2 = "Baby_no";
    public static final String checkBox3 = "Bith_Yes";
    public static final String checkBox4 = "Birth_no";
    public static final String remarks = "Remarks";

    public static final String House_no = "House_no";

    public static final String Name_of_child = "name_of_child";

    public static final String Age_and_month = "age_and_month";

    public static final String Sexyes = "sexyes";
    public static final String Sexno = "sexNo";
    public static final String Name_of_father = "name_of_father";
    public static final String MCPyes = "MCPyes";
    public static final String MCPno = "MCPno";
    public static final String Vaccines_at_brith = "Vaccines_at_brith";
    public static final String Vaccines_at_6week = "Vaccines_at_6week";
    public static final String Vaccines_at_10week = "Vaccines_at_10week";
    public static final String Vaccines_at_14week = "Vaccines_at_14week";

    public static final String Vaccines_at_9to12week = "Vaccines_at_9to12week";
    public static final String Vaccines_at_16to24week = "Vaccines_at_16to24week";
    public static final String immunized_asha = "immunized_asha";
    public static final String firstName = "firstName";
    public static final String lastName = "lastName";
    public static final String mobileNum = "mobileNum";
    public static final String date1 = "Date";
    public static final String Sub_center = "Sub_center";
    public static final String anmDet = "anmDet";
    public static final String areaDet = "areaDet";
    public static final String areaCode = "areaCode";
    public static final String house_details = "SurveyHouse_Details";
    public static final String House_no1 = "House_no";
    public static final String family_head = "family_head";
    public static final String fathername1 = "Fathername";
    public static final String member = "Member";
    public static final String newbornYes = "newbornYes";
    public static final String newbornno = "newbornno";
    public static final String childYes = "childYes";
    public static final String childNo = "childNo";
    public static final String PregnantWomen = "PregnantWomen";
    public static final String Houseno = "Houseno";
    public static final String Age_year = "Age_year";
    public static final String Name_of_pregnment = "Name_of_pregnment";
    public static final String Husband_name = "Husband_name";
    public static final String Moblie = "Moblie";
    public static final String McpYes = "McpYes";
    public static final String Mcpno = "Mcpno";
    public static final String Mobile_number = "Mobile_number";
    public static final String Expected_date = "Expected_date";
    public static final String Tetanus = "Tetanus";
    public static final String Ante_natal_check_up = "Ante_natal_check_up";
    public static final String AEFIReportDetails = "AEFIReportDetails";
    public static final String Reporter_aefi = "Reporter_aefi";
    public static final String Location = "Location";
    public static final String Designation = "Designation";
    public static final String Email = "Email";
    public static final String Contant_number = "Contant_number";
    public static final String Address = "Address";
    public static final String Area_code = "Area_code";
    public static final String vaccine_details = "vaccine_details";
    public static final String vaccine_name1 = "vaccine_name";
    public static final String vaccine_date1 = "vaccine_date";
    public static final String vaccine_time1 = "vaccine_time";
    public static final String vaccine_dose1 = "vaccine_dose";
    public static final String batch_lot1 = "lot_number";
    public static final String expriy_date1 = "expriy_date";
    public static final String Diluent = "Diluent";
    public static final String Nameofdiluent = "Name_of_diluent";
    public static final String lotnumber = "Lot_number";
    public static final String Expirydate = "Expiry_date";
    public static final String date_of_reconstitution = "Date_of_reconstitution";
    public static final String time_of_reconstitution = "Time_of_reconstitution";
    public static final String Adverseevent = "Adverse_Event";
    public static final String severeyes = "severeyes";
    public static final String severeno = "severeno";
    public static final String seizuresyes = "seizuresyes";
    public static final String seizuresno = "seizuresno";
    public static final String abscessyes = "abscessyes";
    public static final String abscessno = "abscessno";
    public static final String sepsisyes = "sepsisyes";
    public static final String sepsisno = "sepsisno";
    public static final String encephalopathyyes = "encephalopathyyes";
    public static final String encephalopathyno = "encephalopathyno";
    public static final String toxicyes = "toxicyes";
    public static final String toxicno = "toxicno";
    public static final String thromboctpeniayes = "thromboctpeniayes";
    public static final String thromboctpeniano = "thromboctpeniano";
    public static final String anaphylaxisyes = "anaphylaxisyes";
    public static final String anaphylaxisno = "anaphylaxisno";
    public static final String feveryes = "feveryes";
    public static final String feverno = "feverno";
    public static final String otheryes = "otheryes";
    public static final String otherno = "otheryes";
    public static final String specify_other = "specify_other";
    public static final String event_time = "event_time";
    public static final String Security = "Security";
    public static final String Severeyes = "Severeyes";
    public static final String Severeno = "Severeno";
    public static final String Deathyes = "Deathyes";
    public static final String Life_threateningyes = "Life_threateningyes";
    public static final String Life_threateningno = "Life_threateningno";
    public static final String Persistententyes = "Persistententyes";
    public static final String Persistententno = "Persistententno";
    public static final String Congantalyes = "Congantalyes";
    public static final String Congantalno = "Congantalno";
    public static final String Otheryes = "Otheryes";
    public static final String Specify = "Specify";
    public static final String Outcome = "Outcome";
    public static final String other1 = "otherno";
    public static final String Past = "Past";
    public static final String Date_investigation = "Date_investigation";
    public static final String Date_done = "Date_done";
    public static final String Finalclassification = "Finalclassification";
    public static final String event_description = "Event_description";
    //MONTHUPDATE
    public static final String Et = "Date";
    public static final String Select_week = "Week";
    public static final String Select_village = "Village";
    public static final String select_state = "State";
    public static final String Select_block = "Block";
    public static final String Select_vaccine = "Vaccine";
    public static final String Select_planhours = "PlanHour";

//monthview
public static final String monthview = "monthview";
    public static final String month_childNames = "month_childNames";
    public static final String month_ashaname = "month_ashaname";
    public static final String month_village = "month_village";
    public static final String month_hour = "month_hour";

    /*public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";
    public static final String expriy_date1 = "expriy_date";*/
//monthlyViewResponse
    public ChildViewResponse getid(String  Uids) throws SQLException
    {
        ChildViewResponse res = new ChildViewResponse();
        System.out.println("ddbpos="+Uids);
        long recc=0;
        String rec=null;
        Cursor mCursor = db.rawQuery(
                "SELECT *  FROM  child_reg WHERE Uid=?",new String[] {Uids});
        SQLiteDatabase db = this.getReadableDatabase();
        if (mCursor != null)
        {

            mCursor.moveToFirst();
            res.setChildName(mCursor.getString(mCursor.getColumnIndex("childname")));
            res.setMothername(mCursor.getString(mCursor.getColumnIndex("mothername")));
            res.setFatherName(mCursor.getString(mCursor.getColumnIndex("fathername")));
           // res.setMobileNum(mCursor.getString(mCursor.getColumnIndex("Mobile")));
            res.setDob(mCursor.getString(mCursor.getColumnIndex("Date_of_birth")));
            res.setPlaceOfBirth(mCursor.getString(mCursor.getColumnIndex("Place_of_Birth")));
            res.setSocialCategory(mCursor.getString(mCursor.getColumnIndex("Social_Category")));
            res.setBirthType(mCursor.getString(mCursor.getColumnIndex("Birthtype")));
            res.setGestationAge(mCursor.getString(mCursor.getColumnIndex("Gestication")));
            res.setBirthWeight(mCursor.getString(mCursor.getColumnIndex("Baby_no")));
            res.setAbnormalWeight(mCursor.getString(mCursor.getColumnIndex("Birth_no")));
            res.setRemarks(mCursor.getString(mCursor.getColumnIndex("Remarks")));

        }
      return res;
    }
    //monthView
    public monthlyViewResponse getfetch() throws SQLException
    {
        monthlyViewResponse res = new monthlyViewResponse();

        long recc=0;
        String rec=null;
        Cursor mCursor = db.rawQuery("SELECT * FROM monthview",null);
        SQLiteDatabase db = this.getReadableDatabase();
        if (mCursor != null) {

            mCursor.moveToFirst();
            res.setChildNames(mCursor.getString(mCursor.getColumnIndex("month_childNames")));

        }
        return res;
    }
    public LoginSQLiteHelper(LoginActvity context) {

        super(context, DATABASE_NAME, null, 1);

    }

    public LoginSQLiteHelper(Beneficiary1Activity context) {

        super(context, DATABASE_NAME, null, 1);

    }

    public LoginSQLiteHelper(ViewReportActivity context) {

        super(context, DATABASE_NAME, null, 1);

    }

    public LoginSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
//Et, Select_week, Select_village, select_state, Select_block, Select_vaccine, Select_planhours

    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " VARCHAR, " + Table_Column_1_Name
                + " VARCHAR)";
        database.execSQL(CREATE_TABLE);
        /*public static final String monthview = "monthview";
        public static final String month_childNames = "PlanHour";
        public static final String month_ashaname = "PlanHour";
        public static final String month_village = "PlanHour";
        public static final String month_hour = "PlanHour";
*/
        String CREATE_TABLE33= "CREATE TABLE IF NOT EXISTS " + monthview + " (" + month_childNames + " VARCHAR, " + month_ashaname
                + " VARCHAR," + month_village + " VARCHAR," + month_hour + " VARCHAR)";
        database.execSQL(CREATE_TABLE33);

        String CREATE_TABLE22= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME44 + " (" + Et + " VARCHAR, " + Select_week
                + " VARCHAR," + Select_village + " VARCHAR," + select_state + " VARCHAR," + Select_block + " VARCHAR," + Select_vaccine + " VARCHAR," + Select_planhours + " VARCHAR)";
        database.execSQL(CREATE_TABLE22);
        String CREATE_TABLE23= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME45 + " (" + Et + " VARCHAR, " + Select_week
                + " VARCHAR," + Select_village + " VARCHAR," + select_state + " VARCHAR," + Select_block + " VARCHAR," + Select_vaccine + " VARCHAR," + Select_planhours + " VARCHAR)";
        database.execSQL(CREATE_TABLE23);
        String CREATE_TABLE24= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME46 + " (" + Et + " VARCHAR, " + Select_week
                + " VARCHAR," + Select_village + " VARCHAR," + select_state + " VARCHAR," + Select_block + " VARCHAR," + Select_vaccine + " VARCHAR," + Select_planhours + " VARCHAR)";
        database.execSQL(CREATE_TABLE24);
        String CREATE_TABLE25= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME47 + " (" + Et + " VARCHAR, " + Select_week
                + " VARCHAR," + Select_village + " VARCHAR," + select_state + " VARCHAR," + Select_block + " VARCHAR," + Select_vaccine + " VARCHAR," + Select_planhours + " VARCHAR)";
        database.execSQL(CREATE_TABLE25);
        /*String CREATE_TABLE22= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME48 + " (" + Et + " VARCHAR, " + Select_week
                + " VARCHAR," + Select_village + " VARCHAR," + select_state + " VARCHAR," + Select_block + " VARCHAR," + Select_vaccine + " VARCHAR," + Select_planhours + " VARCHAR)";
        database.execSQL(CREATE_TABLE22);*/
        String CREATE_TABLE1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " (" + Uid + " VARCHAR, " + Long1
                + " VARCHAR, " + Long2 + " TEXT, " + childname + " TEXT, "
                + Mothername + " TEXT, " + fathername + " TEXT, " + Mobile_1 + " TEXT,  " + dob + " TEXT, " + PoB + " TEXT, " + social + " TEXT, " + birthtype + " TEXT, "
                + gestication + " TEXT, " + spinner7 + " TEXT, " + spinner8 + " TEXT, " + spinner9 + " TEXT, " + Spinner10 + " TEXT, "
                + checkBox1
                + " TEXT, " + checkBox2 + " TEXT, " + checkBox3 + " TEXT, " + checkBox4 + " TEXT, " + remarks + " TEXT )";
        database.execSQL(CREATE_TABLE1);
        String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS " + "Report" + "(" + House_no + " VARCHAR, " + Name_of_child + " VARCHAR, "
                + Age_and_month + " VARCHAR, " + Sexyes + " VARCHER, " + Sexno + " VARCHER, " + Name_of_father
                + " VARCHER, " + Mobile_number + " VARCHER, " + MCPyes + " VARCHER, " + MCPno + " VARCHER, " + Vaccines_at_brith + " VARCHER, "
                + Vaccines_at_6week + " VARCHER, " + Vaccines_at_10week + " VARCHER, " + Vaccines_at_14week
                + " VARCHER, " + Vaccines_at_9to12week + " VARCHER, "
                + Vaccines_at_16to24week + " VARCHER, " + immunized_asha + " VARCHER)";
        database.execSQL(CREATE_TABLE2);

        String CREATE_TABLE3 = "CREATE TABLE IF NOT EXISTS " + "SurveyAnm" + " (" + firstName + " VARCHAR, " + lastName
                + " VARCHAR, " + mobileNum + " VARCHAR, " + date1 + " VARCHAR, " + Sub_center
                + " VARCHAR, " + anmDet + " VARCHAR, " + areaDet + " VARCHAR, " + areaCode + " VARCHAR)";
        database.execSQL(CREATE_TABLE3);
        String CREATE_TABLE4 = "CREATE TABLE IF NOT EXISTS " + "SurveyHouse_Details" + " (" + House_no1 + " VARCHAR, " + family_head
                + " VARCHAR, " + fathername1 + " VARCHAR, " + member + " VARCHAR, " + newbornYes
                + " VARCHAR, " + newbornno + " VARCHAR, " + childYes + " VARCHAR, " + childNo + " VARCHAR)";
        database.execSQL(CREATE_TABLE4);
        String CREATE_TABLE5 = "CREATE TABLE IF NOT EXISTS " + "PregnantWomen" + " (" + Houseno + " VARCHAR,"+  Name_of_pregnment + " VARCHAR, " + Age_year
                + " VARCHAR,"+ Husband_name +" VARCHAR, " + Moblie + " VARCHAR, " + McpYes + " VARCHAR, " + Mcpno
                + " VARCHAR, " + Expected_date + " VARCHAR, " + Tetanus + " VARCHAR, " + Ante_natal_check_up + " VARCHAR)";
        database.execSQL(CREATE_TABLE5);
        String CREATE_TABLE6 = "CREATE TABLE IF NOT EXISTS " + "AEFIReportDetails" + " (" + Reporter_aefi + " VARCHAR, " + Location
                + " VARCHAR, " + Designation + " VARCHAR, " + Email + " VARCHAR, " + Contant_number
                + " VARCHAR, " + Address + " VARCHAR, " + Area_code + " VARCHAR )";
        database.execSQL(CREATE_TABLE6);
        String CREATE_TABLE7= "CREATE TABLE IF NOT EXISTS " + "vaccine_details" + " (" + vaccine_name1 + " VARCHAR, "
                + vaccine_date1
                + " VARCHAR, " + vaccine_time1 + " VARCHAR, " + vaccine_dose1 + " VARCHAR, " + batch_lot1
                + " VARCHAR, " + expriy_date1 + " VARCHAR)";
        database.execSQL(CREATE_TABLE7);
        String CREATE_TABLE8= "CREATE TABLE IF NOT EXISTS " + Diluent + " (" + Nameofdiluent + " VARCHAR, "
                + vaccine_date1
                + " VARCHAR, " + lotnumber + " VARCHAR, " + Expirydate + " VARCHAR, " + date_of_reconstitution
                + " VARCHAR, " + time_of_reconstitution + " VARCHAR)";
        database.execSQL(CREATE_TABLE8);
        String CREATE_TABLE9= "CREATE TABLE IF NOT EXISTS " + Adverseevent + " (" + severeyes + " VARCHAR, "
                + severeno
                + " VARCHAR, " + seizuresyes + " VARCHAR, " + seizuresno + " VARCHAR, " + abscessyes
                + " VARCHAR, " + abscessno + " VARCHAR," + sepsisyes + " VARCHAR, " + sepsisno + " VARCHAR, " + encephalopathyyes
                + " VARCHAR, " + encephalopathyno + " VARCHAR, " + toxicyes + " VARCHAR, " + toxicno + " VARCHAR, " + thromboctpeniayes
                + " VARCHAR, " + thromboctpeniano + " VARCHAR, " + anaphylaxisyes + " VARCHAR, " + anaphylaxisno + " VARCHAR, "
                + feveryes + " VARCHAR, " + feverno + " VARCHAR, " + otherno + " VARCHAR, " + specify_other + " VARCHAR, " + event_time
                + " VARCHAR,"+ event_description +" VARCHAR )";
        database.execSQL(CREATE_TABLE9);
       /* String CREATE_TABLE10= "CREATE TABLE IF NOT EXISTS " + Adverseevent + " (" + Severeyes + " VARCHAR, "
                + Severeno
                + " VARCHAR, " + Deathyes + " VARCHAR, " + Life_threateningyes + " VARCHAR, " + Life_threateningno
                + " VARCHAR, " + Persistententyes + " VARCHAR," + Persistententno + " VARCHAR, " + Congantalyes + " VARCHAR, " + Congantalno
                + " VARCHAR, " + Otheryes + " VARCHAR, " + other1 + " VARCHAR, " + Outcome + " VARCHAR, " + Past + " VARCHAR, " + Date_investigation
                + " VARCHAR, " + Date_done + " VARCHAR, " + Finalclassification + " VARCHAR, " + feveryes + " VARCHAR, " + feverno + " VARCHAR, " + otheryes
                + " VARCHAR, " + otherno + " VARCHAR, " + specify_other + " VARCHAR, " + event_time + " VARCHAR)";
        database.execSQL(CREATE_TABLE10);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + house_details);
        db.execSQL("DROP TABLE IF EXISTS " + PregnantWomen);
        db.execSQL("DROP TABLE IF EXISTS " + AEFIReportDetails);
        onCreate(db);

    }

    public boolean insertData(String User_Name, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table_Column_ID, User_Name);
        contentValues.put(Table_Column_1_Name, Password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData1(String UID, String long1, String long2, String Childname, String mothername,
                               String Fathername, String mobile, String Dob, String PoBs, String Social, String Birthtype, String Gestication, String
                                    CheckBox1, String Spinner7, String Spinner8, String CheckBox2, String CheckBox3,
                               String CheckBox4, String spinner_9, String spinner10,String Remarks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Uid, UID);
        contentValues.put(Long1, long1);
        contentValues.put(Long2, long2);
        /*contentValues.put(State, State);
        contentValues.put(District, District);
        contentValues.put(Block, Block);
        contentValues.put(Village, Village);
        contentValues.put(Tola, Tola);*/
        contentValues.put(childname, Childname);
        contentValues.put(Mothername, mothername);
        contentValues.put(fathername, Fathername);
        contentValues.put(Mobile_1, mobile);
        contentValues.put(dob, Dob);
        contentValues.put(PoB, PoBs);
        contentValues.put(social, Social);
        contentValues.put(birthtype, Birthtype);
        contentValues.put(gestication, Gestication);
        contentValues.put(checkBox1, CheckBox1);

        contentValues.put(spinner7, Spinner7);
        contentValues.put(spinner8, Spinner8);
        contentValues.put(checkBox2, CheckBox2);
        contentValues.put(checkBox3, CheckBox3);

        contentValues.put(spinner9, spinner_9);
        contentValues.put(Spinner10, spinner10);
        contentValues.put(checkBox4, CheckBox4);
        contentValues.put(remarks, Remarks);


        long result1 = db.insert(TABLE_NAME1, null, contentValues);
        if (result1 == -1)
            return false;
        else
            return true;
    }


    public boolean insertData2(String house_no, String name_of_child,String age_and_month,String sexyes,String sexno,
                               String name_of_father,String mobile_number,String mCPyes,String mCPno,String vaccines_at_brith,
                               String vaccines_at_6week,String vaccines_at_10week,
                               String vaccines_at_14week,String vaccines_at_9to12week,String vaccines_at_16to24week,String Immunized_asha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(House_no, house_no);
        contentValues.put(Name_of_child, name_of_child);
        contentValues.put(Age_and_month, age_and_month);
        contentValues.put(Sexyes, sexyes);
       contentValues.put(Sexno, sexno);
        contentValues.put(Name_of_father, name_of_father);
        contentValues.put(Mobile_number, mobile_number);
        contentValues.put(MCPyes, mCPyes);
        contentValues.put(MCPno, mCPno);
        contentValues.put(Vaccines_at_brith, vaccines_at_brith);
        contentValues.put(Vaccines_at_6week, vaccines_at_6week);
        contentValues.put(Vaccines_at_10week, vaccines_at_10week);
        contentValues.put(Vaccines_at_14week, vaccines_at_14week);
        contentValues.put(Vaccines_at_9to12week, vaccines_at_9to12week);
        contentValues.put(Vaccines_at_16to24week, vaccines_at_16to24week);
        contentValues.put(immunized_asha, Immunized_asha);


        long result = db.insert(TABLE_NAME2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData3(String FirstName, String LastName,String MobileNum,String Date1,String sub_center,String AnmDet,String AreaDet,String Areacode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, FirstName);
        contentValues.put(lastName, LastName);
       contentValues.put(mobileNum, MobileNum);
        contentValues.put(date1, Date1);
        contentValues.put(Sub_center, sub_center);
        contentValues.put(anmDet, sub_center);
        contentValues.put(areaDet, AnmDet);
        contentValues.put(areaCode, Areacode);

/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(TABLE_NAME3, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData4(String house_no1, String Family_head,String Fathername1,String Member,String NewbornYes,String Newbornno,String ChildYes,String ChildNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(House_no1, house_no1);
        contentValues.put(family_head, Family_head);
         contentValues.put(fathername1, Fathername1);
        contentValues.put(member, Member);
        contentValues.put(newbornYes, NewbornYes);
        contentValues.put(newbornno, Newbornno);
        contentValues.put(childYes, ChildYes);
        contentValues.put(childNo, ChildNo);

/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(house_details, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData5(String houseno,String name_of_pregnment, String age_year,String husband_name,String moblie,String mcpYes,String mcpno,String expected_date,String tetanus,String ante_natal_check_up) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Houseno, houseno);
        contentValues.put(Name_of_pregnment, name_of_pregnment);
        contentValues.put(Age_year, age_year);

        contentValues.put(Husband_name, husband_name);
        contentValues.put(Moblie, moblie);
        contentValues.put(McpYes, mcpYes);
        contentValues.put(Mcpno, mcpno);
        contentValues.put(Expected_date, expected_date);
        contentValues.put(Tetanus, tetanus);
        contentValues.put(Ante_natal_check_up, ante_natal_check_up);

/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(house_details, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    String CREATE_TABLE6 = "CREATE TABLE IF NOT EXISTS " + "AEFIReportDetails" + " (" + Reporter_aefi + " VARCHAR, " + Location
            + " VARCHAR, " + Designation + " VARCHAR, " + Email + " VARCHAR, " + Contant_number
            + " VARCHAR, " + Address + " VARCHAR, " + Area_code+"VARCHAR)";
    public boolean insertData7(String reporter_aefi,String location,String designation, String email, String contant_number,String address,
                               String area_code) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Reporter_aefi, reporter_aefi);
        contentValues.put(Location, location);
        contentValues.put(Designation, designation);
        contentValues.put(Email, email);
        contentValues.put(Contant_number, contant_number);

        contentValues.put(Address, address);
       // contentValues.put(Area_code, area_code);


/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(AEFIReportDetails, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertData6(String nameofdiluent, String Lotnumber,String expirydate,
                               String Date_of_reconstitution,String Time_of_reconstitution
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Nameofdiluent, nameofdiluent);
        contentValues.put(lotnumber, Lotnumber);

        contentValues.put(Expirydate, expirydate);
        contentValues.put(date_of_reconstitution, Date_of_reconstitution);
        contentValues.put(time_of_reconstitution, Time_of_reconstitution);


/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(Diluent, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData9(String Vaccine_name1, String Vaccine_date1,String Vaccine_time1,
                               String Vaccine_dose1,String Lotnumber,String Expriy_date1
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(vaccine_name1, Vaccine_name1);
        contentValues.put(vaccine_date1, Vaccine_date1);

        contentValues.put(vaccine_time1, Vaccine_time1);
        contentValues.put(vaccine_dose1, Vaccine_dose1);
        contentValues.put(lotnumber, Lotnumber);
        contentValues.put(expriy_date1, Expriy_date1);


        long result = db.insert(vaccine_details, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData7(String Severeyes,String Severeno,String Seizuresyes,String Seizuresno,String Abscessyes,String Abscessno,String Sepsisyes,String Sepsisno,
                               String Encephalopathyyes,String Encephalopathyno,
                               String  Toxicyes,String Toxicno,String Thromboctpeniayes,String Thromboctpeniano,
                               String Anaphylaxisyes,String Anaphylaxisno,String Feveryes,String Feverno,String Otheryes,String Otherno,String Event_time,String Event_description
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(severeyes, Severeyes);
        contentValues.put(severeno, Severeno);
        contentValues.put(seizuresyes, Seizuresyes);

        contentValues.put(seizuresno, Seizuresno);
        contentValues.put(abscessyes, Abscessyes);
        contentValues.put(abscessno, Abscessno);
        contentValues.put(sepsisyes, Sepsisyes);
        contentValues.put(sepsisno, Sepsisno);
        contentValues.put(encephalopathyyes, Encephalopathyyes);
        contentValues.put(encephalopathyno, Encephalopathyno);
        contentValues.put(toxicyes, Toxicyes);
        contentValues.put(toxicno, Toxicno);
        contentValues.put(thromboctpeniayes, Thromboctpeniayes);
        contentValues.put(thromboctpeniano, Thromboctpeniano);
        contentValues.put(anaphylaxisyes, Anaphylaxisyes);
        contentValues.put(anaphylaxisno, Anaphylaxisno);
        contentValues.put(feveryes, Feveryes);
        contentValues.put(feverno, Feverno);
        contentValues.put(otheryes, Otheryes);
        contentValues.put(otherno, Otherno);
        contentValues.put(event_time, Event_time);
        contentValues.put(event_description, Event_description);


/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(firstName, "sfd");
        contentValues.put(lastName, "fsfd");
        contentValues.put(mobileNum, "ffb");
        contentValues.put(date1, "fdhgfg");
        contentValues.put(Sub_center, "gfgjf");
        contentValues.put(anmDet, "gfnf");
        contentValues.put(areaDet, "fggfh");
        contentValues.put(areaCode, "hgjgh");
*/

        long result = db.insert(Diluent, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public boolean insertData10(String et, String select_week,String select_village,
                               String Select_state,String select_block,String select_vaccine,String select_planhours
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Et, et);
        contentValues.put(Select_week, select_week);

        contentValues.put(Select_village, select_village);
        contentValues.put(select_state, Select_state);
        contentValues.put(Select_block, select_block);
        contentValues.put(Select_vaccine, select_vaccine);
        contentValues.put(Select_planhours, select_planhours);


        long result = db.insert(TABLE_NAME44, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertData11(String et, String select_week,String select_village,
                                String Select_state,String select_block,String select_vaccine,String select_planhours
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Et, et);
        contentValues.put(Select_week, select_week);

        contentValues.put(Select_village, select_village);
        contentValues.put(select_state, Select_state);
        contentValues.put(Select_block, select_block);
        contentValues.put(Select_vaccine, select_vaccine);
        contentValues.put(Select_planhours, select_planhours);


        long result = db.insert(TABLE_NAME45, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertData12(String et, String select_week,String select_village,
                                String Select_state,String select_block,String select_vaccine,String select_planhours
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Et, et);
        contentValues.put(Select_week, select_week);

        contentValues.put(Select_village, select_village);
        contentValues.put(select_state, Select_state);
        contentValues.put(Select_block, select_block);
        contentValues.put(Select_vaccine, select_vaccine);
        contentValues.put(Select_planhours, select_planhours);


        long result = db.insert(TABLE_NAME46, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertData13(String et, String select_week,String select_village,
                                String Select_state,String select_block,String select_vaccine,String select_planhours
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Et, et);
        contentValues.put(Select_week, select_week);

        contentValues.put(Select_village, select_village);
        contentValues.put(select_state, Select_state);
        contentValues.put(Select_block, select_block);
        contentValues.put(Select_vaccine, select_vaccine);
        contentValues.put(Select_planhours, select_planhours);


        long result = db.insert(TABLE_NAME47, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


}

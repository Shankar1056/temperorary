package pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 8/9/2019.
 */

public class Users {

    @SerializedName("firstname")
    private String firstname ;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("dob")
    public String dob;
    @SerializedName("gender")
    public String gender;
    @SerializedName("mothername")
    public String mothername;
    @SerializedName("state")
    public String state;
    @SerializedName("district")
    public String district;
    @SerializedName("block")
    public String block;
    @SerializedName("village")
    public String village;

    public Users(String firstname, String lastname, String dob, String gender, String mothername, String state, String district
            , String block, String village ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob=dob;
        this.gender = gender;
        this.mothername =mothername;
        this.state=state;
        this.district=district;
        this.block=block;
        this.village=village;
    }


}

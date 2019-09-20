package pojo;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("username")
   private String user;
    @SerializedName("password")
   private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
}

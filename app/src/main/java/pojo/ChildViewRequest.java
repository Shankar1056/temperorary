package pojo;


import com.google.gson.annotations.SerializedName;

public class ChildViewRequest {

    @SerializedName("uid")
    private String uid;

    public ChildViewRequest(String uid) {
        this.uid = uid;
    }

}

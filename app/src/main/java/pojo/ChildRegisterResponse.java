package pojo;


import com.google.gson.annotations.SerializedName;

public class ChildRegisterResponse {
    @SerializedName("status_code")
    private String status_code;
    @SerializedName("status_message")
    private String status_message;

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }
}

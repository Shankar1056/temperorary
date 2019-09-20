package pojo;

import com.google.gson.annotations.SerializedName;

public class AefiReportwriting {
    @SerializedName("reporterOfAefi")
    private String reporterOfAefi;
    @SerializedName("instituationLoc")
    private String instituationLoc;
    @SerializedName("designation")
    private String designation;
    @SerializedName("email")
    private String email;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("address")
    private String address;



    public AefiReportwriting(String reporterOfAefi, String instituationLoc, String designation, String email, String mobile, String address) {
        this.reporterOfAefi = reporterOfAefi;
        this.instituationLoc = instituationLoc;
        this.designation = designation;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
}

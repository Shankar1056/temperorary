package pojo;

import com.google.gson.annotations.SerializedName;

public class Serveyhousedetail {
    @SerializedName("houseNo")
    private String houseNo;

    @SerializedName("familyHead")
    private String familyHead;
    @SerializedName("fatherName")
    private String fatherName;
    @SerializedName("familyMember")
    private String familyMember;

    @SerializedName("newBornDetails")
    private String newBornDetails;
    @SerializedName("agedChild")
    private String agedChild;


    public Serveyhousedetail(String houseNo, String familyHead, String fatherName, String familyMember, String newBornDetails, String agedChild) {
        this.houseNo = houseNo;
        this.familyHead = familyHead;
        this.fatherName = fatherName;
        this.familyMember = familyMember;
        this.newBornDetails = newBornDetails;
        this.agedChild = agedChild;
    }
}
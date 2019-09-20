package pojo;

import com.google.gson.annotations.SerializedName;

public class ChildRequest {

    @SerializedName("uid")
    private String uid;
    @SerializedName("childName")
    private String childName;
    @SerializedName("fatherName")
    private String fatherName;
    @SerializedName("mobileNum")
    private String mobileNum;
    @SerializedName("placeOfBirth")
    private String placeOfBirth;
    @SerializedName("socialCategory")
    private String socialCategory;
    @SerializedName("birthType")
    private String birthType;
    @SerializedName("gestationAge")
    private String gestationAge;
    @SerializedName("birthWeight")
    private String birthWeight;
    @SerializedName("abnormalWeight")
    private String abnormalWeight;
    @SerializedName("remarks")
    private String remarks;
    @SerializedName("childPhoto")
    private String childPhoto;
    @SerializedName("dob")
    private String dob;
    @SerializedName("gender")
    private String gender;
    @SerializedName("mothername")
    private String mothername;




    public ChildRequest(String uid, String childName, String fatherName, String mobileNum, String placeOfBirth, String socialCategory, String birthType, String gestationAge, String birthWeight, String abnormalWeight, String remarks, String dob, String mothername) {
        this.uid = uid;
        this.childName = childName;
        this.mothername = mothername;

        this.fatherName = fatherName;
        this.dob = dob;

        this.mobileNum = mobileNum;
        this.placeOfBirth = placeOfBirth;
        this.socialCategory = socialCategory;
        this.birthType = birthType;
        this.gestationAge = gestationAge;
        this.birthWeight = birthWeight;
        this.abnormalWeight = abnormalWeight;
        this.remarks = remarks;


    }





}

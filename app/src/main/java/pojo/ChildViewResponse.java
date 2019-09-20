package pojo;

import com.google.gson.annotations.SerializedName;

public class ChildViewResponse {

    @SerializedName("childName")
    private String childName;
    @SerializedName("mothername")
    private String mothername;
    @SerializedName("fatherName")
    private String fatherName;
    @SerializedName("mobileNum")
    private String mobileNum;
    @SerializedName("dob")
    private String dob;
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


    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @SerializedName("abnormalWeight")
    private String abnormalWeight;
    @SerializedName("remarks")
    private String remarks;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }



    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }



    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSocialCategory() {
        return socialCategory;
    }

    public void setSocialCategory(String socialCategory) {
        this.socialCategory = socialCategory;
    }

    public String getBirthType() {
        return birthType;
    }

    public void setBirthType(String birthType) {
        this.birthType = birthType;
    }



    public String getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(String birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getGestationAge() {
        return gestationAge;
    }

    public void setGestationAge(String gestationAge) {
        this.gestationAge = gestationAge;
    }

    public String getAbnormalWeight() {
        return abnormalWeight;
    }

    public void setAbnormalWeight(String abnormalWeight) {
        this.abnormalWeight = abnormalWeight;
    }


}

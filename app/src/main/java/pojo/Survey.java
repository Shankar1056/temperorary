package pojo;

import android.widget.EditText;

import com.google.gson.annotations.SerializedName;

public class Survey {
    @SerializedName("surveyorName")
    private String surveyorName;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("date")
    private String date;

    @SerializedName("subCenter")
    private String subCenter;
    @SerializedName("nameOfAnm")
    private String nameOfAnm;
    @SerializedName("areaName")
    private String areaName;
    @SerializedName("areaCode")
    private String areaCode;

    public Survey(String surveyorName, String mobile, String date, String subCenter, String nameOfAnm, String areaName, String areaCode) {
        this.surveyorName = surveyorName;
        this.mobile = mobile;
        this.date = date;
        this.subCenter = subCenter;
        this.nameOfAnm = nameOfAnm;
        this.areaName = areaName;
        this.areaCode = areaCode;
    }




}

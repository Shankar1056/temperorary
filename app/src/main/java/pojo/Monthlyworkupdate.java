package pojo;

import com.google.gson.annotations.SerializedName;

public class Monthlyworkupdate {
    @SerializedName("planDate")
    private String planDate;
    @SerializedName("planWeek")
    private String planWeek;
    @SerializedName("state")
    private String state;
    @SerializedName("dist")
    private String dist;
    @SerializedName("village")
    private String village;
    @SerializedName("vaccine")
    private String vaccine;

    public Monthlyworkupdate(String planDate, String planWeek, String state, String dist, String village, String vaccine) {
        this.planDate = planDate;
        this.planWeek = planWeek;
        this.state = state;
        this.dist = dist;
        this.village = village;
        this.vaccine = vaccine;
    }
}

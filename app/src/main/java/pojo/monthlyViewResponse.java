package pojo;

import com.google.gson.annotations.SerializedName;

public class monthlyViewResponse {
    @SerializedName("week")
    private String childNames;
    @SerializedName("weekDays")
    private String weekDays;
    @SerializedName("weekHours")
    private String weekHours;
    @SerializedName("ashaWorkerDetails")
    private String ashaWorkerDetails;
    @SerializedName("villageName")
    private String villageName;



    public monthlyViewResponse() {
        this.childNames = childNames;
        this.weekDays = weekDays;
        this.weekHours = weekHours;
        this.ashaWorkerDetails = ashaWorkerDetails;
        this.villageName = villageName;
    }
    public String getChildNames() {
        return childNames;
    }

    public void setChildNames(String childNames) {
        this.childNames = childNames;
    }

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public String getWeekHours() {
        return weekHours;
    }

    public void setWeekHours(String weekHours) {
        this.weekHours = weekHours;
    }

    public String getAshaWorkerDetails() {
        return ashaWorkerDetails;
    }

    public void setAshaWorkerDetails(String ashaWorkerDetails) {
        this.ashaWorkerDetails = ashaWorkerDetails;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
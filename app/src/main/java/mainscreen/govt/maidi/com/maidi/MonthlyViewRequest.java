package mainscreen.govt.maidi.com.maidi;

import com.google.gson.annotations.SerializedName;

public class MonthlyViewRequest {
    @SerializedName("planDate")
    private String planDate;

    public MonthlyViewRequest(String planDate) {
        this.planDate = planDate;
    }
}

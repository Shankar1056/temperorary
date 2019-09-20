package pojo;

import com.google.gson.annotations.SerializedName;

public class monthlyViewRequest {
    @SerializedName("planDate")
    private String planDate;

    public monthlyViewRequest(String planDate) {
        this.planDate = planDate;
    }
}

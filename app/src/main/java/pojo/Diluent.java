package pojo;

import com.google.gson.annotations.SerializedName;

public class Diluent {
    @SerializedName("nameOfDiluent")
    private String nameOfDiluent;
    @SerializedName("lotNumber")
    private String lotNumber;
    @SerializedName("expiryDate")
    private String expiryDate;

    @SerializedName("dateReconstitution")
    private String dateReconstitution;

    @SerializedName("timeReconstitution")
    private String timeReconstitution;

    public Diluent(String nameOfDiluent, String lotNumber, String expiryDate, String dateReconstitution, String timeReconstitution) {
        this.nameOfDiluent = nameOfDiluent;
        this.lotNumber = lotNumber;
        this.expiryDate = expiryDate;
        this.dateReconstitution = dateReconstitution;
        this.timeReconstitution = timeReconstitution;
    }
}

package pojo;

import com.google.gson.annotations.SerializedName;

public class AEIVaccineDetails {
    @SerializedName("vaccineName")
    private String vaccineName;

    @SerializedName("vaccineDate")
    private String vaccineDate;
    @SerializedName("vaccineTime")
    private String vaccineTime;
    @SerializedName("vaccineDose")
    private String vaccineDose;
    @SerializedName("lotNumber")
    private String lotNumber;
    @SerializedName("expiryDate")
    private String expiryDate;

    public AEIVaccineDetails(String vaccineName, String vaccineDate, String vaccineTime, String vaccineDose, String lotNumber, String expiryDate) {
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
        this.vaccineTime = vaccineTime;
        this.vaccineDose = vaccineDose;
        this.lotNumber = lotNumber;
        this.expiryDate = expiryDate;
    }
}

package pojo;

import com.google.gson.annotations.SerializedName;

public class Reportwriting {
    @SerializedName("houseNo")
    private String houseNo;
    @SerializedName("childName")
    private String childName;
    @SerializedName("childAge")
    private String childAge;
    @SerializedName("childGender")
    private String checkmale;
    @SerializedName("childFatherName")
    private String childFatherName;
    @SerializedName("mobileNumber")
    private String mobileNumber;
    @SerializedName("mcpCard")
    private String mcpCard;
    @SerializedName("vaccineAtBirth")
    private String vaccineAtBirth;
    @SerializedName("vaccineSixWeek")
    private String vaccineSixWeek;
    @SerializedName("vaccineTenWeek")
    private String vaccineTenWeek;
    @SerializedName("vaccineFouteenWeek")
    private String vaccineFouteenWeek;
    @SerializedName("vaccineNineToTweel")
    private String vaccineNineToTweel;
    @SerializedName("completeImmuization")

    private String vaccinationSixtenToTwentyFour;

    @SerializedName("vaccinationSixtenToTwentyFour")

    private String completeImmuization;


    public Reportwriting(String houseNo, String childName, String childAge, String checkmale, String childFatherName, String mobileNumber, String mcpCard, String vaccineAtBirth, String vaccineSixWeek, String vaccineTenWeek, String vaccineFouteenWeek, String vaccineNineToTweel, String vaccinationSixtenToTwentyFour, String completeImmuization) {
        this.houseNo = houseNo;
        this.childName = childName;
        this.childAge = childAge;
        this.checkmale = checkmale;
        this.childFatherName = childFatherName;
        this.mobileNumber = mobileNumber;
        this.mcpCard = mcpCard;
        this.vaccineAtBirth = vaccineAtBirth;
        this.vaccineSixWeek = vaccineSixWeek;
        this.vaccineTenWeek = vaccineTenWeek;
        this.vaccineFouteenWeek = vaccineFouteenWeek;
        this.vaccineNineToTweel = vaccineNineToTweel;
        this.vaccinationSixtenToTwentyFour = vaccinationSixtenToTwentyFour;
        this.completeImmuization = completeImmuization;
    }
}

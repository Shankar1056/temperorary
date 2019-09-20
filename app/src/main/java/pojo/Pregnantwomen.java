package pojo;

import com.google.gson.annotations.SerializedName;

public class Pregnantwomen {
    @SerializedName("hoseNo")
    private String hoseNo;
    @SerializedName("pgWomanName")
    private String pgWomanName;
    @SerializedName("age")
    private String age;
    @SerializedName("husbandName")
    private String husbandName;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("mcpCard")
    private String mcpCard;

    @SerializedName("expectedDate")
    private String expectedDate;
    @SerializedName("toxidVaccination")
    private String toxidVaccination;
    @SerializedName("NatalChedkup")
    private String NatalChedkup;


    public Pregnantwomen(String hoseNo, String pgWomanName, String age, String husbandName, String mobile, String mcpCard, String expectedDate, String toxidVaccination, String natalChedkup) {
        this.hoseNo = hoseNo;
        this.pgWomanName = pgWomanName;
        this.age = age;
        this.husbandName = husbandName;
        this.mobile = mobile;
        this.mcpCard = mcpCard;
        this.expectedDate = expectedDate;
        this.toxidVaccination = toxidVaccination;
        NatalChedkup = natalChedkup;
    }
}

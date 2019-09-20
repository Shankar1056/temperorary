package pojo;

import com.google.gson.annotations.SerializedName;

public class Adverseevent {
    @SerializedName("localRelation")
    private String localRelation;
    @SerializedName("seizures")
    private String seizures;
    @SerializedName("abscess")
    private String abscess;
    @SerializedName("sepsis")
    private String sepsis;
    @SerializedName("encephalopathy")
    private String encephalopathy;
    @SerializedName("syndrome")
    private String syndrome;
    @SerializedName("thromboctyopenia")
    private String thromboctyopenia;
    @SerializedName("anaphylaxis")
    private String anaphylaxis;
    @SerializedName("fever")
    private String fever;
    @SerializedName("other")
    private String other;
    @SerializedName("specfiyAnyOther")
    private String specfiyAnyOther;
    @SerializedName("eventTime")
    private String eventTime;

    public Adverseevent(String localRelation, String seizures, String abscess, String sepsis, String encephalopathy, String syndrome, String thromboctyopenia, String anaphylaxis, String fever, String other, String specfiyAnyOther, String eventTime, String severEventRepoted) {
        this.localRelation = localRelation;
        this.seizures = seizures;
        this.abscess = abscess;
        this.sepsis = sepsis;
        this.encephalopathy = encephalopathy;
        this.syndrome = syndrome;
        this.thromboctyopenia = thromboctyopenia;
        this.anaphylaxis = anaphylaxis;
        this.fever = fever;
        this.other = other;
        this.specfiyAnyOther = specfiyAnyOther;
        this.eventTime = eventTime;
        this.severEventRepoted = severEventRepoted;
    }

    @SerializedName("severEventRepoted")
    private String severEventRepoted;

}


package mainscreen.govt.maidi.com.maidi;
public class PlaceNum {

    private String place;

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHrs() {
        return hrs;
    }

    public void setHrs(String hrs) {
        this.hrs = hrs;
    }

    private String village;
    private String days;
    private String hrs;

    private long num;

    PlaceNum(String place, String village , String hrs , String Name){

        this.place=place;
        this.village=village;
        this.days=hrs;
        this.hrs=Name;


    }

    public void setPlace(String place){

        this.place=place;

    }

    public void setNum(long num){

        this.num=num;

    }

    public String getPlace(){

        return place;

    }

    public long getNum(){

        return num;

    }

}

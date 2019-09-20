package pojo;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status_message")
    private String status_message;
    @SerializedName("userName")
    private String userName;
    @SerializedName("userRole")
    private String userRole;
    @SerializedName("states")
    private String states;
    @SerializedName("dist")
    private String dist;
    @SerializedName("block")
    private String block;
    @SerializedName("village")
    private String village;
    @SerializedName("tola")
    private String tola;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTola() {
        return tola;
    }

    public void setTola(String tola) {
        this.tola = tola;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }
}

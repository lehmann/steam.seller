package br.lehmann.steam.api.badge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badge {

    @SerializedName("badgeid")
    @Expose
    private Integer badgeid;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("completion_time")
    @Expose
    private Integer completionTime;
    @SerializedName("xp")
    @Expose
    private Integer xp;
    @SerializedName("scarcity")
    @Expose
    private Integer scarcity;
    @SerializedName("appid")
    @Expose
    private Integer appid;
    @SerializedName("communityitemid")
    @Expose
    private String communityitemid;
    @SerializedName("border_color")
    @Expose
    private Integer borderColor;

    public Integer getBadgeid() {
        return badgeid;
    }

    public void setBadgeid(Integer badgeid) {
        this.badgeid = badgeid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Integer completionTime) {
        this.completionTime = completionTime;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getScarcity() {
        return scarcity;
    }

    public void setScarcity(Integer scarcity) {
        this.scarcity = scarcity;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getCommunityitemid() {
        return communityitemid;
    }

    public void setCommunityitemid(String communityitemid) {
        this.communityitemid = communityitemid;
    }

    public Integer getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Integer borderColor) {
        this.borderColor = borderColor;
    }

}

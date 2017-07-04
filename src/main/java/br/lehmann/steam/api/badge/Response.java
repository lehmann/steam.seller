package br.lehmann.steam.api.badge;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("badges")
    @Expose
    private List<Badge> badges = null;
    @SerializedName("player_xp")
    @Expose
    private Integer playerXp;
    @SerializedName("player_level")
    @Expose
    private Integer playerLevel;
    @SerializedName("player_xp_needed_to_level_up")
    @Expose
    private Integer playerXpNeededToLevelUp;
    @SerializedName("player_xp_needed_current_level")
    @Expose
    private Integer playerXpNeededCurrentLevel;

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public Integer getPlayerXp() {
        return playerXp;
    }

    public void setPlayerXp(Integer playerXp) {
        this.playerXp = playerXp;
    }

    public Integer getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(Integer playerLevel) {
        this.playerLevel = playerLevel;
    }

    public Integer getPlayerXpNeededToLevelUp() {
        return playerXpNeededToLevelUp;
    }

    public void setPlayerXpNeededToLevelUp(Integer playerXpNeededToLevelUp) {
        this.playerXpNeededToLevelUp = playerXpNeededToLevelUp;
    }

    public Integer getPlayerXpNeededCurrentLevel() {
        return playerXpNeededCurrentLevel;
    }

    public void setPlayerXpNeededCurrentLevel(Integer playerXpNeededCurrentLevel) {
        this.playerXpNeededCurrentLevel = playerXpNeededCurrentLevel;
    }

}

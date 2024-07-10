package com.c2w.model;

public class Player {
    // Fields representing player attributes
    private String playerName; // Name of the player
    private String playerImg; // URL or path to the player's image
    private String playerAge; // Age of the player
    private String playerRole; // Role or position of the player
    private String battingStyle; // Batting style of the player
    private String bowlingStyle; // Bowling style of the player
    private String country; // Country the player represents or belongs to
    private String infoUrl; // URL for additional information about the player
    private String flag; // URL or path to the flag representing the player's country
    
    // Getters and setters for each field
    public String getPlayerName() {
    return playerName;
    }
    public void setPlayerName(String playerName) {
    this.playerName = playerName;
    }
    public String getPlayerImg() {
    return playerImg;
    }
    public void setPlayerImg(String playerImg) {
    this.playerImg = playerImg;
    }
    public String getPlayerAge() {
    return playerAge;
    }
    public void setPlayerAge(String playerAge) {
    this.playerAge = playerAge;
    }
    public String getPlayerRole() {
    return playerRole;
    }
    public void setPlayerRole(String playerRole) {
    this.playerRole = playerRole;
    }
    public String getBattingStyle() {
    return battingStyle;
    }
    public void setBattingStyle(String battingStyle) {
    this.battingStyle = battingStyle;
    }
    
    public String getBowlingStyle() {
    return bowlingStyle;
    }
    public void setBowlingStyle(String bowlingStyle) {
    this.bowlingStyle = bowlingStyle;
    }
    public String getCountry() {
    return country;
    }
    public void setCountry(String country) {
    this.country = country;
    }
    public String getInfoUrl() {
    return infoUrl;
    }
    public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
    }
    public String getFlag() {
    return flag;
    }
    public void setFlag(String flag) {
    this.flag = flag;
    }
    // Override toString() to provide a string representation of the object
    @Override
    public String toString() {
        return "Player [playerName=" + playerName + ", playerImg=" + playerImg + ", playerAge=" + playerAge + ", playerRole=" + playerRole + ", battingStyle=" + battingStyle + ", bowlingStyle=" + bowlingStyle + ", country=" + country + ", infoUrl=" + infoUrl + ", flag=" + flag + "]";
    }
}
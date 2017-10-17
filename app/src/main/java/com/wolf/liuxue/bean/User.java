package com.wolf.liuxue.bean;

/**
 * Created by nanchaodong on 2017/5/5.
 */

public class User {
    private String userId;
    private String username;
    private String nickName;
    private String education;
    private String baiduUserId;
    private String attentNation;
    private String personGroup;
    private String imageUrl;
    private String password;
    private int  isSound;
    private int isPush;
    private int isMask;
    private String areaCode;
    private int role;
    private String cloudChannel;
    private int nationId;
    private Nation nation;
    private User teacher;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBaiduUserId() {
        return baiduUserId;
    }

    public void setBaiduUserId(String baiduUserId) {
        this.baiduUserId = baiduUserId;
    }

    public String getAttentNation() {
        return attentNation;
    }

    public void setAttentNation(String attentNation) {
        this.attentNation = attentNation;
    }

    public String getPersonGroup() {
        return personGroup;
    }

    public void setPersonGroup(String personGroup) {
        this.personGroup = personGroup;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSound() {
        return isSound;
    }

    public void setIsSound(int isSound) {
        this.isSound = isSound;
    }

    public int getIsPush() {
        return isPush;
    }

    public void setIsPush(int isPush) {
        this.isPush = isPush;
    }

    public int getIsMask() {
        return isMask;
    }

    public void setIsMask(int isMask) {
        this.isMask = isMask;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getCloudChannel() {
        return cloudChannel;
    }

    public void setCloudChannel(String cloudChannel) {
        this.cloudChannel = cloudChannel;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", nickName='" + nickName + '\'' +
                ", education='" + education + '\'' +
                ", baiduUserId='" + baiduUserId + '\'' +
                ", attentNation='" + attentNation + '\'' +
                ", personGroup='" + personGroup + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", password='" + password + '\'' +
                ", isSound=" + isSound +
                ", isPush=" + isPush +
                ", isMask=" + isMask +
                ", areaCode='" + areaCode + '\'' +
                ", role=" + role +
                ", cloudChannel='" + cloudChannel + '\'' +
                ", nationId=" + nationId +
                ", nation=" + nation +
                ", teacher=" + teacher +
                '}';
    }
}

package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a user
 */
public class User {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("cardNumber")
    private String mCardNumber;

    @SerializedName("birthday")
    private String mBirthday;

    @SerializedName("beersInCurrentTour")
    private Integer mBeersInCurrentTour;

    @SerializedName("toursToVip")
    private Integer mToursToVip;

    @SerializedName("prizeValue")
    private Integer mPrizeValue;

    @SerializedName("prizeRedeemed")
    private Integer mPrizeRedeemed;

    @SerializedName("lifetimePrizeValue")
    private Integer mLifetimePrizeValue;

    @SerializedName("beersUntilNextPrize")
    private Integer mBeersUntilNextPrize;

    @SerializedName("nextPrize")
    private String mNextPrize;

    @SerializedName("homeLocationId")
    private Integer mHomeLocationId;

    @SerializedName("rowChanged")
    private Date mRowChanged;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getCardNumber() {
        return mCardNumber;
    }

    public void setCardNumber(String cardNumber) {
        mCardNumber = cardNumber;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public Integer getBeersInCurrentTour() {
        return mBeersInCurrentTour;
    }

    public void setBeersInCurrentTour(Integer beersInCurrentTour) {
        mBeersInCurrentTour = beersInCurrentTour;
    }

    public Integer getToursToVip() {
        return mToursToVip;
    }

    public void setToursToVip(Integer toursToVip) {
        mToursToVip = toursToVip;
    }

    public Integer getPrizeValue() {
        return mPrizeValue;
    }

    public void setPrizeValue(Integer prizeValue) {
        mPrizeValue = prizeValue;
    }

    public Integer getPrizeRedeemed() {
        return mPrizeRedeemed;
    }

    public void setPrizeRedeemed(Integer prizeRedeemed) {
        mPrizeRedeemed = prizeRedeemed;
    }

    public Integer getLifetimePrizeValue() {
        return mLifetimePrizeValue;
    }

    public void setLifetimePrizeValue(Integer lifetimePrizeValue) {
        mLifetimePrizeValue = lifetimePrizeValue;
    }

    public Integer getBeersUntilNextPrize() {
        return mBeersUntilNextPrize;
    }

    public void setBeersUntilNextPrize(Integer beersUntilNextPrize) {
        mBeersUntilNextPrize = beersUntilNextPrize;
    }

    public String getNextPrize() {
        return mNextPrize;
    }

    public void setNextPrize(String nextPrize) {
        mNextPrize = nextPrize;
    }

    public Integer getHomeLocationId() {
        return mHomeLocationId;
    }

    public void setHomeLocationId(Integer homeLocationId) {
        mHomeLocationId = homeLocationId;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
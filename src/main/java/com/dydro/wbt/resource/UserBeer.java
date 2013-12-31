package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a userbeer
 */
public class UserBeer {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("userId")
    private Integer mUserId;

    @SerializedName("beerId")
    private Integer mBeerId;

    @SerializedName("beerName")
    private String mBeerName;

    @SerializedName("beerCountry")
    private String mBeerCountry;

    @SerializedName("tourNumber")
    private Integer mTourNumber;

    @SerializedName("tourCompleted")
    private Date mTourCompleted;

    @SerializedName("locationId")
    private Integer mLocationId;

    @SerializedName("locationName")
    private String mLocationName;

    @SerializedName("rating")
    private Float mRating;

    @SerializedName("comment")
    private String mComment;

    @SerializedName("time")
    private Date mTime;

    @SerializedName("rowChanged")
    private Date mRowChanged;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public void setUserId(Integer userId) {
        mUserId = userId;
    }

    public Integer getBeerId() {
        return mBeerId;
    }

    public void setBeerId(Integer beerId) {
        mBeerId = beerId;
    }

    public String getBeerName() {
        return mBeerName;
    }

    public void setBeerName(String beerName) {
        mBeerName = beerName;
    }

    public String getBeerCountry() {
        return mBeerCountry;
    }

    public void setBeerCountry(String beerCountry) {
        mBeerCountry = beerCountry;
    }

    public Integer getTourNumber() {
        return mTourNumber;
    }

    public void setTourNumber(Integer tourNumber) {
        mTourNumber = tourNumber;
    }

    public Date getTourCompleted() {
        return mTourCompleted;
    }

    public void setTourCompleted(Date tourCompleted) {
        mTourCompleted = tourCompleted;
    }

    public Integer getLocationId() {
        return mLocationId;
    }

    public void setLocationId(Integer locationId) {
        mLocationId = locationId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    public Float getRating() {
        return mRating;
    }

    public void setRating(Float rating) {
        mRating = rating;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public Date getTime() {
        return mTime;
    }

    public void setTime(Date time) {
        mTime = time;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
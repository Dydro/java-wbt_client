package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a beer
 */
public class Beer {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("averageRating")
    private Double mAverageRating;

    @SerializedName("totalRatings")
    private Integer mTotalRatings;

    @SerializedName("miniTourId")
    private Integer mMiniTourId;

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

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Double getAverageRating() {
        return mAverageRating;
    }

    public void setAverageRating(Double averageRating) {
        mAverageRating = averageRating;
    }

    public Integer getTotalRatings() {
        return mTotalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        mTotalRatings = totalRatings;
    }

    public Integer getMiniTourId() {
        return mMiniTourId;
    }

    public void setMiniTourId(Integer miniTourId) {
        mMiniTourId = miniTourId;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
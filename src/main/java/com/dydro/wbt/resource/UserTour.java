package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a user tour
 */
public class UserTour {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("userId")
    private Integer mUserId;

    @SerializedName("tourNumber")
    private Integer mTourNumber;

    @SerializedName("completedTime")
    private Date mCompletedTime;

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

    public Integer getTourNumber() {
        return mTourNumber;
    }

    public void setTourNumber(Integer tourNumber) {
        mTourNumber = tourNumber;
    }

    public Date getCompletedTime() {
        return mCompletedTime;
    }

    public void setCompletedTime(Date completedTime) {
        mCompletedTime = completedTime;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}

package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a minitour
 */
public class MiniTour {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("image")
    private String mImage;

    @SerializedName("endTime")
    private Date mEndtime;

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

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public Date getEndTime() {
        return mEndtime;
    }

    public void setEndTime(Date endTime) {
        mEndtime = endTime;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
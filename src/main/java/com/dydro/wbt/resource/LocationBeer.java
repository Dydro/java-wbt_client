package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a location beer
 */
public class LocationBeer {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("beerId")
    private Integer mBeerId;

    @SerializedName("locationId")
    private Integer mLocationId;

    @SerializedName("rowChanged")
    private Date mRowChanged;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public Integer getBeerId() {
        return mBeerId;
    }

    public void setBeerId(Integer beerId) {
        mBeerId = beerId;
    }

    public Integer getLocationId() {
        return mLocationId;
    }

    public void setLocationId(Integer locationId) {
        mLocationId = locationId;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
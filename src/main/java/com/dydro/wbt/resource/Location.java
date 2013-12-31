package com.dydro.wbt.resource;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Represents a location
 */
public class Location {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("phone")
    private String mPhone;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    @SerializedName("zip")
    private Integer mZip;

    @SerializedName("latitude")
    private Double mLatitude;

    @SerializedName("longitude")
    private Double mLongitude;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("menuLink")
    private String mMenuLink;

    @SerializedName("nutritionalInfoLink")
    private String mNutritionalInfoLink;

    @SerializedName("hours")
    private String mHours;

    @SerializedName("happyHours")
    private String mHappyHours;

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

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Integer getZip() {
        return mZip;
    }

    public void setZip(Integer zip) {
        mZip = zip;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getMenuLink() {
        return mMenuLink;
    }

    public void setMenuLink(String menuLink) {
        mMenuLink = menuLink;
    }

    public String getNutritionalInfoLink() {
        return mNutritionalInfoLink;
    }

    public void setNutritionalInfoLink(String nutritionalInfoLink) {
        mNutritionalInfoLink = nutritionalInfoLink;
    }

    public String getHours() {
        return mHours;
    }

    public void setHours(String hours) {
        mHours = hours;
    }

    public String getHappyHours() {
        return mHappyHours;
    }

    public void setHappyHours(String happyHours) {
        mHappyHours = happyHours;
    }

    public Date getRowChanged() {
        return mRowChanged;
    }

    public void setRowChanged(Date rowChanged) {
        mRowChanged = rowChanged;
    }
}
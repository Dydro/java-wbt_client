package com.dydro.wbt;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Configuration for a list request
 */
public class ListConfig {
    public static final String SORT_ASC = "asc";
    public static final String SORT_DESC = "desc";

    /**
     * The page to get
     */
    private Integer mPage;

    /**
     * The page size to get
     */
    private Integer mPageSize;

    /**
     * The field to sort on
     */
    private String mSort;

    /**
     * The direction to sort
     */
    private String mSortDir;

    /**
     * The limit on the result set
     */
    private Long mSince;

    /**
     * @return The querystring
     */
    public String toString() {
        String ret = "?";
        if (mPage != null) {
            ret += "page=" + mPage + "&";
        }
        if (mPageSize != null) {
            ret += "pagesize=" + mPageSize + "&";
        }
        if (mSort != null) {
            ret += "sort=" + mSort + "&";
        }
        if (mSortDir != null) {
            ret += "sortdir=" + mSortDir + "&";
        }
        if (mSince != null) {
            ret += "since=" + mSince + "&";
        }

        return ret;
    }

    /**
     * @param page The page to set
     */
    public void setPage(Integer page) {
        mPage = page;
    }

    /**
     * @return The page
     */
    public Integer getPage() {
        return mPage;
    }

    /**
     * @param pageSize The page size to set
     */
    public void setPageSize(Integer pageSize) {
        mPageSize = pageSize;
    }

    /**
     * @return The page size
     */
    public Integer getPageSize() {
        return mPageSize;
    }

    /**
     * @param sort The field to sort by
     */
    public void setSort(String sort) {
        mSort = sort;
    }

    /**
     * @return The field to sort by
     */
    public String getSort() {
        return mSort;
    }

    /**
     * @param sortDir The sort direction
     */
    public void setSortDir(String sortDir) {
        if (!mSortDir.equals(SORT_ASC) && !mSortDir.equals(SORT_DESC)) {
            mSortDir = SORT_ASC;
        } else {
            mSortDir = sortDir;
        }
    }

    /**
     * @return The sort direction
     */
    public String getSortDir() {
        return mSortDir;
    }

    /**
     * @param since The timestamp to get results since
     */
    public void setSince(Long since) {
        mSince = since;
    }

    /**
     * @return The timestamp to get results since
     */
    public Long getSince() {
        return mSince;
    }
}
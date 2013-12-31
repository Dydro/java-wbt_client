package com.dydro.wbt;

import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Custom wrapper for a response from a list endpoint
 */
public class ListResponse<T> extends ArrayList<T> {
    /**
     * The page from the server
     */
    protected int mPage = 1;

    /**
     * The total pages from the server
     */
    protected int mPages = 1;

    /**
     * The total items from the server
     */
    protected int mTotal = 0;

    /**
     * @param page The current page from the server
     * @param pages The total pages from the server
     * @param total The total items from the server
     */
    public ListResponse(int page, int pages, int total) {
        mPage = page;
        mPages = pages;
        mTotal = total;
    }

    /**
     * @return page
     */
    public int getPage() {
        return mPage;
    }

    /**
     * @return pages
     */
    public int getPages() {
        return mPages;
    }

    /**
     * @return total
     */
    public int getTotal() {
        return mTotal;
    }

    /**
     * @return whether there are more pages
     */
    public boolean morePages() {
        return mPages > mPage;
    }
}
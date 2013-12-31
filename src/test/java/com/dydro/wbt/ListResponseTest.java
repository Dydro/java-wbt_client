package com.dydro.wbt;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ListResponseTest {
    private ListResponse<?> mListResponse;

    @Before
    public void setupListResponse() {
        mListResponse = new ListResponse<Object>(1, 2, 100);
    }

    @Test
    public void testMorePages() {
        assertTrue(mListResponse.morePages());
    }
}

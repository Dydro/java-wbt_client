package com.dydro.wbt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListConfigTest {
    private ListConfig mListConfig;

    @Before
    public void setupListResponse() {
        mListConfig = new ListConfig();
    }

    @Test
    public void testMorePages() {
        mListConfig.setPage(1);
        mListConfig.setPageSize(100);
        mListConfig.setSince(0l);
        mListConfig.setSort("name");
        mListConfig.setSortDir(ListConfig.SORT_ASC);
        assertEquals("page=1&pagesize=100&sort=name&sortdir=asc&since=0", mListConfig.toString());
    }
}

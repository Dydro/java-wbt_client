package com.dydro.wbt;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    private Client mClient;

    @Before
    public void setup() {
        mClient = new Client("", "");
    }

    @Test
    public void testGetBeers() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getBeers(listConfig).size());
    }

    @Test
    public void testGetBeer() throws Exception {
        assertEquals("Budweiser [draft]", mClient.getBeer(1).getName());
    }

    @Test
    public void testGetLocations() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getLocations(listConfig).size());
    }

    @Test
    public void testGetLocationsBeers() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getLocationsBeers(listConfig).size());
    }

    @Test
    public void testGetLocation() throws Exception {
        assertEquals("Eden Prairie", mClient.getLocation(138).getName());
    }

    @Test
    public void testGetLocationBeers() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getLocationBeers(138, listConfig).size());
    }

    @Test
    public void testGetMiniTours() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getBeers(listConfig).size());
    }

    @Test
    public void testGetMiniTour() throws Exception {
        assertEquals("Canned Beer Mini Tour", mClient.getMiniTour(1).getName());
    }

    @Test
    public void testLogin() throws Exception {
        assertEquals("Troy Mccabe", mClient.login("troymccabe@gmail.com", new Date(575899200000l)).getName());
    }

    @Test
    public void testGetUser() throws Exception {
        assertEquals("Troy Mccabe", mClient.getUser(6).getName());
    }

    @Test
    public void testGetUserBeers() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(10);
        assertEquals(10, mClient.getUserBeers(6, listConfig).size());
    }

    @Test
    public void testGetUserBeer() throws Exception {
        assertEquals("Oktfest 2012 #8", mClient.getUserBeer(6, 1401954).getBeerName());
    }

    @Test
    public void testGetEndpoints() throws Exception {
        assertEquals(7, mClient.getEndpoints(6, 0).size());
    }

    @Test
    public void testGetUserTours() throws Exception {
        ListConfig listConfig = new ListConfig();
        listConfig.setPageSize(3);
        assertEquals(3, mClient.getUserTours(6, listConfig).size());
    }
}
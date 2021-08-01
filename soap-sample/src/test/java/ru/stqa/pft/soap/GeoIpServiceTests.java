package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GetCountryNameByISO2;
import com.lavasoft.GetIpLocation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {
    @Test
    public void testMyIp() {


        String getIpLocation= new GeoIPService().getGeoIPServiceSoap12().getIpLocation("194.28.29.152");
        assertTrue(getIpLocation.contains("RU"));
    }
    @Test
    public void testInvalidIp() {
        String getIpLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("194.28.29.152.xxx");
        assertTrue(getIpLocation.contains("RU"));
    }
}
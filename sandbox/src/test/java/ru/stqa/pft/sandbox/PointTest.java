package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testDistance() {
        Point d1 = new Point(1, 3, 4, 7);
        Assert.assertEquals(d1.distance(), 5);
    }
}

package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest2 {
        @Test
        public void testDistance() {
            Point d2 = new Point(4, 4, 4, 4);
            Assert.assertEquals(d2.distance(), 0);
        }
    }

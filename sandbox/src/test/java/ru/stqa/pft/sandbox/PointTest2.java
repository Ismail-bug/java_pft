package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest2 {
        @Test
        public void testDistance() {
            Point d3 = new Point(4, 4);
                    Point d4 = new Point (4,4);
            Assert.assertEquals(d3.distance(d4), 0);
        }
    }

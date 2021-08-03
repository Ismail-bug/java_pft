package ru.stqa.pft.simple;

import org.testng.annotations.Test;

public class TestEnv {

    @Test
    public void testEnv() {
        for (String key : System.getenv().keySet()) {
            System.out.println(key + " = " + System.getenv(key));
        }
    }
}
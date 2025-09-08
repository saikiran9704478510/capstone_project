package com.wipro.TestNG;

import org.testng.annotations.Test;

public class sampletest {
    @Test
    public void verifyAddition() {
        int sum = 2 + 3;
        assert sum == 5 : "Sum is incorrect";
        System.out.println("Test passed!");
    }
}
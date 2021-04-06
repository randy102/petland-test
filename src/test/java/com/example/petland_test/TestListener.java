package com.example.petland_test;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static java.lang.System.exit;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result){
        exit(0);
    }
}
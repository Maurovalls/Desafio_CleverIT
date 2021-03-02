package org.desafio.search.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start Test: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Pass: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("running: "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("end of execution: "+context.getName());
    }
}

package utils;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNgListener implements IResultListener {
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.info("Started testcase: " + result.getMethod().getMethodName());
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        Log.info("Start time: " + timestamp);
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.info("Passed testcase: " + result.getMethod().getMethodName());
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        Log.info("End time: " + timestamp);
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.error("Failed test case: " + result.getMethod().getMethodName());
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        Log.error("End time: " + timestamp);
        Log.error(result.getThrowable());
        Log.error("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Log.info("Skipped testcase: " + result.getMethod().getMethodName());
        Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}

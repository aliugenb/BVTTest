package com.xmly.listener.reportlistener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * ClassName: ExtentReport
 * Author: ye.liu
 * Date: 2019-02-19 18:37
 * Description:
 */
public class ExtentReport {
    public static ExtentReports extent;

    //生成的路径以及文件名
    private static final String OUTPUT_FOLDER = "result/";
    private static final String FILE_NAME = "testNGReport.html";

    static {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        // 设置静态文件的DNS
        //怎么样解决cdn.rawgit.com访问不了的情况
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);

        htmlReporter.config().setDocumentTitle("自动化测试报告");
        htmlReporter.config().setReportName("自动化测试报告");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        htmlReporter.config().setProtocol(Protocol.HTTP);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    public static ExtentReports getExtent() {
        return extent;
    }
}

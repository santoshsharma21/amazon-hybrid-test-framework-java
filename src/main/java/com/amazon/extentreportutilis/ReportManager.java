/**
 * 
 */
package com.amazon.extentreportutilis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;

import com.amazon.utilities.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */
public class ReportManager {
	
	public ExtentSparkReporter extentReporter;
	public ExtentReports reports;
	public ExtentTest extentTest;
	private ConfigReader cfg = new ConfigReader();
	public String reportPath;
	
	//setup report
	public void setupExtentReport(ITestContext testContext) {
		
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = "Test-Report_" + dt;
		reportPath = System.getProperty("user.dir") + "/execution-reports/" + fileName + ".html";
		
		extentReporter = new ExtentSparkReporter(reportPath);
		extentReporter.config().setTheme(Theme.DARK);
		extentReporter.config().setReportName("Automation Test Report");
		extentReporter.config().setDocumentTitle("Report");
		
		reports = new ExtentReports();
		reports.attachReporter(extentReporter);
		reports.setSystemInfo("Tester", "Santosh Sharma");
		reports.setSystemInfo("Project", "Amazon");
		reports.setSystemInfo("URL", cfg.getUrl());
		reports.setSystemInfo("Windows Version", System.getProperty("os.version"));
		reports.setSystemInfo("Java Version", System.getProperty("java.version"));
		reports.setSystemInfo("Browser", testContext.getCurrentXmlTest().getParameter("browser"));
		
		List<String> includedTestGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedTestGroups.isEmpty()) {
			reports.setSystemInfo("Test Groups", includedTestGroups.toString());
		}
	}
	
	public void closeReport() {
		reports.flush();
	}
}

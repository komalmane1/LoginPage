package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.helpers.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;
import freemarker.template.SimpleDate;

public class Extent_Reports extends TestBase

{
	
	static ExtentReports report;
   public static ExtentReports getReportInstance()
   
   {
	   if(report==null)
	   {
		   String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-hh").format(new Date());
		   ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("C:\\Users\\Shree\\eclipse-workspace\\OctoberBatch2024-25\\Extent Reports\\"+reportName+".html");
		   
		   report = new ExtentReports();
		   report.attachReporter(htmlreporter);
		   report.setSystemInfo("os", "windows");
		   report.setSystemInfo("Enviromentt", "SIT");
		   report.setSystemInfo("Build No", "101.02.02.123");
		   report.setSystemInfo("Browser", "Chromae");
		   htmlreporter.config().setDocumentTitle("UI Testng Documents");
		   htmlreporter.config().setDocumentTitle("UI Test Report");
		         
	   }
	return report;
	   
	   
   }
	
}

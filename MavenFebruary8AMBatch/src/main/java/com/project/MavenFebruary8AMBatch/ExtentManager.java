package com.project.MavenFebruary8AMBatch;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{

	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report == null) 
		{
			report = new ExtentReports(projectPath+"//HTMLReports//"+filePath+".html");
			report.loadConfig(new File(projectPath+"//extentreportconfig.xml"));
			report.addSystemInfo("Selenium language Binding", "3.141.59").addSystemInfo("Environment", parentProp.getProperty("env"));
		}
		
		return report;
	}
	
	

}
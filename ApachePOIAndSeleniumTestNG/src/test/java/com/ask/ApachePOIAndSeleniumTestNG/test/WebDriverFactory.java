package com.ask.ApachePOIAndSeleniumTestNG.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ask.ApachePOIAndSeleniumTestNG.model.Phone;
import com.ask.ApachePOIAndSeleniumTestNG.poi.ExcelOperation;
import com.ask.ApachePOIAndSeleniumTestNG.poi.ExcelOperationImpl;
import com.ask.ApachePOIAndSeleniumTestNG.util.ExcelUtil;
import com.ask.ApachePOIAndSeleniumTestNG.util.TestUtil;

public class WebDriverFactory {
	private WebDriver webDriver;
	private List<Phone> phoneList = new ArrayList<Phone>();

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	@BeforeSuite
	public void init() {
		InitializeWebDriver();

		try {
			InitializeExcelFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		System.out.println("WebDriverFactory method worked!");
	}

	void InitializeWebDriver() {
		System.setProperty(TestUtil.CHROME_DRIVER_NAME, TestUtil.CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(TestUtil.TIMEOUT_DURATION, TimeUnit.SECONDS);

		System.out.println("InitializeWebDriver method worked!");
	}

	void InitializeExcelFiles() throws IOException {
		ExcelOperation excelOperation = new ExcelOperationImpl();
		phoneList = excelOperation.getAllColumns(ExcelUtil.EXCEL_FILE_PATH, ExcelUtil.PHONE_SHEET_NAME);

		System.out.println("InitializeExcelFiles method worked!");
	}

	@AfterSuite
	public void destroy() {
		webDriver.quit();
	}
}

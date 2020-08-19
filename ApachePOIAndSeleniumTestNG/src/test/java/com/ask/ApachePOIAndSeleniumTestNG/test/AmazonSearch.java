package com.ask.ApachePOIAndSeleniumTestNG.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ask.ApachePOIAndSeleniumTestNG.model.Phone;
import com.ask.ApachePOIAndSeleniumTestNG.util.ExcelUtil;
import com.ask.ApachePOIAndSeleniumTestNG.util.TestUtil;

public class AmazonSearch extends WebDriverFactory {
	@BeforeMethod
	public void openAmazonPage() {
		getWebDriver().get(TestUtil.AMAZON_PATH);

		System.out.println("URL " + getWebDriver().getCurrentUrl());
	}

	@Test(dataProvider = TestUtil.PHONE_DATA_PROVIDER)
	public void search(String data) throws InterruptedException {
		System.out.println("Data is: " + data);

		getWebDriver().findElement(By.xpath(TestUtil.XPATH_AMAZON_SEARCH)).sendKeys(data);
		Thread.sleep(TestUtil.THREAD_SLEEP_DURATION);
		getWebDriver().findElement(By.xpath(TestUtil.XPATH_AMAZON_SEARCH_BUTTON)).click();
		Thread.sleep(TestUtil.THREAD_SLEEP_DURATION);

		System.out.println("Search completed!");
	}

	@DataProvider(name = TestUtil.PHONE_DATA_PROVIDER)
	public Object[][] phoneDataProviderList() {
		Phone pickRandomPhone = (Phone) ExcelUtil.pickRandomItem(getPhoneList());
		String currentPhoneModel = pickRandomPhone.getModel();
		String currentPhoneName = pickRandomPhone.getName();

		System.out.println(currentPhoneModel + " " + currentPhoneName);
		return new Object[][] { { currentPhoneModel + " " + currentPhoneName } };
	}
}

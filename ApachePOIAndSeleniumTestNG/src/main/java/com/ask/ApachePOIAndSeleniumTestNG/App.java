package com.ask.ApachePOIAndSeleniumTestNG;

import java.io.IOException;
import java.util.List;

import com.ask.ApachePOIAndSeleniumTestNG.model.Phone;
import com.ask.ApachePOIAndSeleniumTestNG.poi.ExcelOperation;
import com.ask.ApachePOIAndSeleniumTestNG.poi.ExcelOperationImpl;
import com.ask.ApachePOIAndSeleniumTestNG.util.ExcelUtil;

public class App {
	public static void main(String[] args) throws IOException {
		ExcelOperation excelOperation = new ExcelOperationImpl();
		List<Phone> phoneList = excelOperation.getAllColumns(ExcelUtil.EXCEL_FILE_PATH, ExcelUtil.PHONE_SHEET_NAME);

		if (!phoneList.isEmpty()) {
			for (int i = 0; i < phoneList.size(); i++)
				System.out.println(phoneList.get(i).getModel() + " " + phoneList.get(i).getName());
		} else {
			System.out.println("PhoneList is empty");
		}

		Phone randomPhone = (Phone) ExcelUtil.pickRandomItem(phoneList);
		System.out.println(randomPhone.getName() + " " + randomPhone.getModel());
	}
}

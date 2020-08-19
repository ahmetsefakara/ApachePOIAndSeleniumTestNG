package com.ask.ApachePOIAndSeleniumTestNG.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.ask.ApachePOIAndSeleniumTestNG.model.Phone;

public interface ExcelOperation {
	List<Phone> getAllColumns(String path, String sheetName) throws IOException;

	void closeOperations(Workbook workbook, FileInputStream fileInputStream) throws IOException;
}

package com.ask.ApachePOIAndSeleniumTestNG.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ask.ApachePOIAndSeleniumTestNG.model.Phone;
import com.ask.ApachePOIAndSeleniumTestNG.util.Util;

public class ExcelOperationImpl implements ExcelOperation {
	private Workbook workbook;

	public List<Phone> getAllColumns(String path, String sheetName) throws IOException {
		List<Phone> phoneList = new ArrayList<Phone>();
		FileInputStream fileInputStream = new FileInputStream(new File(path));

		workbook = new XSSFWorkbook(fileInputStream);
		Sheet phoneSheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = phoneSheet.iterator();

		while (rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Phone phone = new Phone();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					phone.setModel((String) Util.getCellValue(nextCell));
					// System.out.println(phone.getModel().toString());
					break;
				case 1:
					phone.setName((String) Util.getCellValue(nextCell));
					// System.out.println(phone.getName().toString());
					break;
				}
			}

			phoneList.add(phone);
		}

		closeOperations(workbook, fileInputStream);
		// System.out.println(phoneList.size());
		return phoneList;
	}

	public void closeOperations(Workbook workbook, FileInputStream fileInputStream) throws IOException {
		workbook.close();
		fileInputStream.close();
	}
}

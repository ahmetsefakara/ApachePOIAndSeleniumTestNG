package com.ask.ApachePOIAndSeleniumTestNG.util;

import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtil {
	public static final String EXCEL_FILE_PATH = "Excel1.xlsx";
	public static final String PHONE_SHEET_NAME = "PhoneSheet";

	public ExcelUtil() {
	}

	public static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellType();
		Object obj;

		switch (cellType) {
		case STRING:
			obj = cell.getStringCellValue();
			break;
		case BOOLEAN:
			obj = cell.getBooleanCellValue();
			break;
		case NUMERIC:
			obj = cell.getNumericCellValue();
			break;
		default:
			obj = null;
			break;
		}

		return obj;
	}

	public static <T> Object pickRandomItem(List<T> list) {
		int maxNum = list.size();

		if (list.isEmpty()) {
			throw new IllegalArgumentException("List is empty");
		} else {
			Random random = new Random();
			return list.get(random.nextInt(maxNum));
		}
	}

	public static <T> Object pickRandomItem(List<T> list, int minNum) {
		int maxNum = list.size();

		if (list.isEmpty()) {
			throw new IllegalArgumentException("List is empty");
		} else if (minNum >= maxNum) {
			throw new IllegalArgumentException("List size must be greater than minNum");
		} else {
			Random random = new Random();
			return list.get(random.nextInt(((maxNum - 1) - minNum) + 1) + minNum);
		}
	}

	public static <T> Object pickRandomItem(List<T> list, boolean exceptFirstItem) {
		int firstItem = 1;
		int maxNum = list.size();

		if (!exceptFirstItem) {
			return pickRandomItem(list);
		} else {
			if (list.isEmpty()) {
				throw new IllegalArgumentException("List is empty");
			} else if (firstItem >= maxNum) {
				throw new IllegalArgumentException("List have 1 item");
			} else {
				Random random = new Random();
				return list.get(random.nextInt(((maxNum - 1) - 1) + 1) + 1);
			}
		}
	}
}

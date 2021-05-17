package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenericMethods {

	public static String[][] getData(String filename, String sheetName) throws IOException {

		String[][] data = null;
		File file = new File(filename);

		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);

			int rowNum = sheet.getLastRowNum() + 1;
			int colNum = sheet.getRow(0).getLastCellNum();
			data = new String[rowNum][colNum];

			for (int i = 0; i < rowNum; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colNum; j++) {
					Cell cell = row.getCell(j);
					String value = new DataFormatter().formatCellValue(cell);
					data[i][j] = value;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in reading excel data: " + e);
		}
		return data;
	}

}
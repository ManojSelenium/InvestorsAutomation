package com.investors.xmlgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {

	public TreeMap<String, LinkedList> excelDataMap;
	String sexcelFilepath = null;
	public Iterator<Row> rowIt;
	// Sheet sheetName;
	// Workbook workbook = null;
	public FileInputStream fis = null;
	public Sheet sheetName = null;
	public Workbook workbook = null;

	public ReadTestData() throws FileNotFoundException {

		sexcelFilepath = "/src/test/resources/RegressionTestCases.xlsx";
		fis = new FileInputStream(new File(getFilePath(sexcelFilepath)));

		System.out.println("Excel Path :::::: " + sexcelFilepath);

	}

	public String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		System.out.println("File path is " + sFilepath);
		String sPath = System.getProperty("user.dir").replace(cbackslash, cforwardslash) + sFilepath;

		File file = new File(sPath);
		if (file.exists()) {
			sPath = file.getAbsolutePath();
			System.out.println("The File Path is " + sPath);
		} else {
		}
		return sPath;
	}

	public Iterator<Row> excelFileTye(String ssheetname) throws IOException {

		if (sexcelFilepath.toLowerCase().endsWith("xls"))
			workbook = new HSSFWorkbook(fis);
		else if (sexcelFilepath.toLowerCase().endsWith("xlsx"))
			workbook = new XSSFWorkbook(fis);
		else
			System.err.println("Invalid cases file Format");
		if (isNumeric(ssheetname)) {
			sheetName = workbook.getSheetAt(Integer.parseInt(ssheetname));
		} else {
			sheetName = workbook.getSheet(ssheetname);
		}
		// System.out.println( "The sheet name is"+sheetName);
		rowIt = sheetName.iterator();

		return rowIt;
	}

	@SuppressWarnings("unchecked")
	public TreeMap<String, LinkedList> readTestCaseExcel(String ssheetName) {
		System.out.println("SheetName : " + ssheetName);
		LinkedList list;
		Row row;
		String className, methodName, flag;
		excelDataMap = new TreeMap<String, LinkedList>();
		// HashMap<String, String> excelMap=new HashMap<String, String>();
		try {
			excelFileTye(ssheetName).next();

			while (rowIt.hasNext()) {
				row = rowIt.next();

				className = row.getCell(0).getStringCellValue();
				methodName = row.getCell(1).getStringCellValue();
				flag = row.getCell(2).getStringCellValue();
				if (excelDataMap.containsKey(className)) {
					list = excelDataMap.get(className);
					list.add(methodName + "@!@" + flag);
					excelDataMap.put(className.trim(), list);
				} else {
					list = new LinkedList();
					list.add(methodName + "@!@" + flag);
					excelDataMap.put(className.trim(), list);
				}

			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return excelDataMap;
	}

	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

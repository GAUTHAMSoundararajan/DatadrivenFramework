package dataProviderPackage;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import basepackage.Base;
import utility.ExcelLibrary;

public class DataFactory extends Base {
	
ExcelLibrary excel = new ExcelLibrary();


@DataProvider(name = "Credentials")
public  Object[][] getSignInCredentials() {
	// Totals rows count
	int rows = excel.getRowCount("Credentials");
	// Total Columns
	int column = excel.getColumnCount("Credentials");
	int actRows = rows - 1;

	Object[][] data = new Object[actRows][column];

	for (int i = 0; i < actRows; i++) {
		for (int j = 0; j < column; j++) {
			data[i][j] = excel.getCellData("Credentials", j, i + 2);
		}
	}
	return data;
}
@DataProvider(name = "CreateAccount")
public  Object[][] createAccount() {
	// Totals rows count
	int rows = excel.getRowCount("Email");
	// Total Columns
	int column = excel.getColumnCount("Email");
	int actRows = rows - 1;

	Object[][] data = new Object[actRows][column];

	for (int i = 0; i < actRows; i++) {
		for (int j = 0; j < column; j++) {
			data[i][j] = excel.getCellData("Email", j, i + 2);
		}
	}
	return data;
}


@DataProvider(name = "AccountCreationData")
public  Object[][] accountCreation() {
	// Totals rows count
			int rows = excel.getRowCount("AccountCreationData");
			// Total Columns
			int column = excel.getColumnCount("AccountCreationData");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					hashMap.put(excel.getCellData("AccountCreationData", j, 1),
							excel.getCellData("AccountCreationData", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
}
}

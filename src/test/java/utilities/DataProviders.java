package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		String path=".\\testData\\openCart.Login_Data.xlsx";
		
		Excel_Utils EU=new Excel_Utils(path);
		
		//This will give the total number of rows present in the Excel file
		int total_row=EU.getRowCount("Sheet1");
		
		//This will give the total columns present
		int total_cell_count=EU.getCellCount("Sheet1", 1);
		
		//This will create a 2 dimensions array to save the data which read from excel
		String loginData[][]=new String[total_row][total_cell_count];
		
		//This loop though the excel file and read the data and past the data in the two dimensional array
		for(int i=1;i<=total_row;i++) {
			for(int j=0;j<total_cell_count;j++) {
				loginData[i-1][j]=EU.getCellData("Sheet1", i, j);
			}
		}
		
		//Finally returning the data to the calling method
		return loginData;
	}
}

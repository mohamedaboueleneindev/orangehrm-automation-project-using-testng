package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
    
    @DataProvider(name = "loginData")
    public String [][] getData() throws IOException{
        
        ExcelUtility excel = new ExcelUtility(".//testData//LoginData.xlsx");
        int no_rows = excel.getRowCount("sheet1");
        int no_cells = excel.getCellCount("sheet1", 1);
        String data [][] = new String[no_rows][no_cells];
        for (int i = 0; i < no_rows; i++) {
            for (int j = 0; j < no_cells; j++) {
                data[i][j] = excel.getCellData("sheet1", i+1, j);
            }
        }
        return data;
    }

}

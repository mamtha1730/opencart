package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	
//data provider-1
	
@DataProvider(name="Logindata")	
public String[][] getData() throws IOException
{
	String path = ".\\testdata\\Opencart_Logindata.xlsx";
	ExcelUtility xlutil = new ExcelUtility(path);
	int totrows= xlutil.getRowCount("Sheet1");
	int totcols = xlutil.getCellCount("Sheet1",1);
	String logindata[][]=new String[totrows][totcols];
	for(int i=1;i<=totrows;i++)
	{
		for(int j=0;j<totcols;j++)
		{
			logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);//1,0
		}
	}
	return logindata; //returning two dim data

}
//data provider-2

//data provider -3

//data provider-4
}
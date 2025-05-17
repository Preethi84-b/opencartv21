package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Datadriven {

	public String path;

	@DataProvider(name="logindata")
	public String[][] logindata() throws IOException{
		path=".\\testdata\\data1.xlsx";
		Utility ux=new Utility(path);
		
		int i=Utility.getrowcount("sheet1");
		int j=Utility.getcellcount("sheet1", 1);
		String data[][]=new String[i][j];
		for(int k=1;k<=i;k++) {
			for(int r=0;r<j;r++) {
				data[k-1][r]=Utility.getcelldata("sheet1", k, r);
			}
			}
		return data;
		}

		
		
	}



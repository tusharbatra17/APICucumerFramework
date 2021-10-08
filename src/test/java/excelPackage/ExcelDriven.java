package excelPackage;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList data=ExcelExtractor.getExcelData("Purchase");
		
		int count = data.size();
		
		for(int i=0;i<count;i++)
		
		System.out.println(data.get(i));
		/*System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));*/
	}

}

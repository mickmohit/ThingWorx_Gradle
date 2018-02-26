package com.thingworx.sdk.practise;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.thingworx.communications.client.ConnectedThingClient;
import com.thingworx.communications.client.things.VirtualThing;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelThing  extends VirtualThing {
	 private String Model;
	 private String sn;
	 
	 public ExcelThing(String ExcelThing, String description, ConnectedThingClient client){
		 super(ExcelThing, description ,client);
		 
	 }
	 
	 public void readBooksFromExcelFile() throws Exception
	 {
		 
		 try
		 {
		 FileInputStream file = new FileInputStream(new File("D:/data/productinstance.xlsx"));
		 
		 Workbook workbook = new XSSFWorkbook(file);
		 
         //Get first/desired sheet from the workbook
         Sheet sheet = workbook.getSheetAt(0);

         //Iterate through each rows one by one
         Iterator<Row> rowIterator = sheet.iterator();
         while (rowIterator.hasNext())
         {
             Row row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();
              
             while (cellIterator.hasNext())
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 switch (cell.getCellType())
                 {
                     case Cell.CELL_TYPE_NUMERIC:
                         System.out.print(cell.getNumericCellValue() + "t");
                         break;
                     case Cell.CELL_TYPE_STRING:
                         System.out.print(cell.getStringCellValue() + "t");
                         break;
                 }
             }
             System.out.println("");
         }
         file.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
 }

		 
		 
	 }
	 


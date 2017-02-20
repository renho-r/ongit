package com.renho;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XSSFWorkbook wb = new XSSFWorkbook();//����Excel����������   
		XSSFSheet sheet = wb.createSheet("new sheet");//����Excel���������     
		sheet.setColumnWidth(0, 6000);
		XSSFRow row = sheet.createRow((short)0); //����Excel���������   
		row.setHeight((short) 500);
		
		XSSFCellStyle cellStyle = wb.createCellStyle();//������Ԫ����ʽ   
		cellStyle.setWrapText(true);
		cellStyle.setAlignment((short) 2);
		cellStyle.setVerticalAlignment((short) 1);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellStyle(cellStyle); //����Excel������ָ���еĵ�Ԫ��   
		cell.setCellValue("ԴIP            Ŀ��IP"); //����Excel�������ֵ
		
		XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        XSSFClientAnchor a = new XSSFClientAnchor(0, 0, 0, 0, 0, 0, 1, 1);  
        XSSFSimpleShape shape1 = patriarch.createSimpleShape(a);  
        shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);   
        shape1.setLineStyle(HSSFSimpleShape.LINESTYLE_SOLID) ; 
        shape1.setLineWidth(1);
        shape1.setLineStyleColor(0, 0, 0);
		
		String excelPath = "d://test.xlsx";
		FileOutputStream outputStream = new FileOutputStream(excelPath);
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
		
		File sss = new File(excelPath);
		System.out.println(sss.getAbsolutePath());
	}

}

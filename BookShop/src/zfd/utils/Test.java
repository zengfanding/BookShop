package zfd.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("我的第一个工作表");

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell01 = row.createCell(0);
		cell01.setCellValue("long string...long string...long string...long string...long string...long string...");

		HSSFCell cell02 = row.createCell(1);
		cell02.setCellValue("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		HSSFCell cell03 = row.createCell(2);
		cell03.setCellValue("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

		// 1.设置回绕文本——自动换行
		// ①创建单元格风格对象
		HSSFCellStyle cellStyle = workbook.createCellStyle();

		// ②设置回绕文本属性为真
		cellStyle.setWrapText(true);

		// ③为有需要的单元格设置风格对象
		cell01.setCellStyle(cellStyle);

		// 2.指定具体数值的列宽
		sheet.setColumnWidth(1, 7000);

		// 3.设置自动列宽
		sheet.autoSizeColumn(2);
		
		
		
		

		workbook.write(new FileOutputStream("E:/good.xls"));
	}

}

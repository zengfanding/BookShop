package zfd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.bean.ExcelBean;
import zfd.service.BookService;
import zfd.service.BookServiceImpl;
import zfd.service.JinshuService;
import zfd.service.JinshuServiceImpl;
import zfd.service.XiaoshouService;
import zfd.service.XiaoshouServiceImpl;

public class ExportExcelUtils {

	private static BookService bookService = ContextLoader.getCurrentWebApplicationContext().getBean(BookService.class);
	private static JinshuService jinshuService = ContextLoader.getCurrentWebApplicationContext()
			.getBean(JinshuService.class);

	private static XiaoshouService xiaoshouService = ContextLoader.getCurrentWebApplicationContext()
			.getBean(XiaoshouService.class);

	public static void exportExcelXiaoshou(List<BookInfo> books, HSSFWorkbook workbook) {

		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFSheet sheet = workbook.createSheet("销售信息");

		HSSFRow row = sheet.createRow(0);

		String[] titles = new String[] { "销售码", "书籍条形码", "书籍名称", "销售量", "销售日期" };

		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			sheet.setColumnWidth(i, 7000);
			cell.setCellStyle(style);
		}

		int i = 0, j = 0;
		int totalRow = 1;
		for (i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			Set<BookXiaoshou> xiaos = book.getBookXiaoshous();

			for (BookXiaoshou xiao : xiaos) {

				String[] values = new String[] { xiao.getXiaoshouMa(), book.getTiaoma(), book.getName(),
						xiao.getXiaoshouNum() + "", DateFormatUtil.formatDateTime(xiao.getXiaoshouDate()) };
				HSSFRow rows = sheet.createRow(totalRow);

				for (int k = 0; k < titles.length; k++) {
					HSSFCell c = rows.createCell(k);
					c.setCellValue(values[k]);
					c.setCellStyle(style);
				}

				totalRow++;

			}

		}

		HSSFRow rowr = sheet.createRow(totalRow + 5);
		HSSFCell cell = rowr.createCell(titles.length - 1);
		cell.setCellValue("导出时间:" + DateFormatUtil.formatDateTime(System.currentTimeMillis()));

	}

	public static void exportExcelJinshu(List<BookInfo> books, HSSFWorkbook workbook) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFSheet sheet = workbook.createSheet("进书信息");
		HSSFRow row = sheet.createRow(0);
		String[] titles = new String[] { "进书码", "书籍条形码", "书籍名称", "采购价", "采购量", "采购日期" };
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			sheet.setColumnWidth(i, 7000);
			cell.setCellStyle(style);
		}
		int i = 0, j = 0;
		int totalRow = 1;
		for (i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			Set<BookJinhuo> jins = book.getBookJinhuos();
			for (BookJinhuo jin : jins) {
				String[] values = new String[] { jin.getJinshuMa(), book.getTiaoma(), book.getName(),
						jin.getJinPrice() + "", jin.getCaiGouNum() + "",
						DateFormatUtil.formatDateTime(jin.getCaiGouDate()) };
				HSSFRow rows = sheet.createRow(totalRow);
				for (int k = 0; k < titles.length; k++) {
					HSSFCell c = rows.createCell(k);
					c.setCellValue(values[k]);
					c.setCellStyle(style);
				}
				totalRow++;
			}
		}
		HSSFRow rowr = sheet.createRow(totalRow + 5);
		HSSFCell cell = rowr.createCell(titles.length - 1);
		cell.setCellValue("导出时间:" + DateFormatUtil.formatDateTime(System.currentTimeMillis()));
	}

	public static void exportExcelKucun(List<BookInfo> books, HSSFWorkbook workbook) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFSheet sheet = workbook.createSheet("库存信息");

		HSSFRow row = sheet.createRow(0);

		String[] titles = new String[] { "条形码", "书籍名称", "库存" };

		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			sheet.setColumnWidth(i, 7000);
			cell.setCellStyle(style);
		}

		int i = 0, j = 0;
		for (i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			String[] values = new String[] { book.getTiaoma(), book.getName(), book.getNum() + "" };
			HSSFRow rows = sheet.createRow(i + 1);
			for (j = 0; j < titles.length; j++) {
				HSSFCell c = rows.createCell(j);
				c.setCellValue(values[j]);
				c.setCellStyle(style);
			}
		}

		HSSFRow rowr = sheet.createRow(i + 5);
		HSSFCell cell = rowr.createCell(j - 1);
		cell.setCellValue("导出时间:" + DateFormatUtil.formatDateTime(System.currentTimeMillis()));

	}

	public static void exportExcelBook(List<BookInfo> books, HSSFWorkbook workbook) {

		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFSheet sheet = workbook.createSheet("书籍信息");

		HSSFRow row = sheet.createRow(0);

		String[] titles = new String[] { "条形码", "书籍名称", "作者", "出版社", "售价", "库存" };

		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			sheet.setColumnWidth(i, 7000);
			cell.setCellStyle(style);
		}

		int i = 0;
		int j = 0;

		for (i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			String[] values = new String[] { book.getTiaoma(), book.getName(), book.getAuthor(), book.getPublishing(),
					book.getPrice() + "", book.getNum() + "" };
			HSSFRow rows = sheet.createRow(i + 1);
			for (j = 0; j < titles.length; j++) {
				HSSFCell c = rows.createCell(j);
				c.setCellValue(values[j]);
				c.setCellStyle(style);
			}
		}

		HSSFRow rowr = sheet.createRow(i + 5);
		HSSFCell cell = rowr.createCell(j - 1);
		cell.setCellValue("导出时间:" + DateFormatUtil.formatDateTime(System.currentTimeMillis()));

	}

	public static List<ExcelBean> tranferFromBookInfoToExcelBean(List<BookInfo> books) {
		if (books == null || books.size() == 0) {
			return null;
		}
		List<ExcelBean> list = new ArrayList<ExcelBean>();
		for (BookInfo book : books) {
			List<BookJinhuo> jins = jinshuService.findByBookIdWithAscOrder(book);
			List<BookXiaoshou> xiaos = xiaoshouService.findByBookIdWithAscOrder(book);
			if (jins == null || xiaos == null || jins.size() == 0 || xiaos.size() == 0) {
				continue;
			}
			String tiaoma = book.getTiaoma();
			String name = book.getName();
			Integer currentKucun = book.getNum();
			String author = book.getAuthor();
			String publishing = book.getPublishing();
			Double price = book.getPrice();
			int j = 0;
			for (int i = 0; i < xiaos.size(); i++) {
				BookJinhuo currentJin = jins.get(j);
				BookXiaoshou currentXiao = xiaos.get(i);

				if (currentXiao.getXiaoshouNum() < currentJin.getCaiGouNum()) {
					list.add(new ExcelBean(tiaoma, name, currentKucun, author, publishing, price,
							currentJin.getJinPrice(), currentXiao.getXiaoshouNum()));
					jins.get(j).setCaiGouNum(currentJin.getCaiGouNum() - currentXiao.getXiaoshouNum());
				} else if (currentXiao.getXiaoshouNum() == currentJin.getCaiGouNum()) {
					list.add(new ExcelBean(tiaoma, name, currentKucun, author, publishing, price,
							currentJin.getJinPrice(), currentXiao.getXiaoshouNum()));
					j++;
				} else {
					list.add(new ExcelBean(tiaoma, name, currentKucun, author, publishing, price,
							currentJin.getJinPrice(), currentJin.getCaiGouNum()));
					xiaos.get(i).setXiaoshouNum(currentXiao.getXiaoshouNum() - currentJin.getCaiGouNum());
					i--;
					j++;
				}
			}
		}
		for (ExcelBean excelBean : list) {
			System.out.println(excelBean);
		}

		return list;
	}

	public static void exportExcelTongji(List<BookInfo> books, HSSFWorkbook workbook) {

		List<ExcelBean> excelBeans = tranferFromBookInfoToExcelBean(books);
		if (excelBeans != null && excelBeans.size() > 0) {
			HSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFSheet sheet = workbook.createSheet("统计信息");

			HSSFRow row = sheet.createRow(0);

			String[] titles = new String[] { "条形码", "书籍名称", "作者", "出版社", "售价", "当前库存", "进价", "销售量", "利润" };

			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(titles[i]);
				sheet.setColumnWidth(i, 6000);
				cell.setCellStyle(style);
			}

			int i = 0;
			int j = 0;
			double totalBenifit = 0;

			for (i = 0; i < excelBeans.size(); i++) {
				ExcelBean bean = excelBeans.get(i);
				totalBenifit = bean.getBenifit() + totalBenifit;
				String[] values = new String[] { bean.getTiaoma(), bean.getName(), bean.getAuthor(),
						bean.getPublishing(), bean.getPrice() + "", bean.getCurrentKucun() + "",
						bean.getJinPrice() + "", bean.getXiaoshouNum() + "", bean.getBenifit() + "" };
				HSSFRow rows = sheet.createRow(i + 1);
				for (j = 0; j < titles.length; j++) {
					HSSFCell c = rows.createCell(j);
					c.setCellValue(values[j]);
					c.setCellStyle(style);
				}

			}

			HSSFRow rowr = sheet.createRow(i + 2);
			HSSFCell cell = rowr.createCell(j - 1);
			cell.setCellValue("总利润:" + totalBenifit);

			rowr = sheet.createRow(i + 5);
			cell = rowr.createCell(j - 1);
			cell.setCellValue("导出时间:" + DateFormatUtil.formatDateTime(System.currentTimeMillis()));
		}

	}

}

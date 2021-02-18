package com.charles.util.xlxs;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XlxsUtils {
    static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
    static Map<String, CellStyle> styleMap = new HashMap<String, CellStyle>();

    public static List<String> readExcel(String filePath) {//读取Excel并获取所有信息
        Workbook book = null;
        try {
            book = getExcelWorkbook(filePath);
            Sheet sheet = getSheetByNum(book, 1);
            System.out.println("sheet名称是：" + sheet.getSheetName());
            int lastRowNum = sheet.getLastRowNum();
            Row row = null;
            for (int i = 0; i <= lastRowNum; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    System.out.println("正在读第" + (i + 1) + "行：");
                    int lastCellNum = row.getLastCellNum();
                    Cell cell = null;
                    StringBuilder sb = null;
                    for (int j = 0; j < lastCellNum; j++) {
                        cell = row.getCell(j);
                        if (cell != null) {
                            sb = new StringBuilder("第" + (j + 1) + "列的单元格内容是：");
                            String type_cn = null;
                            String type_style = cell.getCellStyle().getDataFormatString().toUpperCase();
                            String type_style_cn = getCellStyleByChinese(type_style);
                            int type = cell.getCellType();
                            String value = "";
                            switch (type) {
                                case 0:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        type_cn = "NUMBER-DATE";
                                        Date date = cell.getDateCellValue();
                                        value = sFormat.format(date);
                                    } else {
                                        type_cn = "NUMBER";
                                        double tempValue = cell.getNumericCellValue();
                                        value = String.valueOf(tempValue);
                                    }
                                    break;
                                case 1:
                                    type_cn = "STRING";
                                    value = cell.getStringCellValue();
                                    break;
                                case 2:
                                    type_cn = "FORMULA";
                                    value = cell.getCellFormula();
                                    break;
                                case 3:
                                    type_cn = "BLANK";
                                    value = cell.getStringCellValue();
                                    break;
                                case 4:
                                    type_cn = "BOOLEAN";
                                    boolean tempValue = cell.getBooleanCellValue();
                                    value = String.valueOf(tempValue);
                                    break;
                                case 5:
                                    type_cn = "ERROR";
                                    byte b = cell.getErrorCellValue();
                                    value = String.valueOf(b);
                                default:
                                    break;
                            }
                            sb.append(value + ",内容类型是：" + type_cn + ",单元格的格式是：" + type_style_cn);
                            System.out.println(sb.toString());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Workbook getExcelWorkbook(String filePath) throws IOException{
        Workbook book = null;
        File file  = null;
        FileInputStream fis = null;

        try {
            file = new File(filePath);
            if(!file.exists()){
                throw new RuntimeException("文件不存在");
            }else{
                fis = new FileInputStream(file);
                book = WorkbookFactory.create(fis);
                initStyleMap(book);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if(fis != null){
                fis.close();
            }
        }
        return book;
    }

    public static Sheet getSheetByNum(Workbook book,int number){
        Sheet sheet = null;
        try {
            sheet = book.getSheetAt(number-1);
//			if(sheet == null){
//				sheet = book.createSheet("Sheet"+number);
//			}
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return sheet;
    }

    private static String getCellStyleByChinese(String type_style) {
        String cell_style_cn = "";
        if(type_style.contains("GENERAL")){
            cell_style_cn = "常规";
        }else if(type_style.equals("_ * #,##0.00_ ;_ * \\-#,##0.00_ ;_ * \"-\"??_ ;_ @_ ")){
            cell_style_cn = "会计专用";
        }else if(type_style.equals("0")){
            cell_style_cn = "整数";
        }else if(type_style.contains("YYYY/MM") || type_style.contains("YYYY\\-MM")){
            cell_style_cn = "日期";
        }else if(type_style.equals("0.00%")){
            cell_style_cn = "百分比";
        }else {
            cell_style_cn = "不符合规定格式类型:"+type_style;
//			cell_style_cn = type_style;
        }
        return cell_style_cn;
    }


    public static void initStyleMap(Workbook book){
        DataFormat hssfDF = book.createDataFormat();

        CellStyle doubleStyle = book.createCellStyle(); //会计专用
        doubleStyle.setDataFormat(hssfDF.getFormat("_ * #,##0.00_ ;_ * \\-#,##0.00_ ;_ * \"-\"??_ ;_ @_ ")); //poi写入后为会计专用
        styleMap.put("DOUBLE", doubleStyle);

        CellStyle intStyle = book.createCellStyle(); //会计专用
        intStyle.setDataFormat(hssfDF.getFormat("0")); //poi写入后为会计专用
        styleMap.put("INT", intStyle);

        CellStyle yyyyMMddStyle = book.createCellStyle();//日期yyyyMMdd
        yyyyMMddStyle.setDataFormat(hssfDF.getFormat("yyyy-MM-dd"));
        styleMap.put("DATE", yyyyMMddStyle);

        CellStyle percentStyle = book.createCellStyle();//百分比
        percentStyle.setDataFormat(hssfDF.getFormat("0.00%"));
        styleMap.put("PERCENT", percentStyle);
    }




    public static List<String> read(String filePath) throws IOException {//读取Excel并获取所有信息
        File file = new File(filePath);//获取该路径文件
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));//加载excel文本
        Sheet sheet = workbook.getSheetAt(0);// 读取第一个 sheet
        List<String> personPhone = new ArrayList<>();
        Row row = null;//存储行数据对象
        int rowCount = sheet.getPhysicalNumberOfRows();// 获总数
        // 逐行处理 excel 数据
        for (int i = 1; i < rowCount; i++) {
            row = sheet.getRow(i);//获得每一行的数据
            if (row != null) {
                int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();// 获得咧总数
                String phone;
                for (int j = 0; j < coloumNum; j++) {
                    Cell cell = row.getCell(1);//获得一个单元格
                    if (cell != null) {
                        personPhone.add(cell.toString());
                    }
                }
            }
        }
        return personPhone;
    }
}

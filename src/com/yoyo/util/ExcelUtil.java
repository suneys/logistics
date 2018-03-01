package com.yoyo.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
public class ExcelUtil {

    /**
     * 适用于第一行是标题行的excel
     * 每一行构成一个map，key值是列标题，value是列值。没有值的单元格其value值为null
     * @param filePath
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> readExcel(String filePath) throws Exception {

        List<Map<String, String>> list = null;
        InputStream is = new FileInputStream(filePath);

        Workbook rwb = Workbook.getWorkbook(is);

        Sheet rst = rwb.getSheet(0);

        int rows = rst.getRows();
        if (rows > 2){
            list = new ArrayList<>();
            int columns = rst.getColumns();
            for (int i = 1; i < rows; i++){
                Map<String, String> map = new HashMap<>();
                for (int j = 0; j < columns; j++){
                    Cell titleCell = rst.getCell(j,0);
                    Cell dataCell = rst.getCell(j,i);
                    map.put(titleCell.getContents(),dataCell.getContents());
                }
                list.add(map);
            }
        }

        is.close();
        return list;
    }
}

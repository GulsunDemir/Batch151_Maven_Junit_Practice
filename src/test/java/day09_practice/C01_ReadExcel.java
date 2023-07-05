package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel extends TestBase {
    @Test
    public void Test01() throws IOException {
        //Ulkeler dosyasindaki 3. satir indexin, 3. sutundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz

        int satirNoIdx = 3;
        int sutunNoIdx = 3;

       String actuelData =  banaDataGetir(satirNoIdx, sutunNoIdx);
       String  expextedData = "Cezayir";

        Assert.assertEquals(expextedData, actuelData);

    }

    public static String  banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();


     return istenenData;
    }
}

package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.IOException;


public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        //Ülkeler listesinde Başkent ingilizce sütununu yazdırın


        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirNumarasi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNumarasi);
        //getLastRowNum() son satır numarasini index olarak verir.
/*
        //2.yol;
        for (int i = 0; i <= sonSatirSayisi; i++) {
            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }


 */
      /*  for (int i = 0; i <= sonSatirNumarasi ; i++) {{
            C01_ReadExcel obj = new C01_ReadExcel();

            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }


        }

       */
        for (int i = 0; i <= sonSatirNumarasi; i++) {
            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(satirdakiData);


        }
    }
}

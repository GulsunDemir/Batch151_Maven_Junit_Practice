package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDowload extends TestBase {

    @Test
    public void test01() {
        File amaaaanSil=new File("C:\\Users\\ASUS\\Downloads\\some-file.txt");
        amaaaanSil.delete();
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(3);

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        bekle(3);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        String dosyaYolu = "C:\\Users\\ASUS\\Downloads\\some-file.txt";
        //Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //daha dinamik hale getirelim
        //C:\Users\ASUS          \Downloads\some-file.txt
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim ="\\Downloads\\some-file.txt";
        String dosyaYoluu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluu)));



    }

    @Test
    public void test02() throws InterruptedException {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        Thread.sleep(3000);


        File silinecekDosya = new File("C:\\Users\\ASUS\\Downloads\\some-file.txt");
        silinecekDosya.delete();










        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();

        Thread.sleep(3000);





        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //            "C:\Users\BURAK\Downloads\some-file.txt"

        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\some-file.txt")));


        // daha dinamik hale getirelim

        //            "C:\Users\BURAK                       \Downloads\some-file.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu = farkliKisim + ortakKisim;


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}

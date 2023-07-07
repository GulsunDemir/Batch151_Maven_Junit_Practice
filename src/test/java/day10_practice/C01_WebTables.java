package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // sutun sayısını yazdırın
    // tum body'i yazdirin
    // body'de bulunan satır sayısını yazdırın
    // body'de bulunan satırları yazdırın
    // 4.satırdaki elementleri yazdırın
    @Test
    public void webTables() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();

        // sutun sayısını yazdırın
//
//        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//t"));
//        System.out.println("SUTUN SAYİSİ = " + sutunBasliklariListesi.size());

        // sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SUTUN SAYISI : " + sutunBasliklariListesi.size());

        System.out.println("**************************************************");

        // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("SATIR SAYİSi "+ satirlarListesi.size());

        System.out.println("***************************");
        // body'de bulunan satırları yazdırın
        for (WebElement w : satirlarListesi){
            System.out.println(w.getText());
        }

        satirlarListesi.forEach(t-> System.out.println(t.getText()));

        System.out.println("*********************");

        // 4.satırdaki elementleri yazdırın
        List<WebElement> dorduncuSatirElementleri = driver.findElements(By.xpath("//body//tr[4]//td"));

        //dorduncuSatirElementleri.forEach(t-> System.out.println(t.getText()));

        for (WebElement w : dorduncuSatirElementleri){
            System.out.println(w.getText());
        }

    }

    public void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");

        WebElement gelismis = driver.findElement(By.xpath("//*[@id='details-button']"));
        gelismis.click();
        bekle(2);

        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        bekle(2);

        // Log in butonuna tıklayın
        WebElement login = driver.findElement(By.xpath("//*[text()='Log in']"));
        login.click();
        bekle(2);
        // Username: manager
        // Password: Manager1!
//        driver.findElement(By.xpath("//*[@id='UserName']")).
//                sendKeys("manager"+ Keys.TAB + "Manager1!" +Keys.TAB + Keys.ENTER);

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));

        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();


    }
}

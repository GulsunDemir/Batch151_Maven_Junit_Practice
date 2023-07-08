package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void webTables() {
        girisYap();
        //Email baslıgındaki tüm elementleri(sütun) yazdırın.
        List<WebElement> basliklarinListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo = 0;

        for (int i = 0; i < basliklarinListesi.size(); i++) {
            if (basliklarinListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }
        }

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]"));

        emailSutunListesi.forEach(t-> System.out.println(t.getText()));

        for (WebElement w : emailSutunListesi){
            System.out.println(w.getText());
        }


    }//webTables

    public void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");

        WebElement gelismis = driver.findElement(By.xpath("//*[@id='details-button']"));
        gelismis.click();
        bekle(2);

        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();  //Log'in butonu
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

package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {

        girisYap();
        //input olarak verilen satır sayısına ve sütun sayısına sahip cell'deki text'i dinamik olarak yazdırın.
        int satir = 3;
        int sutun = 3;

        //driver.findElement(By.xpath("//tbody//tr[3]//td[3]")); Dinamik degil
        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]")); //Dinamik
        System.out.println(arananCell.getText());


    }

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

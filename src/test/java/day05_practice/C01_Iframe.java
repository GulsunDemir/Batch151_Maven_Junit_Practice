package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);


        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();

        bekle(3);

        // videoyu durdurunuz
        WebElement videoDurdur = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoDurdur.click();
        bekle(3);

        // videoyu tam ekran yapınız
        WebElement TamEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        TamEkran.click();

        bekle(3);

        // videoyu calıstırınız
        videoDurdur.click();
        bekle(3);

        // videoyu kucultunuz
        TamEkran.click();
        bekle(3);

        // videoyu durdurunuz
        videoDurdur.click();
        bekle(3);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtobeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtobeYazisi.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement JQueryFlexy = driver.findElement(By.xpath("//h1[@style='margin-top:150px;']"));
        Assert.assertTrue(JQueryFlexy.isDisplayed());

    }
}

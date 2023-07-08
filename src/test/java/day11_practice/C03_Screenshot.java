package day11_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C03_Screenshot extends TestBase {
    // https://www.amazon.com/ adresine gidin
// arama kutusuna Nutella yazip aratın
// ilk ürüne tıklayın
// tüm sayfanın fotografını cekin

    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        // tüm sayfanın fotografını cekin
       /*
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmi/screenShot"+tarih+".Jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        */
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        TakesScreenshot ts = (TakesScreenshot) driver;
        File kayit = new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,kayit);

            }
}

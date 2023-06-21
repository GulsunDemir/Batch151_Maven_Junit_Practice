package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
            // 'https://www.n11.com' adresine gidin
        // arama motoruna 'Oppo' yazıp aratın
        // ilk ürüne tıklayın
        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        // ilk sayfaya donun ve Title'ını yazdırın
    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("ilk Sayfanın Handle Degeri = " + ilkSayfaHandleDegeri);
        bekle(3);

        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);
        bekle(3);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();
        bekle(3);


        Set<String> windowHandleSet = driver.getWindowHandles();

        bekle(3);
        //List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(pencereler.get(1));

        //driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(pencereler.get(1));
        //String ikinciSayfaTitle = driver.getTitle();
        //Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));
        String ikinciSayfaHandleDegeri = "";
        for (String w : windowHandleSet){
            if (!w.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri =w;
            }
        }
        bekle(2);
        System.out.println("ikinci Sayfa Handle Degeri = " + ikinciSayfaHandleDegeri);
        driver.switchTo().window(ikinciSayfaHandleDegeri);  //driver'i yeni acilan sekmeye gecirdik
        bekle(2);
        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        String  ikinciSayfaTitle = driver.getTitle();

        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(ilkSayfaHandleDegeri);

        String ilkSayfaTitle = driver.getTitle();
        System.out.println("ilk Sayfa Title = " + ilkSayfaTitle);



    }
}

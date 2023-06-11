package day03_pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Homework {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.cssSelector("textarea[id='APjFqb']")).sendKeys("Nutella" + Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        WebElement sonucYazısı = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi = sonucYazısı.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[1]);

        // sonuc sayısının 100000000  fazla oldugunu test edin
        String sonuc = sonucSayisi[1].replace(".","");

        int actualValue = Integer.valueOf(sonuc);
        int expectedValue = 100000000;

        Assert.assertTrue(actualValue>expectedValue);






    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

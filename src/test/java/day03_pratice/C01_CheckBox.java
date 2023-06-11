package day03_pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_CheckBox {
     /*
    CheckBox ==> Birden fazla haneye tik atılabilir
     */

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
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // checkbox elementlerini locate edin
        WebElement checkbox1 = driver.findElement(By.xpath("(//input)[4]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input)[5]"));
        WebElement checkbox3 = driver.findElement(By.xpath("(//input)[6]"));

        //   (//*[@type='checkbox'])[position()>=1 and position()<=3]

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkbox1.isSelected() && !checkbox3.isSelected()){
            checkbox1.click();
            checkbox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkbox2.isSelected());

    }

    @After
    public void tearDown() throws Exception {

        driver.close();
    }

}

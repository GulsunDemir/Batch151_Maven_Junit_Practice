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

public class C02_RadioButton {

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

        // radiobutton elementlerini locate edin
        WebElement option1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement option2 = driver.findElement(By.xpath("(//input)[2]"));
        WebElement option3 = driver.findElement(By.xpath("(//input)[3]"));

        // option2'yi secin
        option2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(option2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option3.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

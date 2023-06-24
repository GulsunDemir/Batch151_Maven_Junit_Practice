package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_Files {


    @Test
    public void test01() {
        // masaustunde bir text dosyası olusturunuz
        String dosyaYoluu ="C:/Users/ASUS/OneDrive/Masaüstü/Batch151.txt";

        // masaustunde text dosyasının olup olmadıgını test ediniz
        //Assert.assertTrue(Files.exists(Paths.get(dosyaYoluu)));  dinamik degil

        //dinamik hale getirelim

        //C:/Users/ASUS          /OneDrive/Masaüstü/Batch151.txt

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/OneDrive/Masaüstü/Batch151.txt";

        String dosyaYolu = farkliKisim +ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }





}

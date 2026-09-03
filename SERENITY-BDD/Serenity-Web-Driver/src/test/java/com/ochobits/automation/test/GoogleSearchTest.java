package com.ochobits.automation.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    private static WebDriver webDriver;

    @BeforeAll
    public static void setUp() throws Exception{
        System.setProperty("wedriver.chrome.driver","./wedriver/chrome/chromedriver");
        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage(){
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.clear();

        String esperado = "Test Automation por Selenium";
        searchBox.sendKeys(esperado);

        String text= searchBox.getAttribute("value");
        Assertions.assertEquals("Test Automation por Selenium",text);

        searchBox.submit();

//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(esperado));

        String tituloActual = webDriver.getTitle();
        Assertions.assertEquals(esperado+" - Buscar con Google",tituloActual);

    }

    @AfterAll
    public static void closeTest(){
        webDriver.quit();
    }
}

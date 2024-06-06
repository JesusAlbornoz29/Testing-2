package com.Tests;

import com.Pages.Page01;
import com.Pages.Page02;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Test02 {
    private WebDriver driver;
    private WebDriverWait wait;

/*
    @BeforeEach
    public void precondiciones() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        Page02 loginPage = new Page02(driver, wait);
        loginPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");

    }
*/
    @Test
    @Tag("BUSQUEDA")
    @Tag("EXITOSO")
    public void test_BusquedaExitosa() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        Page02 searchPage = new Page02(driver, wait);
        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");

        searchPage.buscar("Iphone");

        searchPage.clickBuscar();
        searchPage.agregarEnCarrito();

        searchPage.close();

    }


}

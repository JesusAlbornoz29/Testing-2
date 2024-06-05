package com.Tests;

import com.Pages.Page02;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Test02 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    @Tag("BUSQUEDA")
    @Tag("EXITOSO")
    public void test_BusquedaExitosa() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        Page02 searchPage = new Page02(driver, wait);
        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");

        searchPage.buscar("Iphone");

        searchPage.clickBuscar();
/*
        String resultado = searchPage.resultadoBusqueda();
        assertTrue(resultado.equals("CASA DE PLAYA\nVilla Kantounes Studio Ostria"));
*/
        searchPage.close();

    }


}

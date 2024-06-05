package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page02 extends BasePage {
    private By searchBox = By.className("search");
    private By searchBtn = By.cssSelector("button[type='button'].btn.btn-default.btn-lg i.fa.fa-search");
//     private By validateSearch = By.className("categoria");

    /**
     * Constructor de la página base.
     *
     * @param driver El controlador del navegador web.
     * @param wait
     */
    public Page02(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void buscar(String articulo) throws InterruptedException{
        this.sendText(articulo, searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickBuscar() throws InterruptedException{
        this.click(searchBtn);
    }

   /*

        public String resultadoBusqueda() throws InterruptedException {
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(validateSearch));
        return this.getText(validateSearch);
    }
    */
}

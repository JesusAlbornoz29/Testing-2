package com.Tests;


import com.Pages.Page01;
import com.ReportFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

import static com.ReportFactory.captureScreenshot;


@Tag("LOGIN")
public class Test01 {
	private WebDriver driver;
	private WebDriverWait wait;
	static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Login-Test.html");
	static ExtentReports extent;


	@BeforeAll
	public static void run() {
		extent = ReportFactory.getInstance();
		extent.attachReporter(info);
		System.out.println("<<< COMIENZAN LOS TEST DE LOGIN >>>");
	}

	@BeforeEach
	public void precondiciones() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		Page01 loginPage = new Page01(driver, wait);
		loginPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");

	}


	@Test
	@Tag("EXITOSO")
	void test_LogueoExitoso() throws InterruptedException {
		ExtentTest test = extent.createTest("Logueo Exitoso");
		test.log(Status.INFO, "Comienza el Test");
		test.log(Status.PASS, "Ingreso en el Login del Parcial");
		Page01 loginPage = new Page01(driver, wait);
		try{

			loginPage.clickMyAcount();

			loginPage.clickRegister();

			loginPage.completarFirstName("Alfredo");
			loginPage.completarLastName("Albornoz");
			loginPage.completarMail("alfredojesus.albornoz@gmail.com");
			loginPage.completarPhone("099119628");
			loginPage.completarPass("123456789");
			loginPage.completarRePass("123456789");
			loginPage.clickPrivacyPolicy();
			loginPage.clickContinuar();


		} catch (Exception error) {
			test.log(Status.FAIL, "FALLO EL TEST DE LOGIN" + error.getMessage());
			captureScreenshot(test, "FAIL_LoginExitoso", driver);
		}
		test.log(Status.INFO, "Finaliza el Test");
}

}

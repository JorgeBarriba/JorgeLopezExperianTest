package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginTest{
    WebDriver driver;
    public String baseUrl = "https://todoist.com/es";


    @Before
    public void launchBrowser() throws InterruptedException {
        //String driverPath = "/Users/Jorsh/Downloads/PruebasSelenium/chromedriver3";
        String driverPath = "src/WebDriver/chromedriver3";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @org.junit.Test
    public void SuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("jorgebarriba@gmail.com", "Challenge02");
        org.junit.Assert.assertTrue(loginPage.validateLogin());
    }

    @org.junit.Test
    public void UnsuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("failed@gmail.com", "nopass");
        org.junit.Assert.assertEquals("Email o contraseña incorrectos",loginPage.validateFailedLogin());
    }

    @org.junit.Test
    public void CreateNewTask(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("jorgebarriba@gmail.com", "Challenge02");
        loginPage.AddTask("Automated Single Task");
        org.junit.Assert.assertEquals("Automated Single Task",loginPage.validateSingleTask());
    }

    @Test
    public void Create10Tasks(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("jorgebarriba@gmail.com", "Challenge02");
        loginPage.ClickPlusButton();
        int n = 1;
        while(n<11){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            loginPage.AddMultipleTask("Automated Task "+n);
            n++;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals(10,loginPage.validateMultipleTask());

    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(100);
        driver.close();
    }

}

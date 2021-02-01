package Tests;

import Pages.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public String baseUrl = "https://todoist.com/";
    String driverPath = "/Users/Jorsh/Downloads/PruebasSelenium/chromedriver3";
    public WebDriver driver;

    @Before
    public void launchBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.wait(5000);
    }
    @Test
    public void login2(){
        WebElement element1 = driver.findElement(By.id("2"));

    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.wait(10);
    }

}

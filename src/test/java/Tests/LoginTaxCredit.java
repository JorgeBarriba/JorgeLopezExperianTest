package Tests;


import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.Zip;

import java.util.concurrent.TimeUnit;

public class LoginTaxCredit {
    WebDriver driver;

    //Amazon
    public String baseUrl = "https://surveyrc.taxcreditco.com/automation-challenge";
    public String FirstName = "Jorge";
    public String LastName = "Lopez Barriba";
    public String EmailAddress = "jorgebarriba@gmail.com";
    public String StreetAddress = "Vallarta";
    public String City = "Guadalajara";
    public String ZipCode = "45609";
    public String BasicAnswer = "No";
    public String RedirectURL = "https://www.experian.com/employer-services";
    public String ChangedURL = "";


    // Before actions to launch the browser
    @Before
    public void launchBrowser() throws InterruptedException {
        String driverPath = "src/WebDriver/chromedriver114";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void ExperianEmployeeServices(){
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.SubmitInformation(FirstName, LastName,EmailAddress,StreetAddress,City, ZipCode);
        loginPage.SetQuestions(BasicAnswer);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.ConfirmForm();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ChangedURL = loginPage.validateExperianURL();
        Assert.assertTrue(ChangedURL.contains(RedirectURL));

    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(100);
        driver.close();
    }


}

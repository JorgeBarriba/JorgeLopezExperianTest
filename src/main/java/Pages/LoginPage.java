package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators for Experian
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[2]/div/div/input") private WebElement first_name;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[3]/div/div/input") private WebElement last_name;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[4]/div/div/input") private WebElement email_name;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[5]/div/div/input") private WebElement street_name;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[6]/div/div/input") private WebElement city_name;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[7]/div/div/input") private WebElement zipcode_name;
    @FindBy (id="SurveyControl_SurveySubmit") private WebElement next_button;
    //Questions page
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[2]/div/div/label[2]")  private WebElement question1;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[3]/div/div/label[2]")  private WebElement question2;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[4]/div/div/label[2]")  private WebElement question3;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[5]/div/div/label[2]")  private WebElement question4;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[6]/div/div/label[2]")  private WebElement question5;
    @FindBy (xpath = "/html/body/form/div[4]/span/div[1]/div[7]/div/div/label[2]")  private WebElement question6;

    //Confirm URL
    //URL to confirm https://www.experian.com/employer-services
    @FindBy (id="SurveyControl_Question1244__as38786__ai2123_as38786_ctl00") private WebElement employer_services_url;

    //EXPERIAN validations
    public void SubmitInformation(String FirstName, String LastName,String EmailAddress,String StreetAddress,String City, String ZipCode){
        first_name.sendKeys(FirstName);
        last_name.sendKeys(LastName);
        email_name.sendKeys(EmailAddress);
        street_name.sendKeys(StreetAddress);
        city_name.sendKeys(City);
        zipcode_name.sendKeys(ZipCode);
        next_button.click();
    }

    public void SetQuestions(String BasicAnswer){
        question1.click();
        question2.click();
        question3.click();
        question4.click();
        question5.click();
        question6.click();
        next_button.click();
    }

    public void ConfirmForm(){
        next_button.click();
    }

    public String validateExperianURL(){

        return driver.getCurrentUrl();
    }


    /*
    @FindBy (id="SurveyControl_Question943__as67156__ai1647_as67156_ctl01") private WebElement first_name;
    @FindBy (id="SurveyControl_Question946__as69086__ai1650_as69086_ctl01") private WebElement last_name;
    @FindBy (id="SurveyControl_Question949__as69086__ai1653_as69086_ctl01") private WebElement email_name;
    @FindBy (id="SurveyControl_Question950__as69086__ai1654_as69086_ctl01") private WebElement street_name;
    @FindBy (id="SurveyControl_Question951__as69086__ai1655_as69086_ctl01") private WebElement city_name;
    @FindBy (id="SurveyControl_Question952__as69086__ai1656_as69086_ctl01") private WebElement zipcode_name;
    //Questions page
    @FindBy (id="SurveyControl_Question11396__as38786__ai22441_as38786_ctl00") private WebElement question1;
    @FindBy (id="SurveyControl_Question11397__as38786__ai22446_as38786_ctl00") private WebElement question2;
    @FindBy (id="SurveyControl_Question914__as38786__ai1597_as38786_ctl00") private WebElement question3;
    @FindBy (id="SurveyControl_Question11361__as38786__ai22393_as38786_ctl00") private WebElement question4;
    @FindBy (id="SurveyControl_Question915__as38786__ai1599_as38786_ctl00") private WebElement question5;
    @FindBy (id="SurveyControl_Question1244__as38786__ai2123_as38786_ctl00") private WebElement question6;
     */
}

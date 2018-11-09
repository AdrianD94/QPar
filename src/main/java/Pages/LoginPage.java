package Pages;

import Models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driverLn) {
        {
            this.driver = driverLn;
        }

    }

    @FindBy(how = How.XPATH, using = "//*[@text='I have a parent account']")
    private WebElement iHaveParrentAccount;

    @FindBy(how = How.XPATH, using = "//*[@id='privacy_policy_expandable_content']")
    private WebElement termsAndConditionText;

    @FindBy(how = How.XPATH, using = "//*[@text='Cancel']")
    private WebElement termsAndConditionCancelButton;

    @FindBy(how = How.XPATH, using = "//*[@text='Accept All']")
    private WebElement termsAndConditionAcceptAllButton;

    @FindBy(how = How.XPATH, using = "//*[@id='etEmail']")
    private WebElement yourEmailInput;

    @FindBy(how = How.XPATH, using = "//*[@id='etPassword']")
    private WebElement yourPasswordInput;

    @FindBy(how = How.XPATH, using = "//*[@text='Login']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@text='This field is required']")
    private WebElement thisFieldIsRequiredError;

    @FindBy(how = How.XPATH, using = "//*[@text='This email address is invalid']")
    private WebElement thisEmailIsInvalidError;

    @FindBy(how = How.XPATH, using = "//*[@text='The username or password was incorrect. Please try again.']")
    private WebElement TheUserNameOrPasswordIncorrectError;

    @FindBy(how = How.XPATH, using = "//*[@class='android.widget.RelativeLayout' and ./*[@id='survey_title_txt']]")
    private WebElement KidParrentScreen;


    //-----------------------------------------------------------------------------------------------


    public void LoginFlow(LoginModel model) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(iHaveParrentAccount));
        iHaveParrentAccount.click();

        wait.until(ExpectedConditions.visibilityOf(termsAndConditionText));
        Assert.assertTrue(termsAndConditionText.isDisplayed());
        Assert.assertTrue(termsAndConditionCancelButton.isDisplayed());
        Assert.assertTrue(termsAndConditionAcceptAllButton.isDisplayed());

        termsAndConditionCancelButton.click();

        wait.until(ExpectedConditions.visibilityOf(iHaveParrentAccount));
        Assert.assertTrue(iHaveParrentAccount.isDisplayed());
        iHaveParrentAccount.click();

        wait.until(ExpectedConditions.visibilityOf(termsAndConditionAcceptAllButton));
        Assert.assertTrue(termsAndConditionAcceptAllButton.isDisplayed());
        termsAndConditionAcceptAllButton.click();
        wait.until(ExpectedConditions.visibilityOf(yourEmailInput));
        loginButton.click();
        Assert.assertTrue(thisFieldIsRequiredError.isDisplayed());

        yourEmailInput.sendKeys(model.getBadEmail());
        loginButton.click();
        Assert.assertTrue(thisEmailIsInvalidError.isDisplayed());

        yourEmailInput.clear();
        yourEmailInput.sendKeys(model.getEmailAddress());
        yourPasswordInput.sendKeys(model.getBadPassword());
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(TheUserNameOrPasswordIncorrectError));


        yourEmailInput.clear();
        yourEmailInput.sendKeys(model.getEmailAddress());
        yourPasswordInput.clear();
        yourPasswordInput.sendKeys(model.getPassword());
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(KidParrentScreen));
        Assert.assertTrue(KidParrentScreen.isDisplayed());





    }


}

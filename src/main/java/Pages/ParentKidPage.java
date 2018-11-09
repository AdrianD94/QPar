package Pages;

import Models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ParentKidPage {
    WebDriver driver;

    public ParentKidPage(WebDriver driverLn) {
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


    @FindBy(how = How.XPATH, using = "//*[@class='android.widget.RelativeLayout' and ./*[@id='survey_title_txt']]")
    private WebElement KidParrentScreen;

    @FindBy(how = How.XPATH, using = "//*[@id='survey_title_txt']")
    private WebElement welcomeMessage;

    @FindBy(how = How.XPATH, using = "//*[@text='Whose device is this?']")
    private WebElement whoseDevice;

    @FindBy(how = How.XPATH, using = "//*[@id='survey_kid_selector']")
    private WebElement kidIcon;

    @FindBy(how = How.XPATH, using = "//*[@text=concat('Kid', \"'\", 's device')]")
    private WebElement kidDeviceText;

    @FindBy(how = How.XPATH, using = "//*[@text='Protect this device']")
    private WebElement protectThisDeviceText;

    @FindBy(how = How.XPATH, using = "//*[@id='survey_parent_dad_selector']")
    private WebElement parent1Icon;

    @FindBy(how = How.XPATH, using = "//*[@id='survey_parent_mum_selector']")
    private WebElement parent2Icon;

    @FindBy(how = How.XPATH, using = "//*[@text=concat('Parent', \"'\", 's device')]")
    private WebElement parentDeviceText;

    @FindBy(how = How.XPATH, using = "//*[@text='Monitor from this device']")
    private WebElement monitorFromDeviceText;

    @FindBy(how = How.XPATH, using = "//*[@text=concat('Great! To start protection you', \"'\", 'll also need to download Qustodio on your child', \"'\", 's device')]")
    private WebElement parentInfoScreen;

    @FindBy(how = How.XPATH, using = "//*[@text='I understand']")
    private WebElement iUnderstandButton;

    @FindBy(how = How.XPATH, using = "//*[@id='tourBackgroundImage' and @width>0]")
    private WebElement androidTour1;

    @FindBy(how = How.XPATH, using = "//*[@text='Skip']")
    private WebElement skip;

    @FindBy(how = How.XPATH, using = "//*[@text='Close Tour']")
    private WebElement closeTour;

    @FindBy(how = How.XPATH, using = "//*[@contentDescription=concat('Welcome to the Qustodio Parent', \"'\", 's App!')]")
    private WebElement welcomeToParentAppFlyOver;

    //-----------------------------------------------------------------------------------------------


    public void LoginFlow(LoginModel model) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(iHaveParrentAccount));
        iHaveParrentAccount.click();

        wait.until(ExpectedConditions.visibilityOf(termsAndConditionText));


        termsAndConditionAcceptAllButton.click();
        wait.until(ExpectedConditions.visibilityOf(yourEmailInput));

        yourEmailInput.sendKeys(model.getEmailAddress());

        yourPasswordInput.sendKeys(model.getPassword());
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(KidParrentScreen));
        Assert.assertTrue(KidParrentScreen.isDisplayed());

        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertTrue(welcomeMessage.getText().contains("Welcome,"));

        Assert.assertTrue(whoseDevice.isDisplayed());
        Assert.assertEquals(whoseDevice.getText(),"Whose device is this?");

        Assert.assertTrue(kidIcon.isDisplayed());

        Assert.assertTrue(kidDeviceText.isDisplayed());
        Assert.assertEquals(kidDeviceText.getText(),"Kid's device");

        Assert.assertTrue(protectThisDeviceText.isDisplayed());
        Assert.assertEquals(protectThisDeviceText.getText(),"Protect this device");

        Assert.assertTrue(parent1Icon.isDisplayed());
        Assert.assertTrue(parent2Icon.isDisplayed());

        Assert.assertTrue(parentDeviceText.isDisplayed());
        Assert.assertEquals(parentDeviceText.getText(),"Parent's device");

        Assert.assertTrue(monitorFromDeviceText.isDisplayed());
        Assert.assertEquals(monitorFromDeviceText.getText(),"Monitor from this device");

        parent1Icon.click();

        wait.until(ExpectedConditions.visibilityOf(parentInfoScreen));
        Assert.assertTrue(parentInfoScreen.isDisplayed());

        Assert.assertTrue(iUnderstandButton.isDisplayed());
        iUnderstandButton.click();

        wait.until(ExpectedConditions.visibilityOf(androidTour1));
        Assert.assertTrue(androidTour1.isDisplayed());

    }

        public void CheckAndroidTour(){
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOf(androidTour1));
            skip.click();
            wait.until(ExpectedConditions.visibilityOf(closeTour));
            closeTour.click();
            wait.until(ExpectedConditions.visibilityOf(welcomeToParentAppFlyOver));
            Assert.assertTrue(welcomeToParentAppFlyOver.isDisplayed());
        }


}

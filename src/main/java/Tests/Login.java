package Tests;

import Framework.BaseTestLogin;
import Models.LoginModel;
import Pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Login extends BaseTestLogin {

    @DataProvider(name = "LoginJson")
    public Iterator<Object[]> jsonLoginDataProvider() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Object[]> dp = new ArrayList<>();

        File[] files = getListOfFiles("login");
        for (File f : files) {
            LoginModel m = objectMapper.readValue(f, LoginModel.class);
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }


    @Test(dataProvider = "LoginJson",priority = 1)
    public void LoginTest(LoginModel loginModel) throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.LoginFlow(loginModel);

    }







}
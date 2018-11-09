package Tests;

import Framework.BaseTestLogin;
import Models.LoginModel;
import Pages.LoginPage;
import Pages.ParentKidPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParentKid extends BaseTestLogin {

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
    public void ParrentKid(LoginModel loginModel) throws InterruptedException {
        ParentKidPage parrentKid = PageFactory.initElements(driver, ParentKidPage.class);

        parrentKid.LoginFlow(loginModel);



    }







}
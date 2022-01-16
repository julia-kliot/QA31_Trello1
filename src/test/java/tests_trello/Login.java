package tests_trello;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

//@BeforeMethod
//public void preConditions(){
   // if (isLogged()) {
       // logout();
   // }
//}

    @Test
    public void loginTest1() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginForm();
        app.getUser().submitLogin();
        app.getUser().isLoggedSuccess();//Thread.sleep(5000);

        Assert.assertTrue(app.getUser().isLoggedSuccess());



    }







}

package tests_trello;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

@BeforeMethod
public void preConditions() {
    if (app.getUser().isLogged()) {
        app.getUser().logout();
    }
}


    @Test
    public void loginTest1() throws InterruptedException {
//User user= new User().withEmail("juliakliot.jk@gmail.com").withPassword("misha240613");
        User user = User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();
        logger.info("Test Login Positive 1" + user.getEmail()+" "+user.getPassword());
        app.getUser().initLogin();
        //app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha240613");
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().isLoggedSuccess();//Thread.sleep(5000);

        Assert.assertTrue(app.getUser().isLoggedSuccess());


    }

   // @Test(enabled = false)
    //public void loginTest2() {

        //initLogin();
        //type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        //click(By.cssSelector("#login"));
        //click(By.cssSelector(".dlMUdg"));
        //type(By.cssSelector("#password"),"misha240613");
        // submitLogin();


    }




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

        initLogin();
        fillLoginForm();
        submitLogin();
        isLoggedSuccess();//Thread.sleep(5000);

        Assert.assertTrue(isLoggedSuccess());



    }
    public boolean isLoggedSuccess(){
        WebDriverWait wait= new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe"))));
        return wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe")).isDisplayed();
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void fillLoginForm() {
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"),"misha240613");
    }

    @Test(enabled = false)
    public void loginTest2() {

        initLogin();
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));
        click(By.cssSelector(".dlMUdg"));
        type(By.cssSelector("#password"),"misha240613");
        submitLogin();


    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }
    public void logout(){
        click(By.cssSelector("[data-test-id='header-member-menu-button'"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("[data-testid='logout-button']"));

    }

    public boolean isLogged(){
        return  wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button'")).size()>0;
    }






}

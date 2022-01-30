package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public boolean isLoggedSuccess(){
        WebDriverWait wait= new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe"))));
        return wd.findElement(By.cssSelector("._9Bfh6AVH84yAZe")).isDisplayed();
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }





    public void fillLoginForm(String email, String password) throws InterruptedException {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        type(By.name("password"), password);
    }
    public void fillLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getEmail());
        Thread.sleep(5000);
        click(By.cssSelector("#login"));
        type(By.name("password"), user.getPassword());

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
    public void login(String email, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), email);
        Thread.sleep(5000);
        click(By.cssSelector("#login"));
        type(By.name("password"),password);
        click(By.id("login-submit"));
        Thread.sleep(20000);


    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button'"));
    }

    public void openUserProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAccount() {
        click(By.cssSelector("[href$='manage-profile']"));
        ArrayList<String> tabs= new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window((tabs.get(1)));
    }

    public void returnToTrelloFromAtlassian() {
        List<String>tabs= new ArrayList<>(wd.getWindowHandles());
        wd.close();
        wd.switchTo().window(tabs.get(0));
    }
}

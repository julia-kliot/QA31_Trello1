package Tests_Trello;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preConditions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA31_Trello1/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

    }


    @Test
    public void loginTest1() {
//initLogin();
        click(By.cssSelector("[href='/login']"));
        //enterUserName();
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));
        //enterPassword();
        type(By.cssSelector("#password"),"misha240613");
        //confirmLogin();
        click(By.cssSelector("#login-submit"));


    }
    @Test
    public void loginTest2() {

        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));

        click(By.cssSelector(".dlMUdg"));
        type(By.cssSelector("#password"),"misha240613");
        click(By.cssSelector("#login-submit"));


    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void logout(){
        click(By.cssSelector("[data-test-id='header-member-menu-button'"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("[data-testid='logout-button']"));

    }

    public boolean isLogged(){
        return  wd.findElements(By.cssSelector("._2ft40Nx3NZII2i")).size()>0;
    }



}

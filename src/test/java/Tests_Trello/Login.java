package Tests_Trello;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preConditions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA31_Trello1/chromedriver.exe");
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void  loginTest1() throws InterruptedException {
        WebElement signup = wd.findElement(By.cssSelector("[href='/login']"));
        signup.click();
        WebElement email= wd.findElement(By.cssSelector("#user"));
        type(email, "juliakliot.jk@gmail.com");
        WebElement login= wd.findElement(By.cssSelector("#login"));
        login.click();
        //
        WebElement password= wd.findElement(By.cssSelector("#password"));
        type(password,"misha240613");
        WebElement loginSubmit= wd.findElement(By.cssSelector("#login-submit"));
        loginSubmit.click();
        Thread.sleep(5000);

    }

    private void type(WebElement email, String myemail) {
        email.click();
        email.clear();
        email.sendKeys(myemail);
    }

}

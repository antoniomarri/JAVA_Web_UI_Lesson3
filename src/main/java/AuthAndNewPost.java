import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AuthAndNewPost {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        WebElement loginForm = driver.findElement(By.xpath(".//a[contains(text(),'Войти')]"));
        WebElement userNameInputField = driver.findElement(By.xpath(".//input[@id='user']"));
        WebElement passwordInputField = driver.findElement(By.xpath
                (".//input[@id='lj_loginwidget_password']"));
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='action:login']"));

       loginForm.click();
       userNameInputField.click();
       userNameInputField.sendKeys("TonioMari");
       passwordInputField.click();
       passwordInputField.sendKeys("testGBtochka.RU");
       loginButton.click();


        WebElement newPost1 = driver.findElement(By.cssSelector(".sc-9n3gis-1"));
        WebElement newPost2 = driver.findElement(By.xpath
                ("//textarea"));
        WebElement newPost3 = driver.findElement(By.cssSelector(".submitBtn-0-2-124 > .rootIn-0-2-71"));
        newPost1.click();
        newPost2.click();
        newPost2.sendKeys("Test post");
        newPost3.click();

        driver.quit();
    }
}

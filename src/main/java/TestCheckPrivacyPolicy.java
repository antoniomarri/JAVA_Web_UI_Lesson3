import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestCheckPrivacyPolicy {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        driver.findElement(By.cssSelector("body"))
               .sendKeys(Keys.CONTROL,Keys.END);
        WebElement privacyPolicy = driver.findElement(By.cssSelector
                (".main-footer__bottom-links-item:nth-child(2) > .main-footer__bottom-link"));

        privacyPolicy.click();
        driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ex1+ {
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/browser-driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.grammarly.com");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log in')]")));
            loginButton.click();

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            emailInput.sendKeys("email@gmail.com");

            WebElement continueButton = driver.findElement(By.type("submit"));
            continueButton.click();

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("password");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
            submitButton.click();

            wait.until(ExpectedConditions.urlContains("app.grammarly.com"));
            if (driver.getCurrentUrl().contains("app.grammarly.com")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Wrong email or password hehe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

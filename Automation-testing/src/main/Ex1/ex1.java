import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex1 {
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/browser-driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.chotot.com");
        driver.manage().window().maximize();

        driver.quit();
    }
}
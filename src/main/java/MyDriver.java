import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyDriver {
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 10);


    public MyDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
    }
}

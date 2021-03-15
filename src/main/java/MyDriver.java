import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyDriver {
    public final WebDriver driver = new ChromeDriver();
    public final WebDriverWait wait = new WebDriverWait(driver, 10);

    public MyDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://github.com");
    }

    public void logIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in")));
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void createNewDirectory() {
        driver.findElement(By.linkText("New")).click();
    }

    public void setNameOfDirectory(String repositoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("repository_name")));
        driver.findElement(By.id("repository_name")).sendKeys(repositoryName);
    }

    public void setCheckbox(String id) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        driver.findElement(By.id(id)).click();
    }

    public void setDropDownMenu(String boxXpath, String lineXpath) {
        driver.findElement(By.xpath(boxXpath)).click();
        driver.findElement(By.xpath(lineXpath)).click();
    }

    public void submit(String xpath) {
        //Click submit bottom
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public void submit(String xpath, boolean checkTextarea) {
        //Click submit bottom if textarea is not empty
        if (checkTextarea) {
            submit(xpath);
        }
    }

    public void submitById(String id) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        driver.findElement(By.id(id)).click();
    }

    public void delete() {
        driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")).click();
    }

    public void submitDelete() {
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(
                driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/p[2]/strong")).getText());

        submit("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]",
                checkTextareaNotEmptyByName("verify"));
    }

    public void close() {
        driver.close();
    }

    public boolean checkTextareaNotEmptyById(String id) {
        if(driver.findElement(By.id(id)).getAttribute("value").isEmpty()) return false;
            else return true;
    }

    public boolean checkTextareaNotEmptyByName(String name) {
        if(driver.findElement(By.name(name)).getAttribute("value").isEmpty()) return false;
        else return true;
    }

    public void writeText(String xpath, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyDriver {
    public final WebDriver driver;
    public final WebDriverWait wait;
    Logging log = new Logging("log.txt");

    public MyDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com");
        wait = new WebDriverWait(driver, 10);
    }

    public MyDriver(Browsers brouser) {
        System.setProperty(brouser.getDriver(), brouser.getAddress());
        if (brouser == Browsers.EDGE) driver = new EdgeDriver();
        else if (brouser == Browsers.TOR) driver = new FirefoxDriver();
        else driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://github.com");
        wait = new WebDriverWait(driver, 10);
    }

    public void logIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in")));
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void createNewDirectory() {
        driver.findElement(By.linkText("New")).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void setNameOfDirectory(String repositoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("repository_name")));
        driver.findElement(By.id("repository_name")).sendKeys(repositoryName);

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());

    }

    public void setCheckbox(String id) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        driver.findElement(By.id(id)).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void setDropDownMenu(String boxXpath, String lineXpath) {
        driver.findElement(By.xpath(boxXpath)).click();
        driver.findElement(By.xpath(lineXpath)).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void submit(String xpath) {
        //Click submit bottom
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void submit(String xpath, boolean checkTextarea) {
        //Click submit bottom if textarea is not empty
        if (checkTextarea) {
            submit(xpath);
        }

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void submitById(String id) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        driver.findElement(By.id(id)).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void delete() {
        driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")).click();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void submitDelete() {
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(
                driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/p[2]/strong")).getText());

        submit("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]",
                checkTextareaNotEmptyByXpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input"));

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    public void close() {
        driver.close();

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
        log.close();
    }

    public boolean checkTextareaNotEmptyById(String id) {
        if(driver.findElement(By.id(id)).getAttribute("value").isEmpty()) return false;
            else return true;
    }

    public boolean checkTextareaNotEmptyByXpath(String xpath) {
        if(driver.findElement(By.xpath(xpath)).getAttribute("value").isEmpty()) return false;
        else return true;
    }

    public void writeText(String xpath, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(text);

        log.writeLog(new Object(){}.getClass().getEnclosingMethod().getName());
    }
}

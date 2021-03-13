import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void logIn() {
        //Log in
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in")));
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.name("login")).sendKeys(new LoginProperty().username);
        driver.findElement(By.name("password")).sendKeys(new LoginProperty().password);

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.findElement(By.name("password")).submit();
    }

    public void createNewDirectory() {
        //Create new repository
        driver.findElement(By.linkText("New")).click();
    }

    public void setNameOfDirectory() {
        //Enter name
        wait.until(ExpectedConditions.elementToBeClickable(By.id("repository_name")));
        driver.findElement(By.id("repository_name")).sendKeys("TestRepository");
    }

    public void setCheckboxes() {
        //Checkboxes
        driver.findElement(By.id("repository_auto_init")).click();
        driver.findElement(By.id("repository_gitignore_template_toggle")).click();
        driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/summary")).click();
        driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/details-menu/div[3]/div[1]/label[52]/span")).click();
    }

    public void submit() {
        //Submit
        driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/button")).click();
    }

    public void delete() {
        //Delete
        driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    public void submitDelete() {
        //Submit delete
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(
                driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/p[2]/strong")).getText());
        driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]")).click();
    }
}

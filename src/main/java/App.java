import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        MyDriver driver = new MyDriver();

        //Log in
        driver.wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in")));
        driver.driver.findElement(By.partialLinkText("Sign in")).click();
        driver.driver.findElement(By.name("login")).sendKeys(new LoginProperty().username);
        driver.driver.findElement(By.name("password")).sendKeys(new LoginProperty().password);

        driver.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.driver.findElement(By.name("password")).submit();

        //Create new repository
        driver.driver.findElement(By.linkText("New")).click();

        //Enter name
        driver.wait.until(ExpectedConditions.elementToBeClickable(By.id("repository_name")));
        driver.driver.findElement(By.id("repository_name")).sendKeys("TestRepository");

        //Checkboxes
        driver.driver.findElement(By.id("repository_auto_init")).click();
        driver.driver.findElement(By.id("repository_gitignore_template_toggle")).click();
        driver.driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/summary")).click();
        driver.driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/details-menu/div[3]/div[1]/label[52]/span")).click();

        //Submit
        driver.driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[6]/button")).click();

        //Delete
        driver.driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a/span[1]")).click();
        driver.driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")).click();
        driver.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //Submit delete
        driver.driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(
                driver.driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/p[2]/strong")).getText());
        driver.driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button/span[1]")).click();



    }
}

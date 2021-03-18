import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TorDriver {
    private WebDriver driver;
    private WebDriverWait wait;
    private Process torProcess;
    @BeforeClass
    public void testSetup() throws IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        String torBinaryPath = "C:\\Tor Browser\\Browser\\firefox.exe";
        Runtime runTime = Runtime.getRuntime();
        torProcess = runTime.exec(torBinaryPath + " -n");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9150);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        driver.quit();
        torProcess.descendants().forEach(ph -> {
            ph.destroy();
        });
        torProcess.destroyForcibly();
    }
    @Test
    public void open_tor_browser() {
        driver.navigate().to("http://whatismyipaddress.com/");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='section_left']/div[2]")));
        Assert.assertNotEquals("151.80.16.169", element.getText());
    }
}

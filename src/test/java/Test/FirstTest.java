package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriver driver = new ChromeDriver(capability);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
        driver.manage().window().maximize();
        driver.navigate().to("https://10.147.106.127");
        String text = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(text,"JMAP"); //Verify JMAP label is shown on login page
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("adm@ADM9");
        driver.findElement(By.xpath("//button")).click();
        String homeLabel = driver.findElement(By.xpath("//span[@class='navbar-brand-text']")).getText();
        Assert.assertEquals(homeLabel,"Jio Manager For Access Platforms"); //Verify JMAP heading label is shown on home page
        //logout
        driver.findElement(By.xpath("//img[@alt='admin']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();

        driver.close();
        driver.quit();
    }
}

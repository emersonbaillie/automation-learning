import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Form {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Emerson");
        Thread.sleep(2000);
        driver.findElement(By.id("last-name")).sendKeys("Baillie");
        Thread.sleep(2000);
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        Thread.sleep(2000);
        driver.findElement(By.id("radio-button-2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkbox-2")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"select-menu\"]/option[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("datepicker")).sendKeys("06/01/2020");
        Thread.sleep(2000);
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
        String alertText = alert.getText();

        assertEquals("The form was successfully submitted!", alertText);




        driver.quit();
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExempleClassTest {
    WebDriver driver = null;
    static String expectedTitleebay ="Electronics, Cars, Fashion, Collectibles & More | eBay";

    //testNg annotations
    @Parameters("browserName")
    @BeforeTest
    public void setUpWebDriver(String browserName) {

        if(browserName.equals("chrome")) {
            // On initialise et on démarre l'objet ChromeDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            //initializing and starting the Chromebrowser
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    //testNg annotations
    @Test
    public void checkTitleOnEbay() throws InterruptedException {

        try {
            driver.manage().window().maximize();
            driver.get("https://www.ebay.com");
            // Met en pause le thread en cours d'exécution
            Thread.sleep(1000);

            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitleebay);

            driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mobile");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).sendKeys(Keys.RETURN);
            Thread.sleep(1000);
            System.out.println( "checkTitleOnEbay execution " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    @Test
    public void goToScub() throws InterruptedException {

        try {
            driver.manage().window().maximize();
            driver.get("https://www.scub.net/");
            Thread.sleep(1000);

            String actualTitle = driver.getTitle();
            // Assert.assertEquals(actualTitle, expectedTitleebay);

//            driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("Scub");
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@name=\"LC20lb MBeuO DKV0Md\"]")).sendKeys(Keys.RETURN);
//            Thread.sleep(1000);
            System.out.println( "goToScub execution " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    @AfterTest
    public void  tearDown() {
        driver.quit();
    }


}

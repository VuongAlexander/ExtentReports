package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportDemo {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Spark.html");
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Yahoo Email Login Test", "Automatically login to my Yahoo Account");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vuong\\Documents\\JAR Files\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        test.log(Status.INFO, "Starting Test Case");

        driver.manage().window().maximize();
        test.info("Maximized window size");
        driver.get("https://login.yahoo.com/account/create/");
        test.pass("Navigated to Yahoo Login Page");

        driver.findElement(By.id("usernamereg-firstName")).sendKeys("Alex");
        test.info("Entered first name");

        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Vuong");
        test.info("Entered last name");

        driver.findElement(By.id("usernamereg-userId")).sendKeys("LetsAGoMario");
        test.info("Entered userID");

        driver.findElement(By.id("usernamereg-password")).sendKeys("NisumTesting123!");
        test.info("Entered password");

        driver.findElement(By.id("usernamereg-birthYear")).sendKeys("1999");
        test.info("Entered birth year");

        driver.findElement(By.id("reg-submit-button")).click();
        test.info("Clicked continue");

        test.pass("Navigated to mobile verification page!");
        driver.quit();
        extent.flush();
    }

}

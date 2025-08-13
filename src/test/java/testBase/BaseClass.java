package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.CandidateDataGenerator;
import utilities.EmployeeDataGenerator;



public class BaseClass {

    static public WebDriver driver;
    protected Logger logger;
    protected Properties properties;
    protected CandidateDataGenerator can_gen;
    protected EmployeeDataGenerator emp_gen;
    
    @BeforeClass(groups = {"smoke"})
    @Parameters({"browser"})
    public void setup(String browser) throws IOException{
        
        logger = LogManager.getLogger(this.getClass());
        can_gen = new CandidateDataGenerator();
        emp_gen =  EmployeeDataGenerator.getInstance();


        FileReader file = new FileReader(".//src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);

        switch (browser.toLowerCase()) {
            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
            case "edge":
            driver = new EdgeDriver();
            break;
        default: 
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        }
        
        driver.get(properties.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    

    @AfterClass(groups = {"smoke"})
    public void teardown(){
        if (driver != null) { 
            driver.quit();
        }
    }

    @AfterTest(groups = {"smoke"})
    public void teardownRandomObject() {
        emp_gen.getNewInstance();
    }

    public String captureScreen(String tname) throws IOException{

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "//screenshots//" + tname + "_" + timestamp+ ".png";
        File targetFile = new File(targetFilePath);

        sourcefile.renameTo(targetFile);

        return targetFilePath;


    } 
}

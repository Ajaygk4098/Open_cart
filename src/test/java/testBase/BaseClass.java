package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger log;
	public Properties p;
	
	//these are common methods which are required for all the test cases hence added under base class

	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception {
		
		
		//loading the properties file
		FileReader file= new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		//this line is used to log all the types of logs into the log file
		log=LogManager.getLogger(this.getClass());   
		
		if(p.getProperty("Exection_environment").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capablity= new DesiredCapabilities();
		
			//here we are taking the browser parameter from the @parameter tag and based on the value received we are lunching the proper browser
			if(os.equalsIgnoreCase("Windows")) {
				capablity.setPlatform(Platform.WINDOWS);
			}else if(os.equalsIgnoreCase("Mac")) {
				capablity.setPlatform(Platform.MAC);
			}else {
				System.out.println("No supporting platform is specified");
				return;
			}
			
		
			switch(br.toLowerCase()) {
			case "chrome": capablity.setBrowserName("chrome");break;
			
			case "edge": capablity.setBrowserName("MicrosoftEdge"); break;
			
			case "firefox": capablity.setBrowserName("Firefox"); break;
			
			default: {
					System.out.println("No matching brower name");
					return;
				}
			}
			
			//from selenium4 onwards we don't need to add the URL of the grid for the capability it will automatically picks the URL of the grid
			driver= new RemoteWebDriver(capablity);
		}
		else if(p.getProperty("Exection_environment").equalsIgnoreCase("local")) {
				
			//here we are taking the browser parameter from the @parameter tag and based on the value received we are lunching the proper browser 
			switch(br.toLowerCase())
			{
			case "chrome":driver= new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			default:System.out.println("No matching brower found hence automation execution is not ran");
					return;		
			}
		}

		
		driver.manage().deleteAllCookies();  //this will delete all the cookies and cache before running the test
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		
	}
	
	
	//these are common methods which are required for all the test cases hence added under base class
	@AfterClass(groups= {"Regression","Sanity","Master"})
	public void teardown() {
		driver.quit();
		
	}
	
	
	//this method will generate random string of 5 chars
	//these are common methods which are required for all the test cases hence added under base class
	public String randomString() {
		String randomstr=RandomStringUtils.randomAlphabetic(5);
		return randomstr;
	}
		
	//these are common methods which are required for all the test cases hence added under base class
	//this method will generate random number of 10 digits
	public String randomInt() {
		String num=RandomStringUtils.randomNumeric(10);
		return num;
	}
		
	//these are common methods which are required for all the test cases hence added under base class	
	//this method will generate random number of 3 digits and random string of 3 char
	public String randomAlphanumeric() {
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

 
@Parameters({"os","browser"})
public class BaseClass 
{
	public static  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","master","logout"})
	@Parameters({"os" ,"browser"})
	public void setup(String os , String br) throws IOException
	{
		//loading properties file
		FileReader file= new FileReader(".//src/test/resources/config.properties");
		p= new Properties();
		p.load(file);
		
		
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass()); //log4j
		//String nodeURL = "http://localhost:4444/wd/hub"; 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println(" No matching OS..");
				return;
			}
				
			//browse
		
		//launching browser based on condition
		switch(br.toLowerCase())
		{
		case "chrome": cap.setBrowserName("chrome");break;
		case "edge"  : cap.setBrowserName("MicrosoftEdge");break;
		default: System.out.println("No matching browser..");return;
		}
		
		
		 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	}
	else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based locally condition
		switch(br.toLowerCase())
		{
		case "chrome": driver =new ChromeDriver();break;
		case "edge": driver= new EdgeDriver();break;
		case "safari": driver = new SafariDriver();break;
		default: System.out.println("No matching browser..");return;
		}
		
		
	}	 
		 driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		//driver.get("http://localhost/opencart/upload/index.php");
		//driver.get("https://tutorialsninja.com/demo/");
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		
	}
	
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatedstring = RandomStringUtils.randomNumeric(10);
		return generatedstring;
	}
	
	public String randomAlphanumeric()
	{
		String str= RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return(str+"@"+num);
	}
	
	@AfterClass(groups= {"sanity", "regression", "master","logout"})
	public void teardown()
	{
		driver.quit();
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

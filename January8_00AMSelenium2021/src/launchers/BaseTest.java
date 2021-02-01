package launchers;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath +"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath + "//enironment.properties");
		parentProp = new Properties();
		parentProp.load(fis);
		String e = parentProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath + "//"+e+".properties" );
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectPath +"//or.properties");
		orProp = new Properties();
		orProp.load(fis);
	}
	
	public static void openBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			
			ChromeOptions option  = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 17");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("JanuaryFFProfile");
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option  = new FirefoxOptions();
			option.setProfile(profile);
			driver = new FirefoxDriver(option);
		}
		
	}
	
	public  static void navigateUrl(String url) 
	{
		driver.get(childProp.getProperty(url));
	}
	
	public static String getcurrentUrl() 
	{
		return driver.getCurrentUrl();
	}

	public static String getTitlePage() 
	{
		return driver.getTitle();
	}

	public static void cookiesDelete() 
	{
		driver.manage().deleteAllCookies();
	}

	public static void windowMaximize() 
	{
		driver.manage().window().maximize();
	}
	
	public static void waitforElement(int milliSeconds) throws Exception 
	{
		Thread.sleep(milliSeconds);
	}

	public static void browserRefresh() 
	{
		driver.navigate().refresh();
	}

	public static void browserForward() 
	{
		driver.navigate().forward();
	}

	public static void browserBack() 
	{
		driver.navigate().back();
	}

	public static void closeBrowser() 
	{
		driver.quit();		
	}
	
	
	public static void clickElement(String locatorKey) 
	{
		driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}

}

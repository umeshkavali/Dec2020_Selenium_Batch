package launchers;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		openBrowser("chrome");
		
		navigateUrl("https://www.amazon.in");
				
		windowMaximize();
		
		cookiesDelete();
		
		String title = getTitlePage();
		System.out.println(title);
		
		String url = getcurrentUrl();
		System.out.println(url);
	
		browserBack();
		waitforElement(4000);
		browserForward();
		waitforElement(4000);
		browserRefresh();
			
		closeBrowser();
			
	}

	

	
	
}

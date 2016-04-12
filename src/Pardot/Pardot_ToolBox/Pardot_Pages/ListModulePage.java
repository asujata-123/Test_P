
 
package Pardot.Pardot_ToolBox.Pardot_Pages;

import Pardot.Pardot_ToolBox.AutomationSettings;
import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;
import UI.GenericPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;

import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public  class ListModulePage extends GenericPage {
	
	String _previousListName;
	public static String _listName;
	public static String listName;
	
	GenerateData genData;
	public ListModulePage(WebDriver aDriver, String aLOG_FILE) {	
		   super(aDriver, aLOG_FILE);
		   this.driver = aDriver;
	       this.LOG_FILE = aLOG_FILE;
	       genData=new GenerateData();
		}
		
	      //Webelements
		
	@FindBy(how = How.CSS, using = "a[class='dropdown-toggle'][id='mark-tog']")
    public WebElement Marketing;
		
	@FindBy(how = How.CSS, using = "li[class='dropdown-submenu'] a[href='/segmentation']")
    public WebElement Segmentation;
	
	@FindBy(how = How.CSS, using = "li[class='dropdown-submenu'] a[href='/email']")
    public WebElement Emails;
		
	
	@FindBy(how = How.CSS, using = "ul[class='dropdown-menu'] a[href='/list']")
    public WebElement Lists;
	@FindBy(how = How.CSS, using = "div[class = 'loginText']")
    public WebElement loginText;
	   
	   
	   //actions  
	    
  //WebElement Lists
    
    @FindBy(how = How.CSS, using = "input[type='text'][id='name']")
    public WebElement Name;
    @FindBy(how = How.CSS, using = "div[class='container-1200'] li[a href='/list']")
    public WebElement MSLists;
    
   // public WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-info']"));
    //Methods
    public void setName(String ListName) throws IOException, InterruptedException {
	      super.setTextField(Name, "name", ListName);   
    } 
     
    
    //WebElement Login        
    
	   @FindBy(how = How.CSS, using = "input[type='text'][id='email_address']")
	    public WebElement emailField;
	   @FindBy(how = How.CSS, using = "input[type='password'][id='password']")
	    public WebElement passwordField;
	   @FindBy(how = How.CSS, using = "input[type='submit'][value='Log in']")
	    public WebElement loginButton;
	   
	   //Methods
	  public void setEmail(String email) throws IOException, InterruptedException {
	      super.setTextField(emailField, "email_address", email);     
	   }
	  
	  public void setPassword(String Password) throws IOException, InterruptedException {
    super.setTextField(passwordField, "Password", Password);     
}
	     
	    public void clickSubmit() throws IOException, InterruptedException {
	        //super.clickElement(submitButton, "Login Button");
	    	super.clickElement(loginButton, "Log in");
	    }    
	    
	    //Lists
	    	
						
	   // page use cases    
	    public boolean launchApplication(String title) throws InterruptedException {  
	    	long elapsedTimeB = Calendar.getInstance().getTimeInMillis();
	    	int browseDelay = AutomationSettings.getDelay("Login");
	    	this.driver.manage().timeouts().implicitlyWait(browseDelay, TimeUnit.SECONDS);
	    	this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    	boolean navigated = false;
		    try {
	    		String url = GeneralMethods.getDeployment(); 
	    		this.driver.navigate().to(url);
	    		String appTitle = driver.getTitle();  
	    		System.out.println("title: "+appTitle);
	    		
	    		for (int i=0; i < PardotTestCase.loginTimeOut; i++) {
	    			GeneralMethods.delay(1000);
	    			navigated = verifyLogin();
	    			if (navigated) break;
	    		}
	    		
	    	} catch (Exception e) {
	    		System.out.println("Exception thrown by launchApplication: " +e.getMessage());
	    	}
	    	
		    // Calculate the test step elapsed time
			long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
			System.out.println("\n\nLOGIN (s): "+elapsedTimeA);
			////
			
	    	return navigated;
	    }
	    
	    	        
	    
	    public boolean verifyLogin() throws InterruptedException{
	    	 String bannerText = this.driver.getTitle();
	    	 boolean check = false;
	    	 check = bannerText.equals("Pardot") ? true :
	    		 bannerText.equals("Pardot") ? true : false;
	    	 
	    	 
	    	 //WebElement container = null;
	    	 //container = this.driver.findElement(By.cssSelector("div[class^='login-container']"));
	    	//List<WebElement> inputs = this.driver.findElements(By.cssSelector("input"));
	    	 WebElement container = GeneralMethods.FindVisibleObject(this.driver, "div[class^='container']");
	 		 List<WebElement> inputs = GeneralMethods.FindElementsInObjHierarchy(container, "input");
	    	 
	 		 //System.out.println("container visible? " +container.isDisplayed());
	 		 //System.out.println("number of inputs? " +inputs.size());
	 		 
	 		 check &= container != null ? true : false;
	 		 check &= container != null && inputs.size() > 0 ? true : false;
	 		
	    	 return check;
	     }
	 }


	
	
	
	
	
	
	
	
	
	



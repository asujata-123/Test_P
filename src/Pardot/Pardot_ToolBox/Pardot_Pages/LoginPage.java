
 
package Pardot.Pardot_ToolBox.Pardot_Pages;

import Pardot.Pardot_ToolBox.AutomationSettings;
import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import UI.GenericPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends GenericPage {
	
	public LoginPage(WebDriver aDriver, String aLOG_FILE) {	
		   super(aDriver, aLOG_FILE);
		   this.driver = aDriver;
	       this.LOG_FILE = aLOG_FILE;
		}
		//WebElements	   
	 
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
			
		
			
	   // page use cases    
	    public boolean launchApplication(String title) throws InterruptedException {  
	    	long elapsedTimeB = Calendar.getInstance().getTimeInMillis();
	    	int browseDelay = AutomationSettings.getDelay("Login");
	    	this.driver.manage().timeouts().implicitlyWait(browseDelay, TimeUnit.SECONDS);
	    	this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    	boolean navigated = false;
		    try {
	    		String url = GeneralMethods.getDeployment(); 
	    		this.driver.navigate().to(url);
	    		String appTitle = driver.getTitle();  
	    		System.out.println("title: "+appTitle);
	    		
	    		for (int i=0; i < PardotTestCase.loginTimeOut; i++) {
	    			GeneralMethods.delay(500);
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
	    
	    public boolean login() throws IOException, InterruptedException{
	        try{
	          long elapsedTimeB = Calendar.getInstance().getTimeInMillis();	
	    	  this.emailField.clear();
		 	  this.passwordField.clear();
	    	  boolean success = true;
	    	  this.emailField.sendKeys(super.EMAIL);
	        //  success &= super.setTextField(this.emailField, "Email field", super.USER_NAME); // this.setUserName(super.USER_NAME);
	          this.passwordField.sendKeys(super.PASSWORD);
	          success &= super.clickElement(this.loginButton, "Login button"); // this.clickSubmit();
	          System.out.println("Wait 3s after login");
	          GeneralMethods.delay(1000); //changed to 1000 3/21/2016
	          // Calculate the test step elapsed time
	  		  long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
	  		  System.out.println("\n\nlp.login() (s): "+elapsedTimeA);
	  		  ////
	          return success;
	        } catch (Exception e){
	        	System.out.println("login: Exception thrown " + e.getMessage());
	        	return false;
	        }
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
	
	
	
	
	
	
	
	
	
	



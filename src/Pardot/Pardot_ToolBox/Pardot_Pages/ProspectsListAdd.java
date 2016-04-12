package Pardot.Pardot_ToolBox.Pardot_Pages;
import Pardot.Pardot_ToolBox.AutomationSettings;
import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import UI.GenericPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.GenerateData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import options.Selenium.Core extensions

public class ProspectsListAdd extends GenericPage {
	String _previprospectFName;	
	String _previprospectLName;	
	String _previEmail;
	String uniEmail1;
	String _previousListName;
	GenerateData genData;
	
	String var;
	public ProspectsListAdd(WebDriver aDriver, String aLOG_FILE) {	
		   super(aDriver, aLOG_FILE);
		   this.driver = aDriver;
	       this.LOG_FILE = aLOG_FILE;
	       genData=new GenerateData();
	      // selectListName = new selectListName();
		}
	//genData=new GenerateData();
		
	      //Webelements
		
	@FindBy(how = How.CSS, using = "a[class='dropdown-toggle'][id='mark-tog']")
    public WebElement Marketing;
	@FindBy(how = How.CSS, using = "li[class='dropdown-submenu'] a[href='/segmentation']")
    public WebElement Segmentation;
	//Prospects WebElements
	@FindBy(how = How.CSS, using = "a[class='dropdown-toggle'][id='pro-tog']")
    public WebElement Prospects;
	@FindBy(how = How.CSS, using = "span[class='dropdown-header']")
    public WebElement Prospects1;
	@FindBy(how = How.CSS, using = "ul[id='dropmenu-prospects'][class='dropdown-menu] [aria-labelledby='protog']")
    public WebElement ProspectsLists1;
	@FindBy(how = How.CSS, using = "li[class^=a[href='/prospect']")
    public WebElement ProspectsLists;
	//Login WebElements
	 @FindBy(how = How.CSS, using = "input[type='text'][id='email_address']")
	    public WebElement emailField;
	 @FindBy(how = How.CSS, using = "input[type='password'][id='password']")
	    public WebElement passwordField;
	// private WebElement passwordField;
			@FindBy(how = How.CSS, using = "input[type='submit'][value='Log in']")
		    public WebElement loginButton;
	
    @FindBy(how = How.CSS, using = "div[class = 'loginText']")
    public WebElement loginText;
  //3/25/2016
	   @FindBy(how = How.CSS, using = "div[Class = 'chzn-search']")
	    public WebElement searchBox;
	   
	   //actions Methods login
	 	  
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
	    
	    //3/25/2016
	    @FindBy(how = How.CSS, using = "select[name = 'pre_list[]'] option")
	    public WebElement listSelectorList;
	    
	    
	    //Lists
	    
	    @FindBy(how = How.CSS, using = "input[type='text'][id='name']")
	    public WebElement Name;
	    
	    public void setName(String ListName) throws IOException, InterruptedException {
		      super.setTextField(Name, "name", ListName);     
		   }
	    // Prospects Form WebElements
	    
	    @FindBy(how = How.CSS, using = "input[type='text'][id='default_field_3361']")
	    public WebElement FName;
	    @FindBy(how = How.CSS, using = "input[type='text'][id='default_field_3371']")
	    public WebElement LName;
	    @FindBy(how = How.CSS, using = "input[type='text'][id='email']")
	    public WebElement Email;
	   // Prospects Form Methods and actions
	    public void setName1(String FirstName) throws IOException, InterruptedException {
	    	super.setTextField(FName, "default_field_3361", FirstName);		         
		   }	   
	    
	    public void setName2(String LastName) throws IOException, InterruptedException {
	    	super.setTextField(LName, "default_field_3371", LastName);		         
		   }	   
	    
	    public void setName3(String Email1) throws IOException, InterruptedException {
	    	super.setTextField(Email, "email", Email1);		         
		   }
	   
	    		
	    				@FindBy(how = How.CSS, using = "div[class = 'chzn-search']")
	    	    public WebElement SearchBox;
		@FindBy(how = How.CSS, using = "ul[class = 'chzn-results']")
	    public WebElement Results;
		@FindBy(how = How.CSS, using = "li[class = 'active-results']")
	    public WebElement ActiveResult;
	    			
	    //WebElement Drop down Campaign Dropdown
	    String ProspectsSelectorCSS = "a[class = 'dropdown-toggle'] [id = 'pro-tog']";
	    String optionSelectorCSSP = "a[href = '/prospect']";
	    @FindBy(how = How.CSS, using = "select[id = 'campaign_id']")
	    public WebElement campaign_id_Selector;
	    String campaignSelectorCSS = "select[id = 'campaign_id']";
	    String optionSelectorCSS = "option[value= '27631']";
	    @FindBy(how = How.CSS, using = "select[id = 'campaign_id'] option")
	    public List<WebElement> campaign_id_List;
	    //WebElement Drop down Profile
	    @FindBy(how = How.CSS, using = "select[id = 'profile_id']")
	    public WebElement profile_id_Selector;
	    String profileSelectorCSS = "select[id = 'profile_id']";
	    String optionSelectorCSS1 = "option[value= '3221']";
	    //WebElement Assign To
	    @FindBy(how = How.CSS, using = "select[id = 'to']")
	    public WebElement assignTo_Selector;
	    String assignToSelectorCSS = "select[id = 'to']";
	    String optionSelectorCSS2 = "option[value= 'user']";
	    //WebElement User
	    @FindBy(how = How.CSS, using = "select[id = 'user_id']")
	    public WebElement user_Selector;
	    String user_SelectorCSS = "select[id = 'user_id']";
	    String optionSelectorCSS3 = "option[value= '179222']";
	    //WebElement Create Prospect button
	    @FindBy(how = How.CSS, using = "input[type='submit'][value='Create prospect']")
	    public WebElement Create_prospectButton;
	    public void clickSubmitbutton() throws IOException, InterruptedException {
	        //super.clickElement(submitButton, "Login Button");
	    	super.clickElement(Create_prospectButton, "Create prospect");	    	
	    }
	    //List drop down
	    
	    String selectList_SelectorCSS = "select[class ^='select-list-chosen']";
	  //  String optionSelectorCSS7 = "div[class= 'chzn-drop']";
	    String optionSelectorCSS7 = "option icon[value= '139991']";
	   @FindBy(how = How.CSS, using = "select[ng-model = 'cancelReasonId']")
	    public WebElement cancelationReasonSelector;

	   @FindBy(how = How.CSS, using = "select[class ='select-list-chosen']")  
	  
	   public WebElement listSelectorCSS;
	   
	  
	    //DropDown Method
	    public boolean selectcampaign_id(WebDriver driver, String Campaign) throws IOException, InterruptedException {
	    	boolean success = false;
	    	//WebElement cancelButton = cancelAppt;
	    //	super.clickAndWaitForElement(cancelAppt, "Appointment Details Cancel link", cancelationPopup);
	    	super.clickElement(campaign_id_Selector, "Campaign popup");
	    	success = super.selectDropdownItem(campaign_id_List, "Campaign_id dropdown value", Campaign);
	    	success &= this.selectDropdownItem(campaign_id_List, campaignSelectorCSS, Campaign);
	    	return success;
	    }
	     
			
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
	    	
	    
	    
	    public boolean selectListName(WebDriver driver, String list) throws IOException, InterruptedException {
	    	boolean success = false;
	    	//WebElement cancelButton = cancelAppt;
	    	//super.clickAndWaitForElement(cancelAppt, "Appointment Details Cancel link", cancelationPopup);
	    	super.clickElement(listSelectorCSS, "List popup");
	    	//success = super.selectDropdownItem(listSelectorList, "Select list dropdown value", list);
	    	//success &= this.clickCancelApptYes();
	    	return success;
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


	

	
	
	
	
	
	
	
	



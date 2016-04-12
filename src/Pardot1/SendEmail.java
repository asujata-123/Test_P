package Pardot1;


	

	import java.util.regex.Pattern;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;

import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.EmailPage;
//import testsuites.Selected;
//import Pardot.Pardot_ToolBox.Pardot_Pages.ErrorPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
//import Pardot.Pardot_ToolBox.Pardot_Pages.MainPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsListAdd;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsPage;

import static org.testng.Assert.*;
	import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

	public class SendEmail extends PardotTestCase {
		 // private WebDriver driver;
		 public boolean acceptNextAlert = true;
		  public StringBuffer verificationErrors = new StringBuffer();
		  @Test
		public static void SendEmail() throws Exception {
			//PardotTestCase.testName = "CreateProspect";	
			//PardotTestCase.tester = "Sujata Sudhakar";
			
			WebDriver driver = GeneralMethods.startDriver();
		//	 public boolean acceptNextAlert = true;
			//  private StringBuffer verificationErrors = new StringBuffer();
		// Objects used
			//MainPage mp = new MainPage(driver, "mainpage");
			LoginPage lp = new LoginPage(driver, "loginpage");
			//ErrorPage ep = new ErrorPage(driver, "errorpage");
			ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
			//ProspectsPage_works pp = new ProspectsPage_works(driver, "prospectspage_works");
			ProspectsPage pp = new ProspectsPage(driver, "prospectspage");
			ProspectsListAdd pl = new ProspectsListAdd(driver, "prospectslist");
			EmailPage emp = new EmailPage(driver, "emailpage");
		  
		  lp.launchApplication("Pardot");
		  lp.login();
		   try{
		  //WebElements
		 /* @FindBy(how = How.CSS, using = "a[class='dropdown-toggle'][id='mark-tog']")
		    public WebElement Marketing;
			@FindBy(how = How.CSS, using = "li[class^='dropdown-submenu' ] a[href='/email']")
		    public WebElement Emails;
			 public String buttonCheckEligibility = "[ng-click='checkEligibility(false)']"; 
			 public String buttonChoose = "[on-click='()']"; 
			 public String buttonCheckEligibilityCss = "span[ng-click*='checkEligibility']";
			 public String buttonChooseCss = "button[on-click*='Choose']";
			 @FindBy(how = How.CSS, using = "i[class='i-icon-open-alt']")
			    public WebElement Folder;
			  @FindBy(how = How.CSS, using = "div[class='form-inline'] input[class*='js-new-folder']")
			    public WebElement FolderName;
			  @FindBy(how = How.CSS, using = "button[id='select-asset'][class*='btn-primary']")
			    public WebElement ChooseSelected1;
			  WebElement ChooseSelected = driver.findElement(By.xpath("//button[contains(., 'Choose Selected')]"));
			  
			  public void ClickButton1(String Choose){
 
				    ChooseSelected.click();
				    }*/
				    
				  /*  public void clickChooseSelected() throws IOException, InterruptedException {
				        //super.clickElement(submitButton, "Login Button");
				    	super.clickElement(ChooseSelected, "Choose Selected");
				    }    	  				    }*/
			  
		/*  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
			  System.setProperty("webdriver.chrome.driver", "/Users/Sujata/chromedriver.exe");
		         driver = new ChromeDriver();
		       //  driver.get("https://pi.pardot.com");
		    baseUrl = "https://pi.pardot.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }**/

	  
	   
		driver.findElement(By.id("mark-tog")).click();
		driver.findElement(By.linkText("Emails")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.findElement(By.linkText("Send New Email")).click();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   driver.findElement(By.id("name")).clear();
	   driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	    driver.findElement(By.id("name")).sendKeys("Test");
	    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("i.icon-folder-open-alt")).click();
	    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	   // driver.findElement(By.cssSelector("div.btn.btn-warning")).click();
	    driver.findElement(By.cssSelector("span[title=\"KevinTest\"]")).click();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 //  emp.ChooseSelected.click();
	  //  emp.ChooseSelectedButton.click();
	  // emp.clickButton(CancelButton))
	  //  ChooseSelected.
	    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	  //  driver.findElement(By.cssSelector("span.add-on")).click();
	   // chooseSelected.click
		 // driver.findElement(By.cssSelector("div#select-asset")).click();
		//  #asset-chooser-app-modal > div.modal-footer > button:nth-child(1)
		 // driver.findElement(By.cssSelector("#asset-chooser-app-modal > div.modal-footer > button:nth-child(1)")).click();
		  driver.findElement(By.cssSelector("#asset-chooser-app-modal > div.modal-footer > button:nth-child(2)")).click();
		  // driver.findElement(By.xpath(".//*[@id='select-asset']").c
	    //driver.findElement(By.xpath("//*[@id='asset-chooser-app-modal']/div[3]/div/div[2]/div/div[2]/div/div[2]/div/i").click
		   driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		   driver.findElement(By.cssSelector("#information_form > div.control-group.required.campaign_errors > div > div > span.add-on > i")).click();
		   driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		  // driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		   driver.findElement(By.cssSelector("h4.pull-left")).click();
		 //  driver.findElement(By.cssSelector("#ember1451 > div > div.media-body > h4")).click();
		    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		    //driver.findElement(By.cssSelector(" #select-asset")).click();
		    driver.findElement(By.cssSelector("#asset-chooser-app-modal > div.modal-footer > button:nth-child(2)")).click();
		    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		    driver.findElement(By.id("email_type_text_only")).click();
		    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		    driver.findElement(By.linkText("Save")).click();
		    driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("#template_select_list > div.content > ul > li:nth-child(18)")).click();
		    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		   // driver.findElement(By.id("template_confirm")).click();
		    driver.findElement(By.cssSelector("#template_confirm")).click();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  		   
			 System.out.println("Wait 3s after login");
	          GeneralMethods.delay(3000);
	          // Calculate the test step elapsed time
	  		 // long elapsedTimeA = Calendar.getInstance().getTimeInMillis() - elapsedTimeB;
	  		         return;
	        } catch (Exception e){
	        	System.out.println("List: Exception thrown " + e.getMessage());
	        	return;
	        }
	      
		}
	
		   
	  

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}



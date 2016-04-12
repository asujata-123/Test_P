package Pardot1;	

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import Pardot.Pardot_ToolBox.GeneralMethods;
import Pardot.Pardot_ToolBox.PardotTestCase;
import Pardot.Pardot_ToolBox.Pardot_Pages.EmailPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ListModulePage;
import Pardot.Pardot_ToolBox.Pardot_Pages.LoginPage;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsListAdd;
import Pardot.Pardot_ToolBox.Pardot_Pages.ProspectsPage;

import org.openqa.selenium.*;

	public class SendEmail extends PardotTestCase {
		 
		 public boolean acceptNextAlert = true;
		 public StringBuffer verificationErrors = new StringBuffer();
		  @Test
		public static void SendEmail() throws Exception {
			PardotTestCase.testName = "CreateProspect";	
			PardotTestCase.tester = "Sujata Sudhakar";
			
			WebDriver driver = GeneralMethods.startDriver();
		
		// Objects used
			
			LoginPage lp = new LoginPage(driver, "loginpage");
			ListModulePage lmp = new ListModulePage(driver, "listmodulepage");
			ProspectsPage pp = new ProspectsPage(driver, "prospectspage");
			ProspectsListAdd pl = new ProspectsListAdd(driver, "prospectslist");
			EmailPage emp = new EmailPage(driver, "emailpage");
		  
		    lp.launchApplication("Pardot");
		    lp.login();
		   
		try{
		 
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
	    driver.findElement(By.cssSelector("span[title=\"KevinTest\"]")).click();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("#asset-chooser-app-modal > div.modal-footer > button:nth-child(2)")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#information_form > div.control-group.required.campaign_errors > div > div > span.add-on > i")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("h4.pull-left")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#asset-chooser-app-modal > div.modal-footer > button:nth-child(2)")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
	    driver.findElement(By.id("email_type_text_only")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Save")).click();
		driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#template_select_list > div.content > ul > li:nth-child(18)")).click();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);		
		driver.findElement(By.cssSelector("#template_confirm")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("save_information")).click();	
		
		
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


